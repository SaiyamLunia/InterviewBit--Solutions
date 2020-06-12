/*Reverse digits of an integer.

Example1:

x = 123,
return 321
Example2:
x = -123,
return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
*/

public class Solution {
    public int reverse(int A) {
        if(A == 0 || A > Integer.MAX_VALUE || A < Integer.MIN_VALUE) return 0;
        boolean isNegative = A < 0;
        long res = 0;
        A = A > 0 ? A : -A;
        while(A > 0) {
            res = (res * 10) + (A % 10);
            A /= 10;
        }
        if(res > Integer.MAX_VALUE)
            return 0;
        return isNegative ? (int)-res : (int)res;
    }
}
