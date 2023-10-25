class DoublyLinkedList:
    def __init__(self, left=None, right=None, key=-1, value=-1):
        self.left = left
        self.right = right
        self.key = key
        self.value = value

class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cnt = 0
        self.mapKeyToNode = {}
        self.LRUno = 0
        self.mapCntToDL = {}
        self.mapKeyToCnt = {}        

    def createDL(self):
        head, tail = DoublyLinkedList(), DoublyLinkedList()
        head.right, tail.left = tail, head
        return head, tail

    def pop(self, DL, node):
        head, tail = DL
        pre, post = node.left, node.right
        pre.right, post.left = post, pre

    def popFromLRU(self, LRU):
        head, tail = LRU
        popNode = tail.left
        pre = popNode.left
        pre.right, tail.left = tail, pre
        del self.mapKeyToNode[popNode.key]
        del self.mapKeyToCnt[popNode.key]

    def addOnHead(self, DL, node):
        head, tail = DL
        post = head.right
        head.right, post.left = node, node
        node.left, node.right = head, post

    def get(self, key: int) -> int:
        node = self.mapKeyToNode[key] if key in self.mapKeyToNode else None
        if node:
            cnt = self.mapKeyToCnt[key]
            tempDL = self.mapCntToDL[cnt]
            self.pop(tempDL, node)
            currDL = self.mapCntToDL[cnt+1] if cnt+1 in self.mapCntToDL else self.createDL()
            self.addOnHead(currDL, node)
            self.mapKeyToCnt[key] = cnt+1
            self.mapCntToDL[cnt+1] = currDL
            LRU = self.mapCntToDL[self.LRUno]
            if LRU[0].right == LRU[-1]:
                self.LRUno = cnt+1
            return node.value
        return -1        

    def put(self, key: int, value: int) -> None:
        node = self.mapKeyToNode[key] if key in self.mapKeyToNode else None
        if node:
            node.value = value
            self.get(key)
        else:
            node = DoublyLinkedList(None, None, key, value)
            if self.cnt == self.capacity:
                LRU = self.mapCntToDL[self.LRUno]
                self.popFromLRU(self.mapCntToDL[self.LRUno])
                self.cnt -= 1
            DL = self.mapCntToDL[1] if 1 in self.mapCntToDL else self.createDL()
            self.addOnHead(DL, node)
            self.LRUno = 1
            self.mapKeyToNode[key] = node
            self.mapKeyToCnt[key] = 1
            self.mapCntToDL[1] = DL
            self.cnt += 1     


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)