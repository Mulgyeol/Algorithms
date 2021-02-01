package com.my.algo;

import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			String s = sc.next();
			int count = 0;
			for(int i = s.length()-1; i>0; i--) {
				if (s.charAt(i) != s.charAt(i-1)){
					count++;
				}
			}
			if (s.charAt(0) != '0') count++;
			
			System.out.println("#"+tc+" "+count);
		}
		sc.close();
		
	}

}
