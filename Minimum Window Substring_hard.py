class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n, start, end, cnt, ans, l = len(s), 0, 0, 0, '', 2 ** 31 - 1
        mps, mpt = Counter(), Counter(t),
        key_len = len(mpt.keys())

        while start < n and mpt[s[start]] == 0:
            start = start + 1
        while start < n:
            while start < n and cnt < key_len:
                key = s[start]
                if mpt[key] > 0:
                    mps[key] = mps[key] + 1
                    cnt = cnt + 1 if mps[key] == mpt[key] else cnt
                start = start + 1
            if start >= n and cnt < key_len:
                break
            while end < start:
                key = s[end]
                if mpt[key] > 0 and cnt < key_len:
                    break
                elif mpt[key] > 0:
                    aux = s[end:start]
                    ans = aux if len(aux) < l else ans
                    l = min(l, len(ans))
                    mps[key] = mps[key] - 1
                    cnt = cnt - 1 if mps[key] < mpt[key] else cnt
                end = end + 1
        return ans