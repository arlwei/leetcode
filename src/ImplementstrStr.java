import java.util.Objects;

/**
 * title:
 *  28. Implement strStr()
 *
 *  content:
 *      Implement strStr().
 *      Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(Objects.isNull(haystack) || Objects.isNull(needle) || haystack.length() < needle.length())
            return -1;
        if(needle.length() == 0)
            return 0;

        char[] str = haystack.toCharArray();
        char[] reg = needle.toCharArray();
        int pos = 0, index = 0;
        int[] next = getNext(reg);
        while(index < str.length && pos < reg.length)
        {
            while (pos > 0 && str[index] != reg[pos])
                pos = next[pos - 1];
            if(str[index] == reg[pos])
                pos++;
            index++;
        }
        return pos == reg.length ? index - pos : -1;
    }

    private int[] getNext(char[] pattern)
    {
        int[] next = new int[pattern.length];
        int q = 1, k = 0;
        next[0] = 0;

        while(q < pattern.length)
        {
            while (k > 0 && pattern[q] != pattern[k])
            {
                k = next[k - 1];
            }
            if (pattern[q] == pattern[k])
            {
                k++;
            }
            next[q++] = k;
        }

        return next;
    }
}
