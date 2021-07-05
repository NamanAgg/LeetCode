//************40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

// Constraints:
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2_03(candidates, target, 0, smallAns, res);

        return res;
    }

    public int combinationSum2_03(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            count += combinationSum2_03(arr, tar - arr[idx], idx + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        idx++;
        while (idx < arr.length && arr[idx - 1] == arr[idx]) {
            idx++;
        }

        count += combinationSum2_03(arr, tar, idx, smallAns, res);
        return count;
    }
}
