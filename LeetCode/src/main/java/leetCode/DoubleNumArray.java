package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleNumArray {
	public boolean canReorderDoubled(int[] a) {
        List<Integer> A = new ArrayList<>();
        for(int n : a){
            A.add(n);
        }
        Collections.sort(A);
        int i=0;
        while(i<A.size()){
            if (A.get(i)<0 || A.get(i)>0){
                int index = A.get(i)<0 ? A.indexOf(A.get(i)/2) : A.indexOf(2*A.get(i));
                 if (index == -1) return false;
                 A.remove(i);
                 A.remove(index-1);
            }     
            else {
                if (A.get(i+1)!=0) return false;
                A.remove(i);
                A.remove(i);
            }
        }
       return true; 
        
    }
	
	public boolean canReorderDoubled2(int[] a) {

		Arrays.sort(a);
		Map<Integer, Integer> map=new HashMap<>();
		for (int n : a){
			if(!map.containsKey(n)){
				map.put(n, 1);
			}
			else{
				map.put(n, map.get(n)+1);
			}
		}
		System.out.print(map);
		

		for (int n: a){
			if (!map.containsKey(n)) continue;
			if (n==0){
				if (map.get(n)%2!=0) return false;
				else map.remove(n);
			} else{
				int m = n>0 ? 2*n : n/2;
				if (!map.containsKey(m)) return false;
			      else {
			    	  if((map.get(m)-1) == 0) map.remove(m);
			    	  else map.put(m,map.get(m)-1);
			    	  if((map.get(n)-1) == 0) map.remove(n);
			    	  else map.put(n,map.get(n)-1);
			    	 
					}
			}
	  	
		}
		
			
			//System.out.println("m "+m);
		System.out.println("size: "+map.size());
		return map.size()==0;
		 
	}
	
	public boolean canReorderDoubled3(int[] a) {
		Arrays.sort(a);
		Map<Integer,Integer> map = new HashMap<>();
			for (int n:a){
				if (n==0){
					if(map.containsKey(0)) {
						map.remove(0);
					}
					else map.put(n, 1);
					continue;
				}
				int m;
				if(n<0){
					m= 2*n;
				}
				else{
					if (n%2!=0){
						if(!map.containsKey(n)) map.put(n, 1);
						else map.put(n, map.get(n)+1);
						continue;
					}
					else m=n/2;
				}
				if(!map.containsKey(m)){				
					if (!map.containsKey(n)) map.put(n, 1);
					else map.put(n, map.get(n)+1);
				}
				else{
					if(map.get(m)==1) map.remove(m);
					else map.put(m, map.get(m)-1);
				}
		
			}
		System.out.println(map);
		System.out.println("size: "+map.size());
		return map.size()==0;	
	}

	public static void main(String[] args) {
		DoubleNumArray dn = new DoubleNumArray();
		//int[] input = {2,2,4,5,-8,-4};
		//int[] input ={4,-2,2,-4,0,0};
		//int[] input ={3,3,1,6};
		//int [] input ={4,-4,4,-2,-4,-8};
		//int[] input={1,1,1,1,2,2,2,2};
		int[] input={0,0};
		boolean res=dn.canReorderDoubled3(input);
		System.out.println(res);

	}

}
