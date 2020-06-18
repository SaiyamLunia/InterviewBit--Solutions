/*
Given an integar A.
Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

Input Format
The first and only argument given is the integer A.
Output Format
Return floor(sqrt(A))

Input 1:
    A = 11
Output 1:
    3
Input 2:
    A = 9
Output 2:
    3
*/

public class Solution {
    public int sqrt(int A) {
        if(A <= 1) return A;
        int low = 0, high = A, mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if((mid <= A / mid) && ((mid + 1) > A / (mid + 1)))
                return mid;
            else if(mid > A / mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return mid;
    }
}






