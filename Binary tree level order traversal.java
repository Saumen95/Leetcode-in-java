import javax.swing.tree.TreeNode;
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            List<Integer> thisLevel = new ArrayList(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode tn = q.poll();
                thisLevel.add(tn.val);
                if (tn.left != null) {
                    q.add(tn.left);
                }
                if (tn.right != null) {
                    q.add(tn.right);
                }
            }
            result.add(thisLevel);


        }
        return result;
    }
}