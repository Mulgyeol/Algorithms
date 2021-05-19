package algo.study.thisweek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Acmicpc_21610_마법사상어와비바라기 {

    static int N, M;
    static int[][] map;

    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int[] diagonalX = {-1,-1,1,1};
    static int[] diagonalY = {-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        Queue<int[]> cloud = new LinkedList<>();
        Queue<int[]> magic = new LinkedList<>();
        cloud.offer(new int[] {N,1});
        cloud.offer(new int[] {N,2});
        cloud.offer(new int[] {N-1,1});
        cloud.offer(new int[] {N-1,2});

        for(int i=0; i<M; i++){
            int size = cloud.size();
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.valueOf(st.nextToken()); //방향
            int s = Integer.valueOf(st.nextToken()); //이동 거리
            int realS = s % N; // 왕복 없이 실제로 이동할 거리
            
            // 비 내리기
            for(int j=0; j<size; j++){ // 구름에서 비를 내린다.
                int[] curCloud = cloud.poll();
                int x = curCloud[0];
                int y = curCloud[1];

                int nx = x + dx[d]*(realS);
                int ny = y + dy[d]*(realS);

                if(nx < 1 ) nx += N;
                else if(nx > N ) nx -= N;
                if(ny < 1 ) ny += N;
                else if(ny > N ) ny -= N;

                map[nx][ny] += 1;
                magic.offer(new int[] {nx,ny});
            }

            boolean[][] check = new boolean[N+1][N+1];
            
            //물 복사
            for(int j=0; j<size; j++){ // 대각선에 물이 들어있는 바구니 수 만큼 물 복사가 이뤄진다.
                int[] current = magic.poll();
                int x = current[0];
                int y = current[1];
                check[x][y] = true;

                for(int k=0; k<4; k++){
                    int nx = x + diagonalX[k];
                    int ny = y + diagonalY[k];

                    if(nx > 0 && nx <=N && ny > 0 && ny <= N && map[nx][ny] >0){
                        map[x][y] += 1;
                    }
                }
            }
            
            // 구름 생성하고 2만큼 빼주기
            for(int x=1; x<=N; x++){
                for(int y=1; y<=N; y++){
                    if(map[x][y] >= 2 && !check[x][y]){
                        int[] current = {x,y};
                        map[x][y] -= 2;
                        cloud.offer(current);
                    }
                }
            }
        }
        
        //물의 양 다 더해서 답 찾기
        int answer = 0;
        for(int x=1; x<=N; x++){
            for(int y=1; y<=N; y++){
                answer += map[x][y];
            }
        }
        System.out.println(answer);
    }
}
