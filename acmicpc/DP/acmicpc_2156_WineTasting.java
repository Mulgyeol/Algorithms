package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmicpc_2156_WineTasting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] wines = new int[n];
		int[][] dp = new int[n][4];
		
		for(int i=0; i<n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			answer = wines[0];
		}
		else if(n==2) {
			answer =wines[0]+ wines[1];
		}else {
			/*세 번째 부터 dp 배열 초기화
			 *dp 테이블 정의
			 *dp[i][0] : 현재 와인을 마시지 않고 앞의 두 와인을 마셨을 때 최대 마실 수 있는 와인 양
			 *dp[i][1] : 바로 앞의 와인을 마시지 않고 현재 와인을 마셨을 때 최대 마실 수 있는 와인의 양
			 *dp[i][2] : 앞앞 와인을 마시지 않고 앞 와인과 현재 와인을 마시는 경우 최대 마실 수 있는 와인의 양
			 *dp[i][3] : 그냥 현재 와인을 마시지 않을 경우 마실 수 있는 최대 와인 양.
			 *표
			 * i-2 | i-1 | i | 
			 *  O  |  O	 | X |  dp[i][0], dp[i-1][2]값.
			 *  ?  |  X	 | O |	dp[i][1], dp[i-1][0]과 dp[i-1][3] 중 큰값과 지금 와인 양을 더한 값.
			 *  X  |  O	 | O |  dp[i][2], dp[i-1][1]에 지금 와인 양을 더한 값.
			 *  ?  |  ?  | X |  dp[i][3] 앞이 뭐든 난 안마심, dp[i-1]중에서 최대 값.
			 */
			
			dp[2][0] = wines[0]+wines[1];
			dp[2][1] = wines[0]+wines[2];
			dp[2][2] = wines[1]+wines[2];
			dp[2][3] = wines[0]+wines[1];
			int max = Integer.MIN_VALUE;
			for(int i=0; i<4; i++) {
				if(max < dp[2][i]) max = dp[2][i];
			}
			
			for(int i=3; i<n; i++) {
				dp[i][0] = dp[i-1][2];
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][3])+wines[i];
				dp[i][2] = dp[i-1][1]+wines[i];
				dp[i][3] = max;
				
				max = Integer.MIN_VALUE;
				for(int j=0; j<4; j++) {
					if(max < dp[i][j]) max = dp[i][j];
				}
			}
			answer = max;
			
		}
		System.out.println(answer);

	}

}
