import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int[] array = new int[sb.length()];
		for(int i=0; i<sb.length(); i++) {
			array[i] = (int)sb.charAt(i)-48;
		}
		
		selectionSortMax(array, sb.length());
		StringBuilder sb2 = new StringBuilder();
		for(int n : array) {
			sb2.append(n);
		}
		System.out.println(sb2);
		
	}
	
	public static void selectionSortMax(int[] input, int length) {
		int max, temp;
		for(int i=0; i<length-1; i++) {
			max = i;
			for(int j=i+1; j<length; j++) {
				if(input[j]>input[max]) {
					max=j;
				}
			}
			temp = input[i];
			input[i] = input[max];
			input[max] = temp;
		}
	}

}
