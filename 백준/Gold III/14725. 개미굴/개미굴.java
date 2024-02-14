import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 이병헌
 * - @since 2/10/24
 * - @see https://www.acmicpc.net/problem/14725
 * - @git https://github.com/Hunnibs
 * - @youtube
 * - @performance 1sec 256MB
 * - @category # List # HashMap
 * - @note
 */

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<String> roots = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<TreeMap<String, List<String>>> tree = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            tree.add(new TreeMap<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            // 맨 처음 root node 초기화
            String root = st.nextToken();
            if (!roots.contains(root)) {
                roots.add(root);
            }

            if (!tree.get(0).containsKey(root)) {
                tree.get(0).put(root, new ArrayList<>());
            }

            // 트리 형태로 만들기
            StringBuilder parent = new StringBuilder(root);
            for (int j = 1; j < num; j++) {
                String node = st.nextToken();
                if (tree.get(j).containsKey(parent.toString())) {
                    if (!tree.get(j).get(parent.toString()).contains(node)) {
                        tree.get(j).get(parent.toString()).add(node);
                    }
                } else {
                    tree.get(j).put(parent.toString(), new ArrayList<>());
                    tree.get(j).get(parent.toString()).add(node);
                }
                parent.append(node);
            }
        }

        // 출력
        Collections.sort(roots);
        for (String key : roots) {
            sb.append(key).append("\n");
            sol(tree, 1, new StringBuilder(key));
        }
        System.out.print(sb);
    }

    private static void sol(List<TreeMap<String, List<String>>> tree, int depth, StringBuilder key) {
        TreeMap<String, List<String>> cur = tree.get(depth);
        String curKey = key.toString();

        if (cur.containsKey(curKey)) {
            List<String> next = cur.get(curKey);
            Collections.sort(next);
            for (String nextKey : next) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(nextKey).append("\n");
                sol(tree, depth + 1, key.append(nextKey));
                key.delete(key.length()-nextKey.length(), key.length());
            }
        }
    }
}