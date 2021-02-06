package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[] chars = br.readLine().toCharArray(); //char 문자열 저장할 배열
			Stack<Character> stack = new Stack<>(); // 스택
			
			result.append("#").append(t).append(" "); //테스트 케이스 결과에 넣기
			StringBuilder sb = new StringBuilder(); //새 스트링 빌더 생성
			
			for(char c : chars) {
				if(c - '0' >= 0 && c -'9' <= 0) { // 숫자면
					sb.append(c); // builder에 append(출력
				}else { // 아닐경우
					if(stack.isEmpty()) { // 스택이 비어있으며ㄴ
						stack.push(c); // 집어넣기
					}else {
						if(getPriority(c) > getPriority(stack.peek())) {
							sb.append(stack.pop());
							stack.push(c);
						}else if(getPriority(c) == getPriority(stack.peek())){
							sb.append(c);
						}else {
							stack.push(c);
						}
					}
				}
				
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			char[] chars2 = sb.toString().toCharArray();
			Stack<Integer> stackInt = new Stack<Integer>();
			
			for(char c : chars2) {
				if(c - '0' >= 0 && c -'9' <= 0) {
					stackInt.push(c - '0');
				}else {
					if(c == '+') {
						stackInt.push(stackInt.pop()+stackInt.pop());
					}
					else if(c == '*') {
						stackInt.push(stackInt.pop()*stackInt.pop());
					}
				}
			}
			
			result.append(stackInt.pop()).append("\n");
			
		}
		
		System.out.println(result);
	}
	
	
	private static int getPriority(char c) {
			if(c == '+') return 2;
			else return 1;
	}

}
