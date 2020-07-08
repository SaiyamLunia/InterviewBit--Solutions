/*
Given an integer array A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Problem Constraints
1 <= |A| <= 100000
Input Format
The only argument given is integer array A.

Output Format
Return the total water it is able to trap after raining.

Example Input
Input 1:

 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:
 A = [1, 2]

Example Output
Output 1:
 6
Output 2:
 0
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for (int current =0; current < A.size(); current++) {
            while (!st.empty() && A.get(current) > A.get(st.peek())) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(A.get(current), A.get(st.peek())) - A.get(top);
                ans += distance * bounded_height;
            }
            st.push(current);
        }
        return ans;
    }
}
