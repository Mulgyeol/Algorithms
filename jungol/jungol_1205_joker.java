package com.algo.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class jungol_1205_joker {
	
	static class Card implements Comparable<Card>{
		int next;
		int num;
		
		Card(){}
		
		Card(int num){
			this.num = num;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public int getNum() {
			return num;
		}

		public void setN(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Card o) {
			return this.num - o.num;
		}


	}
	
	private static int N, maxStraight = 0, cardTemp, joker=0;
	private static boolean[] cardsChoice = new boolean[1000001];
	static List<Card> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			cardTemp = Integer.parseInt(st.nextToken());
			if (cardTemp == 0) {
				joker++;
			}else {
				if(cardsChoice[cardTemp] == false) {
					cardsChoice[cardTemp] = true;
					list.add(new Card(cardTemp));
				}
			}
		}
		
		Collections.sort(list);
		
		if(list.size() > 2) {
			list.get(0).setNext(list.get(1).num - list.get(0).num+1);
			list.get(list.size()-1).setNext(0);
		}else {
			maxStraight = list.size() + joker;
		}
		
		
		for(int i=0; i<list.size()-1; i++) {
			Card CardNow = list.get(i);
			Card CardNext = list.get(i+1);
						
			CardNow.setNext(CardNext.getNum()-CardNow.getNum()-1);
		}
		
		for(int i=0; i<list.size(); i++) {
			int Straight = 1;
			int jokerTemp = joker;
			int next = i;
			int limit = list.size();
			
			while(next < limit && jokerTemp >= list.get(next).getNext()  ) {
				jokerTemp -= list.get(next).getNext();
				Straight += list.get(next).getNext()+1;
				next++;
			} 
			
			if(next == limit) jokerTemp -= 1; //고민 필요
			Straight += jokerTemp;
			
			maxStraight = Math.max(maxStraight, Straight);
		}
		
		System.out.println(maxStraight);
	}

}
