package leetCode;
/*
 * 917. Reverse Only Letters
 * Given a string S, return the "reversed" string where 
 * all characters that are not a letter stay in the same 
 * place, and all letters reverse their positions.
Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "
 */

public class ReverseLetters {
	public String reverseOnlyLetters(String S){
		StringBuilder sb= new StringBuilder(S);
		for(int j=S.length()-1, i=0;i<j;++i,--j){
			while(i<j && !Character.isLetter(S.charAt(i))) ++i;
			while(i<j && !Character.isLetter(S.charAt(j))) --j;
			if (i<j){
				sb.setCharAt(i,S.charAt(j));
				sb.setCharAt(j, S.charAt(i));
			}		
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		ReverseLetters rl=new ReverseLetters();
		String s ="a-bC-dEf-ghIj";
		String newS=rl.reverseOnlyLetters(s);
		System.out.println(newS);
	}

}
