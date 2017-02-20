package Isomorphism;

public class Isomorph {

	public int[] perm;

	public Isomorph(int k){
		perm = new int[k];
		for(int p=0; p < perm.length; p++){

			perm[p] = -1;
		}
	}

	boolean DFS(int n, int level, int[][] graph1, int[][] graph2, boolean[] used) {  
		boolean result = false;
		if (level == -1) {
			result = checkEdges(n, graph1, graph2);
		} else {
			int i = 0;
			while (i < n && result == false) {
				if (used[i] == false) {
					used[i] = true;
					perm[level] = i;
					result = DFS(n, level - 1, graph1, graph2, used);
					used[i] = false;
				}
				i++;
			}
		}
		return result;
	}

	boolean checkEdges(int n, int[][] graph1, int[][] graph2) {  
		boolean same = true;
		for(int x = 0; x < n; x++) {
			int y = 0;
			while (y < n && same == true) {
				if  (graph1[x][y] != graph2[perm[x]][perm[y]]) {
					same = false;
				}
				y++;
			}
		}
		return same;
	}

	void isomorphism(int[][] graph1, int[][] graph2) {
		int n = graph1.length;
		boolean[] used = new boolean[n];
		for(int j=0; j <n; j++){
			used[j] = false;
		}
		boolean isomorphic = DFS(n, n - 1, graph1, graph2, used);
		if (isomorphic == true) {
			System.out.println("isomorphic");
			System.out.println("Orderings of vertices in graph-1: ");
			for (int i = 0; i < n; i++) {
				System.out.print((i+1)+"  ");
			}
			System.out.println();
			System.out.println("Orderings of vertices in graph-2: ");

			for (int i = 0; i < n; i++) {
				System.out.print((perm[i]+1)+"  ");
			}
		} else {
			System.out.println("not isomorphic");
		}
	}
	public static void main(String[] args) {

		//case1
		int[][] graph1 = {{0, 1, 0, 0, 1, 1, 0},
			{1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{0, 1, 0, 1, 1, 1, 0}};

			int[][] graph2 = {{0, 1, 0, 1, 1, 0, 0},
					{1, 0, 0, 0, 0, 1, 1},
					{0, 0, 0, 1, 1, 1, 0},
					{1, 0, 1, 0, 0, 0, 0},
					{1, 0, 1, 0, 0, 1, 1},
					{0, 1, 1, 0, 1, 0, 0},
					{0, 1, 0, 0, 1, 0, 0}};



			//case2
			/*int[][]  graph1 = {{0, 1, 1, 1, 1, 0},
				{1, 0, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 1},
				{1, 0, 0, 0, 0, 1},
				{1, 1, 1, 0, 0, 1},
				{0, 1, 1, 1, 1, 0}};

		int[][]  graph2 = {{0, 0, 0, 0, 0, 1},
				{0, 0, 0, 1, 1, 0},
				{0, 0, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 1},
				{0, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 0, 0}};*/

			//case3
			/*	int[][] graph1 = {{0, 0, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 1, 1, 0},
				{1, 0, 0, 0, 1, 1, 0},
				{1, 1, 1, 1, 0, 0, 1},
				{1, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 1, 1, 0}};

		int[][] graph2 = {{0, 0, 0, 0, 0, 0, 1},
				{0, 0, 1, 1, 0, 1, 1},
				{0, 1, 0, 0, 0, 1, 1},
				{0, 1, 0, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 1, 1},
				{0, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 0, 0}};*/

			
			Isomorph iso = new Isomorph(graph1.length);
			iso.isomorphism(graph1, graph2);
	}
}
