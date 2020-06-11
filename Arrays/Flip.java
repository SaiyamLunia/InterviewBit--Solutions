/*You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the 
characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. 
If you don’t want to perform the operation, return an empty array. 
Else, return an array consisting of two elements denoting L and R. 
If there are multiple solutions, return the lexicographically smallest pair of L and R.
*/

// NOTE: https://www.youtube.com/watch?v=cLVpE5q_-DE&feature=youtu.be


public class Solution {
    public int[] flip(String A) {
        int count = 0, l = 0, r = 0, temp = 0;
        int maxCount = Integer.MIN_VALUE;
        boolean isZeroPresent = false;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0') {
                count++;
                isZeroPresent = true;
            }
            else
                count--;
            if(count > maxCount) {
                maxCount = count;
                l = temp;
                r = i;
            }
            if(count < 0) {
                count = 0;
                temp = i + 1;
            }
        }
        if(!isZeroPresent)
            return new int[0];
        else
            return new int[]{ l + 1, r + 1 };
    }
}
