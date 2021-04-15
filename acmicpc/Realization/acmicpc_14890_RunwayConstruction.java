package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_14890_RunwayConstruction {

	static int[][] map, mapReverse;
	static int N, X, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 지형의 길이
		X = Integer.parseInt(st.nextToken()); // 활주로 밑변

		map = new int[N][N];
		mapReverse = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapReverse[j][i] = map[i][j];

			}
		}
		
		sb.append(process());

		System.out.println(sb);
	}

	private static int process() {

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (makeRoad(map[i]))
				++count;
			if (makeRoad(mapReverse[i]))
				++count;
		}

		return count;
	}

	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0];
		int size = 0; // 연속된 동일 갯수;
		int j = 0; // 탐색 열 위치

		while (j < N) {
			if (beforeHeight == road[j]) {
				size++; // 첫번째 열도 자기랑 비교해서 갯수를 늘린다.
				j++;
			} else if (beforeHeight + 1 == road[j]) {// 오르막
				if (size < X)
					return false; // 경사로 설치 불가
				beforeHeight++;
				size = 1;
				j++;
			} else if (beforeHeight - 1 == road[j]) {// 내리마
				int count = 0;
				for (int k = j; k < N; k++) {
					if (road[k] != beforeHeight - 1)
						break;
					if (++count == X)
						break;
				}

				if (count < X)
					return false;
				beforeHeight--;
				size = 0;
				j += X;
			} else {
				return false;
			}
		}
		return true;
	}
}
