/**
     *	The class that includes the methods of all the operations that the Vertex can do
     */

import java.util.LinkedList;
import java.util.List;

/**
 * Vertex class
 * @author UFUK
 *
 */
public class Vertex {
		//Data Field
		private int index;
		
		private String label;
		
		private double weight;
		
		private String property1;
		
		private String property2;
		
		private String property3;
		
		public List<Edge> AdjacencyList = new LinkedList<Edge>();
		
		/**
		 * Constructor of Vertex class.
		 */
		public Vertex(int tempIndex, String tempLabel, double tempWeight) {
			this.index = tempIndex;
			this.label = tempLabel;
			this.weight = tempWeight;
		}
		
		/**
		 * Get method of 'index'
		 * @return
		 */
		public int getIndex() {
			return index;
		}
		
		/**
		 * Get method of 'label'
		 * @return
		 */
		public String getLabel() {
			return label;
		}
		
		/**
		 * Get method of 'weight'
		 * @return
		 */
		public double getWeight() {
			return weight;
		}
		
		/**
		 * Get method of 'property1'
		 * @return
		 */
		public String getProp1() {
			return property1;
		}
		
		/**
		 * Get method of 'property2'
		 * @return
		 */
		public String getProp2() {
			return property2;
		}
		
		/**
		 * Get method of 'property3'
		 * @return
		 */
		public String getProp3() {
			return property3;
		}
		
		/**
		 * Set method of label
		 * @param temp
		 */
		public void setLabel(String temp) {
			this.label=temp;
		}
		
		/**
		 * Set method of weight
		 * @param temp
		 */
		public void setWeight(double temp) {
			this.weight=temp;
		}
		
		/**
		 * Set method of prop1
		 * @param temp
		 */
		public void setProp1(String temp) {
			this.property1=temp;
		}
		
		/**
		 * Set method of prop2
		 * @param temp
		 */
		public void setProp2(String temp) {
			this.property2=temp;
		}
		
		/**
		 * Set method of prop3
		 * @param temp
		 */
		public void setProp3(String temp) {
			this.property3=temp;
		}
}
