package algorithm;

import java.util.*;

import structure.Graph;
import structure.Vertex;

public class DeletionContractionAlgo {
	static boolean[] visited;

	public static ArrayList<Integer> find_Loop(Graph g) {
		visited=new boolean[g.num];
		Stack<Integer> a = new Stack();
		ArrayList<Integer> path=new ArrayList();
		for(int i =0; i < g.num;i++) {
			ArrayList<Integer> returned =DFS_loop(g,new ArrayList(),i,-1);
			if(returned!=null) {
				return returned;
			}
		}
		return null;
	}
	public static ArrayList<Integer> DFS_loop(Graph g, ArrayList<Integer> arr, int curr,int parent){
		if(visited[curr]==true) {//find a loop
			return arr;
		}
		if(g.vertices.get(g.vertices.indexOf(new Vertex(curr))).edge.size()==0) {//no children
			return null;
		}
		visited[curr]=true;//mark visited
		arr.add(curr);//add current node to the path
		for(int a : g.vertices.get(g.vertices.indexOf(new Vertex(curr))).edge) {
			if(a==parent) {continue;}
			ArrayList<Integer> returned=DFS_loop(g,arr,a,curr);
			if(returned!=null) {
				return returned;
			}
		}
		arr.remove(arr.size()-1);
		return null;
	}
	
	
	
	public static boolean check_Loop(Graph g, int v1, int v2) {
		Graph g2=g.clone();
		if(g2.delete_edge(v1, v2)!=0) {System.out.println("check_Loop deleting non-existing edge");return false;}
		visited=new boolean[g.num];
		return DFS_back(g2,v1,-1,v2);
	}
	
	public static boolean DFS_back(Graph g, int curr,int parent, int target){
		if(visited[curr]==true) {//find a loop
			return false;
		}
		if(curr==target) {
			return true;
		}
		if(g.vertices.get(g.vertices.indexOf(new Vertex(curr))).edge.size()==0) {//no children
			return false;
		}
		visited[curr]=true;//mark visited
		//arr.add(curr);//add current node to the path
		for(int a : g.vertices.get(g.vertices.indexOf(new Vertex(curr))).edge) {
			if(a==parent) {continue;}
			boolean returned=DFS_back(g,a,curr,target);
			if(returned==true) {
				return true;
			}
		}

		return false;
	}
	

	
	public static boolean check_Cut(Graph g, int v1, int v2) {
		Graph g2=g.clone();
		if(g2.delete_edge(v1, v2)!=0) {System.out.println("check_Cut deleting non-existing edge");return false;}
		visited=new boolean[g.num];
		return !DFS_back(g2,v1,-1,v2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		g.add_edge(0, 1);
		g.add_edge(0, 3);
		//g.add_edge(1, 2);
		g.add_edge(2, 3);
		g.show_adj();
		System.out.println(check_Loop(g,0,1));
		System.out.println(check_Cut(g,0,1));
//		ArrayList<Integer> returned=find_Loop(g);
//		System.out.println(returned.toString());
//		Graph g2=g.clone();
//		g.delete_edge(0, 1);
//		g2.delete_edge(0, 3);
//		g.show_adj();
//		g2.show_adj();
	}

}
