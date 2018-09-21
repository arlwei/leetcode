/**
 * title:
 *   70. Climbing Stairs
 *
 * content:
 *   You are climbing a stair case. It takes n steps to reach to the top.
 *   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimingStairs {
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return n;

        int pre_1 = 2, pre_2 = 1;
        int ret = 0;
        for(int i = 3; i <= n; i++)
        {
            ret = pre_1 + pre_2;
            pre_2 = ret - pre_2;
            pre_1 = ret;
        }

        return ret;
    }
}
