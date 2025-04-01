class Solution {
    public Node insert(Node head, int insertVal) {
        Node res = new Node(insertVal);
        if (head == null) {
            res.next = res; // also need itself to point to itself 
            return res;
        }
        
        Node p = head;
        while (p.next != head) {
          // case1: in the increasing part of the linked list
            if (p.val <= p.next.val) {
                if (p.val <= insertVal && insertVal <= p.next.val) break;
          // case2: at the board of max and min so it could be the new min or the new max
            } else {
                if (insertVal >= p.val || insertVal <= p.next.val) break;
            }
            p = p.next;
        }

        res.next = p.next;
        p.next = res;
        return head;
    }
}
