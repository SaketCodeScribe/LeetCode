class Node {
	char val;
	Node next, prev ;
	
	public Node(char val){
		this.val = val;
	}

    public String toString(){
        return ""+this.val;
    }
}
class TextEditor {

	Node head, cursor, next, prev, last;
    public TextEditor() {        
    }
    
    public void addText(String text) {
        if (head == null) {
        	Node temp = head;
        	for(var ch:text.toCharArray()) {
        		if (head == null) {
        			head = new Node(ch);
        			temp = head;
        		}
        		else {
        			temp.next = new Node(ch);
        			temp.next.prev = temp;
        		    temp = temp.next;
        		}
        		cursor = last = temp;
        	}
        }
        else {
        	Node temp = cursor;
        	next = cursor != null ? cursor.next : head;
        	for(var ch:text.toCharArray()) {
        		if (temp == null) {
        			head = new Node(ch);
        			temp = head;
        		}
        		else {
	        		temp.next = new Node(ch);
	        		temp.next.prev =  temp;
        		  temp = temp.next;
        		}
        		cursor = temp;
        	}
        	if (next != null) {
        		temp.next = next;
        		next.prev = temp;
        	}
        }
			// print("A", head);
    }
    
    public int deleteText(int k) {
    	int cnt = 0;
			Node temp;
    	next = cursor != null ? cursor.next : head;
        if (next != null)
            next.prev = null;
        while (cursor != null && k-- > 0) {
            temp = cursor;
        	cursor = temp.prev;
            temp.prev = null;
            if (cursor != null)
                cursor.next = null;
        	cnt++;
        }
        if (cursor != null){
        	cursor.next = next;
					if (next != null)
						next.prev = cursor;
				}
        else
        	head = next;
        // print("D", head);
        return cnt;
    }
    
    public String cursorLeft(int k) {
    	int i = 0;
    	StringBuilder str = new StringBuilder();
    	while (cursor != null && k > 0) {
        	cursor = cursor.prev;
        	k--;
    	}
    	Node temp = cursor;
    	while (temp != null && i++<10) {
    		str.append(temp.val); 
    		temp = temp.prev;
    	}
			// print("cL", cursor);
    	return str.reverse().toString();
    }
    
    public String cursorRight(int k) {
    	int i = 0;
    	StringBuilder str = new StringBuilder();
      if (cursor == null)
				k--;
			cursor = cursor == null ? head : cursor;
			
    	while (cursor != null && cursor.next != null && k-- > 0) {
        	cursor = cursor.next;
    	}
    	Node temp = cursor;
			// print("cR", cursor);
    	while (temp != null && i++<10) {
    		str.append(temp.val); 
    		temp = temp.prev;
    	}
    	return str.reverse().toString();
    }
    public void print(String str, Node temp){
        System.out.print(str+"---->");
        while (temp!= null){
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();
    }
}