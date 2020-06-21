/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
    public int isPalindrome(String A) {
        if(A == null || A.length() == 0) return 0;
        A = A.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = A.length();
        for(int i = 0; i < n / 2; i++){
            if(A.charAt(i) != A.charAt(n-1-i))
                return 0;
        }
        return 1;
    }
}









