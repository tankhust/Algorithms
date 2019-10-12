package 春招公司笔试20190310_20190515.basicClass;

public class Code_18_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value=data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        if (getLoopNode(head1) == null &&  getLoopNode(head2) == null) {//无环
            return noLoop(head1,head2);
        } else if (getLoopNode(head1) != null && getLoopNode(head2) != null) {//有环
            return bothLoop(head1,head2);
        } else {
            return null;
        }
    }

    public static Node getLoopNode(Node head) {//获得环
        if (head == null || head.next == null||head.next.next==null) {
            return null;
        }
        Node n1 = head.next;//慢指针
        Node n2 = head.next.next;//快指针
        while (n1!=n2) {
            if (n2.next==null||n2.next.next==null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2=head;//快指针回到头节点
        while (n1 != n2) {//利用之前快慢指正相遇的点距离环入口的距离和头结点距离环入口的距离相等的性质
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node noLoop(Node head1,Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int count=0;
        Node curr1 = head1;
        Node curr2 = head2;
        while (curr1 != null) {
            curr1=curr1.next;
            ++count;
        }
        while (curr2 != null) {
            curr2=curr2.next;
            --count;
        }
        curr1 = count > 0 ? head1 : head2;
        curr2 = curr1 == head1 ? head2 : head1;
        count = Math.abs(count);
        while (count != 0) {//长一点的链表先走
            curr1 = curr1.next;
            --count;
        }
        while (curr1 != null) {//走了两链表长度差之后，一起走
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    public static Node bothLoop(Node head1,Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1==loop2) {
            int count=0;
            while (curr1 != loop1) {
                curr1=curr1.next;
                ++count;
            }
            while (curr2 != loop2) {
                curr2=curr2.next;
                --count;
            }
            curr1 = count > 0 ? head1 : head2;
            curr2 = curr1 == head1 ? head2 : head1;
            count = Math.abs(count);
            while (count != 0) {//长一点的链表先走
                curr1 = curr1.next;
                --count;
            }
            while (curr1 != curr2) {//走了两链表长度差之后，一起走
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return curr1;
        }else{
            curr1=loop1.next;
            while (curr1 != loop1) {
                if (curr1 == loop2) {
                    return loop1;
                }
                curr1 = curr1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
