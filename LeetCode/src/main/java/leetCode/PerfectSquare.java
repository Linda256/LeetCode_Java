package leetCode;
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.
 */

public class PerfectSquare {
	 public boolean isPerfectSquare(int num) {
	        //brute force
	        if (num==1 || num == 4 ||num==9 || num ==16 || num==25) return true;
	        for (int i=4;i<=num/6; i++){
	            if (i*i==num) return true;
	        }
	        return false;
	    }
	 
	 //a square number is 1+3+5+7....
	public boolean isPerfectSquare2(int num) {
	     int i = 1;
	     while (num > 0) {
	         num -= i;
	         i += 2;
	     }
	     return num == 0;
	    }
}
