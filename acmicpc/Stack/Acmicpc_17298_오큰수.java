package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Acmicpc_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] sequence = new int[N];
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			sequence[i] = Integer.valueOf(st.nextToken());
		}
		
		int idx = N-1;
		answer[idx] = -1;
		stack.push(sequence[idx]);
		
		for(int i=idx-1; i>=0; i--) {
			int compareTo = stack.peek();
			
			if(sequence[i] >= compareTo) {
				while(!stack.isEmpty()) {
					compareTo = stack.pop();
					if(sequence[i] < compareTo) {
						answer[i] = compareTo;
						stack.push(compareTo);
						break;
					}
				}
				if(answer[i] == 0) {
					answer[i] = -1;
				}
				stack.push(sequence[i]);
			}else {
				answer[i] = compareTo;
				stack.push(compareTo);
				stack.push(sequence[i]);
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
