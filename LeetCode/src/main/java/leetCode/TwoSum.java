package leetCode;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * 
 *
 */

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target){
		// initiate a HashMap
		// loop through nums, 
		// if the target - current number in the HashMap, put the current number's position and the matched number's value in Map into result array
		// else put current number as key and its position as value into HashMap
	    // return result
		
		int[] result = new int[2];
		Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length; i++ ){
			if (map.containsKey(target-nums[i])){
				result[0]=map.get(target-nums[i]);
				result[1]=i;
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
		
	}

	public static void print(int[] nums){
		System.out.print('[');
		for (int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.print(']');
		System.out.println();
	}
	
	public static void main(String[] args){
		TwoSum s=new TwoSum();
		int[] nums={2, 7, 11, 15};
		int[] nums2={2,2,4};
		int target=4;
		int[] result=s.twoSum(nums, target);
		int[] result2=s.twoSum(nums2, target);
		System.out.println("nums result" );
		TwoSum.print(result);
		System.out.println("nums2 result" );
		TwoSum.print( result2);	
	}
}