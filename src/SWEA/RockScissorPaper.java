package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RockScissorPaper {
    static int A;
    static int B;

    public String solution(int A, int B){  // 비기는 경우는 없다고 가정
        String answer = null;
        if (A > B){
            if (B == 1 && A == 3){
                answer = "B";
            }
            else{
                answer = "A";
            }
        }
        else if (B > A){
            if (A == 1 & B == 3){
                answer =  "A";
            }
            else{
                answer = "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        RockScissorPaper rsp = new RockScissorPaper();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(rsp.solution(A, B));
    }
}
