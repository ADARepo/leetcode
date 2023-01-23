# https://www.youtube.com/watch?v=HAA8mgxlov8
class Solution:

    def __init__(self):
        return None

    def isMatch(self, s: str, p: str):
    
        cache = {}

        def recursiveDepth(i, j):

            if (i, j) in cache:
                return cache[(i, j)]

            if i >= len(s) and j >= len(p):
                return True
            if j >= len(p):
                return False

            match = i < len(s) and (s[i] == p[j] or p[j] == '.')
            if (j + 1) < len(p) and (p[j + 1] == '*'):
                # Skip the two chars since the char isn't in s OR keep checking since char matches regex in p.
                cache[(i, j)] = (recursiveDepth(i, j + 2) or (match and recursiveDepth(i + 1, j)))

                return cache[(i, j)]
            if match:
                cache [(i, j)] = recursiveDepth(i + 1, j + 1)
                return cache [(i, j)]
            cache[(i, j)] = False
            
            return False
        
        return recursiveDepth(0, 0)


    

     

if __name__ == "__main__":
    st = Solution()
    print("1 " + str(st.isMatch("aa", "a")) + " False") # False
    print("2 " + str(st.isMatch("aa", ".")) + " False") # False
    print("3 " + str(st.isMatch("ab", ".*")) + " True") # True
    print("4 " + str(st.isMatch("a", "b")) + " False") # False
    print("5 " + str(st.isMatch("aab", "c*a*b*")) + " True") # True
    print("6 " + str(st.isMatch("mississippi", "mis*is*p*.")) + " False") # False
    print("7 " + str(st.isMatch("ab", ".*c")) + " False") # False
    print("8 " + str(st.isMatch("aaa", "aaaa")) + " False") # False
    print("9 " + str(st.isMatch("aaa", "ab*a")) + " False") # False
    print("10 " + str(st.isMatch("abcd", "d*")) + " False") # False
    print("11 " + str(st.isMatch("a", "ab*")) + " True") # True
    print("12 " + str(st.isMatch("a", "ab*a")) + " False") # False
    print("12 " + str(st.isMatch("bbbba", ".*a*a")) + " True") # True
    print("13 " + str(st.isMatch("aaa", "a.a")) + " True") # True
    print("14 " + str(st.isMatch("aaa", "a*a")) + " True") # True
    print("15 " + str(st.isMatch("a", "ab*a")) + " false") # True