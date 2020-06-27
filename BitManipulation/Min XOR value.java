/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
Input Format:
First and only argument of input contains an integer array A
Output Format:
return a single integer denoting minimum xor value

Example Input 1:
    A = [0, 2, 5, 7]
Example Output 1:
    2
Explanation:
    0 xor 2 = 2
Example Input 2:
    A = [0, 4, 7, 9]
Example Output 2:
    3
*/

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < A.size(); i++) {
            int xor = A.get(i - 1) ^ A.get(i);
            min = Math.min(min, xor);
        }
        return min;
    }
}


