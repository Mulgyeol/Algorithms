package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_Combination {

	private static int[][] R;
	private static int L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); //제한 칼로리 수
			R = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				R[i][0] = Integer.parseInt(st.nextToken());
				R[i][1] = Integer.parseInt(st.nextToken());
			}// 맛 입력.
			
			//각 재료별 조합을 만들어 그때의 맛점수가 최고인 것 찾기
			int idx = 0; // 조합할 재료 번호
			int score = 0; // 맛 점수, 재료를 선택해 나갈 때마다 올라간다.
			
			int max = find(idx, score, L);
			sb.append(max).append("\n");
		}//for
		System.out.println(sb);
	}//main
	
	//idx번째의 재료를 고려해서(넣을수도 있고 뺄수도 있다.) 조합을 만들었을 때, 
	//칼로리 체크 후 맛점수 리턴하는 함수
	//remian : 남아있는 사용가능 칼로리
	private static int find(int idx, int score, int remain) {
		if(remain < 0) {
			return 0;
		}
		if(remain == 0) {
			return score; // 그 시점의 맛 점수 리턴
		}
		if(idx == R.length) { //모든 재료를 조합 만드는데 다 사용
			return score;
		}
		
		// idx번째 재료를 사용하지 않은 경우
		int v1 = find(idx+1, score, remain);
		// idx번째 재료를 사용한 경우
		int v2 = find(idx+1, score+R[idx][0], remain-R[idx][1]);
		
		return Math.max(v1, v2);
	}
}
