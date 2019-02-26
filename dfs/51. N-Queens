import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> pos = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pos.add(0);
        }
        dfs(res, pos, 0, n);
        return res;
    }

    void dfs(List<List<String>> res, List<Integer> pos, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            //将pos放入结果集中
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == pos.get(i)) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (pos.set(row, 0); pos.get(row) < n; pos.set(row, pos.get(row) + 1)) {
            if (issafe(pos, n, row)) {
                dfs(res, pos, row + 1, n);
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
