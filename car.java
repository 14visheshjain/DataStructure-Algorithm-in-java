package lecture9a21;

public class car implements Comparable<car> {
int price ;
int speed ;
String colour;
public car(int price , int speed , String colour) {
	this.colour = colour ;
	this.speed = speed;
	this.price = price ; 
}
@Override
public String toString() {
	return ("P:"+this.price+" S:"+this.speed+" C:"+this.colour);
}
public int compareTo(car o) {
//	return this.speed - o.speed ;
//	return o.price - this.price ;
	return this.colour.compareTo(o.colour);
}

}
