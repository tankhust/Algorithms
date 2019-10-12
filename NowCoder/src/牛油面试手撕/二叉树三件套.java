/*
 * Tencent is pleased to support the open source community by making BlueKing available.
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package 牛油面试手撕;


import java.util.Stack;

/**
 * 二叉树三件套
 * 
 * @author fakertan
 * @date 2019/8/19
 * @version V1.0
 */
public class 二叉树三件套
{
    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
//        new 二叉树三件套().preOrder(node);
//        new 二叉树三件套().inOrder(node);
        new 二叉树三件套().postOrder(node);
    }

    private void preOrder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                System.out.print(root.val + " ");
                root = root.left;
            }
            if (!stack.isEmpty())
            {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    private void inOrder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty())
            {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    private void postOrder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack1.push(root);
                stack2.push(root);
                root = root.right;
            }
            if (!stack1.isEmpty())
            {
                root = stack1.pop();
                root = root.left;
            }
        }
        while (!stack2.isEmpty())
        {
            System.out.print(stack2.pop().val + " ");
        }
    }

}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val)
    {
        this.val = val;
    }
}
