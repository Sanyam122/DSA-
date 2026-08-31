/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = 0;
        helper(root,  set);
        for( int i = 1 ; i <= k ; i++){
            if( i == k) ans = set.pollFirst();
            set.pollFirst();
        };
        return ans;
    };

    private void helper( TreeNode root,TreeSet set){
        if( root == null)return;
        set.add( root.val);
        helper(root.left,set);
        helper(root.right,set);
    };
}