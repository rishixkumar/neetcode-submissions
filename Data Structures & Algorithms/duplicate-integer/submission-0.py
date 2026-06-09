class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        d = Counter(nums)
        for i in nums:
            if d[i] > 1:
                return True
        return False