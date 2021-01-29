import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] sort = new int[N];
		
		
		for(int i=0;i<N;i++) {
			 sort[i] = Integer.parseInt(br.readLine());
		}
		
		bubbleSort(sort, N);
		
		StringBuilder sb = new StringBuilder();
		
		for(int s : sort) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}
	
	 static void bubbleSort(int[] input, int length) {
		int temp= 0;
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<length-1-i;j++) {
				if (input[j] > input[j+1]) {
					System.out.println(input[j] +" "+ input[j+1]);
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
			}
		}
	}
}
