package com.algo.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 3228 이항계수 구하기와 같은 문제

public class acmicpc_11402_BinomialCoefficient {
	
	static long N, K;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Long.parseLong(st.nextToken()); // n
		K = Long.parseLong(st.nextToken()); // r
		M = Integer.parseInt(st.nextToken()); // p
		
		System.out.println(nCr(N,K,M));
		
		
	}

	private static long nCr(long n, long r, int p) {
		if(r == 0 || r == n) {
			return 1L; // long
		}else if(r == 1 || r == n-1) { // 5C1, 100C99(=100C1)
			return n % p;
		}
		
		// factorial값 저장
		// 모듈러 연산을 다 해준 값을 다룰 것이기 때문에, p개만큼 선언한다.
		long[] fact = new long[p]; // 0~p-1사이의 값을 저장
		fact[0] = 1;
		
		for(int i=1; i<p; i++) {
			//곱셈의 나머지 정리에 의해서 (i%p * fact[i-1] %p)%p 와 같다.
			fact[i] = (fact[i-1] * i) % p; 
		}
		
		// 이항계수 나머지정리
		// 가장 먼저할일
		//n>=p 이면 a와 b를 구해주고
		//a보다 b가 크면 답은 0
		//a가 b보다 크거나 같다면, 페르마의 소정리를 이용해서 답을 구함.
		//일단 aCb가 나옴
		
		//그리고 다음 과정을 해준다.
		//n= n/p
		//r =r/p
		
		if(n<p) {// n < p -> 원래대로 페르마의 소정리 적용 nCr(= n!/((n-r)!*r!))
			long result = 1L;
			result *= fact[(int)n]; // n!
			result %= p;
			
			result *= pow(fact[(int)n-(int)r], p-2); // 페르마의 소정리
			result %= p;
			
			result *= pow(fact[(int)r], p-2);
			result %= p;
			
			return result;
			
		}else { // n >= p
		// n,r에 대해 mod 연산을 한다.
		// a,b를 체크한다.
		// n,r을 p로 나눠서 작게 조정
		// 몫을 구해서 반복문을 도는 과정을 다시 이해하자
			long result = 1L;
			
			while(n > 0 || r > 0) {
				
				long a = n % p;
				long b = r % p;
				
				if(a < b) {
					return 0;
				}
				
				if(result == 0) {
					break;
				}
				
				// a>=b 인 경우
				result *= fact[(int)a]; // a!
				result %= p;
				
				result *= pow(fact[(int)a-(int)b], p-2); // 페르마의 소정리
				result %= p;
				
				result *= pow(fact[(int)b], p-2); // r!
				result %= p;
				
				// 몫
				n = n / p;
				r = r / p;
			}
			
			return result;
		}
		
	}

	private static long pow(long a, int b) { // a의 b승
		if(b == 0) return 1;
		else if(b == 1) return a;
		
		if(b%2 == 0) { // b가 짝수인 경우
			long tmp = pow(a, b/2);
			return (tmp * tmp) % M;
		}
		
		//b가 홀수인 경우
		long tmp = pow(a,b-1);
		return (tmp * a) % M;
	}

}
