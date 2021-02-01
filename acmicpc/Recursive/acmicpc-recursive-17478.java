package com.recursive;

import java.util.Scanner;

public class Recursive_17478 {
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(n);
		System.out.print(sb);
		sc.close();
	}
	
	private static String question = "\"재귀함수가 뭔가요?\"\n";
	private static String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	private static String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	private static String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	private static String end = "라고 답변하였지.\n";
	private static String bar = "____";
	
	private static int i = 0;
	
	private static void addSentence(int i, String s) {
		for(int j=0;j<i;j++) sb.append(bar);
		sb.append(s);
	}
	
	private static void recursive(int n) {
		if (i >= n) {
			addSentence(i,question);
			addSentence(i,"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			addSentence(i,end);			
			return;
			
		}
		
		addSentence(i,question);
		addSentence(i,answer1);
		addSentence(i,answer2);
		addSentence(i,answer3);
		
		i++;
		recursive(n);
		i--;
		addSentence(i,end);
	}
}
