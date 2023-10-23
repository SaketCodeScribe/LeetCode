class Node{
	int key,val;
	Node prev, next;
	
	Node (int key, int val){
		this.key = key;
		this.val = val;
		this.next = this.prev = null;
	}
}
class LRUCache {
	int n, size;
	Node head, last;
	Map<Integer, Node> nodeMap;
    public LRUCache(int capacity) {
        n = 0;
        size = capacity;
        head = last = null;
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (nodeMap.get(key) == null)
        	return -1;
        if (key == head.key)
            return head.val;
        Node curr = nodeMap.get(key);
        Node prev = curr.prev, next = curr.next;
        if (prev != null)
        	prev.next = next;
        if (next != null)
        	next.prev = prev;
        else if (prev != null)
        	last = prev;
        curr.next = head;
        head.prev = curr;
        head = curr;
        // Node temp = head;
        // while (temp != null){
        //     System.out.print(temp.key+" ");
        //     temp = temp.next;
        // }
        // System.out.println();
        return head.val;
    }
    
    public void put(int key, int value) {
        if (nodeMap.get(key) == null) {
        	Node curr = new Node(key, value);
        	curr.next = head;
        	if (head != null)
        		head.prev = curr;
        	else
        		last = curr;
        	head = curr;
        	if (n == size) {
        		nodeMap.remove(last.key);
        		last = last.prev;

        		if (last != null){
        			if (last.next != null)
                        last.next.prev = null;
                    last.next = null;
                }
        		else
        			last = curr;
        		n--;
        	}
        	n++;
            nodeMap.put(key, curr);
        }
        else {
        	get(key);
        	head.val = value;
        }
        // Node temp = head;
        // System.out.println("put");
        // while (temp != null){
        //     System.out.print(temp.key+" ");
        //     temp = temp.next;
        // }
        // System.out.println();
    }
}