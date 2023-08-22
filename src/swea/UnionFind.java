package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - @author 이병헌
 * - @since 2023-08-22
 * - @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * - @git
 * - @youtube
 * - @performance
 * - @category # Union-Find
 * - @note
 */
public class UnionFind {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            make();

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 0){  // union
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else{  // find
                    if(check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))){
                        sb.append(1);
                    } else{
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void make(){
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }

    private static int find(int a){
        if (parent[a] == a){
            return parent[a];
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    private static boolean union(int a, int b){
        int A = find(a);
        int B = find(b);

        if (A == B){
            return true;
        } else{
            parent[A] = B;
            return false;
        }
    }
    private static boolean check(int a, int b){
        int A = find(a);
        int B = find(b);

        if (A == B){
            return true;
        } else{
            return false;
        }
    }
}
