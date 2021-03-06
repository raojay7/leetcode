import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        //先加入一个空集
        res.add(new ArrayList<>());
        if (nums==null||nums.length==0)return res;
        Arrays.sort(nums);
        dfs(0,nums,res,new ArrayList<>());
        return res;
    }

    void dfs(int start,int[] nums,List<List<Integer>> res,List<Integer> list){

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(i+1,nums,res,list);
            list.remove(list.size()-1);//回溯
        }
    }


}

//一样的写法
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {        
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;
        helper(new ArrayList<>(),res,nums,0);
        return res;
    }
    
    public void helper(List<Integer> list,List<List<Integer>> res,int nums[],int begin){
        res.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            helper(list,res,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
