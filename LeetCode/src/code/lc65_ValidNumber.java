package code;

public class lc65_ValidNumber {
    /**
     * 方法1：直接遍历，时间复杂度O(n)，空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || (s = s.trim()).length() == 0)
            return false;

        boolean isExponent = false, numPre = false, isDecimal = false, numAfterE = true;

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numPre = true;
                numAfterE = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else if (s.charAt(i) == 'e') {
                if (isExponent || !numPre)
                    return false;
                numAfterE = false;
                isExponent = true;
            } else if (s.charAt(i) == '.') {
                if (isDecimal || isExponent)
                    return false;
                isDecimal = true;
            } else {
                return false;
            }
            i++;
        }
        return numPre && numAfterE;
    }

    /**
     * 方法2，自动机
     * 参考本包里lc65_ValidNumber_自动机.png
     * 为什么state7和state3不能合并？因为state3是正确可结束点，但7并不是
     * @param s
     */
    public boolean isNumber2(String s) {
        if (s == null)
            return false;

        s = s.trim();
        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                //正负号
                case '+':
                case '-':
                    if (state == 0)
                        state = 1;
                    else if (state == 4)
                        state = 6;
                    else
                        return false;
                    break;
                //数字
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    switch (state) {
                        case 0:
                        case 1:
                            state = 2;
                            break;
                        case 2:
                        case 3:
                        case 5:
                        case 8:
                            break;
                        case 4:
                        case 6:
                            state = 5;
                            break;
                        case 7:
                            state = 8;
                            break;
                        default:
                            return false;
                    }
                    break;

                case '.':
                    switch (state) {
                        case 0:
                        case 1:
                            state = 7;
                            break;
                        case 2:
                            state = 3;
                            break;
                        default:
                            return false;
                    }
                    break;
                case 'e':
                    if (state == 2 || state == 3 || state == 8)
                        state = 4;
                    else
                        return false;
                    break;
                default:
                    return false;

            }
        }
        return state == 2 || state == 3 || state == 5 || state == 8;
    }

    public static void main(String[] args) {
        String[] valid = {"-.1", "3.", "-3.e1", "0", " 0.1 ", "3e10", " -90e3   ", "6e-1", "53.5e93"};
        String[] invalid = {". ", ".e1", "e", "abc", "1 a", " 1e", "e3", " 99e2.5 ", " --5", "95a54e53"};

        lc65_ValidNumber test = new lc65_ValidNumber();

        for (String str : valid) {
            boolean res = test.isNumber(str);
            if (!res)
                System.out.println("wrong in valid: " + str);
        }
        for (String str : invalid) {
            boolean res = test.isNumber2(str);
            if (res)
                System.out.println("wrong in invalid: " + str);
        }
        System.out.println("pass");
    }
}
