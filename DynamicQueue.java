package lecture9a15;

import lecture9a13.queue;

public class DynamicQueue extends queue {
	@Override
	public void enqueue(int item) throws Exception {
		if(this.isFull()) {
			int[] na = new int[2*this.data.length];
			int[] oa = this.data;
			for (int i = 0; i < this.size; i++) {
				int p = (this.front + i) % this.data.length;
				na[i]=oa[p];	
			}
			this.data=na;
			this.front=0;
		}
		super.enqueue(item);
	}
	
	
}
