/*
Given a string A representing an absolute path for a file (Unix-style).
Return the string A after simplifying the absolute path.
Note:
Absolute path always begin with ’/’ ( root directory ).
Path will not have whitespace characters.

Input Format
The only argument given is string A.
Output Format
Return a string denoting the simplified absolue path for a file (Unix-style).
For Example
Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"
*/

public class Solution {
    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] str = A.trim().split("/");
        for(String s: str) {
            if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!s.isEmpty() && !s.equals("."))
                stack.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return (sb.length() != 0) ? sb.toString() : "/";
    }
}
