package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogFiles{
	public String[] reorderLogFiles(String[] logs){
		//initiate array digits, letters
		//loop though logs
			//put each log into digits and letters accordingly
		//sort letters
		//combine letters and digits
		String[] result=new String[logs.length];
		List<String> digits=new ArrayList<>();
		List<String> letters=new ArrayList<>();
		for (String log : logs){
			int start = log.indexOf(' ');
			if(Character.isDigit(log.charAt(start+1))){
				digits.add(log);
			}
			else{
				letters.add(log);
			}
		}
		System.out.println(digits);
		System.out.println(letters);
		
		
		Collections.sort(letters, new Comparator<String>(){
			public int compare(String s1,String s2){
				String[] sp1= s1.split(" ",2);
				String[] sp2= s2.split(" ",2);
				if(sp1[1].equals(sp2[1])) return sp1[0].compareTo(sp2[0]);
				return sp1[1].compareTo(sp2[1]);
			}
		});
		
		System.out.println(letters);
		int i=0;
		for(String s : letters){
			result[i]=s;
			i++;
		}
		
		for(String d : digits){
			result[i]=d;
			i++;
		}
		return result;
		
	}
	
	
	public static void main(String[] args){
		LogFiles lf = new LogFiles();
		String[] logs = {"a1 9 2 3 1","g1 act car","c1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		
		String[] result = lf.reorderLogFiles(logs);
		System.out.println(Arrays.toString(result));
		
	}
	

}
