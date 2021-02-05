package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_Search_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int[] tower = new int[N+1]; // 타워 높이를 저장할 1차원 배열
		int[] result = new int[N+1]; // 결과를 저장할 1차원 배열
		
		tower[0] = 100000000; // 0번 째 타워를 가장 높게 해서 걸리게 한다.
		for(int i=1; i<N+1; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
				
		int compareTower; // 비교할 타워의 인덱스 번호를 저장할 변수
		
		for(int i=2; i<N+1; i++) {
			compareTower = i-1; // 바로 앞의 타워와 일단 비교한다.
			if(tower[i]<=tower[compareTower]) {
				result[i] = compareTower; // 바로 앞 타워에 걸리면 result[i]에 저장한다.
			}else { // 바로 앞 타워에 걸리지 않으면
				while(compareTower != 0) { // 그 타워가 걸린 타워, 또 안 걸리면 그 타워가 걸린 타워....와 걸릴때 까지  비교하게 한다.
					compareTower = result[compareTower];
					if(tower[i]<=tower[compareTower]) {
						result[i] = compareTower;
						break;
					}
				}
			}
		}
		
		for(int i=1 ; i<N+1; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
