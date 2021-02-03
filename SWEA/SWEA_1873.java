package com.ssafy.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)
다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
 
문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.*/

public class SWEA_1873 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int carH=0, carW=0; // 전차 위치, 담을 변수
			
			String[][] map = new String[H][W];
			
			for(int i=0; i<H; i++) { // 맵 초기화
				map[i] = br.readLine().split("");
			}
			
			for(int i=0; i<H; i++) { // 전차의 초기 위치 찾기
				for(int j=0; j<W; j++) {
					if(map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
						carH = i;
						carW = j;
						break;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String[] input = new String[n];
			input = br.readLine().split("");
			
			for(int i=0; i<n; i++) {
				switch(input[i]) {
					case "U":
						map[carH][carW] = "^";
						if(carH > 0 && map[carH-1][carW].equals(".")) {
							map[carH][carW] = ".";
							map[--carH][carW] = "^";
						}
						break;
					case "D":
						map[carH][carW] = "v";
						if(carH < H-1 && map[carH+1][carW].equals(".")) {
							map[carH][carW] = ".";
							map[++carH][carW] = "v";
						}
						break;
					case "L":
						map[carH][carW] = "<";
						if(carW > 0 && map[carH][carW-1].equals(".")) {
							map[carH][carW] = ".";
							map[carH][--carW] = "<";
						}
						break;
					case "R":
						map[carH][carW] = ">";
						if(carW < W-1 && map[carH][carW+1].equals(".")) {
							map[carH][carW] = ".";
							map[carH][++carW] = ">";
						}
						break;
						
					case "S":
						if(map[carH][carW].equals("^")) {
							for(int y = carH-1; y >= 0; y--) {
								if(map[y][carW].equals("*")) {
									map[y][carW] = ".";
									break;
								}else if(map[y][carW].equals("#")) {
									break;
								}
							}
							
						}else if(map[carH][carW].equals("v")) {
							for(int y = carH+1; y < H; y++) {
								if(map[y][carW].equals("*")) {
									map[y][carW] = ".";
									break;
								}else if(map[y][carW].equals("#")) {
									break;
								}
							}
							
						}else if(map[carH][carW].equals("<")) {
							for(int x = carW-1; x >= 0; x--) {
								if(map[carH][x].equals("*")) {
									map[carH][x] = ".";
									break;
								}else if(map[carH][x].equals("#")) {
									break;
								}
							}
						}else if(map[carH][carW].equals(">")) {
							for(int x = carW+1; x < W; x++) {
								if(map[carH][x].equals("*")) {
									map[carH][x] = ".";
									break;
								}else if(map[carH][x].equals("#")) {
									break;
								}
							}
						}
						
						break;
				}//switch
				
			}// for Input
			
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

			
		}//for Tc
		
		System.out.print(sb);
	}

}
