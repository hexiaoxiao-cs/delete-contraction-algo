package algorithm;

import structure.Graph;
import structure.Vertex;

public class DeletionContractionAlgo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(5);
		g.add_edge(0, 1);
		Graph g2=g.clone();
		g.delete_edge(0, 1);
		g.show_adj();
		g2.show_adj();
	}

}
