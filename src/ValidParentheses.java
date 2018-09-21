import java.util.Stack;

/**
 * titile:
 *  20. Valid Parentheses
 *
 * content:
 *   Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *   An input string is valid if:
 *   Open brackets must be closed by the same type of brackets.
 *   Open brackets must be closed in the correct order.
 *   Note that an empty string is also considered valid.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null)
        {
            return false;
        }
        if (s == "")
        {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(')
            {
                stack.push(c);
            }
            else if (c == ']' || c == '}' || c == ')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char temp = stack.pop();
                if (c == ']' && temp != '[') return false;
                if (c == '}' && temp != '{') return false;
                if (c == ')' && temp != '(') return false;
            }
            else
            {
                return false;
            }
        }

        return  stack.isEmpty();
    }
}
