/**
 * title:
 *   98. Validate Binary Search Tree
 *
 * content:
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 *    Assume a BST is defined as follows:
 *        The left subtree of a node contains only nodes with keys less than the node's key.
 *        The right subtree of a node contains only nodes with keys greater than the node's key.
 *        Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long low, long high)
    {
        if(root == null)
        {
            return true;
        }
        if(root.val <= low || root.val >= high)
        {
            return false;
        }
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
}
