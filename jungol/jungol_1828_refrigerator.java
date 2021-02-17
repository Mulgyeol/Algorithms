package com.algo.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class jungol_1828_refrigerator {
	private static int N;
	private static ArrayList<ChemiSub> chemiListH;
	private static ArrayList<ChemiSub> chemiListL;
	
	private static class ChemiSub implements Comparable<ChemiSub>{
		private int lowTemp;
		private int highTemp;
		
		public ChemiSub(int lowTemp, int highTemp) {
			super();
			this.lowTemp = lowTemp;
			this.highTemp = highTemp;
		}

		@Override
		public int compareTo(ChemiSub o) {
			// TODO Auto-generated method stub
			int high = this.highTemp - o.highTemp;
			return high == 0 ? this.lowTemp - o.lowTemp : high ;
		}

		public int getHighTemp() {
			return highTemp;
		}

		public int getLowTemp() {
			return lowTemp;
		}

		@Override
		public String toString() {
			return "ChemiSub [lowTemp=" + lowTemp + ", highTemp=" + highTemp + "]";
		}

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		chemiListH = new ArrayList<>();
		chemiListL = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			
			chemiListH.add(new ChemiSub(low,high));
			chemiListL.add(new ChemiSub(low,high));
		}
		
		Collections.sort(chemiListH);
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
		int max = chemiListH.get(0).getHighTemp();
		for(int i=0; i<N; i++) {
			if(max < chemiListL.get(i).getLowTemp()) {
				max = chemiListL.get(i).getHighTemp();
				count++;
			}
			if(max > chemiListL.get(i).getHighTemp()) {
				max = chemiListL.get(i).getHighTemp();
			}
		}
		
		return count;
	}

}
