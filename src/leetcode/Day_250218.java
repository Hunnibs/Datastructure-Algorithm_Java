package leetcode;

import java.util.*;

public class Day_250218 {
    class Solution {
        int[] number = new int[10];

        public String smallestNumber(String pattern) {
            int n = pattern.length();
            Deque<Integer> stack = new ArrayDeque<>();

            int cur = 1;
            for (int i = 1; i <= n; i++) {
                if (pattern.charAt(i-1) == 'I') {
                    if (!stack.isEmpty()) {
                        number[i] = n - cur++ + 1;
                        while(!stack.isEmpty()) {
                            number[stack.pollLast()] = n - cur++ + 1;
                        }
                    } else {
                        number[i] = n - cur++ + 1;
                    }
                } else {
                    stack.offerLast(i);
                }
            }

            number[n+1] = n - cur++ + 1;
            while(!stack.isEmpty()) {
                number[stack.pollLast()] = n - cur++ + 1;
            }

            int answer = 0;
            for (int i = 1; i <= n+1; i++) {
                answer += (i * (Math.pow(10, number[i])));
            }

            return Integer.toString(answer);
        }
    }
}
