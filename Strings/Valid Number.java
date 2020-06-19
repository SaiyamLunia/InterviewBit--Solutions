/*
Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String A) {
        if(A == null || A.length() == 0 || A.charAt(A.length()-1) == '.')
			return 0;
		int i = 0, dot = 0, e = 0, num = 0;
		if(A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == ' ')
			i++;
		while(i < A.length()) {
			char temp = A.charAt(i);
			if(temp >= '0' && temp <= '9')
                num++;                
			else if(temp == '+' || temp == '-' || temp == ' '){}
				
			else if(temp == '.' && i < A.length()-1 && (A.charAt(i+1) >= '0' && A.charAt(i+1) <= '9')) {
				if(dot > 1 || e > 0)
					return 0;
				else 
					dot++;
			}
			else if(temp == 'e') {
				if(e > 1)
					return 0;
				else 
					e++;
			}
			else return 0;
			i++;
		}
		if(num < 1) return 0;
		return 1;
    }
}









