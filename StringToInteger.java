public class StringToInteger {
    public int myAtoi(String str) {
        if(null == str)
        {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0)
        {
            return 0;
        }

        long longNum = 0;
        boolean neg = false;
        boolean point = false;
        for (int i = 0; i < str.length(); i++)
        {
            char temp = str.charAt(i);
            //first position
            if( 0 == i )
            {
                if ( temp == '-' )
                {
                    neg = true;
                }
                else if ( '0' <= temp && temp <= '9' )
                {
                    longNum = temp - '0';
                }
                else if( temp == '+' )
                {
                    continue;
                }
                else
                {
                    return 0;
                }
            }
            else
            {
                if ('0' <= temp && temp <= '9')
                {
                    longNum = longNum * 10 + (temp - '0');
                    if( longNum > 2147483648L )
                    {
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        long ret_num = neg ? -longNum : longNum;
        if(ret_num < -2147483648l || ret_num > 2147483647l)
        {
            ret_num = ret_num > 0L ? 2147483647L: -2147483648L;
        }
        return (int)ret_num;
    }
}
