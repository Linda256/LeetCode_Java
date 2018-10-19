/**
 * 910 Smallest RangeII
 
* Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.


Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 3
Explanation: B = [4,6,3]
 

Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

*/

package leetCode;

import java.util.Arrays;

public class SmallestRange {
	//Method I
	public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }
	
	//Method 2
	public int smallestRange(int[] A, int K) {
        int N = A.length;
       Arrays.sort(A);
       for (int i=0;i<A.length;i++){
    	   System.out.println(A[i]);
       }
       
       int ans = A[N-1] - A[0];

       for (int i = 0; i < A.length - 1; ++i) {
    	   System.out.println(i);
           int a = A[i], b = A[i+1];
           int high = Math.max(A[N-1] - K, a + K);
           //System.out.println("A[N-1] "+A[N-1]);
           //System.out.println("a + K "+(a + K));
           System.out.println("high: "+high);
           int low = Math.min(A[0] + K, b - K);
           System.out.println("low: "+ low);
           ans = Math.min(ans, high - low);
           System.out.println("ans: "+ans);
           
       }
       return ans;
   }
	
	public static void main(String[] args){
		SmallestRange sr=new SmallestRange();
		//int[] A={3,1,10};
		int[] A={3,1,10,8,11};
		int K=7;
		System.out.println(sr.smallestRange(A, K));
	}

}
