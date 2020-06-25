/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        if(A.size() < 3) 
            return new ArrayList<ArrayList<Integer>>(result);
        Collections.sort(A);
        
        for(int i = 0; i < A.size() - 2; i++) {
            if(i == 0 || A.get(i) > A.get(i - 1)) {
                int k = A.size() - 1;
                for(int j = i + 1; j < k; ) {
                    long sum = (long)A.get(i) + (long)A.get(j) + (long)A.get(k);
                    if(sum == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(A.get(i));
                        temp.add(A.get(j));
                        temp.add(A.get(k));
                        result.add(temp);
                        k--;
                        j++;
                        
                        // To handle the corner cases for time complexity
                        while(j < k && A.get(k) == A.get(k + 1))
                            k--;
                        while(j < k && A.get(j) == A.get(j - 1))
                            j++;
                    }
                    else if(sum < 0)
                        j++;
                    else
                        k--;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}






