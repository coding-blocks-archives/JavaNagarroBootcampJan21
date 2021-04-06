package Nagarro_Qps;

public class Buy_and_Sell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {7,1,5,3,6,4};
		System.out.println(buyandsell(arr));

	}
 public static int buyandsell(int []arr) {
	 int max_profit=0;
	 int min_price=Integer.MAX_VALUE;
	 for (int i = 0; i < arr.length; i++) {
		if(min_price>arr[i]) {
			min_price=arr[i];
		}
		else {
			max_profit=Math.max(max_profit, arr[i]-min_price);
		}
	}
	 return max_profit;
 }
}
