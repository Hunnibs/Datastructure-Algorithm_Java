package leetcode;

import java.util.*;

public class Day_250217 {
    class Solution {
        public int numTilePossibilities(String tiles) {
            Set<String> set = new HashSet<>();
            int n = tiles.length();
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                visited[i] = true;
                set.add(tiles.substring(i, i + 1));
                combination(tiles, tiles.substring(i, i + 1), visited, set, n, 0);
                visited[i] = false;
            }

            return set.size();
        }

        private void combination(String tiles, String subTiles, boolean[] visited, Set<String> set, int n, int depth) {
            for(int i = 0; i < n; i++) {
                if (visited[i]) continue;
                else {
                    visited[i] = true;
                    set.add(subTiles.concat(tiles.substring(i, i + 1)));
                    combination(tiles, subTiles.concat(tiles.substring(i, i + 1)), visited, set, n, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
