package lecture9a25;

import java.util.HashMap;

public class GraphClient {
public static void main(String[] args) {
	Graph g = new Graph();
	g.addVertex("A"); 
	g.addVertex("B"); 
	g.addVertex("C"); 
	g.addVertex("D"); 
	g.addVertex("E"); 
	g.addVertex("F"); 
	g.addVertex("G"); 
	g.addVertex("i");
	g.addVertex("j");
	g.addEdge("A", "i", 1);
	g.addEdge("A", "B", 1);
	g.addEdge("B", "C", 1);
	g.addEdge("C", "D", 1);
	g.addEdge("A", "D", 1);
	g.addEdge("E", "D", 1);
	g.addEdge("E", "F", 1);
	g.addEdge("G", "F", 1);
	g.addEdge("E", "G", 1);
	g.BreadthFirstTaversal();
//	g.display();
//	System.out.println(g.numEdges()+g.numVertex());
//	System.out.println(g.containVertex("a"));
//	System.out.println(g.containsedge("A","a"));
//   System.out.println(g.containsedge("A", "B"));
//   System.out.println(g.containVertex("D"));
//  g.removeEdge("B", "C");
  //g.removeEdge("D", "E");
//  g.removeEdge("G", "F");
//   g.display();
  // g.removeVertex("D");
//   g.display();
//	
//   System.out.println( g.BreadthFirstSeacrch("A", "F"));
//   System.out.println( g.DepthFirstSeacrch("A", "F"));
//   g.BreadthFirstTaversal();
//   g.DepthFirstTaversal();
//   System.out.println(g.IsConnected());
 //  System.out.println(g.isBipertite());
}
}
