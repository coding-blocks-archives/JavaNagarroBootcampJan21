package L47_QPS;

public class PivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int pivotIndex2(int[] nums) {

		int[] left = new int[nums.length];

		left[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] + nums[i];
		}

		int[] right = new int[nums.length];

		right[right.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] + nums[i];
		}

		for (int i = 0; i < nums.length; i++) {

			if (left[i] == right[i]) {
				return i;
			}
		}

		return -1;

	}

	public int pivotIndex3(int[] nums) {

		int rs = 0;
		for (int val : nums) {
			rs += val;
		}

		int ls = 0;

		for (int i = 0; i < nums.length; i++) {

			rs -= nums[i];

			if (ls == rs)
				return i;
			
			ls += nums[i] ;

		}
		
		return -1 ;

	}
}







