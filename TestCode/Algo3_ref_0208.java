package com.algo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 보안성 : 해커가 시도했던 모든 패스워드와의 보안척도 중 최솟값
 * 보안척도 : 두 패스워드의 보안척도는 이진법으로 표현한 두 패스워드의 서로 다른 자리의 개수
 * 보안 척도가 낮다 => 일치하는 자리수가 많다. => 보안성
 * 보안성 중에 큰 값을 출력.
 */

public class Algo3_ref_0208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 관리자 패스워드의 최댓값
		int M = Integer.parseInt(br.readLine()); // 해커가 사용한 패스워드의 갯수
		int[] attack = new int[M]; // 해커가 사용한 패스워드 배열
		int result = 0;
		
		st = new StringTokenizer(br.readLine()," "); //해커가 사용한 패스워드 입력
		
		for(int i=0; i<M; i++) {
			attack [i]= Integer.parseInt(st.nextToken()); // 패스워드 배열 채우기
		}
				
		// 사용 가능한 패스워드 후보와 해커가 사용한 패스워드를 비교하면서 안전거리 계산하기
		for(int i=0; i<=N; i++) {// 가능한 패스워드 범위
			int safeDistance = Integer.MAX_VALUE; //보안척도를 저장할 변수
			
			for(int j=0; j<M; j++) { //보안 척도 계산
				int tmp = 0; // 서로 다른 비트 수 기록한 변수
				tmp = countDiffBit(i, attack[j]);
				safeDistance = Math.min(safeDistance, tmp);
			}
			
			result = Math.max(safeDistance, result);
		}
		
		System.out.println(result);
	}

	//패스워드 후보와 해커가 사용한 패스워드를 비교하면서 안전거리 계산하기(min)
	private static int countDiffBit(int admin, int hacker) {
		// ^(xor) : exclusive or 
		//	정수형을 비교할 경우 비트단위로 비교한다.
		//	이진수로 내부적으로 바꾼 다음 비교한다.
		// 0110 ^ 1011 => 1101
		// 0110 & 1011 => 0010
		// 0110 | 1011 => 1111
		int tmp = admin ^ hacker; // 서로 다른 비트만 1로 나온 것이 int형으로 변환되어 저장됨.
		int cnt = 0;
		
		//xor한 결과를 이진수 문자열 변환 -> char []
		char[] binaryCount = Integer.toBinaryString(tmp).toCharArray();
		for (int i = 0; i < binaryCount.length; i++) {
			if(binaryCount[i] == '1') cnt++;
		}
		
		return cnt;
	}
}


