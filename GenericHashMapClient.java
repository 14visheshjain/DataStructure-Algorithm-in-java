package lecture9a22;

public class GenericHashMapClient {

	public static void main(String[] args) throws Exception {
	GenericHashMap<String , Integer> hp = new GenericHashMap<>(4);
	hp.put("aus", 10);
	hp.put("india", 20);
	hp.put("pak", 30);
	hp.put("us", 40);
	hp.put("us1", 401);
	
	hp.put("us2", 402);
	hp.display();
	System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	hp.put("us3", 403);
	System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	hp.display();
	System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	System.out.println(hp.get("us"));
	System.out.println(hp.get("aus1"));
	System.out.println(hp.remove("us"));
	System.out.println(hp.remove("us1"));
		//	hp.display();
	hp.display();
} 
}
