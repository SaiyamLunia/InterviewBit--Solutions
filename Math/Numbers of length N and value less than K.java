/*
Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.
 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        int n = A.size(), MAX = 10, d2;
        if(n == 0) return 0;
        
        int result = 0;
        List<Integer> cDigit = numToList(C);
        
        // Case 1 : When B is greater than length of C
        if(B > cDigit.size()) return 0;
        
        // When B is smaller than length of C
        else if(B < cDigit.size()) {
            if (A.get(0) == 0 && B != 1) 
                return (int) ((n - 1) * Math.pow(n, B - 1)); 
            else
                return (int) Math.pow(n, B);
        }
        
        // When B is equal to length of C
        else {
            int []dp = new int[B + 1]; 
            int []lower = new int[MAX + 1]; 
            for (int i = 0; i < n; i++) 
                lower[A.get(i) + 1] = 1; 
            for (int i = 1; i <= MAX; i++) 
                lower[i] = lower[i - 1] + lower[i]; 
      
            boolean flag = true; 
            dp[0] = 0; 
            for (int i = 1; i <= B; i++)  
            { 
                d2 = lower[cDigit.get(i - 1)]; 
                dp[i] = dp[i - 1] * n; 
      
                // For first index we can't use 0 
                if (i == 1 && A.get(0) == 0 && B != 1) 
                    d2 = d2 - 1; 
      
                // Whether (i-1) digit of generated number 
                // can be equal to (i - 1) digit of C 
                if (flag) 
                    dp[i] += d2; 
      
                // Is cDigit[i - 1] present in A ? 
                flag = (flag & (lower[cDigit.get(i - 1) + 1] ==  
                                lower[cDigit.get(i - 1)] + 1)); 
            } 
            return dp[B];
        }
    }
    
    private List<Integer> numToList(int C) {
        List<Integer> list = new ArrayList<>();
        if(C == 0) {
            list.add(0);
            return list;
        }
        while(C > 0) {
            list.add(C % 10);
            C /= 10;
        }
        Collections.reverse(list);
        return list;
    }
}


