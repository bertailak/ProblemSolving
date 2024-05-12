package task;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class GamePlatformer {

    private int calculatePosition(String commands) {
        int position = 0;
        int direction = 1;
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'R') {
                direction = 1;
            } else if (commands.charAt(i) == 'L') {
                direction = -1;
            } else {
                position += direction;
            }
        }
        return position;
    }

    public int gamePlatformer(String commands) {
        HashSet<Integer> set = new HashSet<>();

        char[] steps = new char[] { 'F', 'L', 'R' };
        StringBuilder sb = new StringBuilder(commands);
        for (int i = 0; i < sb.length(); i++) {
            char original = sb.charAt(i);

            for (int j = 0; j < steps.length; j++) {
                if (original == steps[j])
                    continue;
                sb.setCharAt(i, steps[j]);
                set.add(calculatePosition(sb.toString()));
            }

            sb.setCharAt(i, original);
        }

        return set.size();
    }

    @Test
    public void test1() {
        assertEquals(4, gamePlatformer("RLF"));
    }

    @Test
    public void test2() {
        assertEquals(6, gamePlatformer("LRFFLR"));
    }

    @Test
    public void test3() {
        assertEquals(3, gamePlatformer("FFF"));
    }
}
