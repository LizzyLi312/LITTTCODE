//use hashmap to store the original node and the copy node. then traverse the neighbors using queue to build the relationship for the copy nodes
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>(); //using hashmap to store the relationship between original node and new node
        Node cur = node;
        Node curCopy = new Node(node.val);
        map.put(cur, curCopy);
        Queue<Node> que = new LinkedList<>(); //bfs to color the nodes
        que.offer(cur);
        while(!que.isEmpty()){
            cur = que.poll();
            curCopy = map.get(cur);
            for(Node nei : cur.neighbors){
                if(map.containsKey(nei)) curCopy.neighbors.add(map.get(nei)); //means we already colored it(visited it) so we just need to build the edge between the newNode and the copy node 
                else{ //if we haven't visited it. then store nodes pair into the hashmap and put into que
                    Node copy = new Node(nei.val);
                    map.put(nei, copy);
                    curCopy.neighbors.add(copy);
                    que.offer(nei);
                }
            }
        }
        return map.get(node);
    }
}
