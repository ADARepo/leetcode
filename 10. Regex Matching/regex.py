def isMatch(s, p):

    if len(p) == 1 and len(s) == 1 and (p[0] == '*' or p[0] == '.'):
        return True
    if len(p) == 1 and len(s) == 1 and p[0] != s[0]:
        return False
    if len(p) == 1 and len(s) == 1 and s[0] == p[0]:
        return True

    sCount = 0
    pCount = 0

    while sCount < len(s) and pCount < len(p):
        if p[pCount] == s[sCount]:
            pCount += 1
            sCount += 1
        
        elif p[pCount] == '*':
            sCount += 1
            while (sCount < len(s)) and (s[sCount] != s[sCount - 1]):
                sCount += 1

            pCount += 1
        
        elif (p[pCount] == '.'):
            pCount += 1
            sCount += 1

        if pCount >= len(p) and sCount < len(s):
            return False
        pCount += 1
        
    return True


if __name__ == "__main__":
    # print(isMatch("aa", "a"))
    # print(isMatch("aa", "."))
    # print(isMatch("aa", "*"))
    # print(isMatch("a", "b"))
    print(isMatch("aab", "c*a*b*"))
    print(isMatch("mississippi", "mis*is*p*."))