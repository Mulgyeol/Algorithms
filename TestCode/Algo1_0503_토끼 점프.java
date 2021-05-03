import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_광주_4반_정물결 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int[] area = new int[10];
			int[][] rabbit = new int[5][2];
			
			for(int i=0; i<10; i++) {
				area[i] = Integer.valueOf(st.nextToken());
			}
			
			for(int i=0; i<5; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				rabbit[i][0] = Integer.valueOf(st.nextToken()); //오르막
				rabbit[i][1] = Integer.valueOf(st.nextToken()); //내리막
			}
			
			int cnt = 5;
			
			for(int i=0; i<5; i++) {
				for(int j=1; j<10; j++) {
					int heightGap = area[j]-area[j-1];
					if(heightGap > 0 && rabbit[i][0] < heightGap) {
						cnt--;
						break;
					}
					
					if(heightGap < 0 && rabbit[i][1] < -heightGap) {
						cnt--;
						break;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}

}
