/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

Example:
Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then
[a, b] < [c, d] 
If a < c OR a==c AND b < d.
*/

public class Solution {
    public int[] primesum(int A) {
        int[] list = new int[2];
        for(int i = 2; i < A; i++) {
            if(isPrime(i)) {
                if(isPrime(A - i)) {
                    list[0] = i;
                    list[1] = A - i;
                    break;
                }
            }
        }
        return list;
    }
    
    private boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num <= 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i = i + 6) 
            if (num % i == 0 || num % (i + 2) == 0) 
                return false; 
        
        return true;
    }
    /* all primes are of the form 6k ± 1, with the exception of 2 and 3. 
	This is because all integers can be expressed as (6k + i) for some integer 
	k and for i = ?1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); 
	and 3 divides (6k + 3). So a more efficient method is to test if n is divisible by 2 or 3, 
	then to check through all the numbers of form 6k ± 1.
	*/
}
