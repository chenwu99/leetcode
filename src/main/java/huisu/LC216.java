package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class LC216 {

    private List<Integer> tmpList = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSumDfs(1,  n, 0, k);
        return res;
    }

    private void combinationSumDfs(int start, int target, int curSum, int k) {

        if (curSum == target ) {
            System.out.println("123");
            if( tmpList.size() == k) {
                res.add(new ArrayList<>(tmpList));
            }
        } else {
            if(res.size() > 0){
                return;
            }
            if (curSum > target) {
                return;
            }
            for (int i = start; i < 10; i++) {
                tmpList.add(i);
                combinationSumDfs(i + 1, target, curSum + i, k);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new LC216().combinationSum3(3, 7);
        System.out.println(res.toString());
    }
}
