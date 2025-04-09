class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return new TreeNode();

        TreeNode res = construct(nums, 0, nums.length - 1);
        return res;
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) return new TreeNode(nums[left]);
        if (left > right ) return null;

        int idx = findMax(nums, left, right);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = construct(nums, left, idx - 1);
        node.right = construct(nums, idx + 1, right);

        return node;
    }

    private int findMax(int[] nums, int left, int right) {
        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[max] < nums[i]) max = i;
        }
        return max;
    }
}
