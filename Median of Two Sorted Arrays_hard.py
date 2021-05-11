class Solution:
    def findkth(self, a: List[int], b: List[int], target) -> int:
        # print("a: {}, b:{}".format(a, b))
        n, m = len(a), len(b)
        if n <= 0:
            return b[target - 1]
        if m <= 0:
            return a[target - 1]
        med_a, med_b = n // 2 + 1, m // 2 + 1
        ma, mb = a[n // 2], b[m // 2]

        if med_a + med_b > target:
            if ma > mb:
                return self.findkth(a[:med_a - 1], b, target)
            else:
                return self.findkth(a, b[:med_b - 1], target)
        else:
            if ma > mb:
                return self.findkth(a, b[med_b:], target - med_b)
            else:
                return self.findkth(a[med_a:], b, target - med_a)

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n, m = len(nums1), len(nums2)
        if n == 0:
            if m % 2 == 0:
                return (nums2[m // 2 - 1] + nums2[m // 2]) / 2
            else:
                return nums2[m // 2]
        if m == 0:
            if n % 2 == 0:
                return (nums1[n // 2 - 1] + nums1[n // 2]) / 2
            else:
                return nums1[n // 2]
        if (m + n) % 2 == 0:
            return (self.findkth(nums1, nums2, (m + n) // 2) + self.findkth(nums1, nums2, (m + n) // 2 + 1)) / 2
        return self.findkth(nums1, nums2, (m + n) // 2 + 1)