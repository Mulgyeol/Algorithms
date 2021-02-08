package com.ssafy.notyetclassification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	private static int[][] score;
	private static int N;
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
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); //제한 칼로리 수
			score = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}// 맛 입력.
			
			int answer = solution(0,0,0);
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}


	private static int solution(int step, int sumTaste, int sumCal) {
		if(sumCal >= L) {
			return 0;
		}
		if(step == N) {
			return sumTaste;
		}
		int result=0;
		result = Math.max(result, solution(step+1, sumTaste+score[step][0], sumCal + score[step][1]));
		result = Math.max(result, solution(step+1, sumTaste, sumCal));
		return result;
	}
	

}
