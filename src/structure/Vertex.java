package structure;
import java.io.*; 
import java.util.*;
public class Vertex {
	public int num;
	public ArrayList<Integer> edge;
	public Vertex(int num) {
		this.num=num;
		this.edge= new ArrayList();
	}
	public int add_edge(int v) {
		if(this.edge.contains(v)==true) {
			System.out.println("Trying to add repeating edge in "+num+" that connects "+v);
			return -1;
		}
		this.edge.add(v);
		return 0;
	}
	
	public int delete_edge(int v) {
		if(this.edge.contains(v)==false) {
			System.out.println("Trying to delete non-existing edge in "+num+" that connects "+v);
			return -1;
		}
		this.edge.remove(v);
		return 0;
	}
	
	public boolean equals(int num) {
		if(this.num==num) {return true;}
		return false;
	}
	
	public boolean equals(Object o) {
	if (this == o) {return true;}
	if (this == null) {return false;}
	Vertex vertex = (Vertex) o;
	if (this.num==vertex.num) {return true;}
	return false;
	}

}
