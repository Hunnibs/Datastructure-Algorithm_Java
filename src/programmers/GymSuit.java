package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GymSuit {
    static int n;
    static int[] lost;
    static int[] reserve;

    public int solution(int n, int[] lost, int[] reserve){
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length;i++){
            for(int j=0; j<reserve.length;j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }

        for(int i=0; i<lost.length;i++){
            int lostStudent = lost[i];
            for(int j=0; j<reserve.length;j++){
                if (lostStudent - 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer += 1;
                    break;
                } else if (lostStudent + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        GymSuit gs = new GymSuit();

        n = Integer.parseInt(st.nextToken());
        lost = new int[] {2, 4};
        reserve = new int[] {2, 3, 4};

        System.out.println(gs.solution(n, lost, reserve));
    }
}
