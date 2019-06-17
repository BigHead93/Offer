package code;

public class lc204_CountPrimes {

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int ans = n - 2; // 去掉n和1，答案不包括n本身，查找范围是1~n-1

        for (int i = 2; i * i < n; i++) {
            if (flag[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                if (!flag[j]) {
                    ans--;
                    flag[j] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = 97979697;
        int j = i * i;
        int k = j % i;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

    }

}
