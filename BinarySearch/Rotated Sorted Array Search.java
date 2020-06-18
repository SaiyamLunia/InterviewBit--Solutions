/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 
 You are given a target value to search. If found in the array, return its index, otherwise return -1.
 
 You may assume no duplicate exists in the array.
 
 NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?
 Input arr[] = {3, 4, 5, 1, 2}
 Element to Search = 1
 1) Find out pivot point and divide the array in two 
 sub-arrays. (pivot = 2) i.e Index of 5
 2) Now call binary search for one of the two sub-arrays.
 (a) If element is greater than 0th element then 
 search in left array
 (b) Else Search in right array 
 (1 will go in else as 1 < 0th element(3))
 3) If element is found in selected sub-array then return index 
 Else return -1.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        while(low <= high) {
            if((low == high && A.get(low) != B)) return -1;
            int mid = low + (high - low) / 2;
            if(A.get(mid) == B)
                return mid;
            else if(A.get(mid) > B && A.get(mid) > A.get(high) && A.get(high) >= B)
                low = mid + 1;
            else if(A.get(mid) < B && A.get(high) >= B)
                low = mid + 1;
            else if(A.get(mid) < B && A.get(high) < B && A.get(mid) > A.get(high))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}







