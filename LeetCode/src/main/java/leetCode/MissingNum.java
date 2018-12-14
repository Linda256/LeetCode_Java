package leetCode;
/*
 * Given an array containing n distinct numbers taken 
 * from 0, 1, 2, ..., n, find the one that is missing 
 * from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant extra space complexity?


 */

import java.util.Arrays;

public class MissingNum {
	//method 1
	//Time Complexity O(n)
	// Space Coomplexity O(n)
	public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i) return i;
            
        }
        return nums[nums.length-1]+1;
    }

	
	/*if array nums is from 0-n the total of nums should
	 * be (nums.length*(nums.length+1))/2 
	 */
	//method 2
	//Time complexity O(n);
	//space complexity O(1);

	public int missingNumber2(int[] nums){
		int sum=0;
		for (int num : nums){
			sum +=num;
		}
		return (nums.length*(nums.length+1))/2-sum;
	}
	
	public static void main(String[] args){
		MissingNum mn = new MissingNum();
		//int[] nums = {9,6,4,2,3,5,7,0,1};
		int[] nums ={0};
		int n = mn.missingNumber2(nums);
		System.out.println(n);
	}

}
