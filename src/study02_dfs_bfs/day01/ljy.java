package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1962 {
	public static int[][] graph;
	public static boolean[][] visited;
	public static int N;
	public static int M;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int mCnt;
	public static int mArea;
	public static int area;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mCnt = 0;
		mArea = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					area = 1;
//					bfs(i, j);
					visited[i][j] = true;
					dfs(i, j);
					mCnt++;
					if (mArea < area) {
						mArea = area;
					}
				}
			}
		}
		System.out.println(mCnt);
		System.out.println(mArea);
		
	}
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0];
			int py = pos[1];
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if ((nx>=0&&nx<N)&&(ny>=0&&ny<M)) {
					if (!visited[nx][ny] && graph[nx][ny] == 1) {
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny});
						area++;
					}
				}
			}
		}
	}
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx>=0&&nx<N)&&(ny>=0&&ny<M)) {
				if(!visited[nx][ny] && graph[nx][ny] == 1) {
					visited[nx][ny] = true;
					area++;
					dfs(nx, ny);
				}
			}
		}
	}

}
