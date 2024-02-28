package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_02800 {
    private static List<String> answer = new ArrayList<>();
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String exp = br.readLine();
        // input end

        boolean[] visited = new boolean[exp.length()];
        init(exp);
        dfs(exp, 0, sb, visited);

        Collections.sort(answer);

        for (int i = 1; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(String exp, int depth, StringBuilder sb, boolean[] visited) {
        if (depth == exp.length()) {
            if (!answer.contains(String.valueOf(sb))) {
                answer.add(String.valueOf(sb));
            }
            return;
        }

        if (exp.charAt(depth) == '(') {
            visited[map.get(depth)] = true;
            dfs(exp, depth + 1, sb, visited);
            visited[map.get(depth)] = false;
            dfs(exp, depth + 1, sb.append(exp.charAt(depth)), visited);
            sb.deleteCharAt(sb.length() - 1);
        } else if (exp.charAt(depth) == ')') {
            if (visited[depth]) {
                dfs(exp, depth + 1, sb, visited);
            } else {
                dfs(exp, depth + 1, sb.append(exp.charAt(depth)), visited);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            dfs(exp, depth + 1, sb.append(exp.charAt(depth)), visited);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void init(String exp) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                stack.offerLast(i);
            } else if (exp.charAt(i) == ')') {
                map.put(stack.pollLast(), i);
            }
        }
    }
}
