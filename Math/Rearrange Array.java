public class Solution {
    public void arrange(ArrayList<Integer> a) {
        int max = a.size()+1;
    	for (int i = 0; i < a.size(); i++) {
    		if(a.get(i)<i) 
    			a.set(i, max*a.get(i)+a.get(a.get(i))/max);
    	    else 
    			a.set(i, max*a.get(i)+a.get(a.get(i)));
	}
		for (int i = 0; i < a.size(); i++) {
			a.set(i, a.get(i)%max);
		}
    }
}
