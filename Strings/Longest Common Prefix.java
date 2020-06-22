/*
Given the array of strings A,
you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
and S2.
For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Input Format
The only argument given is an array of strings A.
Output Format
Return longest common prefix of all strings in A.
For Example

Input 1:
    A = ["abcdefgh", "aefghijk", "abcefgh"]
Output 1:
    "a"
    Explanation 1:
        Longest common prefix of all the strings is "a".

Input 2:
    A = ["abab", "ab", "abcd"];
Output 2:
    "ab"
    Explanation 2:
        Longest common prefix of all the strings is "ab".
*/

public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        String res = "";
        int minLength = Integer.MAX_VALUE;
        for(String str: A)
            minLength = Math.min(minLength, str.length());
        if(minLength == 0) 
            return res;
        
        for(int j = 0; j < minLength; j++) {
            char temp = A.get(0).charAt(j);
            for(String str: A) {
                if(str.charAt(j) != temp)
                    return str.substring(0, j);
            }
        }
        return A.get(0).substring(0, minLength);
        
    }
}











