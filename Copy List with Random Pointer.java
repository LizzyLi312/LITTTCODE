//we need: relation between old nodes and new nodes; return new head
class Solution {
    public Node copyRandomList(Node head) {
        //2 passes + HashMap
        if(head == null) return head;
        Map<Node, Node> relation = new HashMap<>();
        Node cur = head;
        //1st pass: build the relationship between new nodes and old nodes
        while(cur != null){
            relation.put(cur, new Node(cur.val));  //do not need to build a new linkedlist cause
            cur = cur.next;
        }
        //2nd pass: copy the relationship between one node to the nodes that have connection with it
        cur = head;
        while(cur != null){
            relation.get(cur).next = relation.get(cur.next);  //new_node.next = old_node.next
            relation.get(cur).random = relation.get(cur.random);
            cur = cur.next;
        }
        return relation.get(head); //new head
    }
}
