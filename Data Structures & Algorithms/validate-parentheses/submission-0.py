class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        closedOpen = { ")" : "(" , "]" : "[" , "}" : "{"}

        for c in s:
            if c in closedOpen:
                if stack and stack[-1] == closedOpen[c]:
                    stack.pop()
                else: 
                    return False
            else:
                stack.append(c)

        return True if not stack else False