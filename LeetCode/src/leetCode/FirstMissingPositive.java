package leetCode;

public class FirstMissingPositive{
	public int findMissingPositive(int[] num) {
	    for (int i = 0; i < num.length; i++) {
	        while (num[i] > 0 && num[i] < num.length && num[i] != num[num[i] - 1]) {
	            swap(num, i, num[i] - 1);
	        }
	    }
	    for (int i = 0; i < num.length; i++) {
	        if (num[i] != i + 1) {
	            return i + 1;
	        }
	    }
	    return num.length + 1;
	}
	
	private void swap(int[] input, int source, int target) {
	    int temp = input[target];
	    input[target] = input[source];
	    input[source] = temp;
	}
	
	public static void main(String[] args){
		int[] num ={2,-9, 13,1, 25};
		FirstMissingPositive p = new FirstMissingPositive();
		System.out.print(p.findMissingPositive(num));
	}
}