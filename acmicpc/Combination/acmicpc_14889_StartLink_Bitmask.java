package algo.study.thisweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_14889_StartLink_Bitmask { //비트마스킹을 이용한 조합

	static int[][] ability;
	static int N, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeTeam(0,0,0);
		System.out.println(min);
		
	}
	
	//1로 마킹된 번호의 사람은 start팀, 아니면 link팀
	private static void makeTeam(int cnt, int bitmask, int choiceCount) {
		if(cnt ==N) {
			if(choiceCount == N/2) { // 종료조건
				int start = 0, link = 0;
				for(int i=0; i<N; i++) {
					if((bitmask & 1<<i) != 0) { //i번째 사람이 start 팀이면
						for(int j=0; j<N; j++) {
							if((bitmask & 1<<j) != 0) // 다른사람과의 시너지를 더한다.
								start += ability[i][j];
						}
					}else {
						for(int j=0; j<N; j++) {
							if((bitmask & 1<<j) == 0)
								link += ability[i][j];
						}
					}
				}
				
				min = Math.min(min, Math.abs(start - link));
				return;
			}else {
				return;
			}
		}
		makeTeam(cnt+1, bitmask | 1<<cnt, choiceCount+1);
		makeTeam(cnt+1, bitmask, choiceCount);
	}

}
