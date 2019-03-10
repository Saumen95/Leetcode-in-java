class Solution {
   public List<String> binaryTreePaths(TreeNode root) {
 
    String sb = "";
    ArrayList<String> result = new ArrayList<String>();
 
    helper(root, result, sb);
 
    return result;
}
 
public void helper(TreeNode root, ArrayList<String> result, String s){
    if(root==null){
        return;
    }
 
    s = s+"->"+root.val;
 
    if(root.left==null &&root.right==null){
        result.add(s.substring(2));
        return;
    }
 
    if(root.left!=null){
        helper(root.left, result, s);
    }
    if(root.right!=null){
        helper(root.right, result, s);
    }
}
}