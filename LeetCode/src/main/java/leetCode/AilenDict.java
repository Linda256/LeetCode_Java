package leetCode;
/*
 * 953 Verifying an Alien Dictionary
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", because 'l' > '∅',
 where '∅' is defined as the blank character which is less than any other character (More info).
 */
public class AilenDict {
	public boolean isAlienSorted(String[] words, String order) {
		boolean res=true;
		for(int i=0;i<words.length-1;i++){
			if (isInOrder(words[i],words[i+1],order)==false) return false;
		}
        return res;
    }
	
	public boolean isInOrder(String word1, String word2,String order){
		int len = Math.min(word1.length(),word2.length());
		System.out.println("len " +len);
		int i=0;
		while(i<len){
			if (order.indexOf(word1.charAt(i))<order.indexOf(word2.charAt(i))) return true;
			else if (order.indexOf(word1.charAt(i))>order.indexOf(word2.charAt(i))) return false;
			else i++;
		}
		if (word1.length()>word2.length()) return false;
		return true;
	}
   
	public static void main(String[] args) {
		AilenDict ad = new AilenDict();
		//String[] words = {"word","world","row"};
//		String[] words = {"apple","app"};
//		String order = "abcdefghijklmnopqrstuvwxyz";
		String[] words = {"word","world","row"};
		String order = "worldabcefghijkmnpqstuvxyz";
		//String[] words = {"hello","leetcode"};
//		String order = "hlabcdefgijkmnopqrstuvwxyz";
		boolean res2=ad.isInOrder(words[0],words[1],order);
		System.out.println("isInOrder:"+res2);
		boolean res = ad.isAlienSorted(words, order);
		System.out.println(res);	

	}

}
