import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //use space for time, time complexity O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for(int i = 0; i < nums.length; i++)
        {
            int temp = target - nums[i];
            if (map.containsKey(temp))
            {
                return new int[]{map.get(temp), i};
            }
            else
            {
                map.put(nums[i], i);
            }
        }

        return  new int[]{0, 0};
    }
}