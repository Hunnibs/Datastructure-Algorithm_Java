class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= Math.sqrt(right); i++) {
            int j = 2;
            while(i * j <= right) {
                isPrime[i * j] = false;
                j++;
            }
        }

        List<Integer> primeNumber = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) primeNumber.add(i);
        }

        int[] answer = new int[2];
        int diff = Integer.MAX_VALUE;
        if (primeNumber.size() < 2) return new int[]{-1, -1};
        else {
            for (int i = 0; i < primeNumber.size() - 1; i++) {
                if (primeNumber.get(i) == 1) continue;

                if (diff <= primeNumber.get(i + 1) - primeNumber.get(i)){
                    continue;
                } else {
                    answer[0] = primeNumber.get(i);
                    answer[1] = primeNumber.get(i+1);
                    diff = answer[1] - answer[0];
                }
            }

            return answer;
        } 
    }
}