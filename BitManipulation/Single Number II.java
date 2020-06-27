/*
Given an array of integers, every element appears thrice except for one which occurs once.
Find that element which does not appear thrice.
Note: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
Input Format:
First and only argument of input contains an integer array A
Output Format:
return a single integer.
For Examples :

Example Input 1:
    A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Example Output 1:
    4
Explanation:
    4 occur exactly once
Example Input 2:
    A = [0, 0, 0, 1]
Example Output 2:
    1
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int first = 0;
        int second = 0;
        for(int n: A){
            first = (first ^ n) & ~second;
            second = (second ^ n) & ~first;
        }
        return first;
    }
}

