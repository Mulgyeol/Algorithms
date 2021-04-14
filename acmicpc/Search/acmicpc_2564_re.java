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
		int[] posRE = new int[storeCnt+1];
		int answer = 0;
		
		for(int i=0; i<storeCnt+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			if(dir == 1) {
				posRE[i] = dis;
			}else if(dir == 2) {
				posRE[i] = -R-dis;
			}else if(dir == 3) {
				posRE[i] = -dis;
			}else if(dir == 4) {
				posRE[i] = C+dis;
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
