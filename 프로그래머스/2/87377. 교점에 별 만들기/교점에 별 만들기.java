import java.util.*;

class Solution {
    private static int maxY = Integer.MIN_VALUE;
    private static int minY = Integer.MAX_VALUE;
    private static int maxX = Integer.MIN_VALUE;
    private static int minX = Integer.MAX_VALUE;
    
    private static class Pos {
        int r, c;
        
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return r == pos.r && c == pos.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    
    private static void check(int[][] line, HashSet<Pos> set, int cur, int next) {
        long A = line[cur][0];
        long B = line[cur][1];
        long E = line[cur][2];
        long C = line[next][0];
        long D = line[next][1];
        long F = line[next][2];
        
        long denominator = A * D - B * C;  // 분모 계산
        if (denominator == 0) return;  // 평행 또는 동일 직선
        
        long numeratorX = B * F - E * D;  // x의 분자
        long numeratorY = E * C - A * F;  // y의 분자

        // 정수인지 확인
        if (numeratorX % denominator == 0 && numeratorY % denominator == 0) {
            int x = (int) (numeratorX / denominator);
            int y = (int) (numeratorY / denominator);

            set.add(new Pos(y, x));

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
    }
    
    public String[] solution(int[][] line) {
        HashSet<Pos> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                check(line, set, i, j);
            }
        }

        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        String[] answer = new String[height];
        Arrays.fill(answer, ".".repeat(width));
        
        for (Pos pos : set) {
            int r = maxY - pos.r;
            int c = pos.c - minX;
            StringBuilder sb = new StringBuilder(answer[r]);
            sb.setCharAt(c, '*');
            answer[r] = sb.toString();
        }
        
        return answer;
    }
}
