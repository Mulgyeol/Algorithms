import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmicpc_2564_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int storeCnt = Integer.parseInt(br.readLine());
		int[][] storePos = new int[storeCnt+1][2];
		int[] posRE = new int[storeCnt+1];
		int answer = 0;
		
		for(int i=0; i<storeCnt+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			storePos[i][0] = Integer.parseInt(st.nextToken());
			storePos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<storeCnt+1; i++) {
			if(storePos[i][0] == 1) {
				posRE[i] = storePos[i][1];
			}else if(storePos[i][0] == 2) {
				posRE[i] = -R-storePos[i][1];
			}else if(storePos[i][0] == 3) {
				posRE[i] = -storePos[i][1];
			}else if(storePos[i][0] == 4) {
				posRE[i] = C+storePos[i][1];
			}
		}
		
		int add = -posRE[storeCnt]; // 동근이의 위치를 0으로 만드는 값
		
		for(int i=0; i<storeCnt; i++) {
			posRE[i] += add;
			if(posRE[i] < -R-C) posRE[i] += (R+C)*2;
			if(posRE[i] > R+C ) posRE[i] -= (R+C)*2;
			answer += Math.abs(posRE[i]);
		}
		
		System.out.println(answer);
	}

}
