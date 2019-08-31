/**
 * titile:
 *   125. Valid Palindrom
 *
 *  content:
 *    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *    Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
 
 class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			}
		}
		return true;
    }
	
	private boolean isPalindrome(String str, int begin, int end) {
		while (begin < end) {
			if (str.charAt(begin++) != str.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}