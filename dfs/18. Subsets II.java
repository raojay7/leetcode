import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //先加入一个空集
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

   

    void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> list) {

        for (int i = start; i < nums.length; i++) {
            //保证只取相邻的不跳过去取（去重）
            if(i!=start&&nums[i-1]==nums[i])continue;
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(i + 1, nums, res, list);
            list.remove(list.size() - 1);//回溯
        }
    }


}
