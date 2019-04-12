package code;

public class StringUtil {
    private String str;
    private int hash;

    public StringUtil() {

    }

    public StringUtil(String str) {
        this.str = str;
    }
    public int hashcode() {
        int h = hash;
        if(h == 0 && str.length() > 0) {
            for(int i = 0; i < str.length(); i++) {
                h = h * 31 + str.charAt(i);
//                h = (h << 5 - h) + str.charAt(i);
            }
        }
        return h;
    }

    public boolean equals(Object anObject ) {
        if(str == anObject)
            return true;
        if(anObject instanceof String) {
            String anotherString = (String) anObject;
            if(str.length() == anotherString.length()) {
                int len = str.length();
                for(int i = 0; i < len; i++) {
                    if(str.charAt(i) != anotherString.charAt(i))
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
