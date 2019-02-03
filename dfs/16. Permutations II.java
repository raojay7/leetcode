import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (nums==null||nums.length==0){
            res.add(new ArrayList<>(list));
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited=new boolean[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=false;
        }
        dfs(visited,nums,res,list);
        return res;
    }

    void dfs(boolean[] visited,int[] nums,List<List<Integer>> res,List<Integer> list){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //利用访问数组来判断是否访问过，前面的是利用list的自带contains来判断，核心还是判断其有没有被访问过
            //同时我们强制要求先访问前面的，如果前面的还没被访问，后面的相同元素就不让访问
            if (visited[i]||(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]))continue;
            visited[i]=true;
            list.add(nums[i]);
            dfs(visited,nums,res,list);

            //回溯
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
}
