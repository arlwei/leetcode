/**
 * title:
 * 633. Sum of Square Numbers
 * <p>
 * content:
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 */
class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
		int a = 0;
		int b = (int)Math.sqrt(c);
		while (a <= b) {
			int sum = a*a + b*b;
			if (sum == c) {
				return true;
			} else if (sum > c) {
				b--;
			} else {
				a++;
			}
		}
		return false;
    }
}