package Nagarro_Qps;

public class Gas_Station {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] gas= {1,2,3,4,5};
		int []cost= {3,4,5,1,2};

	}
	public static int Gas_Cost(int []gas,int []cost) {
		int res=0;
		int start=0;
		int curr=0;
		for (int i = 0; i < cost.length; i++) {
			res+=(gas[i]-cost[i]);
			curr+=gas[i]-cost[i];
			if(curr<0) {
				start=i+1;
				curr=0;
			}
		}
		if(res<0) {
			return -1;
		}
		else {
			return start;
					
		}
		
		
	}

}
