package algo.study.thisweek;

import java.io.BufferedReader;

/*
 * 아이디어
 * 1. dfs로 경로를 구한다
 *   - 실패 : 시간초과
 *   	- 갔던 경로를 또 가야한다.
 * 2. dfs + dp : dfs로 들어가면서 마지막과 연결된 부분들을 구해와 dp 테이블을 채운다
 *   - 실패 : 시간 초과
 *   	- 처음에 dp배열을 0으로 초기화하고 들어가서, 
 *   	- 0이면 탐색을하고, 0이 아니면 값을 더해주고 경로를 더 안따라가게 했다.
 *   	- 그러나, 0일 경우 탐색을 했는데, 연결이 도착점과 연결이 안된 것인지
 *      - 탐색을 안한것인지 구별하지못해 탐색을 했음에도 도착점과 연결이 안된 경로를
 *      - 재탐색하게 된다.
 * 3. visited 배열로 방문을 체크한다.
 * 
 * 
 * 
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_1520_DownhillPath_DP {

	static int R, C, cnt;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		dp = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[R-1][C-1] = 1;
		dfs(0,0);
		
		System.out.println(dp[0][0]);
	}


	private static void dfs(int i, int j) {
		if(i==R-1 && j==C-1) {
			return;
		}
		
		if(visited[i][j]) {
			return;
		}
		
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >=0 && nx <R && ny >=0 && ny <C && map[i][j] > map[nx][ny]) {
				if(dp[nx][ny] != 0) {
					dp[i][j] += dp[nx][ny];
					continue;
				}else {
					dfs(nx,ny);
					dp[i][j] += dp[nx][ny];
				}
			}
		}
	}
}
