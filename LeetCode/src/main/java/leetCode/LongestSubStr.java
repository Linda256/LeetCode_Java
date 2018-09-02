package leetCode;

import java.util.HashMap;

public class LongestSubStr {

	// Method 1,  better performance O(n)
	public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
	
	
//	//Method 2, O(n)
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
	
	public static void main(String[] args){
		LongestSubStr str=new LongestSubStr();
		String s="abcabcbbefg";
		//String s="abcdefghijklmnopq";
		int l=str.lengthOfLongestSubstring2(s);
		System.out.println(l);
		int l1=str.lengthOfLongestSubstring1(s);
		System.out.println(l1);
	}

}