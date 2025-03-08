package backtracking;

import java.util.*;


//Backtracking explores all potential solutions in a depth-first but excepts paths that are clearly invalid
// Use cases:
// - Combinatorial problems (e.g., generating permutations, subsets,  combinations, ...)
// - Constraint satisfaction problems (e.g., Sudoku, N-Queens)
// - Graph problems (e.g., Hamiltonian path, Knight’s tour)
public class Solution {

    //There are ( 2^n ) possible subsets of a set with ( n ) elements.
    //For each subset, it takes ( O(n) ) time to construct it (in the worst case, when the subset contains all ( n ) elements).
    //Therefore, the overall time complexity is ( O(2^n * n) ).
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfsSubsets(nums, 0, subset, res);
        return res;
    }

    private void dfsSubsets(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // left child
        subset.add(nums[i]);
        dfsSubsets(nums, i + 1, subset, res);

        //right child
        subset.removeLast();// for visiting previous node and then go to the right child
        dfsSubsets(nums, i + 1, subset, res);
    }

    //Time Complexity: (O(2^n * n))
    //The method explores all possible combinations of the candidates array, which results in (2^n) combinations in the worst case.
    //For each combination, it takes (O(n)) time to construct it.
    //Space Complexity: (O(n))
    //The space complexity is primarily due to the recursion stack, which can go as deep as the length of the candidates array.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfsCombinationSum(candidates, 0, subset, res, target);

        return res;
    }

    private void dfsCombinationSum(int[] candidates, int i, List<Integer> subset, List<List<Integer>> res, int target) {
        if (i >= candidates.length) {
            return;
        }

        if (target < 0)
            return;

        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(candidates[i]);
        dfsCombinationSum(candidates, i, subset, res, target - candidates[i]);

        subset.remove(subset.size() - 1);
        dfsCombinationSum(candidates, i + 1, subset, res, target);
    }

    //Time Complexity: (O(2^n * n))
    //Similar to combinationSum, this method also explores all possible combinations, resulting in (2^n) combinations in the worst case.
    //Sorting the candidates array takes (O(n log n)) time, but the overall complexity is dominated by the combination generation.
    //Space Complexity: (O(n))
    //The space complexity is due to the recursion stack and the additional space used for sorting the candidates array.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates);

        dfsCombinationSum2(candidates, 0, subset, res, target);

        return res;
    }

    private void dfsCombinationSum2(int[] candidates, int i, List<Integer> subset, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (i >= candidates.length) {
            return;
        }

        if (target < 0)
            return;

        subset.add(candidates[i]);
        dfsCombinationSum2(candidates, i + 1, subset, res, target - candidates[i]);

        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        dfsCombinationSum2(candidates, i + 1, subset, res, target);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 1, 2, 3};

//        List<List<Integer>> result = solution.subsets(nums);
//        List<List<Integer>> result = solution.combinationSum(nums, 3);
        List<List<Integer>> result = solution.combinationSum2(nums, 3);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
