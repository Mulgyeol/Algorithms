package algo.study.thisweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_21611_마법사상어와블리자드 {
	
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int[][] map, index;
	static int[] line, answer;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		map = new int[N+1][N+1];
		index = new int[N+1][N+1];
		line = new int[N*N+1];
		answer = new int[4];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		makeOneLine(); //1차원 배열로 바꿔보는 함수
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.valueOf(st.nextToken());
			int s = Integer.valueOf(st.nextToken());
			blizzard(d,s);
			move();
			while(explosion()) {
				move();
			}
			grouping();

		}
		
		int realAnswer = 0;
		for(int i=1; i<=3; i++) {
			realAnswer += answer[i]*i;
		}
		
		System.out.println(realAnswer);
	}

	private static void grouping() {
		int [] newLine = new int[N*N+1];
		int curBall = line[1];
		int cnt = 1;
		int startIdx =1;
		for(int i=2; i<N*N; i++) {
			if(line[i] != curBall) {
				newLine[startIdx++] = cnt;
				if(startIdx == N*N) {
					line = newLine;
					return; //구슬이 칸 수보다 많아지면 끝
				}
				newLine[startIdx++] = curBall;
				if(startIdx == N*N) {
					line = newLine;
					return; //구슬이 칸 수보다 많아지면 끝
				}
				cnt = 1;
				curBall = line[i];
			}else {
				cnt++;
			}
		}
		
		line = newLine;
	}

	private static boolean explosion() {
		int curBall = 0; // 현재 인덱스의 Ball
		int cnt = 0; // 현재 인덱스의 Ball이 연속한 횟수
		int startIdx = 0;
		boolean flag = false;
		
		for(int i=1; i<N*N; i++) {
			if(line[i] != curBall) {
				if(cnt >= 4) {
					answer[curBall] += cnt; //폭발할 갯수 담기
					for(int idx=startIdx; idx<i; idx++) { 
						line[idx] = 0;
					}
					flag = true;
				}
				
				cnt=1;
				curBall = line[i];
				startIdx = i;
			}else {
				cnt++;
			}
		}

		return flag;
	}

	private static void move() {
		int [] newLine = new int[N*N+1];
		int idx = 1;
		for(int i=1; i<N*N; i++) {
			if(line[i] != 0) {
				newLine[idx] = line[i];
				idx++;
			}
		}
		line = newLine;
	}

	private static void blizzard(int d, int s) {
		int[] pos = {(N+1)/2, (N+1)/2}; //상어의 시작점
		for(int i=0; i<s; i++) {
			pos[0] += dx[d];
			pos[1] += dy[d];
			
			line[index[pos[0]][pos[1]]] = 0;
		}
	}

	private static void makeOneLine() {
		int oneLineDir = 0; //1차원으로 만들어볼 방향
		int[] pos = {(N+1)/2, (N+1)/2}; //상어의 시작점
		int[] dir = {3,2,4,1};
		int posIdx = 1; //0은 상어 위치로 한다. 1부터 시작
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<i; k++) {
					pos[0] += dx[dir[oneLineDir]]; // 다음 단계로 스텝을 바꿔준다.
					pos[1] += dy[dir[oneLineDir]];
					line[posIdx] = map[pos[0]][pos[1]]; // 담고
					index[pos[0]][pos[1]] = posIdx;
					posIdx++;
				}
				
				oneLineDir++; //방향을 전환해준다.
				if(oneLineDir == 4) {
					oneLineDir = 0;
				}
			}
		}
		
		for(int i=1; i<N; i++) { //마지막은 한번 더해준다
			pos[0] += dx[dir[oneLineDir]]; // 다음 단계로 스텝을 바꿔준다.
			pos[1] += dy[dir[oneLineDir]];
			line[posIdx] = map[pos[0]][pos[1]]; // 담고
			index[pos[0]][pos[1]] = posIdx;
			posIdx++;
		}
	}
}
