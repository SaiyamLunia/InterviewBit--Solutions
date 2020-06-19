/*
Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 


Do check
a) If your code responds correctly to the signs.
+7 -----> 7
-7 -----> -7
-+7 -----> 0

b) Check for other characters
m7 -----> 0
7m -----> 7
"7 ----> 0
7; -----> 7
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        if(A == null || A.length() == 0) return 0;
        boolean isMinus = false;
        double result = 0;
        int i = 0;
        if(A.charAt(0) == '-') {
        	isMinus = true;
        	i++;
        }else if(A.charAt(0) == '+')
        	i++;
        while(i < A.length() && A.charAt(i) >= '0' && A.charAt(i) <= '9') {
        	result = result * 10 + (A.charAt(i) - '0');
        	i++;
        }
        result = isMinus ? -result : result;
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
}








