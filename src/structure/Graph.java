package structure;

import java.io.*; 
import java.util.*;


public class Graph {
	public ArrayList<Vertex> vertices = new ArrayList();
	public int num;
	
	public Graph(int num) {
		this.num=num;
		for(int i = 0 ; i<num; i++) {
			this.vertices.add(new Vertex(i));
		}
	}
	
	public int add_edge(int v1,int v2) {
		if(vertices.contains(new Vertex(v1))==false || vertices.contains(new Vertex(v2))==false) {
			System.out.println("Does not contains "+v1+" or "+v2);
			return -1;
		}
		return vertices.get(v1).add_edge(v2) + vertices.get(v2).add_edge(v1);
		
	}
	
	public int delete_edge(int v1, int v2) {
		if(vertices.contains(new Vertex(v1))==false || vertices.contains(new Vertex(v2))==false) {
			System.out.println("Does not contains "+v1+" or "+v2);
			return -1;
		}
		return vertices.get(v1).delete_edge(v2) + vertices.get(v2).delete_edge(v1);
	}
	
}