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
			//System.out.println("Does not contains "+v1+" or "+v2);
			return -1;
		}
		if(v1==v2) {//System.out.println("Adding self edge");
		return 0;}
		return vertices.get(v1).add_edge(v2) + vertices.get(v2).add_edge(v1);
		
	}
	
	public int delete_edge(int v1, int v2) {
		if(vertices.contains(new Vertex(v1))==false || vertices.contains(new Vertex(v2))==false) {
			//System.out.println("Does not contains "+v1+" or "+v2);
			return -1;
		}
		if(v1==v2) {//System.out.println("Deleting self edge");
		return 0;}
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
		Graph g = this.clone();
		ArrayList<Integer> temp = new ArrayList();
		for(int a : g.vertices.get(g.vertices.indexOf(new Vertex(v2))).edge) {//connecting all edges in v2 to v1
			//g.vertices.get(g.vertices.indexOf(new Vertex(v1))).add_edge(a);//add edge
			g.add_edge(v1, a);
			temp.add(a);
		}
		for(int a : temp) {
			g.delete_edge(v2,a);
		}
		g.delete_edge(v1, v2);
		g.vertices.remove(g.vertices.indexOf(new Vertex(v2)));
		for(Vertex v : g.vertices) {
			if(v.num>v2) {v.num--;}
			for(int k  = 0; k < v.edge.size();k++) {
				if(v.edge.get(k)>v2) {v.edge.set(k, v.edge.get(k)-1);}
			}
		}
		g.num--;
		return g;
		
	}
	
	public boolean isEdge_Empty() {
		for(Vertex v : this.vertices) {
			if(v.edge.isEmpty()==false) {return false;
			}
		}
		return true;
	}
	public int[] get_edge_in_graph() {
		Random rand = new Random();
		int a = rand.nextInt(this.vertices.size());
		int b = rand.nextInt(this.vertices.get(a).edge.size());
		int[] res={a,this.vertices.get(a).edge.get(b)};
		return res;
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
