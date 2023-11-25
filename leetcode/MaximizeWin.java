package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MaximizeWin {

    public int maximizeWin(int[] prizePositions, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < prizePositions.length;) {
            int c = 1;
            while (i + c < prizePositions.length && prizePositions[i] == prizePositions[i + c]) {
                c++;
            }
            list.add(new int[] { prizePositions[i], c });
            i = i + c;
        }

        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            int maxPoint = list.get(i)[0] + k;
            int sum = list.get(i)[1];
            while (j < list.size() && list.get(j)[0] <= maxPoint) {
                sum += list.get(j)[1];
                j++;
            }
            max2 = Math.max(max2, sum);

            if (max1 < max2) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }
        }

        return Math.min(prizePositions.length, max1 + max2);
    }

    @Test
    public void test1() {
        assertEquals(7, maximizeWin(new int[] { 1, 1, 2, 2, 3, 3, 5 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(2, maximizeWin(new int[] { 1, 2, 3, 4 }, 0));
    }

    @Test
    public void test3() {
        assertEquals(74,
                maximizeWin(new int[] { 3937, 3938, 3939, 3951, 3951, 3959, 3975, 3988, 3993, 4010, 4031, 4033, 4036,
                        4038, 4039, 4041, 4047, 4058, 4059, 4064, 4072, 4081, 4084, 4084, 4089, 4094, 4098, 4112, 4114,
                        4116, 4123, 4123, 4127, 4130, 4135, 4143, 4149, 4152, 4163, 4164, 4176, 4178, 4180, 4198, 4216,
                        4224, 4233, 4240, 4253, 4259, 4273, 4286, 4305, 4322, 4335, 4350, 4364, 4378, 4396, 4397, 4398,
                        4404, 4415, 4421, 4430, 4469, 4476, 4490, 4492, 4497, 4504, 4519, 4519, 4525, 4526, 4530, 4530,
                        4540, 4550, 4554, 4563, 4571, 4571, 4595, 4595, 4606, 4639, 4639, 4660, 4663, 4676, 4678, 4680,
                        4695, 4697, 4709, 4709, 4711, 4724, 4751, 4781, 4786, 4786, 4794, 4797, 4801, 4807, 4808, 4817,
                        4822, 4824, 4825, 4840, 4851, 4887, 4889, 4891, 4910, 4917, 4927, 4931, 4932, 4951, 4959, 4964,
                        4993, 4997, 5003, 5003, 5006, 5006, 5022, 5029, 5035, 5043, 5045, 5045, 5046, 5059, 5060, 5079,
                        5084, 5105, 5109, 5109, 5112, 5120, 5126, 5130, 5142, 5143, 5151, 5152, 5154, 5156, 5168, 5189,
                        5213, 5214, 5223, 5226, 5235, 5247, 5259, 5272, 5289, 5303, 5309, 5317, 5322, 5344, 5347, 5352,
                        5374, 5379, 5380, 5383, 5385, 5391, 5418, 5425, 5429, 5432, 5479, 5486, 5490, 5502, 5502, 5505,
                        5506, 5509, 5515, 5518, 5519, 5521, 5526, 5528, 5533, 5536, 5536, 5538, 5555, 5556, 5557, 5557,
                        5566, 5571, 5580, 5585, 5596, 5604, 5619, 5634, 5649, 5668, 5694, 5696, 5699, 5701, 5704, 5709,
                        5732, 5745, 5745, 5746, 5749, 5762, 5766, 5766, 5770, 5773, 5796, 5810, 5817, 5823, 5838, 5843,
                        5846, 5860, 5869, 5872, 5877, 5880, 5896, 5899, 5902, 5905, 5910, 5913, 5913, 5915, 5923 },
                        220));
    }

}
