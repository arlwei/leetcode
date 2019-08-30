import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * title:
 * 345. Reverse Vowels of a String
 * <p>
 * content:
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */

class ReverseVowelsString {
	private final static Set<Character> vowels =
			new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] ret = new char[s.length()];
		while (i <= j) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (!vowels.contains(a)){
				ret[i++] = a;
			} else if(!vowels.contains(b)) {
				ret[j--] = b;
			} else {
				ret[i++] = b;
				ret[j--] = a;
			}
		}
		return new String(ret);
	}
}