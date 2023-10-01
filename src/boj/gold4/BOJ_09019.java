package boj.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

- @author 이병헌
- @since 2023/09/29
- @see https://www.acmicpc.net/problem/9019
- @git https://github.com/Hunnibs
- @youtube
- @performance
- @category # Implemetation # BFS
- @note */

public class BOJ_09019 {
    static class Info{
        int num;
        StringBuilder sb = new StringBuilder();

        public Info(int num, StringBuilder sb) {
            this.num = num;
            this.sb = sb;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            sb.append(bfs(start, target)).append("\n");
        }
        System.out.println(sb);
    }

    private static StringBuilder bfs(int start, int target){
        boolean[] visited = new boolean[100_001];
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(start, new StringBuilder()));

        StringBuilder sb;
        int num;
        while(!queue.isEmpty()){
            Info info = queue.poll();
            num = info.num;
            sb = info.sb;
            if (num == target){
                return sb;
            }

            int next = 0;
            next = multiply(num);
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, new StringBuilder(sb).append("D")));
            }
            next = sub(num);
            if (!visited[next]){
                visited[next] = true;
                queue.offer(new Info(next, new StringBuilder().append(sb).append("S")));
            }
            next = left(num);
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, new StringBuilder().append(sb).append("L")));
            }
            next = right(num);
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new Info(next, new StringBuilder().append(sb).append("R")));
            }
        }
        return null;
    }

    private static int multiply(int num) {
        return num * 2 % 10_000;
    }

    private static int sub(int num){
        if (num == 0){
            return 9999;
        } else{
            return num - 1;
        }
    }

    private static int left(int num){
        int tmp = 0;
        int idx = 0;
        for (int i = 3; i >= 0; i--) {
            tmp = (int)(num / Math.pow(10, i));
            idx = i;
            if (tmp != 0){
                break;
            }
        }

        if (idx < 3){
            return num * 10;
        } else {
            return (int) (num % Math.pow(10, idx)) * 10 + tmp;
        }
    }

    private static int right(int num){
        int tmp = 0;
        int idx = 0;
        for (int i = 3; i >= 0; i--) {
            tmp = (int)(num / Math.pow(10, i));
            idx = i;
            if (tmp != 0){
                break;
            }
        }

        tmp = num % 10;
        if (idx < 3){
            return tmp * (int) (Math.pow(10, 3)) + (int) num /10;
        } else {
            return tmp * (int) (Math.pow(10, idx)) + (int) num / 10;
        }
    }
}
