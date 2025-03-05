class Solution {
    public long coloredCells(int n) {
        return 4 * (long)n * ((long)n-1) / 2 + 1;
    }
}