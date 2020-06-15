/*
A robot is located at the top-left corner of an A x B grid.

Path Sum: Example 1
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
How many possible unique paths are there?
Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
*/

public class Solution {
    public int uniquePaths(int A, int B) {
        return getUniquePaths(0, 0, A, B);
    }
    
    private int getUniquePaths(int i, int j, int A, int B) {
        if(i == A || j ==B) return 0;
        if(i == A-1 && j == B-1) return 1;
        return getUniquePaths(i+1, j, A, B) + getUniquePaths(i, j+1, A, B);
    }
}

