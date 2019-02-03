/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res=new ArrayList<>();
        dfs(res,nestedList);
        return res;
    }
    void dfs(List<Integer> res,List<NestedInteger> nestedList){
        for(int i=0;i<nestedList.size();i++){
            if(nestedList.get(i).isInteger()){
                res.add(nestedList.get(i).getInteger());
            }
            else{
                dfs(res,nestedList.get(i).getList());
            }
        }
    }
}
