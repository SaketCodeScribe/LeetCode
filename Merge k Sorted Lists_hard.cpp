// 1. Divide and Conquer solution

// Time Complexity: O(n * k * log(k))

class Solution {
public:
    ListNode* merge(ListNode* a, ListNode* b){
        int mi, posmin;
        if (!a)
            return b;
        if (!b)
            return a;
        
        vector<ListNode*> arr(2, NULL);
        ListNode *ans, *head;
        
        ans = head = NULL;
        arr[0] = a;
        arr[1] = b;
        while(true){
            mi = INT_MAX;
            posmin = -1;
            if (arr[0]){
                if (mi > arr[0]->val){
                    mi = arr[0]->val;
                    posmin = 0;
                }
            }
            if (arr[1]){
                if (mi > arr[1]->val){
                    mi = arr[1]->val;
                    posmin = 1;
                }
            }
            if (posmin != -1){
                if (head){
                    head->next = new ListNode(mi);
                    head = head->next;
                }
                else{
                    head = new ListNode(mi);
                    ans = head;
                }
                arr[posmin] = arr[posmin]->next;
            }
            else
                break;
        }
        
      return ans;  
    }
    
    ListNode* DivandConq(vector<ListNode*>& lists, int low, int high){
        int mid;
        ListNode *a, *b;
        
        if (low > high)
            return NULL;
        if(low == high)
            return lists[low];
        
        a = b = NULL;
        mid = low + (high - low) / 2;
        a = DivandConq(lists,low,mid);
        b = DivandConq(lists,mid + 1,high);
        
        return merge(a,b);
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        return DivandConq(lists,0,lists.size()-1);
    }
};



// 2. Two pointer solution

// Time Complexity: O(n * k)

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int i, n = lists.size(), mi, posmin;
        vector<ListNode*> arr={};
        ListNode *ans, *head;
        
        ans = head = NULL;
        for(i = 0; i < n; i++)
            arr.push_back(lists[i]);
        while(true){
            mi = INT_MAX;
            posmin = -1;
            for(i = 0; i < n; i++){
                if (arr[i]){
                    if (mi > arr[i]->val){
                        mi = arr[i]->val;
                        posmin = i;
                    }
                }
            }
            if (posmin != -1){
                if (head){
                    head->next = new ListNode(mi);
                    head = head->next;
                }
                else{
                    head = new ListNode(mi);
                    ans = head;
                }
                arr[posmin] = arr[posmin]->next;
            }
            else
                break;
        }
        
      return ans;  
    }
};