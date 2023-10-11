/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {

    public static void inOrderTraversal(TreeNode root, List<Integer> arr){
        if (root != null){
            inOrderTraversal(root.left, arr);
            arr.add(root.data);
            inOrderTraversal(root.right, arr);
        }
        return;
    }
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> a, b, ans;
        a = new ArrayList<>();
        b = new ArrayList<>();
        ans = new ArrayList<>();

        inOrderTraversal(root1, a);
        inOrderTraversal(root2, b);
        int i = 0, j = 0, m = a.size(), n = b.size();
        while(i < m || j < n){
            if (i >= m)
                ans.add(b.get(j++));
            else if(j >= n)
                ans.add(a.get(i++));
            else if (a.get(i) < b.get(j))
                ans.add(a.get(i++));
            else
                ans.add(b.get(j++));
        }
        return ans;
    }
}