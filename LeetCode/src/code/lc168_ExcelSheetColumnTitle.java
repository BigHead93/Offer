package code;

public class lc168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 26) {
//            int times = n % 26;
//            while(times > 26) {
//                times
//            }
        }
        sb.append((char)('A'+ n - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        lc168_ExcelSheetColumnTitle test = new lc168_ExcelSheetColumnTitle();
        System.out.println(test.convertToTitle(1));
    }
}
