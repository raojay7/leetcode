public class Solution {
    /**
     * @param a: a positive integer
     * @return: the smallest positive integer whose multiplication of each digit equals to a
     */
    public int smallestFactorization(int a) {
        // Write your code here
        if (a < 10) return a;
        long res = 0, cnt = 1;
        for (int i = 9; i >= 2; --i) {
            while (a % i == 0) {
                res += cnt * i;
                if (res > Integer.MAX_VALUE) return 0;
                a /= i;
                cnt *= 10;
            }
        }
        return (a == 1) ? (int)res : 0;
    }
}
