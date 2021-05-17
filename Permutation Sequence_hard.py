class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        ans = ['.'] * n
        fact = [1] * (n + 1)
        ind, elt = 0, 1
        arr = [str(i + 1) for i in range(n)]

        for i in range(1, n + 1):
            fact[i] = i * fact[i - 1]
        k, n = k - 1, n - 1
        while k >= 0 and n >= 0:
            q = k // fact[n]
            ans[ind] = arr[q]
            arr.pop(q)
            k, n, ind = k - q * fact[n], n - 1, ind + 1
        return "".join(ans)