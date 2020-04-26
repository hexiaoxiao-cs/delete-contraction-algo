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
//			if(visited[i]==true) {continue;}
//			a.add(i);
//			int current;
//			while(!a.empty()) {
//				current=a.pop();
//				if(visited[current]==true) {continue;}
//				visited[i]=true;
//				a.addAll(g.vertices.get(g.vertices.indexOf(new Vertex(current))).edge);//add all of its neighbours to the stack
//				path.add(current);
//			}
//			
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
//			System.out.println(a);
//			System.out.println(curr);
			if(a==parent) {continue;}
			ArrayList<Integer> returned=DFS_loop(g,arr,a,curr);
			if(returned!=null) {
				return returned;
			}
		}
		arr.remove(arr.size()-1);
		return null;
	}
	
	public static void find_Cut(Graph g) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(5);
		
		g.add_edge(0, 1);
		g.add_edge(0, 3);
		g.add_edge(1, 2);
		g.add_edge(2, 3);
		g.show_adj();
		ArrayList<Integer> returned=find_Loop(g);
		System.out.println(returned.toString());
//		Graph g2=g.clone();
//		g.delete_edge(0, 1);
//		g2.delete_edge(0, 3);
//		g.show_adj();
//		g2.show_adj();
	}

}
