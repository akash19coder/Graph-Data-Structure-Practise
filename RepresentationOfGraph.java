package graph;

import java.util.*;

public class RepresentationOfGraph {

	public static void main(String[] args) {
		// Adjacency Matrix Representation of Graph(Undirected and Unweighed)
		int vertices = 5;
		int edges = 5;
		int[][] matrix = new int[vertices + 1][edges + 1];

		// 1--2
		matrix[1][2] = 1;
		matrix[2][1] = 1;

		// 1--3
		matrix[1][3] = 1;
		matrix[3][1] = 1;

		// 2--4
		matrix[2][4] = 1;
		matrix[4][2] = 1;

		// 3--4
		matrix[3][4] = 1;
		matrix[4][3] = 1;

		// 2--5
		matrix[2][5] = 1;
		matrix[5][2] = 1;

		// 4--5
		matrix[4][5] = 1;
		matrix[5][4] = 1;

		// traversing through the adjacency matrix
		for (int i = 1; i <= vertices; i++) {
			for (int j = 1; j <= edges; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}
		matrixToList(matrix, vertices, edges);

		// Adjacency List Representation of Graph
		ArrayList<ArrayList<Integer>> al = new ArrayList();
		for (int i = 1; i <= vertices + 1; i++) {
			al.add(new ArrayList<Integer>());
		}

		System.out.println(al.size());
		// 1--2
		al.get(1).add(2);
		al.get(2).add(1);

		// 1--3
		al.get(1).add(3);
		al.get(3).add(1);

		// 2--4
		al.get(2).add(4);
		al.get(4).add(2);

		// 3--4
		al.get(3).add(4);
		al.get(4).add(3);

		// 2--5
		al.get(2).add(5);
		al.get(5).add(2);

		// 4--5
		al.get(4).add(5);
		al.get(5).add(4);

		// Traversing through the Adjacency List
		for (int i = 1; i < al.size(); i++) {

			System.out.print(i + "-->{" + al.get(i) + "}");

			System.out.println();
		}

		bfs(al);
	}

	public static void bfs(ArrayList<ArrayList<Integer>> al) {
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] visited = new int[al.size() + 1];
		queue.add(1);
		while (!queue.isEmpty()) {
			
			visited[queue.peek()] = 1;
			for (int i = 0; i < al.get(queue.peek()).size(); i++) {
				if (visited[al.get(queue.peek()).get(i)] != 1) {
					queue.add(al.get(queue.peek()).get(i));
					visited[al.get(queue.peek()).get(i)] = 1;
				}

			}
			result.add(queue.remove());
		}
		
	}

	public static void matrixToList(int[][] matrix, int row, int col) {
		ArrayList<ArrayList<Integer>> List = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= row; i++) {
			List.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i][j] != 0) {
					List.get(i).add(j);

				}
			}
		}
	}

}
