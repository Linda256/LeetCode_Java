package leetCode;
/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (int i=0; i<words.length; ++i){
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        }
        return true;
     }
	
	public boolean wordPattern2(String pattern, String str) {
		String[] words = str.split(" ");
		if(words.length!=pattern.length()) return false;
		Map map = new HashMap();
		for (int i=0;i<pattern.length();i++){
			if(map.containsKey(pattern.charAt(i))){
				if( !map.get(pattern.charAt(i)).equals(words[i])){
					return false;
				}
			}
			else{
				if(map.containsValue(words[i])) return false;
				map.put(pattern.charAt(i),words[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		String pattern = "abab";
		String str = "Linda Lee Linda Lee";
		boolean isMatch=wp.wordPattern2(pattern, str);
		System.out.println(isMatch);

	}

}
