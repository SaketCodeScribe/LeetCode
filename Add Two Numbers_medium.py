# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def Length(self, l1: ListNode) -> int:
        length = 0
        while l1:
            length += 1
            l1 = l1.next
        return length

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        len1 = self.Length(l1)
        len2 = self.Length(l2)
        h1 = l1
        h2 = l2

        if len2 > len1:
            h1 = l2
            h2 = l1

        ans = h1
        carry = 0
        while h1:
            if h2:
                val = h1.val + h2.val + carry
                h1.val = val % 10
                carry = val // 10
                if h1.next == None and carry:
                    h1.next = ListNode(0)
                h1 = h1.next
                h2 = h2.next
            elif h1:
                val = h1.val + carry
                h1.val = val % 10
                carry = val // 10
                if h1.next == None and carry:
                    h1.next = ListNode(0)
                h1 = h1.next

        return ans