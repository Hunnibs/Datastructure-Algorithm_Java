package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HarshadNumber {
    public boolean solution(int x) {
        boolean answer = true;
        int y = x;
        int sum = 0;

        for(int i=1; i<=4; i++){
            int tmp = y % 10;
            sum += tmp;
            y = (y-tmp) / 10;
        }

        if(x % sum != 0){
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x;

        x = Integer.parseInt(st.nextToken());

        HarshadNumber hn = new HarshadNumber();
        System.out.println(hn.solution(x));
    }
}
