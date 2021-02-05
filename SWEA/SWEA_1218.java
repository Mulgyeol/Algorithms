package com.algo.SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Stack<Character> stack = new Stack<>();
			int n = sc.nextInt();
			String s = sc.next();
			int result = 1;
			char peek;
			
			for(int i=0; i<n; i++) {
				if(s.charAt(i) == '<' || s.charAt(i) == '{' || s.charAt(i)== '[' || s.charAt(i) == '(') {
					stack.push(s.charAt(i));
					continue;
				}else {
					if(stack.isEmpty()) {
						result =0;
						break;
					}else {
						peek = stack.pop();
						
						if(peek == '<' && s.charAt(i)!='>') {
							result =0;
							break;
						}
						else if(peek == '[' && s.charAt(i)!=']') {
							result =0;
							break;
						}
						else if(peek == '{' && s.charAt(i)!='}') {
							result =0;
							break;
						}
						else if(peek == '(' && s.charAt(i)!=')') {
							result =0;
							break;
						}
					}
				}
			}
			
			if(!stack.empty()) result =0;
			
			System.out.println("#"+t+" "+result);
			
			
			
		}
		sc.close();
	}

}
