import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class waitingInterviewTime1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arrival = new int[n];
		int[] endInterview = new int[n];
		int[] timeForInterView = new int[n];
		int waitingTimeSum = 0;
		
		if(n < 1) {
			System.out.println(0);
		}else {
			st = new StringTokenizer(br.readLine(), " ");
			arrival[0] = Integer.parseInt(st.nextToken());
			timeForInterView[0] = Integer.parseInt(st.nextToken());
			endInterview[0] = arrival[0] + timeForInterView[0];
			
			for(int i=1; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arrival[i] = arrival[i-1] + Integer.parseInt(st.nextToken());
				timeForInterView[i] = Integer.parseInt(st.nextToken());
				if(endInterview[i-1] <= arrival[i]) {
					endInterview[i] = arrival[i] + timeForInterView[i];
				}else {
					endInterview[i] = endInterview[i-1] + timeForInterView[i];
					waitingTimeSum += endInterview[i-1] - arrival[i];
				}
			}
			System.out.println((float)waitingTimeSum/n);
		}
	}

}
