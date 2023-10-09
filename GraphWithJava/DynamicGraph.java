////////////////////////////////DynamicGraph Interface////////////////////////////////////
	/**
     *  It is inside  MyGraph methods.
     *  Implements Graph Interface.
     */
public interface DynamicGraph extends Graph {
	
	/**
     *   Creates new vertex according to parameters.
     * @param label
     * @param weight
     * @return
     */
	Vertex newVertex (String label, double weight);
	
	/**
     *   Adds Vertex to MyGraph object.
     * @param new_vertex
     */
	void addVertex (Vertex new_vertex);
	
	/**
     *   Adds Edge between the vertices with Ids in the parameters and set weight of new edge.
     * @param vertexID1
     * @param vertexID2
     * @param weight
     */
	void addEdge (int vertexID1, int vertexID2, double weight);
	
	/**
     *   Removes the edge between vertices
     * @param vertexID1
     * @param vertexID2
     */
	void removeEdge (int vertexID1, int vertexID2);
	
	/**
     *   Removes the vertex according to information in the parameter.
     * @param vertexID
     */
	void removeVertex (int vertexID);
	
	/**
     *   Removes the vertex according to information in the parameter.
     * @param label
     */
	void removeVertex (String label);
	
	/**
     *   Filter the vertices in the graph according to key and filter. Adds it into new MyGraph object and returns it.
     * @param key
     * @param filter
     * @return
     */
	MyGraph filterVertices (String key, String filter);
	
	/**
     *   Creates an Adjacency Matrix according to vertices and their edges. Returns 2d integer Array.
     * @return
     */
	int[][] exportMatrix();
	
	/**
     *   Prints the Graph.
     */
	void printGraph();
}
