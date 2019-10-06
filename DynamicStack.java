package lecture9a15;

import lecture9a13.Stack;

public class DynamicStack  extends Stack{

	@Override
	public void push(int item) throws Exception {
		if(this.isFull()) {
			int[] na = new int[2*this.data.length];
			int [] oa = data;
			for(int i=0 ; i<oa.length ; i++) {
				na[i]=oa[i];
			}
			data=na;
		}
		super.push(item);
	}

}
