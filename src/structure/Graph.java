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
	public Graph() {
		
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
	
	public Graph clone() {
		Graph g=new Graph();
		g.num=this.num;
		for(int i = 0; i < num; i++) {
			g.vertices.add(this.vertices.get(i).clone());
		}
		
		return g;
	}
	
	public Graph deletion(int v1, int v2) {
		Graph g = this.clone();
		if(g.delete_edge(v1, v2)!=0) {return null;}
		return g;
		
	}
	
	public Graph contraction(int v1, int v2) {
		return null;
		
	}
	
	public void show_adj() {
		int[][] a = new int[num][num];
		for(int i = 0; i < num; i++) {
			Vertex c = this.vertices.get(i);
			for(int j = 0 ; j < c.edge.size();j++) {
				a[i][c.edge.get(j)]=1;
			}
		}
		for(int i = 0; i < num; i ++) {
			for(int j=0; j<num; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		return;
	}
	
}
