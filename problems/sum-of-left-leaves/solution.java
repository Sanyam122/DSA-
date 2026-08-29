class Solution{


public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
}

private int helper(TreeNode node, boolean isLeftChild) {
    if (node == null) {
        return 0;
    }
    if (node.left == null && node.right == null) {
        return isLeftChild ? node.val : 0;
    }
    return helper(node.left, true) + helper(node.right, false);
}
}