package com.algo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/*
 * 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾아야 함.
 * 회사(출발점) -> 고객집(중간 방문지점) -> 집(도착점)
 * N명의 고객을 모두 방문하고 -> 어떤 순서로 방문할까? 순열 nPn
 * 두 위치 (x1, y1)와 (x2, y2) 사이의 거리: |x1-x2| + |y1-y2|
 * 
 * 1.data input
 * 2.회사에서 출발해서 매번 고객방문 순서를 다르게 해서 집까지 오는 경로의 길이를 계산해 봄
 * 3.그 중 제일 작은 값이 답
 * */

public class SW1247_OptimalRoute {
	static Point home;
	static Point company;
	static Point[] customers;
	static int N, ans;
	static int[] selected;//np를 위한 배열. 방문해야 되는 고객 순서. 01234..	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int TC = Integer.parseInt(br.readLine());		
	
		for (int tc = 1; tc <= TC; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());//고객 수
			customers = new Point[N];//고객 정보 저장
			selected = new int[N];//고객 방문 순열 만들려고 준비
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company = new Point(x,y);
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new Point(x,y);
			
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				customers[i] = new Point(x,y);
			}
			
			//np사용하기 위해 배열 준비 0,1,2,...N-1
			for (int i = 0; i < N; i++) {
				selected[i] = i;
			}
			
			//순열 만들어서 길이 체크
			do {
				int tmp = calc(selected);
				ans = ans > tmp ? tmp:ans;//최소 경로 체크
			}while(np(selected));			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static boolean np(int[] selected) {
		//1.i찾기(top). i-1번째가 교환 대상
		int i = N -1;
		while(i > 0 && selected[i-1] >= selected[i])
			i--;
		if(i == 0)//마지막 순열의 경우
			return false;
		
		//2.j찾기 (i-1 <-> j)
		int j = N-1;
		while(selected[i-1] >= selected[j])
				j--;
		
		//3.i~j를 서로 swap
		swap(selected, i-1, j);
		
		//4.i(top)~맨끝(N-1)까지 오름차순 정렬해서 가장 작은 수 만듬
		int k = N-1;
		while(i < k) {//둘이 아직 안만남. 안만났으면 교환해야 함
			swap(selected, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] selected, int i, int j) {
		int tmp = selected[i];
		selected[i] = selected[j];
		selected[j] = tmp;		
	}

	//selected 배열의 있는 값대로 고객을 방문해서 거리 계산해 봄
	private static int calc(int[] selected) {//012345, 312450
		int sum = 0;
		//1.회사~첫고객
		sum += getDistance(company, customers[selected[0]]);
		
		//2.N명의 고객 방문
		int i = 0;
		for (i = 0; i < selected.length - 1; i++) {
			int from = selected[i];//시작
			int to = selected[i + 1];//도착
			sum += getDistance(customers[from], customers[to]); 			
		}
		
		//3.마지막 고객~집
		sum += getDistance(customers[selected[i]], home);		
		return sum;
	}
	
	private static int getDistance(Point from, Point to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);	
	}



	static String src = "2\r\n" + 
			"5\r\n" + 
			"0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + 
			"6\r\n" + 
			"88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14";
}

class Point{
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}








