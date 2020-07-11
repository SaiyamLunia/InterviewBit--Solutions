/*
You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (i>j). If multiple A[j]'s are present in multiple positions, the LeftSpecialValue is the maximum value of j.
RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] and (j>i). If multiple A[j]'s are present in multiple positions, the RightSpecialValue is the minimum value of j.
Write a program to find the maximum special product of any integer in the array.

NOTE: As the answer can be large, output your answer modulo 109 + 7.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First and only argument is an integer array A.
Output Format
Return an integer denoting the maximum special product of any integer.
Example Input
Input 1:
 A = [1, 4, 3, 4]
Input 2:
 A = [10, 7, 100]
Example Output
Output 1:
 3
Output 2:
 0
Example Explanation
Explanation 1:
 For A[2] = 3, LeftSpecialValue is 1 and RightSpecialValue is 3.
 So, the ans is 1*3 = 3.
 
Explanation 2:
 There is not any integer having maximum special product > 0. So, the ans is 0.
*/

public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        if(A.size() == 1 || A.size() == 2)
            return 0;
        
        long[] prods = new long[A.size()];
        Stack<Integer> s1 = new Stack<>();
        
        s1.push(0);
        for (int i = 1; i < A.size(); i++) {
            while (s1.empty() == false && A.get(s1.peek()) <= A.get(i))
                s1.pop();
            if (s1.empty() == true) {
                s1.push(i);
                continue;
            } else {
                prods[i] = s1.peek();
                prods[i] %= 1000000007;
                s1.push(i);
            }
        }
        
        Stack<Integer> s2 = new Stack<>();
        
        s2.push(A.size()-1);
        for (int i = A.size()-1; i >= 0; i--) {
            while (s2.empty() == false && A.get(s2.peek()) <= A.get(i))
                s2.pop();
            if (s2.empty() == true) {
                s2.push(i);
                prods[i] = 0;
                continue;
            } else {
                prods[i] *= (s2.peek()%1000000007);
                //prods[i] %= 1000000007;
                s2.push(i);
            }
        }
        
        long max = 0;
        for (int i = 0; i < A.size(); i++)
            if (prods[i] > max)
                max = prods[i];
                
        return (int)(max%1000000007);
    }
}
