class Solution {
    public boolean checkPowersOfThree(int n) {
        List<Integer> dp = new ArrayList<>();
        int x = 0;
        int y = (int)Math.pow(3, x++);
        while(y <= n) {
            dp.add(y);
            y = (int)Math.pow(3, x++);
        }

        return sum(dp.size() - 1, 0, n, dp);
    }

    private boolean sum(int cur, int sum, int n, List<Integer> dp) {
        if (cur < 0) {
            if (sum == n) return true;
            else return false;
        }

        int num = dp.get(cur);
        boolean flag1 = sum(cur-1, sum, n, dp);
        boolean flag2 = sum(cur-1,sum + num, n, dp);

        if (flag1 || flag2) return true;
        else return false;
    }
}