import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * title:
 *    3. Longest Substring Without Repeating Characters
 *  content:
 *    Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstrWithoutRepChar {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        Set<Character> charSet = new HashSet();
        int left=0, right = 0;

        if (Objects.isNull(s) || s.length() == 0) {
            return length;
        }

        while(right < s.length()) {
            char tmp = s.charAt(right);
            if (charSet.contains(tmp)) {
                while (s.charAt(left) != tmp) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                charSet.add(tmp);
                if (charSet.size() > length) {
                    length = charSet.size();
                }
            }
            right++;
        }
        return length;
    }
}
