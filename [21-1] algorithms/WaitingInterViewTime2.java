import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaitingInterViewTime2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println(0);
		}else if(n == 1) {
			st = new StringTokenizer(br.readLine(), " ");
			System.out.println(0);
		}else if(n == 2) {
			st = new StringTokenizer(br.readLine(), " ");
			st = new StringTokenizer(br.readLine(), " ");
			System.out.println(0);
		}else {
			int[] arrival = new int[n];
			int[] timeForInterView = new int[n];
			int waitingTimeSum = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			arrival[0] = Integer.parseInt(st.nextToken());
			timeForInterView[0] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			arrival[1] = arrival[0] + Integer.parseInt(st.nextToken());
			timeForInterView[1] = Integer.parseInt(st.nextToken());
			
			
			int A = arrival[0] + timeForInterView[0]; //a 심사대에서 시간이 끝나느 시간
			int B = arrival[1] + timeForInterView[1]; //b 심사대에서 시간이 끝나는 시간
			
			for(int i=2; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arrival[i] = arrival[i-1] + Integer.parseInt(st.nextToken());
				timeForInterView[i] = Integer.parseInt(st.nextToken());
				if(arrival[i] < A) {
					if(arrival[i] < B) {
						if(A>B) { // B가 더 빨리끝나는 경우
							waitingTimeSum += B - arrival[i];
							B += timeForInterView[i];
						}else {
							waitingTimeSum += A - arrival[i];
							A += timeForInterView[i];
						}
						
					}else {
						B = arrival[i] + timeForInterView[i];
					}
				}else {
					A = arrival[i] + timeForInterView[i];
				}
			}
			
			System.out.println((float)waitingTimeSum/n);
		}
	}
}
