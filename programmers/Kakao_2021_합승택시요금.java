package algo.study.thisweek;

import java.util.Arrays;

public class Kakao_2021_합승택시요금 {
	
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {
				{4, 1, 10},
				{3, 5, 24}, 
				{5, 6, 2}, 
				{3, 1, 41}, 
				{5, 1, 24}, 
				{4, 6, 50}, 
				{2, 4, 66}, 
				{2, 3, 22}, 
				{1, 6, 25}};
		
		int road = fares.length;
		int[][] reFares = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			Arrays.fill(reFares[i], 1000001);
		}
		for(int i=1; i<n+1; i++) {
			reFares[i][i] = 0;
		}
		
		for(int i=0; i<road; i++) {
			reFares[fares[i][0]][fares[i][1]] = fares[i][2];
			reFares[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		for(int i=1; i<n+1; i++) {//경
			for(int j=1; j<n+1; j++) {//출
				for(int k=1; k<n+1; k++) {//도
					if(reFares[j][k] > reFares[j][i]+reFares[i][k]) {
						reFares[j][k] = reFares[j][i]+reFares[i][k];
					}
				}
			}
		}
		
		int minFare = reFares[s][a]+reFares[s][b];
		for(int i=1; i<n+1; i++) {//경
			if(minFare > reFares[s][i] + reFares[i][a] + reFares[i][b]) {
				minFare = reFares[s][i] + reFares[i][a] + reFares[i][b];
			}
		}
		
		System.out.println(minFare);
		
		
		
	}

}
