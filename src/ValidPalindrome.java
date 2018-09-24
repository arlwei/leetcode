import java.util.Objects;

/**
 * titile:
 *   125. Valid Palindrom
 *
 *  content:
 *    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *    Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(Objects.isNull(s))
        {
            return false;
        }
        if (s.isEmpty())
        {
            return true;
        }

        int p1 = 0, p2 = s.length() - 1;
        char left, right;
        s = s.toUpperCase();
        while(p1 < p2)
        {
            left = s.charAt(p1);
            while (!isChar(left) && p1 < p2)
            {
                left = s.charAt(++p1);
            }
            right = s.charAt(p2);
            while (!isChar(right) && p1 < p2)
            {
                right = s.charAt(--p2);
            }
            if (left == right && p1 < p2)
            {
                p1++;
                p2--;
            }
            else
            {
                if(p1 == p2)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isChar(char c)
    {
        if('A' <= c && c <= 'Z' || '0' <= c && c <= '9')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
