package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2023-08-25
 * - @see
 * - @git
 * - @youtube
 * - @performance
 * - @category # BackTracking
 * - @note
 * 벽에 닿아있지 않은 코어들의 위치를 특정지어서 받는다.
 * 이 후 4방 탐색으로 진행해주면서 visited를 체크해주고 모든 것이 연결되었을 때 가장 최소가 되는것을 체크해준다.
 */
public class Processor {
    static class Core{
        int row, col, direction;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, finalCoreNum, coreNum, answer;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<Core> cores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++){
            cores = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            coreNum = 0;
            finalCoreNum = 0;

            N = Integer.parseInt(br.readLine());

            int[][] processor = new int[N][N];

            for (int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++){
                    processor[r][c] = Integer.parseInt(st.nextToken());
                    if (r == 0 || c == 0 || r == N-1 || c == N-1){
                        continue;
                    } else{
                        if (processor[r][c] == 1){
                            cores.add(new Core(r, c));
                        }
                    }
                }
            }

            search(0, processor);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void search(int idx, int[][] processor){
        if (idx == cores.size()){  // 기저 조건
            if (coreNum > finalCoreNum) {
                answer = check(processor);
                finalCoreNum = coreNum;
            } else if (coreNum == finalCoreNum){
                answer = Math.min(answer, check(processor));
            }
            return;
        }

        if (finalCoreNum > coreNum + cores.size() - idx) return;

        int[][] searchMap = new int[N][N];
        Core core = cores.get(idx);

        for (int i = 0; i < 4; i++){
            for (int r = 0; r < N; r++){
                searchMap[r] = processor[r].clone();
            }
            if (dfs(core.row, core.col, i, searchMap)) {  // 탐색이 가능할 때는 탐색한 후의 배열을 넘기고
                coreNum++;
                search(idx + 1, searchMap);
                coreNum--;
            }
        }
        search(idx+1, processor);
    }

    private static boolean dfs(int row, int col, int d, int[][] searchMap){
        Queue<Core> queue = new ArrayDeque<>();
        queue.offer(new Core(row, col));

        int tr, tc;
        while(!queue.isEmpty()){
            Core core  = queue.poll();
            tr = core.row + delta[d][0];
            tc = core.col + delta[d][1];
            if (!isIn(tr, tc)){
                break;
            } else{
                if (searchMap[tr][tc] == 0){
                    searchMap[tr][tc] = 2;
                    queue.offer(new Core(tr, tc));
                } else{
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isIn(int row, int col){
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    private static int check(int[][] processor){
        int cnt = 0;
        for (int r = 0; r < N; r++){
            for (int c = 0; c < N; c++){
                if (processor[r][c] == 2){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
