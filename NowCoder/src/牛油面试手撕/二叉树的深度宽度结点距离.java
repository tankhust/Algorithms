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

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度宽度结点距离
 *
 * @author fakertan
 * @version V1.0
 * @date 2019/8/19
 */
public class 二叉树的深度宽度结点距离
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
//        System.out.println(treeDepth(node));
//        System.out.println(treeWidth(node));
        System.out.println(treeNodeDistance(node));
    }

    private static int treeDepth(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        return Math.max(treeDepth(node.left), treeDepth(node.right)) + 1;
    }

    private static int treeWidth(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int size = 1;
        int curWidth = 1;
        int width = 1;
        while (!queue.isEmpty())
        {
            while (size != 0)
            {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                {
                    queue.add(cur.left);
                }
                if (cur.right != null)
                {
                    queue.add(cur.right);
                }
                size--;
            }
            curWidth = queue.size();
            width = curWidth > width ? curWidth : width;
            size = curWidth;
        }
        return width;
    }

    private static int treeNodeDistance(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        int[] res = new int[1];
        res[0] = 0;
        heightOfTree(node,res);
        return res[0];
    }

    private static int heightOfTree(TreeNode node, int[] res)
    {
        if (node == null)
        {
            return -1;
        }
        int leftHeight = heightOfTree(node.left, res) + 1;
        int rightHeight = heightOfTree(node.right, res) + 1;
        res[0] = res[0] > (leftHeight + rightHeight) ? res[0] : (leftHeight + rightHeight);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
