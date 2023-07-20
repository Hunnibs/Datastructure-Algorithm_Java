import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String words = "안녕하세요 저는 이병헌입니다";
        char word = words.charAt(1);

        for (int i = 0; i < words.length(); i++){
            System.out.println(words.charAt(i));
        }

        StringTokenizer st = new StringTokenizer(words);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}