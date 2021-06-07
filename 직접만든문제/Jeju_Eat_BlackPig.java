import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jeju_Eat_BlackPig {
	
	final static int row = 7;
	final static int col = 7;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dxC = {0,-1,-1,-1,0,1,1,1};
	static int[] dyC = {-1,-1,0,1,1,1,0,-1};
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.valueOf(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");

			int[][] map = new int[row][col];
			int[] startPos =  new int[3];
			Queue<int[]> cloudPos = new LinkedList<>();
			
			for(int i=0; i<row; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<col; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
					if(map[i][j] == -1) {
						startPos[0] = i;
						startPos[1] = j;
						startPos[2] = 0;
					}
					
					if(map[i][j] == 2) {
						cloudPos.offer(new int[] {i,j});
					}
				}
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int windDirCnt = Integer.valueOf(st.nextToken());
			int[] windDir = new int[windDirCnt];
			
			for(int i=0; i<windDirCnt; i++) {
				windDir[i] = Integer.valueOf(st.nextToken());
			}
			
			int[] answer = bfs(map, startPos, cloudPos, windDir, windDirCnt);
			sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	private static int[] bfs(int[][] map, int[] startPos, Queue<int[]> cloudPos, int[] windDir, int windDirCnt) {
		boolean[][] visited = new boolean[7][7];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(startPos);
		visited[startPos[0]][startPos[1]] = true;
		int time = 0;
		int answer[] = {0, Integer.MAX_VALUE};
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] pos = queue.poll();
				int x = pos[0];
				int y = pos[1];
				int meetCnt = pos[2];
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx <0 || nx >=7 || ny<0 || ny>=7|| map[nx][ny]==1 || map[nx][ny]==3 || visited[nx][ny]) continue;
					if(map[nx][ny]==2) meetCnt++;
					if(map[nx][ny]==4) {
						answer[0] = time+1;
						answer[1] = answer[1] < meetCnt ? answer[1] : meetCnt;
					}
					
					visited[nx][ny] = true;
					queue.offer(new int[] {nx,ny,meetCnt});
					
				}
				
			}
			
			if(answer[0] != 0) break;
			cloudPos = cloudRotate(cloudPos, time, windDir, windDirCnt);
			time++;
		}
		
		
		return answer;
	}

	private static Queue<int[]> cloudRotate(Queue<int[]> cloudPos, int idx, int[] windDir, int windDirCnt) {
		int cloudCnt = cloudPos.size();
		
		for(int i=0; i<cloudCnt; i++) {
			int[] pos = cloudPos.poll();
			//범위 체크
			int newPosX = pos[0] + dxC[idx % windDirCnt];
			int newPosY = pos[1] + dyC[idx % windDirCnt];
			
			if(newPosX >= 0 && newPosX <7 && newPosY >=0 && newPosY <7) {
				pos[0] = newPosX;
				pos[1] = newPosY;
			}
			
			cloudPos.offer(pos);
		}

		return cloudPos;
	}

}
