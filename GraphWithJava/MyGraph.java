/**
     *	The class that includes the methods of all the operations that the MyGraph can do
     *  Implements  DynamicGraph Interface and Override its methods 
     */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * MyGraph class which wanted in HW8.
 * @author UFUK
 *
 */
public class MyGraph implements DynamicGraph {
	// Data Fields
	  /** The number of vertices */
	  private int numV;
	  
	  //
	  private int IndexCount=0;
	  
	  //
	  public List<Vertex> AllVertex = new ArrayList<Vertex>();
	
	  /** Flag to indicate whether this is a directed graph */
	  private boolean directed;
	  
	  /** An array of Lists to contain the edges that
      originate with each vertex. */
	  private List < Edge > [] edges;
	  
	  // Constructor
	  /** Construct a graph with the specified number of vertices
	      and the directed flag. If the directed flag is true,
	      this is a directed graph.
	      @param numV The number of vertices
	      @param directed The directed flag
	   */
	  public MyGraph(int numV, boolean directed) {
	    this.numV = numV;
	    this.directed = directed;
	  }
	  
	  //HW8 Methods
	  
	  public Vertex newVertex (String label, double weight) {
		  Vertex temp = new Vertex(IndexCount,label,weight);
		  IndexCount++;
		  return temp;
	  }
	  
	  public void addVertex(Vertex new_vertex) {
		  AllVertex.add(new_vertex);
		  numV++;
	  }
	  
	  public void addEdge (int vertexID1, int vertexID2, double weight) {
		  if( vertexID1 == vertexID2) {
			  return;
		  }
		  
		  int temp1=-1;
		  
		  boolean isfirstfound = false;
		  boolean issecondfound = false;
		  
		  for(int i=0 ; i<AllVertex.size() ; i++ ) {
			  if(AllVertex.get(i).getIndex() == vertexID1 ) {
				  temp1 = i;
				  isfirstfound=true;
			  }
			  if(AllVertex.get(i).getIndex() == vertexID2 ) {
				  issecondfound=true;
			  }
		  }
		  
		  if( isfirstfound == false || issecondfound == false ) {
			  return;
		  }
		 
		  Edge temp = new Edge(vertexID1,vertexID2,weight);
		  AllVertex.get(temp1).AdjacencyList.add(temp);
	  }

	  public void removeEdge (int vertexID1, int vertexID2) {
		  if(vertexID1 == vertexID2) {
			  return;
		  }
		  
		  int temp1=-1;
		  for(int i=0; i<AllVertex.size() ; i++) {
			  if(AllVertex.get(i).getIndex() == vertexID1) {
				  temp1=i;
				  break;
			  }
		  }
		  
		  if( temp1 == -1) {
			  return;
		  }
		  
		  for(int j=0; j<AllVertex.get(temp1).AdjacencyList.size() ; j++) {
			  if(AllVertex.get(temp1).AdjacencyList.get(j).getDest() == vertexID2) {
				  AllVertex.get(temp1).AdjacencyList.remove(j);
				  break;
			  }
		  }
	  }

	  public void removeVertex (int vertexID) {
		  for(int i=0; i<AllVertex.size(); i++) {
			  if(AllVertex.get(i).getIndex() == vertexID) {
				  AllVertex.remove(i);
				  numV--;
				  break;
			  }
		  }
		  //or can not find
	  }

	  public void removeVertex (String label) {
		  for(int i=0; i<AllVertex.size(); i++) {
			  if(AllVertex.get(i).getLabel() == label) {
				  AllVertex.remove(i);
				  numV--;
			  }
		  }
	  }
	  
	  public MyGraph filterVertices (String key, String filter) {
		  MyGraph temp = new MyGraph(0,true);
		  
		  if( key == "1" ) {
			  for(int i=0 ; i<AllVertex.size() ; i++ ) {
				  if(AllVertex.get(i).getProp1() == filter ) {
					  temp.addVertex(AllVertex.get(i));
				  }
			  }
		  }
		  
		  if( key == "2" ) {
			  for(int j=0 ; j<AllVertex.size() ; j++ ) {
				  if(AllVertex.get(j).getProp2() == filter ) {
					  temp.addVertex(AllVertex.get(j));
				  }
			  }
		  }
		  
		  if( key == "3" ) {
			  for(int k=0 ; k<AllVertex.size() ; k++ ) {
				  if(AllVertex.get(k).getProp3() == filter ) {
					  temp.addVertex(AllVertex.get(k));
				  }
			  }
		  }
		  
		  return temp;
	  }
	  
