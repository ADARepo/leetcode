def isMatch(s, p):
    if len(p) == 1 and len(s) == 1:
        if s[0] != p[0] and p[0] != '.':
            return False
        else:
            return True
    elif len(p) == 1 and len(s) > 1:
        return False

    if len(p) == 2 and p[1] == '*':
        if p[0] == '.':
            return True
        else:
            sCount = 0
            while sCount < len(s):
                if s[sCount] != p[0]:
                    return False
                sCount += 1
            return True
    
    pCount = 0
    sCount = 0

    while pCount < len(p) and sCount < len(s):

        # pCountLessThanLength = True
        # if (pCount + 1) >= len(p):
        #     pCountLessThanLength = False

        # A case where we only match letter to letter since its a period.
        if ((pCount + 1) < len(p)) and p[pCount + 1] != '*':
            if p[pCount] != s[sCount] and p[pCount] != '.':
                return False
            sCount += 1
            pCount += 1
        
        elif pCount == (len(p) - 1):
            if p[pCount] != '.' and s[sCount] != p[pCount]:
                return False
            sCount += 1
            pCount += 1
            if sCount < len(s):
                return False
        
        # letter followed by * and can be 0 or more of that char.
        elif p[pCount] != '.':
            while sCount < len(s) and s[sCount] == p[pCount]:
                sCount += 1
            pCount += 2
        
        # period followed by * and can be any combination of chars until the char after ".*".
        else:
            # Since ".*" can be any combination of characters of any length, 
            # check to see if there is supposed to be a single character match at some point after
            pCount += 2
            
            # Check for just a character left in regex. This should increment the pCount by two until
            # finding a lone character without an asterisk next to it (or end of string, in which case any matches are fine)
            # If we increment past len(p), return True.
            # If we land on a char are next char is in bounds and not an asterisk, 
            # Check the char in p against the chars in s. if it isn't in there, return false.
            # If it is in there, increment once more as well as increment p to continue.
            # Final check outside of main while loop: if sCount is still less than len(s): return false
            while (pCount < len(p) and pCount != (len(p) - 1)):
                # Found a period with no asterisk after, only increment by 1.
                if (pCount + 1 < len(p)) and p[pCount] == '.' and p[pCount + 1] != '*':
                    pCount += 1
                # Found a single letter with no asterisk after. either len(p) - 1 or not followed by '*'.
                elif (pCount + 1 < len(p)) and p[pCount + 1] != '*':
                    break
                # All other cases, increment by 2.
                else:
                    pCount += 2
            
            # If we left bounds of p, no match to worry about after ".*" in the regex.
            if pCount >= len(p):
                return True
            
            # We didn't leave bounds of p, so we have a char without an asterisk after.
            while sCount < len(s) and s[sCount] != p[pCount]:
                sCount += 1
            
            # If at end of s, return False since the char we need isn't in the string.
            if sCount >= len(s):
                return False

            # Should be at the letter that matches, increment for next check.
            else:
                sCount += 1
                pCount += 1

    # Check if sCount iterated through s entirely and also that if we iterate through the rest of p, there isn't a single char to check against.
    if sCount < len(s):
        return False
    while (pCount) < len(p):
        # If a letter or period without an asterisk, we left the main loop while still having chars to check.
        # If we reach a character without an asterisk after, return false since we didn't have a char in s to check.
        if pCount + 1 < len(p) and p[pCount + 1] =='*':
            pCount += 2
        elif pCount == len(p) - 1 and p[pCount] == s[len(s) - 1] and p[pCount - 1] == '*' and ((pCount - 1) % 2 != 0):
            return True
        else:
            return False

    return True
    
    


if __name__ == "__main__":
    print("1 " + str(isMatch("aa", "a")) + " should be False") # False
    print("2 " + str(isMatch("aa", ".")) + " should be False") # False
    print("3 " + str(isMatch("ab", ".*")) + " should be True") # True
    print("4 " + str(isMatch("a", "b")) + " should be False") # False
    print("5 " + str(isMatch("aab", "c*a*b*")) + " should be True") # True
    print("6 " + str(isMatch("mississippi", "mis*is*p*.")) + " should be False") # False
    print("7 " + str(isMatch("ab", ".*c")) + " should be False") # False
    print("8 " + str(isMatch("aaa", "aaaa")) + " should be False") # False
    print("9 " + str(isMatch("aaa", "ab*a")) + " should be False") # False
    print("10 " + str(isMatch("abcd", "d*")) + " should be False") # False
    print("11 " + str(isMatch("a", "ab*")) + " should be True") # True
    print("12 " + str(isMatch("a", "ab*a")) + " should be False") # False
    print("12 " + str(isMatch("bbbba", ".*a*a")) + " should be True") # True
    print("13 " + str(isMatch("aaa", "a.a")) + " should be True") # True
    print("13 " + str(isMatch("aaa", "a*a")) + " should be True") # True
    print("13 " + str(isMatch("a", "ab*a")) + " should be false") # True