/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :
Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]
Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]
Output : [3 5] 
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i =0, j = 0;
        while(i < A.size() && j < B.size()) {
            if(A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i) > B.get(j))
                j++;
            else
                i++;
        }
        return result;
    }
}