	  public int[][] exportMatrix() {
		  int[][] temp = new int[AllVertex.size()][AllVertex.size()];
		  boolean ishave=false;
		  
		  for(int i=0; i<AllVertex.size(); i++) {	  
			  for(int j=0 ; j<AllVertex.size(); j++) {
				  for(int k=0; k<AllVertex.get(i).AdjacencyList.size(); k++ ) {
					  if(AllVertex.get(i).AdjacencyList.get(k).getDest() == AllVertex.get(j).getIndex()) {
						  ishave=true;
						  break;
					  }
				  }
				  if(ishave == true) {
					  temp[i][j]=1;
				  }
				  else {
					  temp[i][j]=0;
				  }
				  ishave=false;
			  }
		  }
		  return temp;
	  }

	  public void printGraph() {
		  System.out.println("-----GRAPH IN ADJACENCY LIST FORMAT-----");
		  for(int i=0; i<AllVertex.size(); i++) {
			  System.out.print("[Node" + AllVertex.get(i).getIndex() + "]" );
			  	for(int j=0; j<AllVertex.get(i).AdjacencyList.size() ; j++) {
			  		System.out.print(" -> [Node" + AllVertex.get(i).AdjacencyList.get(j).getDest() + "|" + AllVertex.get(i).AdjacencyList.get(j).getWeight() +"]" );
			  	}
			  	System.out.println();
		  }
	  }
	  
	  //The following methods are copied from the AbstracthGraph class 
	  //due to the errors that occur as a result of the implementation of Graph interface.
	  // Accessor Methods
	  /** Return the number of vertices.
	      @return The number of vertices
	   */
	  public int getNumV() {
	    return numV;
	  }

	  /** Return whether this is a directed graph.
	      @return true if this is a directed graph
	   */
	  public boolean isDirected() {
	    return directed;
	  }
	  
	  public Iterator < Edge > edgeIterator(int source) {
		    return edges[source].iterator();
		  }
	  
	  /** Insert a new edge into the graph.
      @param edge The new edge
   */
	  public void insert(Edge edge) {
		  edges[edge.getSource()].add(edge);
		  if (!isDirected()) {
			  edges[edge.getDest()].add(new Edge(edge.getDest(),
                                   edge.getSource(),
                                   edge.getWeight()));
		  }
	  }
	  
	  /** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
	  public boolean isEdge(int source, int dest) {
		  return edges[source].contains(new Edge(source, dest));
	  }
	  
	  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
	  public Edge getEdge(int source, int dest) {
		    Edge target =
		        new Edge(source, dest, Double.POSITIVE_INFINITY);
		    for (Edge edge : edges[source]) {
		      if (edge.equals(target))
		        return edge; // Desired edge found, return it.
		    }
		    // Assert: All edges for source checked.
		    return target; // Desired edge not found.
	  }

	  // Other Methods
	  /** Load the edges of a graph from the data in an input file.
	      The file should contain a series of lines, each line
	      with two or three data values. The first is the source,
	      the second is the destination, and the optional third
	      is the weight.
	      @param bR The buffered reader containing the data
	      @throws IOException if an I/O error occurs
	   */
	  public void loadEdgesFromFile(BufferedReader bR) throws IOException {
	    // Programming Exercise 1
	  }

	  /** Factory method to create a graph and load the data from an input
	      file. The first line of the input file should contain the number
	      of vertices. The remaining lines should contain the edge data as
	      described under loadEdgesFromFile.
	      @param bR The BufferedReader that is connected to
	                            the file that contains the data
	      @param isDirected true if this is a directed graph,
	                        false otherwise
	      @param type The string "Matrix" if an adjacency matrix is to be
	                  created, and the string "List" if an adjacency list
	                  is to be created
	      @throws IOException if there is an I/O error
	      @throws IllegalArgumentException if type is neither "Matrix"
	                                       nor "List"
	   */
}
