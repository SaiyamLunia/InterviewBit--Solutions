/*
Given three sorted arrays A, B and Cof not necessarily same sizes.
Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :
Input:
A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:
1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/

public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int aS = A.size();
        int bS = B.size();
        int cS = C.size();
        int result = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        
        while(i < aS && j < bS && k < cS) {
            int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int diff = Math.abs(max - min);
            result = Math.min(result, diff);
            
            if(diff == 0) break;
            if(A.get(i) == min)
                i++;
            else if(B.get(j) == min)
                j++;
            else
                k++;
        }
        return result;
    }
}








