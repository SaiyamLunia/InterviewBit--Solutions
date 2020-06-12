/*Determine whether an integer is a palindrome. Do this without extra space.
A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :
Input : 12121
Output : True

Input : 123
Output : False
*/

public class Solution {
    public int isPalindrome(int A) {
        if(A < 0 || A > Integer.MAX_VALUE || A < Integer.MIN_VALUE) return 0;
        int rev = A, res = 0;
        while(A > 0) {
            res = (res * 10) + (A % 10);
            A /= 10;
        }
        if(res > Integer.MAX_VALUE)
            return 0;
        return (rev == res) ? 1 : 0;
    }
}

