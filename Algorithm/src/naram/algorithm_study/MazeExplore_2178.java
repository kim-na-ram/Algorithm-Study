import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class Node {
    
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}

public class MazeExplore_2178 {
    
    public static int N, M;
    public static int[][] maze;
    public static int[][] visited;
    
    public static void bfs() {
        
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.offer(new Node(0, 0));
        
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};
        // �߰��� ��� �湮ó��
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.x;
            int col = node.y;

            // �����¿� 4���� ��忡 ���� �۾�
            for(int i = 0 ; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];

                if(checkNode(x, y)) {
                    // ť�� ���� ��� �߰�
                    queue.offer(new Node(x, y));
                    // �߰��� �������� �Ÿ� = ���� �������� �Ÿ� + 1
                    visited[x][y] = visited[row][col] + 1;
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
        
    }
    
    public static boolean checkNode(int row, int col) {
        // ��尡 ���� ���� ���
        if(row < 0 || row >= N || col < 0 || col >= M) return false;
        // �̹� �湮�� ����� ���
        if(visited[row][col] != 0 || maze[row][col] == 0) return false;
        return true;
    }
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    maze = new int[N][M];
	    visited = new int[N][M];
	    
	    for(int i = 0; i < N; i++) {
	        String line = br.readLine();
	        for(int j = 0; j < M; j++) {
	            maze[i][j] = line.charAt(j) - '0';
	            visited[i][j] = 0;
	        }
        }
	            
	   bfs();
	    
	}
}