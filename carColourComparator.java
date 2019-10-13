package lecture9a21;

import java.util.Comparator;

public class carColourComparator implements Comparator<car> {

	@Override
	public int compare(car o1, car o2) {
	                     
		return o1.colour.compareTo(o2.colour);
	}

	
}
