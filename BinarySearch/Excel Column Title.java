/*
Given a matrix of integers A of size N x M and an integer B.
Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
*/

public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int rowSize = A.size();
        int columnSize = A.get(0).size();
        for(int i = 0; i < rowSize; i++) {
            if((B >= A.get(i).get(0)) && (B <=A.get(i).get(columnSize - 1)))
                return binarySearch(A.get(i), B);
        }
        return 0;
    }
    
    private int binarySearch(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) == B)
                return 1;
            else if(A.get(mid) > B)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
}





