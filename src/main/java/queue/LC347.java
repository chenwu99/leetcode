package queue;



import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 思路： a.放到map里面; b.map根据value排序;
 * c. 排序的时间复杂度; 快排：O(nlogn)
 */
public class LC347 {

    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>(k, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.fst - o2.fst;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer num :map.keySet()) {
            if(queue.size() >= k){
                queue.poll();
            }
            queue.add(new Pair<>(map.get(num), num));
        }

        int[] res = new int[k];
        int i = 0;
        while(!queue.isEmpty() && i < k){
            res[i] = queue.poll().snd;
            System.out.println(res[i]);
            i++;
        }
        return res;
    }

    static class Pair<A, B> {

        public  A fst;
        public  B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public boolean equals(Object other) {
            return
                    other instanceof com.sun.tools.javac.util.Pair<?,?> &&
                            Objects.equals(fst, ((com.sun.tools.javac.util.Pair<?,?>)other).fst) &&
                            Objects.equals(snd, ((com.sun.tools.javac.util.Pair<?,?>)other).snd);
        }

        public int hashCode() {
            if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
            else if (snd == null) return fst.hashCode() + 2;
            else return fst.hashCode() * 17 + snd.hashCode();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(new LC347().topKFrequent(nums, 2)));

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>(2, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.fst - o2.fst;
            }
        });
        queue.add(new Pair<>(3,1));
        queue.add(new Pair<>(2,2));
        queue.add(new Pair<>(1,3));

        while(!queue.isEmpty()){
            System.out.println(queue.poll().fst);
        }




    }
}
