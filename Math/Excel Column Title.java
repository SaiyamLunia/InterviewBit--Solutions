/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
Example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB  
*/

public class Solution {
    public String convertToTitle(int A) {
        StringBuilder columnName = new StringBuilder();
        while(A > 0) {
            columnName.append((char) ((A - 1) % 26 + 'A'));
            A = (A - 1) / 26;
        }
        return columnName.reverse().toString();
    }
}




