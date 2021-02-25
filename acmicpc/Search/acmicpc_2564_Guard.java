package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2564_Guard {
	
	static int width, height, N, dir, sum=0;
	static int[][] store;
	static int[] dongguen;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		store = new int[N][2];
		dongguen = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			//1: ��, 2:��, 3:��, 4:��
			store[i][0] = Integer.parseInt(st.nextToken());		
			//[0]�� 1,2�� ��� ���ʺ��� �Ÿ�
			//[0]�� 3,4�� ��� ���ʺ����� �Ÿ�
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		//1: ��, 2:��, 3:��, 4:��
		dongguen[0] = Integer.parseInt(st.nextToken());
		//[0]�� 3,4�� ��� ���ʺ����� �Ÿ�
		dongguen[1] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			sum += findOpiDistance(store[i]);
		}
		
		System.out.println(sum);
		
	}
	
	public static int findOpiDistance(int[] store) {
		int distance = 0;
		if(dongguen[0] == store[0]) {
			distance = Math.abs(dongguen[1] - store[1]);
		}else {
			if(dongguen[0] == 1) {
				if(store[0] == 2) {
					distance =  height + Math.min(dongguen[1] + store[1], (width - dongguen[1]) + width - store[1]);
				}else if(store[0] == 3) {
					distance =  dongguen[1] + store[1];
				}else if(store[0] == 4) {
					distance = (width - dongguen[1]) + store[1];
				}
			}else if(dongguen[0] == 2) {
				if(store[0] == 1) {
					distance =  height + Math.min(dongguen[1] + store[1], (width - dongguen[1]) + (width - store[1]));
				}else if(store[0] == 3) {
					distance =  dongguen[1] + (height - store[1]);
				}else if(store[0] == 4) {
					distance = (width - dongguen[1]) + (height - store[1]);
				}
				
			}else if(dongguen[0] == 3) {
				if(store[0] == 1) {
					distance = dongguen[1] + store[1];
				}else if(store[0] == 2) {
					distance = (height - dongguen[1]) + store[1];
				}else if(store[0] == 4) {
					distance = width + Math.min(dongguen[1] + store[1], (height - dongguen[1]) + (height - store[1]));
				}
			}else if(dongguen[0] == 4) {
				if(store[0] == 1) {
					distance = dongguen[1] + (width - store[1]);
				}else if(store[0] == 2) {
					distance = (height - dongguen[1]) + (width - store[1]);
				}else if(store[0] == 3) {
					distance = height + Math.min(dongguen[1] + store[1], (height - dongguen[1]) + (height - store[1]));
				}
			}
			
		}
		
		return distance;		
	}

}

