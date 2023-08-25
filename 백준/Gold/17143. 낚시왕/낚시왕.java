import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-25
 * - @see https://www.acmicpc.net/problem/17143
 * - @git
 * - @youtube
 * - @performance
 * - @category #
 * - @note
 */
public class Main {
    static class Shark{
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M, totalSize;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<Shark> sharks = new ArrayList<>();
    static int[][] fishing;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fishing = new int[R][C];
        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(r, c, s, d, z));
            fishing[r][c] = i;
        }

        for (int col = 0; col < C; col++){
            fishing(col);
            moveShark();
            eatShark();
        }

        System.out.println(totalSize);
    }

    private static void fishing(int col){
        for (int row = 0; row < R; row++){
            if(fishing[row][col] != 0){
                totalSize += sharks.get(fishing[row][col]-1).z;
                sharks.set(fishing[row][col]-1, null);
                return;
            }
        }
    }

    private static void moveShark(){
        for (int i = 0; i < sharks.size(); i++){
            Shark shark = sharks.get(i);
            if (shark == null){
                continue;
            }

            for (int move = 0; move < shark.s; move++){
                if(isIn(shark.r + delta[shark.d][0], shark.c + delta[shark.d][1])){
                    shark.r += delta[shark.d][0];
                    shark.c += delta[shark.d][1];
                } else{
                    if (shark.d == 0 || shark.d == 2){
                        shark.d++;
                        shark.r += delta[shark.d][0];
                        shark.c += delta[shark.d][1];
                    } else{
                        shark.d--;
                        shark.r += delta[shark.d][0];
                        shark.c += delta[shark.d][1];
                    }
                }
            }
        }
    }

    private static void eatShark(){
        fishing = new int[R][C];
        for (int i = 0; i < sharks.size(); i++){
            Shark shark = sharks.get(i);
            if (shark == null){
                continue;
            }

            if (fishing[shark.r][shark.c] == 0){
                fishing[shark.r][shark.c] = i+1;
            } else{
                if (shark.z > sharks.get(fishing[shark.r][shark.c]-1).z){
                    sharks.set(fishing[shark.r][shark.c]-1, null);
                    fishing[shark.r][shark.c] = i+1;
                } else{
                    sharks.set(i, null);
                }
            }
        }
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}