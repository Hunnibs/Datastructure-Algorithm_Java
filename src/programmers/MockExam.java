package programmers;

public class MockExam {
    public int[] solution(int[] answers){
        int[] answer = {};

        int[] studentA = new int[] {1, 2, 3, 4, 5};
        int[] studentB = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] correct = new int[] {0, 0, 0};

        for(int i = 0; i < answers.length; i++){
            if (answers[i] == studentA[i % 5]) {
                correct[0] += 1;
            }
        }

        for(int i = 0; i < answers.length; i++){
            if (answers[i] == studentB[i % 8]){
                correct[1] += 1;
            }
        }

        for(int i = 0; i < answers.length; i++){
            if (answers[i] == studentC[i % 10]) {
                correct[2] += 1;
            }
        }

        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));

        int maxCount = 0;
        for (int i = 0; i < 3; i++) {
            if (max == correct[i]){
                maxCount += 1;
            }
        }

        answer = new int[maxCount];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (max == correct[i]) {
                answer[idx++] = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MockExam me = new MockExam();

        int[] answers = new int[] {1, 2, 3, 4, 5};
        System.out.println(me.solution(answers));
    }
}
