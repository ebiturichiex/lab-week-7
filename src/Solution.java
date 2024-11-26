//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through the array and find consecutive sequences
        for (int num : nums) {
            // Check if it is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {0};
        int[] nums5 = {5, 5, 5, 5};
        int[] nums6 = {0, -1, 9, -3, -2, 2, 1, 5};
        int[] nums7 = {10, 20, 30, 40, 50};
        int[] nums8 = {1, 9, 3, 10, 4, 20, 2};
        int[] nums9 = {1, 3, 5, 2, 4, 6, 7, 9, 8, 12, 13, 10, 11};

        System.out.println(solution.longestConsecutive(nums1)); // Output: 4
        System.out.println(solution.longestConsecutive(nums2)); // Output: 9
        System.out.println(solution.longestConsecutive(nums3)); // Output: 5
        System.out.println(solution.longestConsecutive(nums4)); // Output: 1
        System.out.println(solution.longestConsecutive(nums5)); // Output: 1
        System.out.println(solution.longestConsecutive(nums6)); // Output: 6
        System.out.println(solution.longestConsecutive(nums7)); // Output: 5
        System.out.println(solution.longestConsecutive(nums8)); // Output: 4
        System.out.println(solution.longestConsecutive(nums9)); // Output: 13
    }
}
