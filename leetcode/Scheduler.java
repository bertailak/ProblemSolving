package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Scheduler {

    private Task getNextTask(List<LinkedList<Task>> qTasks, int order, int time) {
        Task nextTask = new Task();

        int minIndex = -1;
        int minTime = -1;

        for (int i = order; i < order + qTasks.size(); i++) {
            int index = i % qTasks.size();
            if (qTasks.get(index).size() == 0)
                continue;

            if ((minIndex == -1)
                    || (minTime == qTasks.get(index).getFirst().startTime && minIndex < index)
                    || (minTime > qTasks.get(index).getFirst().startTime)) {
                minIndex = index;
                minTime = qTasks.get(index).getFirst().startTime;
            }

            if (time < qTasks.get(index).getFirst().startTime)
                continue;

            minIndex = index;

            break;
        }

        Task task = qTasks.get(minIndex).getFirst();
        nextTask.startTime = task.startTime;
        nextTask.queueNumber = task.queueNumber;
        nextTask.elapsedTime = task.elapsedTime;
        nextTask.index = task.index;
        nextTask.order = minIndex;

        qTasks.get(minIndex).removeFirst();
        return nextTask;
    }

    public int[][] scheduler(int m, int k, int[][] tasks) {
        int[][] result = new int[tasks.length][2];

        List<LinkedList<Task>> qTasks = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            qTasks.add(new LinkedList<>());
        }

        for (int i = 0; i < tasks.length; i++) {
            Task task = new Task();
            task.startTime = tasks[i][0];
            task.queueNumber = tasks[i][1];
            task.elapsedTime = tasks[i][2];
            task.index = i;
            qTasks.get(task.queueNumber - 1).add(task);
        }

        PriorityQueue<Executor> pqExecutors = new PriorityQueue<>(
                (a, b) -> a.startTime == b.startTime ? a.index - b.index : a.startTime - b.startTime);
        for (int i = 0; i < m; i++) {
            pqExecutors.add(new Executor(i + 1, 1));
        }

        int taskCount = 0;
        int order = 0;
        while (taskCount++ < tasks.length) {

            Executor executor = pqExecutors.poll();
            Task task = getNextTask(qTasks, order, executor.startTime);
            order = task.order + 1;

            executor.startTime = Math.max(executor.startTime, task.startTime);
            result[task.index] = new int[] { executor.index, executor.startTime };
            executor.startTime += task.elapsedTime;
            pqExecutors.add(executor);

        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[][] { { 1, 1 }, { 1, 6 }, { 1, 11 }, { 1, 9 }, { 1, 12 } },
                scheduler(1, 2, new int[][] { { 1, 1, 5 }, { 1, 2, 3 }, { 2, 2, 1 }, { 3, 1, 2 }, { 4, 1, 3 } }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[][] { { 1, 1 }, { 2, 1 }, { 1, 6 }, { 2, 4 }, { 2, 6 } },
                scheduler(2, 2, new int[][] { { 1, 1, 5 }, { 1, 2, 3 }, { 2, 2, 1 }, { 3, 1, 2 }, { 4, 1, 3 } }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[][] { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 1, 5 }, { 2, 6 } },
                scheduler(2, 2, new int[][] { { 1, 1, 1 }, { 1, 2, 5 }, { 2, 2, 1 }, { 5, 1, 3 }, { 6, 1, 3 } }));
    }
}

class Task {
    int startTime;
    int queueNumber;
    int elapsedTime;
    int index;
    int order;
}

class Executor {
    int index;
    int startTime;

    public Executor(int i, int s) {
        index = i;
        startTime = s;
    }
}