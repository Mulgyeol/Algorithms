package com.algo.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0. 출발방 번호를 항상 작게, 도착방 번호를 항상 크게
 * 1. 첫 방을 큐에 넣고 방문 표시.
 * 2. 큐에 있는 방을 뽑아 리스트에도 넣는다.
 * 3. 리스트에 있는 모든 방들과 겹치지 않는 방을 발견하면 리스트에서 추가, 리스트에 추가하면서 방문표시 (한 번에 이동할 수 있는 학생 처리)
 * 4. 다 처리했으면 시간++
 * 5. 다시, 방문하지 않은 방을 하나 큐에 넣고, 방문 표시.
 * 
 * 6. 큐가 비었으면 반복문 탈출.
 */

public class SWEA_4408_ReturnToRoom {

	static class Student implements Comparable<Student> {
		int from;
		int to;

		@Override
		public int compareTo(Student o) {
			return this.from - o.from;
		}

		public Student(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());
			Student[] students = new Student[N];
			boolean[] visited = new boolean[N];
			ArrayList<Student> notOverSt = new ArrayList<>();
			int time = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(from > to) { // from을 항상 작게, to를 항상 크게
					int temp = from;
					from = to;
					to = temp;
				}
				students[i] = new Student(from, to);
			}

			Arrays.sort(students);

			Queue<Student> queue = new LinkedList<>();
			queue.offer(students[0]);
			visited[0] = true;

			while (!queue.isEmpty()) {
				Student temp = queue.poll();
				notOverSt.add(temp);
				for (int j = 0; j < N; j++) {
					if (!visited[j]) {
						boolean overlap = false;
						for(Student s : notOverSt) {
							if(!notOverlap(s, students[j])) {
								overlap = true;
								break;
							}
						}
						if(!overlap) {
							visited[j] = true;
							notOverSt.add(students[j]);
						}
					}
				}
				
				notOverSt.clear();
				time++;

				for (int i = 0; i < N; i++) {
					if (!visited[i]) {
						queue.offer(students[i]);
						visited[i] = true;
						break;
					}
				}
			}

			sb.append(time).append("\n");
		} // tc
		System.out.println(sb);
	}

	private static boolean notOverlap(Student temp, Student student) {
		int tFrom = temp.from;
		int tTo = temp.to;
		int sFrom = student.from;
		int sTo = student.to;

		if (tFrom % 2 == 0)
			tFrom--;
		if (tTo % 2 == 1)
			tTo++;
		if (sFrom % 2 == 0)
			sFrom--;
		if (sTo % 2 == 1)
			sTo++;
		
//		if ((tFrom <= sFrom && tTo >= sFrom) || (tFrom <= sTo && tTo >= sTo)||
//				(sFrom <= tFrom && sTo >= tFrom) || (sFrom <= tTo && sTo >= tTo))
		if (tFrom <= sFrom && tTo >= sFrom)
			return false;


		return true;
	}

}
