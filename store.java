package lecture9a22;

public class store implements Comparable<store>{
int data ;
int listNo ;

@Override
public int compareTo(store o) {
	return  o.data-this.data; 
			
} 

}
