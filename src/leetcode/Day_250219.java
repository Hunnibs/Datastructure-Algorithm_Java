class Solution {
    final char[] sets = {'a', 'b', 'c'};
    List<String> happyString = new ArrayList<>();

    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(sets[i]);
            findHappyString(1, n, i, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (happyString.size() < k) return "";
        else return happyString.get(k-1);
    }

    public void findHappyString(int depth, int n, int idx, StringBuilder sb) {
        if (depth == n) {
            happyString.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (idx != i) {
                sb.append(sets[i]);
                findHappyString(depth + 1, n, i, sb);
                sb.deleteCharAt(sb.length()-1);
            } else {
                continue;
            }
        }
    }
}
