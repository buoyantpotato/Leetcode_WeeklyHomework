package Weekly_Homework;

public class M114_BTtoLinkedList {

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        
        if (root.left != null) {
            TreeNode tempRight = root.right;
            TreeNode leftLast = mostRightInLeft(root.left);
            root.right = root.left;
            root.left = null;
            leftLast.right = tempRight;
            TreeNode rightLast = mostRightInLeft(leftLast);
        }
        else {
            TreeNode rightLast = mostRightInLeft(root.right);
        }
        
    }
    
    private TreeNode mostRightInLeft(TreeNode root) {
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        if (root.left != null) {
            TreeNode tempRight = root.right;
            TreeNode leftLast = mostRightInLeft(root.left);
            root.right = root.left;
            root.left = null;
            leftLast.right = tempRight;
            return mostRightInLeft(leftLast);
        }
        else {
            return mostRightInLeft(root.right);
        }
    }
}
