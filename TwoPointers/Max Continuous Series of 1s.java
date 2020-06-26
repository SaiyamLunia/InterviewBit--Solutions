/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.
For this problem, return the indices of maximum continuous series of 1s in order.

Example:
Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1
Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
*/

public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int lW = 0, rW = 0, leftIndex = -1, zeroCount = 0, bestWindow = 0;
    
        while (rW < A.size()) {
            if (zeroCount <= B) {
                if (A.get(rW) == 0) zeroCount++;
                rW++;
            }
            
            if (zeroCount > B) {
                if (A.get(lW) == 0) zeroCount--;
                lW++;
            }
            
            if ( (rW - lW) > bestWindow ) {
                bestWindow = rW - lW;
                leftIndex = lW;
            }
        }
    
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        
        while (0 < bestWindow) {
            res.add(leftIndex++);
            bestWindow--;
        }
            
        
        return res;
    }
}











