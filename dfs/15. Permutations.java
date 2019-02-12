import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //只有当size为nums.length时才加入
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (nums==null||nums.length==0){
            res.add(new ArrayList<>(list));
            return res;
        }
        Arrays.sort(nums);
        dfs(nums,res,list);
        return res;
    }

    void dfs(int[] nums,List<List<Integer>> res,List<Integer> list){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            dfs(nums,res,list);
            list.remove(list.size()-1);
        }
    }
}
