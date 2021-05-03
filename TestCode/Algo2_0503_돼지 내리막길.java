import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_광주_4반_정물결 {
	
	static int N,M;
	static int[][] map;
	static int[][] dp;
	static int[] dy = {0,0,-1,1}; //4방 탐색 상하좌우 
	static int[] dx = {-1,1,0,0}; //4방 탐색 상하좌우
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.valueOf(st.nextToken()); //
			N = Integer.valueOf(st.nextToken());
			
			map = new int[M][N];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			//같은 크기의 dp테이블을 생성하고 -1로 채운다.
			//dp[x][y] = x,y 지점에서 도착점까지 가는 경로 가짓수
			dp = new int[M][N];
			for(int i=0; i<M; i++) {
				Arrays.fill(dp[i], -1);
			}
			
			dp[0][0] = 0; //시작점의 dp 테이블을 0으로 둔다.
			dp[M-1][N-1] = 1; //도착점의 dp 테이블을 1로 둔다.
			dfs(0,0); //시작점부터 dfs를 돈다.
			
			sb.append(dp[0][0]).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int x, int y) {		
		for(int i=0; i<4; i++) { //4방탐색을 하면서
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			//지역 내 범위 제한을 주고, 내리막길을 찾는다.
			//top-down 방식으로 dp테이블을 채워나간다.
			if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny] < map[x][y]) {			
				if(dp[nx][ny] == -1) {// 계산되지 않은 곳일 경우
					//값을 0으로 변경하고 dfs를 돈 후, dp[x][y]에 dp[nx][ny]를 더해준다.
					dp[nx][ny] = 0;
					dfs(nx,ny);
					dp[x][y] += dp[nx][ny];
				}else {//아니면 그냥 dp[x][y]에 dp[nx][ny]를 더해준다.
					dp[x][y] += dp[nx][ny];
				}
			}
		}
	}

}
