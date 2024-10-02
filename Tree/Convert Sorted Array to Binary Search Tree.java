// Logic and Intuition:

// DIVIDE AND CONQUER : 
  // The middle element of the array becomes the root, ensuring balanced subtrees.

// Recursive Construction :
  // Left subtree is built using the left half of the array.
  // Right subtree is built using the right half.
  // Base Case: When there are no elements left in the subarray, return null.

class Solution {
    public TreeNode sortedArrayToBST(int[] nums){

        return solve(nums, 0, nums.length-1);
    }

    public TreeNode solve(int[] nums, int start, int 
    end) {
        if(start > end) {
            return null;
        }

        int mid = (start+end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = solve(nums, start, mid-1);
        root.right = solve(nums, mid+1, end);

        return root;
    }
}
