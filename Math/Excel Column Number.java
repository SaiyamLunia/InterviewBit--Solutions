/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
Example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28  
*/

public class Solution {
    public int titleToNumber(String A) {
        int ans = 0;
        for(int i = 0; i < A.length(); i++) {
            ans = 26 * ans + (A.charAt(i) + 1 - 'A');
        }
        return ans;
    }
}



