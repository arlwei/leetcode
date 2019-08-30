/**
 * title:
 * 167. Two Sum II - Input array is sorted
 * <p>
 * content:
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 */
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
		int end = numbers.length - 1;
		int ret[] = null;
		
		while (begin < end) {
			int sum = numbers[begin] + numbers[end];
			if (sum == target) {
				ret = new int[]{begin + 1, end + 1};
				break;
			} else if (sum < target) {
				begin++;
			} else {
				end--;
			}
		}
		return ret;
    }
}