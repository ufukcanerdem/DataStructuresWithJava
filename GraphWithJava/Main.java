import java.util.*;

/**
 * Driver and main of HW8
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  03.06.2022
 */
public class Main {
	
	/**
	 * Prints the result of HW8-q2
	 * @param obj
	 */
	public static void q2(MyGraph obj) {
		double BfsDistance = bfs(obj);
		
		System.out.println("BFS distance of object is -> " + BfsDistance);
	}
	
	/**
	 * Calculates the distance of a graph with BFS traversal and returns.
	 * @param obj
	 * @return
	 */
	public static double bfs(MyGraph obj) {
		Vertex root = obj.AllVertex.get(0);
		Boolean IsIn=false;
		
		List<Integer> vIds = new ArrayList<Integer>();		//Visited
		List<Integer> qIds = new LinkedList<Integer>();		//In queue
		
		if( root == null ) {
			return 0;
		}
		
		vIds.add(root.getIndex());
		int k=obj.getNumV();
		int p=1;
		double TotalDistance=0.0;
		System.out.println("k=" + k);
		Vertex rootTemp=root;
		Vertex destTemp;
		
		while(k>0) {
			for(int i=0; i<root.AdjacencyList.size(); i++) {
				for(int j=0; j<qIds.size(); j++) {
					if(root.AdjacencyList.get(i).getDest() == qIds.get(j) ) {
						IsIn=true;
					}
				}
				if(IsIn==false) {
					System.out.println("Addedq->" + root.AdjacencyList.get(i).getDest());
					qIds.add(root.AdjacencyList.get(i).getDest());
					
					TotalDistance+=root.AdjacencyList.get(i).getWeight();
					vIds.add(root.AdjacencyList.get(i).getDest());
					
				}
				IsIn=false;
			}
			
			if(p<obj.AllVertex.size()) {
				root=obj.AllVertex.get(p);
			}
			p++;
			k--;
		}
		System.out.println("Final Total Size->" + TotalDistance);
		return TotalDistance;
	}
	
	/**  
     * @param args
     */
	  public static void main(String args[]){
		  
		  //Creates MyGraph object then creates vertices and add that vertices to MyGraph object which
		  //is 'test1'
		  MyGraph test1 = new MyGraph(0,true);
		  
		  Vertex v0 = test1.newVertex("a", 1.1);
		  Vertex v1 = test1.newVertex("b", 2.7);
		  Vertex v2 = test1.newVertex("c", 1.1);
		  Vertex v3 = test1.newVertex("a", 3.9);
		  Vertex v4 = test1.newVertex("d", 7.3);
		  Vertex v5 = test1.newVertex("x", 5.3);
		  
		  test1.addVertex(v0);
		  test1.addVertex(v1);
		  test1.addVertex(v2);
		  test1.addVertex(v3);
		  
		  //Adds edges between vertices in the test1 object.
		  test1.addEdge(0,2,11.3);
		  test1.addEdge(0,3,8.7);
		  test1.addEdge(0,1,17.9);
		  test1.addEdge(2,1,8.9);
		  test1.addEdge(1,1,9.9);
		  test1.addEdge(1, 3, 3.5);
		  
		  test1.printGraph();
		  
		  Vertex v6 = test1.newVertex("h", 98.1);
		  
		  //Tests remove methods.
		  test1.removeEdge(0, 3);
		  test1.removeEdge(2, 1);
		  test1.removeVertex(0);
		  test1.removeVertex("h");
		  
		  
		  test1.addVertex(v4);
		  test1.addEdge(4, 2, 5.5);
		  
		  test1.removeVertex(4);
		  test1.addVertex(v5);
		  test1.addEdge(5, 3, 0.3);
		  
		  test1.printGraph();
		  
		  test1.addVertex(v0);
		  
		  MyGraph testsubgraph;
		  
		  //Tests filter method.
		  test1.AllVertex.get(0).setProp1("red");
		  test1.AllVertex.get(1).setProp1("blue");
		  test1.AllVertex.get(2).setProp1("purple");
		  test1.AllVertex.get(3).setProp1("red");
		  test1.AllVertex.get(4).setProp1("red");
		  
		  testsubgraph = test1.filterVertices("1", "red");
		  
		  for(int k=0 ; k< testsubgraph.AllVertex.size() ; k++ ) {
			  System.out.println("k -> " + testsubgraph.AllVertex.get(k).getProp1() + " indexid-> " + testsubgraph.AllVertex.get(k).getIndex());
		  }
		  
		  //EXPORT MATRIX USAGE AND PRINTING
		  int[][] exportmatrix = test1.exportMatrix();
		  
		  System.out.print(" ");
		  for(int i=0; i<test1.AllVertex.size(); i++ ) {
			  System.out.print(" " + test1.AllVertex.get(i).getIndex());
		  }
		  System.out.println();
		  System.out.print(" ");
		  for(int i=0; i<test1.AllVertex.size(); i++ ) {
			  System.out.print(" -");
		  }
		  System.out.println();
		  
		  for(int i=0; i<test1.AllVertex.size(); i++) {
			  System.out.print(test1.AllVertex.get(i).getIndex() + "|");
			  for(int j=0; j<test1.AllVertex.size(); j++) {
				  System.out.print(exportmatrix[i][j] + " ");
			  }
			  System.out.println();
		  }
		  
		  //Tests Q2 of HW8
		  test1.addEdge(2, 5, 5.1);
		  test1.removeEdge(0, 1);
		  test1.removeEdge(2,1);
		  test1.addEdge(5, 1, 6.3);
		  
		  test1.printGraph();
		  
		  
		  q2(test1);
	  }
}
