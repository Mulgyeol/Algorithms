package com.algo.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4408_ReturnToRoom_ref {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] cor = new int[200];
			for(int i=0; i<N; i++) {
				int r1 = sc.nextInt();
				int r2 = sc.nextInt();
				
				//방 번호 정리 r1->r2
				int min = Math.min(r1, r2);
				int max = Math.max(r1, r2);
				
				//방 번호 -> 복도번호로 변환
				r1 = (min -1)/2; //1 2
				r2 = (max -1)/2; //1 2
				
				for(int j = r1; j <= r2; j++) {
					cor[j]++;
				}
				
			}
			Arrays.sort(cor);
			System.out.println("#"+t+" "+cor[199]);
		}
		sc.close();
	}

}
