package channel.leetcode.questions.TwoSum;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        BestSolution bestSolution = new BestSolution();

        int[] nums = {150,24,79,50,88,345,3};

        solution.twoSum(nums, 200);
        bestSolution.twoSum(nums, 200);
    }
}
