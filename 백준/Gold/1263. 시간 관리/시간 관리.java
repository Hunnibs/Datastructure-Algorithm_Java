import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**

- @author 이병헌
- @since 12/13/23
- @see https://www.acmicpc.net/problem/1263
- @git https://github.com/Hunnibs
- @youtube
- @performance 2sec 128MB
- @category # Greedy
- @note
 끝내야하는 시간을 기준으로 내림차순으로 정렬
 끝 시간부터 차례대로 시간을 빼준다. -> 시간이 음수가 되는 순간은 -1을 출력하도록 한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Info> timeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            timeList.add(new Info(T, S));
        }

        // input end
        timeList.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.S - o1.S;
            }
        });

        int currentTime = timeList.get(0).S;
        for (int i = 0; i < N; i++) {
            int curS = timeList.get(i).S;
            int curT = timeList.get(i).T;

            if (curS < currentTime){
                currentTime = curS;
            }

            if (curS >= currentTime && currentTime - curT >= 0){
                currentTime -= curT;
            }  else{
                currentTime = -1;
                break;
            }
        }

        System.out.println(currentTime);
    }

    private static class Info{
        int T, S;

        public Info(int t, int s) {
            T = t;
            S = s;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "T=" + T +
                    ", S=" + S +
                    '}';
        }
    }
}