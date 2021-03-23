package com.algo.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1681_HamiltonianCircuit {
	
	static boolean[] visited;
    static int N;
    static int[][] adjMatrix;
    static int min = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N+1][N+1];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        visited = new boolean[N];
        permutation(1, 0, 0);
        System.out.println(min);
    }
 
    private static void permutation(int cnt, int from, int sum) {
        if(cnt == N) {
        	if(adjMatrix[from][0] == 0) return;
        	sum += adjMatrix[from][0];
            if(min > sum)
                min = sum;
            return;
        }
        
        if(sum > min) return; //이미 합이 min보다 작은게 있으면 return
         
        for(int i=1; i<N; i++) {
            if(!visited[i] && adjMatrix[from][i] != 0) {
                visited[i] = true;
                permutation(cnt+1, i, sum + adjMatrix[from][i]);
                visited[i] = false;
            }
        }
         
    }
 
}