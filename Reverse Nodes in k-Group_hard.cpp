class Solution {
public:
    int length(ListNode* head){
        int len = 0;
        while (head){
            len++;
            head = head -> next;
        }
        
        return len;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (!head)
            return head;
        
        int len, n, i;
        ListNode* ans = NULL, *prev = NULL, * curr = head, *next = NULL, *node_1 = NULL;
        
        len = length(head);
        
        if (len == 1)
            return head;
        
        n = len / k;
        while(n--){
            prev = NULL;
            i = 0;
            while (i < k && curr){
                next = curr -> next;
                curr -> next = prev;
                prev = curr;
                curr = next;
                i++;
            }
            
            if (ans && node_1)
                node_1 -> next = prev;
            node_1 = head;
            head = curr;
            if (!ans)
                ans= prev;
        }
        if(curr)
            node_1 -> next = curr;
        
        return ans;
    }
};