package leetCode;

import java.util.HashMap;

public class LongestSubStr {
	
	// Method 1, naive method O(n*n)
	public int lengthOfLongestSubstring(String s) {
		char[] str=s.toCharArray();
		int longest=0, j=0;
		for(int i=0; i<str.length-1;i++){
			for (j=i+1;j<str.length;j++){
				if (str[i]==str[j]){
					break;
				}
				
			}
			if (longest<(j-i)) longest=j-i;
			
		}
		return longest;
	}
	
	// Method 2,  better performance O(n)
	public int lengthOfLongestSubstring2(String s) {
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
	
	
	//Method 3, O(n)
    public int lengthOfLongestSubstring3(String s) {
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
		String s="abcabcbb";
		//String s="abcdefghijklmnopq";
		int l=str.lengthOfLongestSubstring3(s);
		System.out.println(l);
		int l1=str.lengthOfLongestSubstring2(s);
		System.out.println(l1);
	}

}