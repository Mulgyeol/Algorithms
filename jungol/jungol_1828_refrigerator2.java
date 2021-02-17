package com.algo.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class jungol_1828_refrigerator2 {
	private static int N, maxRefTemp = Integer.MAX_VALUE;
	private static ArrayList<ChemiSub> chemiListL;
	
	private static class ChemiSub{
		private int lowTemp;
		private int highTemp;
		
		public ChemiSub(int lowTemp, int highTemp) {
			this.lowTemp = lowTemp;
			this.highTemp = highTemp;
		}

		public int getHighTemp() {
			return highTemp;
		}

		public int getLowTemp() {
			return lowTemp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		chemiListL = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			
			if(maxRefTemp > high) {
				maxRefTemp = high;
			}
			
			chemiListL.add(new ChemiSub(low,high));
		}
		
		Collections.sort(chemiListL, new Comparator<ChemiSub>() {

			@Override
			public int compare(ChemiSub o1, ChemiSub o2) {
				int low = Integer.compare(o1.getLowTemp(), o2.getLowTemp());
				return low != 0 ? low : o1.getHighTemp() - o2.getHighTemp();
			}
			
		});
		
		int answer = findRefCount();
		System.out.println(answer);
		
	}

	private static int findRefCount() {
		int count = 1;
		for(int i=0; i<N; i++) {
			if(maxRefTemp < chemiListL.get(i).getLowTemp()) {
				maxRefTemp = chemiListL.get(i).getHighTemp();
				count++;
			}
			if(maxRefTemp > chemiListL.get(i).getHighTemp()) {
				maxRefTemp = chemiListL.get(i).getHighTemp();
			}
		}
		
		return count;
	}

}
