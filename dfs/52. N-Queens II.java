import java.util.ArrayList;
import java.util.List;

class Solution {
    int cnt=0;
   
    public int totalNQueens(int n) {
        List<Integer> pos = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pos.add(0);
        }
        dfs(pos, 0, n);
        return cnt;
    }

    void dfs(List<Integer> pos, int row, int n) {
        if (row == n) {
            cnt++;
            return;
        }
        for (pos.set(row, 0); pos.get(row) < n; pos.set(row, pos.get(row) + 1)) {
            if (issafe(pos, n, row)) {
                dfs(pos, row + 1, n);
            }
        }
    }

    boolean issafe(List<Integer> pos, int n, int row) {
        for (int i = 0; i < row; i++) {
            if (pos.get(i).equals(pos.get(row)) || Math.abs(i - row) == Math.abs(pos.get(i) - pos.get(row)))
                return false;
        }
        return true;
    }
}
