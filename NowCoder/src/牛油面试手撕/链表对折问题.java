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

/**
 * 链表对折
 * 
 * @author fakertan
 * @date 2019/8/20
 * @version V1.0
 */
public class 链表对折问题
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static void reorderList(ListNode node)
    {
        if (node == null || node.next == null || node.next.next == null)
        {
            return;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);// 反转链表
        ListNode first = node;
        while (second != null)
        {
            ListNode next = first.next;
            first.next = second;
            second = second.next;
            first = first.next;
            first.next = next;
            first = first.next;
        }
    }

    private static ListNode reverse(ListNode node)
    {
        ListNode dummy = new ListNode(-1);
        while (node != null)
        {
            ListNode next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
        }
        return dummy.next;
    }

}
class ListNode{
    ListNode next;
    int val;

    ListNode(int val)
    {
        this.val = val;
    }
}
