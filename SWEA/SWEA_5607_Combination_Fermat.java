package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_Combination {
	static long[] factorialDP;
	static int P = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			//factorial 미리 구해놓기
			factorialDP = new long[N+1];
			factorialDP[1] = 1;
			
			//수가 커질 수 있으니 미리 P로 나눈 나머지를 넣어놓는다.
			for(int i=2; i<=N; i++) {
				factorialDP[i] = (factorialDP[i-1] *i) % P;
			}
			
			//분모 부분
			long bottom = (factorialDP[N-R] * factorialDP[R]) % P;
			
			//거듭제곱 분할정복으로 빠르게 구하는 함수.
			long B = pow(bottom, P-2);
			
			long answer = (factorialDP[N] * B) % P;
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
		
	}

	private static long pow(long a, int b) { // a의 b승
		if(b == 0) return 1;
		else if(b == 1) return a;
		
		
		if(b%2 == 0) { // b가 짝수인 경우
			long tmp = pow(a, b/2);
			return (tmp * tmp) % P;
		}
		
		//b가 홀수인 경우
		long tmp = pow(a,b-1);
		return (tmp * a) % P;
	}

}
