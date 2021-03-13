package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_5658_TreasureChest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder myanswer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			myanswer.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			sb.append(br.readLine());// StringBuilder로 숫자들을 회전시킨다.
			
			ArrayList<String> list = new ArrayList<>();

			int step = N/4; //한 면에 있는 숫자 갯수
			// 끊어서 저장
			for(int i=0; i<step; i++) {
				int start = 0;
				for(int j=0; j<4; j++) { //4변의 숫자를 리스트에 넣는다.
					String num = sb.substring(start, start+step);
					if(!list.contains(num)){ // 이미 포함되어 있지 않은 수만 넣는다.
						list.add(num);
					}
					start += step;
				}
				String first = sb.substring(0,1);
				sb = new StringBuilder(sb.substring(1, N));
				sb.append(first); //sb를 회전시킨다. 방향이 반대긴 한데, 문제는 없다.
			}
			
			Collections.sort(list, new Comparator<String>(){ // 내림차순으로 정렬한다.
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			});
			
			int answer = Integer.parseInt(list.get(K-1),16); //문자열을 16진수로 변환
			myanswer.append(answer).append("\n");

			//N/4씩 끊은 다음 N/4번 회전시킨다.
		}//tc
		System.out.print(myanswer);
	}//main

}
