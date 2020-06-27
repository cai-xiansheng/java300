package algorithm; /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Codec {
    // 中序遍历

    private String ser(TreeNode root, String str) {
        if (root == null) {
            // 当前节点为空
            str = str + "null,";
        } else {
            // 当前节点不为空
            str = str + root.val + ",";
            str = ser(root.left, str);
            str = ser(root.right, str); 
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { // 序列化
        return ser(root, "");
    }

    private TreeNode des(List<String> strList) {

        if (strList.get(0).equals("null")) {
            strList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strList.get(0)));
        strList.remove(0);
        root.left = des(strList);
        root.right = des(strList);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // 反序列化
        String[] strArray = data.split(",");
        List<String> list = new ArrayList<>();
        list = Arrays.asList(strArray);
        // System.out.println(list);
        return des(list);
    }

    public static void main(String[] args) {

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));