package L37_DynamicStackQueue;

import L34_Stack.Stack;

public class DynamicStack extends Stack{

	@Override
	public void push(int item) throws Exception {
		
		if(isFull()) {
			
			// create a new array of double size
			int[] na =  new int[data.length * 2] ;
			
			// copy the old values
			for(int i = tos ; i >=0 ; i--) {
				na[i] = data[i] ;
			}
			
			// ref change
			data = na ;
			
		}
		
		super.push(item);
		
	}

}
