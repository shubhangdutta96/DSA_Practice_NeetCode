class Solution {
    int remove = -1;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            // edge case
            return null;
        }

        if(root.val == key && root.left == null && 
        root.right == null) {
            // single node in the entire tree
            return null;
        }

        List<Integer> list = new ArrayList<>();
        traversal(root, list); // inorder traversal

        return solve(root, key, list);
    }

    public TreeNode solve(TreeNode root, int key, 
    List<Integer> list) {
        if(root == null) {
            // base case
            return null;
        }

        if(root.val == key) {
            if(root.right == null && root.left == null) {
                // leaf node
                return null;
            } else if(root.left == null && root.right != null) {
                // left is null
                return root.right;
            } else if(root.left != null && root.right == null) {
                // right is null
                return root.left;
            } else {
                for(int i=0; i<list.size()-1; i++) {
                    if(list.get(i) == key) {
                        root.val = list.get(i+1);
                        
                        root.right =
                        solve(root.right, list.get(i+1), list);
                        break;
                    }
                }
            }
        }


        root.left = solve(root.left, key, list);
        root.right = solve(root.right, key, list);

        return root;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
        
        return;
    }
}
