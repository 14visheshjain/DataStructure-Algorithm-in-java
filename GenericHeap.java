package lecture9a22;
import java.util.ArrayList;
public class GenericHeap<T extends Comparable<T>> {
	ArrayList<T> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void add(T item) {
		this.data.add(item);
		upheapify(this.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (isLarger(this.data.get(ci), this.data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int i, int j) {
		T ith = this.data.get(i);
		T jth = this.data.get(j);
		this.data.set(i, jth);
		this.data.set(j, ith);
	}

	public T remove() {
		swap(0, this.size() - 1);
		T rv = this.data.remove(this.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < this.data.size() && isLarger(this.data.get(lci), this.data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < this.data.size() && isLarger(this.data.get(rci), this.data.get(mini)) > 0) {
			mini = rci;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	private int isLarger(T o1, T o2) {
		return o1.compareTo(o2);
	}

	public void display() {
		System.out.println(this.data);
	}

	public T getHP() {
		return this.data.get(0);
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

}
