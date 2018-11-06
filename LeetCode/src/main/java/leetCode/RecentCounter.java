/*
 * Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.

 

Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]
 

Note:

Each test case will have at most 10000 calls to ping.
Each test case will call ping with strictly increasing values of t.
Each call to ping will have 1 <= t <= 10^9.
 */
package leetCode;

import java.util.ArrayList;

public class RecentCounter {
private ArrayList<Integer> recentPing;
    
	public RecentCounter(){
		recentPing=new ArrayList<Integer>();
	}
	
	public int ping(int t) {
	    this.recentPing.add(t);
	    int total=0;
	    if (t<3000) return recentPing.size();
	    else {
	        int smallest = t-3000;
	        for (int i=recentPing.size()-1;i>=0;i--){
	            if (recentPing.get(i)>=smallest) total++;
	            else break;      
	        }
	    } 
	     return total; 
	}

	 
	 public static void main(String[] args){
		 RecentCounter rc= new RecentCounter();
		 rc.ping(1);
		 rc.ping(300);
		 int result = rc.ping(3303);
		 System.out.println(result);
	 }

	/**
	 * Your RecentCounter object will be instantiated and called as such:
	 * RecentCounter obj = new RecentCounter();
	 * int param_1 = obj.ping(t);
	 */

}
