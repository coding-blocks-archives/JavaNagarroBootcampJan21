package L37_DynamicStackQueue;

import L35_Queue.Queue;

public class DynamicQueue extends Queue{

	@Override
	public void enqueue(int item) throws Exception {
		
		if(isFull()) {
			
			// create a new array
			int[] na = new int[data.length*2] ;
			
			// copy the values
			for (int i = 0; i < size; i++) {

				int idx = (i + front) % data.length;
				na[i] = data[idx] ;
			}
			
			// ref change
			data = na ;
			front = 0 ;
		}
		
		super.enqueue(item);
	}
}
