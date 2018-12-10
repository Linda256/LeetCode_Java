package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public static void main(String[] args) {
		DoubleNumArray dn = new DoubleNumArray();
		int[] input = {1,2,4,16,8,4};
		boolean res=dn.canReorderDoubled(input);
		System.out.println(res);

	}

}
