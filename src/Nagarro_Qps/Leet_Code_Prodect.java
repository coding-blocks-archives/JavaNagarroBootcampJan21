package Nagarro_Qps;

public class Leet_Code_Prodect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,6,3,4};
         int ans [] =Prodoct_Array2(arr);
         for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}
	public static int [] Prodoct_Array(int [] arr) {
		
		int [] left = new int [arr.length];
		int [] right = new int [arr.length];
		left[0]=1;
		right[right.length-1]=1;
		for (int i = 1; i < right.length; i++) {
			left[i]=arr[i-1]*left[i-1];
		}
		for (int i = right.length-2; i>=0; i--) {
			right[i]=arr[i+1]*right[i+1];
		}
		for (int i = 0; i < right.length; i++) {
			left[i]=left[i]*right[i];
		}
		return left;
		
	}

public static int [] Prodoct_Array2(int [] arr) {
		
		int [] left = new int [arr.length];
		
		left[0]=1;
		
		for (int i = 1; i < left.length; i++) {
			left[i]=arr[i-1]*left[i-1];
		}
		int r=1;
		for (int i = arr.length-1; i>=0; i--) {
			left[i]=left[i]*r;
			r=r*arr[i];
			
		}
		
		
		return left;
		
	}
}
