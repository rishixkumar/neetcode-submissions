class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2

        if len(B) < len(A):
            A, B = B, A

        l, r = 0, len(A) - 1
        while True:
            i = (l + r) // 2
            j = half - i - 2

            aLeft = A[i] if i >= 0 else float("-infinity")
            bLeft = B[j] if j >= 0 else float("-infinity")
            aRight = A[i + 1] if (i + 1) < len(A) else float("infinity")
            bRight = B[j + 1] if (j + 1) < len(B) else float("infinity")

            if aLeft <= bRight and bLeft <= aRight:
                if total % 2:
                    return min(aRight, bRight)
                return (max(aLeft, bLeft) + min(aRight, bRight)) / 2
            elif aLeft > bRight:
                r = i - 1
            else:
                l = i + 1


