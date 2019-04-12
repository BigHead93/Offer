package code;

public class lc43_MultiplyStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                res[i + j + 1] += n1 * n2;
            }
        }
        int carry = 0;
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            int tmp = res[i] + carry;
            res[i] = tmp % 10;
            carry = tmp / 10;
        }

        StringBuilder sb = new StringBuilder();
        int start = res[0] == 0 ? 1 : 0;
        for (int i = start; i < len1 + len2; i++)
            sb.append(res[i]);
        return sb.toString();

    }

    public static void main(String[] args) {
        lc43_MultiplyStrings test = new lc43_MultiplyStrings();
        String res = test.multiply("777777888877992", "3867857647646485867657");
        System.out.println(res);
    }
}