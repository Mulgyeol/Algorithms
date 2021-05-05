package algo.study.thisweek;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Kakao_2021_순위검색 {

	public static void main(String[] args) {
		String[] info = {
				"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"
		};
		String[] query = {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"
		};
		
		StringTokenizer st;
		int people = info.length;
		String[][] reInfo = new String[people][5];
		for(int i=0; i<people; i++) {
			st = new StringTokenizer(info[i], " ");
			for(int j=0; j<5; j++) {
				reInfo[i][j] = st.nextToken();
			}
		}
		
		int queryNum = query.length;
		String[][] reQuery = new String[queryNum][5];
		for(int i=0; i<queryNum; i++) {
			st = new StringTokenizer(query[i], " ");
			for(int j=0; j<4; j++) {
				if(j != 3) {
					reQuery[i][j] = st.nextToken();
					st.nextToken();
				}
				else {
					reQuery[i][j] = st.nextToken();
					reQuery[i][j+1] = st.nextToken();
				}
			}
		}
		
		int[] answer = new int[queryNum];
		for(int i=0; i<queryNum; i++) {//질문 수
			int cnt = 0;
			for(int j=0; j<people; j++) {// 사람 수
				boolean flag = true;
				for(int k=0; k<4; k++) {//질문 가짓수
					if(reQuery[i][k].equals("-")) continue;
					if(!reQuery[i][k].equals(reInfo[j][k])) {
						flag = false;
						break;
					}
				}
				if(flag == true && Integer.valueOf(reQuery[i][4]) <= Integer.valueOf(reInfo[j][4])) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		
		System.out.println(Arrays.toString(answer));
		
	}
}