package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class acmicpc_Stack_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		Stack<int[]> stack = new Stack<int[]>();
		int[] result = new int[N];

		for (int i = 1; i < N + 1; i++) {
			int[] tower = {Integer.parseInt(st.nextToken()), i};
			if (stack.isEmpty()) { //현재 스택이 비어있으면
				result[i - 1] = 0; //결과는 0
				stack.add(tower); // 현재 타워를 스택에 넣는다.
			} else {
				while (!stack.isEmpty()) { // 스택이 비어있지 않으면
					if (stack.peek()[0] >= tower[0]) { // 스택의 peek의 높이와 비교하고, peek의 높이가 같거나 크면
						result[i - 1] = stack.peek()[1]; // 결과는 peek의 index
						stack.add(tower); // tower를 스택에 넣는다.
						break;
					} else { //peek보다 자기가 크면
						stack.pop(); // pop해서 더 앞의 타워랑 비교한다.
					}
				}

				if (stack.isEmpty()) { //stack에 현재 타워보다 큰 타워가 없었다면,
					result[i - 1] = 0; // 결과는 0
					stack.add(tower); // 현재 타워를 스택에 넣는다.
				}
			}
			
		}

		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);
	}
}
