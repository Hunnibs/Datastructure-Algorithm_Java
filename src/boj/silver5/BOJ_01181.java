package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        Set<String> set1 = new HashSet<String>(Arrays.asList(words));
        String[] words2 = set1.toArray(new String[0]);

        Arrays.sort(words2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });


        for(int i = 0; i < words2.length; i++){
            System.out.println(words2[i]);
        }
    }
}
