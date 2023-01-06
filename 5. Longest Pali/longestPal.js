var longestPalindrome = function(s) 
{
    if (s.length < 2) return s

    
    var retString = s.charAt(0)
    var max = 1
    var counter = 1
    var l = 0
    var r = s.length - counter
    var maxStart
    var maxEnd
    var origL
    var origR
    var pali = false

    while (l < r)
    {
        // Match, continue checking for match
        if (s.charAt(l) == s.charAt(r))
        {
            origL = l
            origR = r
            while ((s.charAt(l) == s.charAt(r)) && (r - l) > 2)
            {
                l++
                r--
            }

            if ((r - l) < 3 && (s.charAt(l) == s.charAt(r))) pali = true

            if (pali && (origR - origL + 1) > max)
            {
                max = (origR - origL + 1)
                maxStart = origL
                maxEnd = origR
            }

            pali = false
            
            // Needed to reset the comparisons to next cycle so we dont redundantly check inside the string more.
            l = origL + 1
            r = origR
        }

        l++
        
        if (l >= (r))
        {
            l = 0
            r = s.length - 1 - counter
            counter++
        }
    }

    return (max == 1) ? retString: s.substring(maxStart, maxEnd + 1);
};

console.log(longestPalindrome("aacabdkacaa")) // aca
console.log(longestPalindrome("cbbd")) // bb
console.log(longestPalindrome("babad")) // bab or aba
console.log(longestPalindrome("abbcccbbbcaaccbababcbcabca")) // bbcccbb or cbababc
console.log(longestPalindrome("ccd")) // cc
console.log(longestPalindrome("aaaabaaa")) // aaabaaa
