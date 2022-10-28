import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
// Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

  private static boolean PathWithGivenSequence(TreeNode root, int[] sequence) {
        if (root == null)
      return sequence.length == 0;
    return PathWithGivenSeq(root, sequence, 0);
  }

  private static boolean PathWithGivenSeq(TreeNode currentNode, int[] sequence, int sequenceIndex) {
    if (currentNode == null)
      return false;

    if(sequenceIndex >= sequence.length || currentNode.val != sequence[sequenceIndex])
      return false;
    
    if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
      return true;
    
    return PathWithGivenSeq(currentNode.left, sequence, sequenceIndex + 1) || PathWithGivenSeq(currentNode.right, sequence, sequenceIndex + 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println(Main.PathWithGivenSequence(root, new int[] {1,1,1}));

  }
}