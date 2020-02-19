    public static int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> que = new LinkedList<>();
        int sum = 0, level = 1;
        for(NestedInteger num : nestedList){
                que.offer(num);
        }
        while(!que.isEmpty()){
            int size = que.size(), levelSum = 0;
            while(size-- > 0){
                NestedInteger cur = que.poll();
                if(cur.isInteger()) levelSum += cur.getInteger();
                else{
                    for(NestedInteger ni : cur.getList()){
                        que.offer(ni);
                    }
                }
            }
            sum += levelSum * level++;
        }
        return sum;
    }
