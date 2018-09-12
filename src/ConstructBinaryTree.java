import java.util.HashMap;
import java.util.Map;

/**
 * title:
 *   889. Construct Binary Tree from Preorder and Postorder Traversal
 *
 * content:
 *   Return any binary tree that matches the given preorder and postorder traversals.
 *   Values in the traversals pre and post are distinct positive integers.
 */


public class ConstructBinaryTree {
    private static Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        for(int i = 0; i < post.length; i++)
        {
            map.put(post[i], i);
        }

        return recurseBuildTree(pre, post, 0, pre.length -1, 0, post.length - 1);
    }

    private TreeNode recurseBuildTree(int[] pre, int[] post, int preStart , int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd)
        {
            return root;
        }

        //get the index of left tree root node in the post traversed tree
        int postLeftRootIndex = map.get(pre[preStart + 1]);
        int leftTreeLen = postLeftRootIndex - postStart + 1;
        //rebuild left child tree
        root.left = recurseBuildTree(pre, post, preStart + 1, preStart + leftTreeLen, postStart, postLeftRootIndex);
        //rebuild right child tree
        root.right = recurseBuildTree(pre, post, preStart + leftTreeLen + 1, preEnd, postLeftRootIndex + 1, postEnd - 1);

        return root;
    }
}

