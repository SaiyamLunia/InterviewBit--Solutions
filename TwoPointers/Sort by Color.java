/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: Using library sort function is not allowed.
Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
*/

public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i : a) {
            if(i == 0)
                count0++;
            else if(i == 1)
                count1++;
            else
                count2++;
        }
        for(int i = 0; i < count0; i++)
            a.set(i, 0);
        for(int i = count0; i < count0 + count1; i++)
            a.set(i, 1);
        for(int i = count0 + count1; i < count0 + count1 + count2; i++)
            a.set(i, 2);
        
    }
}



