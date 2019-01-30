package code;

public class lc38_CountAndSay {
    public String countAndSay(int n) {
        String start = "1";
        while(n > 1) {
            start = next(start);
            n--;
        }
        return start;
    }

    private String next(String s) {
        int i = 1, j = 0, k = 1;
        StringBuilder sb = new StringBuilder();
        while(i <= s.length()) {
            if(i == s.length()) {
                sb.append(k);
                sb.append(s.charAt(j));
                break;
            }
            if(s.charAt(i) == s.charAt(j)) {
                k++;
                i++;
            } else {
                sb.append(k);
                sb.append(s.charAt(j));
                j = i;
                i++;
                k = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc38_CountAndSay test = new lc38_CountAndSay();
        System.out.println(test.countAndSay(6));
    }
}
