/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    if(a.size() == 0) return 0;
	    int low = 0, high = a.size() - 1;
	    
	    while(low <= high) {
	       int mid = low + (high - low) / 2;
	       if(a.get(mid) == b)
	            return mid;
	       else if(a.get(mid) > b)
	            high = mid - 1;
	       else
	            low = mid + 1;
	    }
	    return low;
	}
}






