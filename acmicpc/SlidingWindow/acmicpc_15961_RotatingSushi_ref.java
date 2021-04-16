package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_15961_RotatingSushi_ref {
	
	static int N, D, K, C, dishes[];//dishes는 접시 수만큼 준비.
	static int eaten[]; //D만큼의 크기. 해당 번호의 초밥을 먹을 때마다 값 증가(1~D)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		dishes = new int[N]; //접시 수 만큼
		eaten = new int[D+1]; // 초밥 가짓수 만큼
		
		for(int i=0; i<N; i++) { // 접시에 초밥을 올려둔다.
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(conveyorblet());
	}

	private static int conveyorblet() {
		int max = 0, kind = 0; //최대로 먹은 초밥 종류 갯수, 먹은 초밥 갯수
		
		//1, 0~K개의 초밥을 윈도우에 포함시키고 시작
		for(int i=0; i<K; i++) {
			int sushi_no = dishes[i]; // 초밥 번호
			if(eaten[sushi_no]==0) // 처음 먹는거
				kind++;
			
			eaten[sushi_no]++; // 해당번호의 초밥 갯수 증가
		}
		
		//1-2. 일단은 window를 한 번 채움. 
		//맨 처음에 먹은 초밥 종류를 최대 종류로 넣어둔다.
		max = kind;
		
		//2. 왼쪽에서부터 하나씩 윈도우에서 제외시키고 오른쪽 초밥을 윈도우에 포함시키면서 이동한다.
		for(int i=1; i<N; i++) { // 0번 접시부터는 이미 한 번 봤으니, 1번부터
			int front = dishes[i-1]; // Qkwlf clsrn
			eaten[front]--;
			if(eaten[front] == 0) // 먹었던 종류의 초밥이 0개가 되면, 빼줘야한다.
				kind--;
			
			// 오른쪽 초밥 처리
			
			int end = (i + K - 1 ) % N; //오른쪽 끝 초밥 번호.
			int sushi_no = dishes[end];
			
			if(eaten[sushi_no] == 0) kind++; // 윈도우에 포함시켰는데 그 전에 안먹어본 초밥
			eaten[sushi_no]++;
			
			// 먹은 종류에가 많아지거나 같은 경우, 쿠폰을 반영해서 max값 갱신
			if(max <= kind) {
				if(eaten[C] == 0)
					max = kind +1;//쿠폰 번호에 해당하는 초밥은 안먹어본 경우
				else
					max = kind;
			}
		}
		
		
		return max;
	}

}
