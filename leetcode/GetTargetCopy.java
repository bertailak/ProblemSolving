package leetcode;

import leetcode.model.TreeNode;

public class GetTargetCopy {

    // https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original.val==cloned.val && original.val==target.val) return cloned;
        if(original.left !=null && cloned.left !=null){
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if(left!=null) return left;
        }
        if(original.right !=null && cloned.right !=null){
            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            if(right!=null) return right;
        }

        return null;
    }
}
