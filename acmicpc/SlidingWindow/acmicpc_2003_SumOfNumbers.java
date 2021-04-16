package com.algo.acmicpc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 
구하는 프로그램을 작성하시오.
 */
public class acmicpc_2003_SumOfNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());// 수열의 길이. N개의 수로 된 수열
		int M = Integer.parseInt(st.nextToken());// 만들어야 되는 합

		st = new StringTokenizer(br.readLine().trim());
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		//
		int s = 0;  // start
		int e = 0 ; // end
		int sum = 0; // 5가 되어야 함
		int count = 0;
		
		while(true) {
			if(sum < M) { // 5미만인 경우. 창 크기를 오른쪽으로 늘려 나가야 한다.
				if(e >= N) break;
				sum += numbers[e++];
			}else { // sum이 5보다 크거나 같은 경우
				sum -= numbers[s++];
			}
			
			if(sum == M) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	//static String src = "10 5\r\n" + "1 2 3 4 2 5 3 1 1 2";
	// 3
}
