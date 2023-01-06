const getDrome = (left, right, s) =>
{
    while (left >= 0 && right < s.length)
    {
        if (s[left] != s[right]) break;
        left--;
        right++;
    }
    return [left + 1, right];
}

var longestPalindrome = function(s) {
    let max = [0, 1];

    for (let i = 0; i < s.length; i++)
    {
        let odd = getDrome(i - 1, i + 1, s);
        let even = getDrome(i, i + 1, s);
        let currMax = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
        max = (currMax[1] - currMax[0] > max[1] - max[0]) ? currMax: max;
    }

    return s.slice(max[0], max[1]);
};

// var longestPalindrome = function(s) 
// {
//     if (s.length < 2) return s

    
//     var retString = s.charAt(0)
//     var max = 1
//     var counter = 1
//     var l = 0
//     var r = s.length - counter
//     var maxStart
//     var maxEnd
//     var origL
//     var origR
//     var pali = false

//     while (l < r)
//     {
//         // Match, continue checking for match
//         if (s.charAt(l) == s.charAt(r))
//         {
//             origL = l
//             origR = r
//             while ((s.charAt(l) == s.charAt(r)) && (r - l) > 2)
//             {
//                 l++
//                 r--
//             }

//             if ((r - l) < 3 && (s.charAt(l) == s.charAt(r))) pali = true

//             if (pali && (origR - origL + 1) > max)
//             {
//                 max = (origR - origL + 1)
//                 maxStart = origL
//                 maxEnd = origR
//             }

//             pali = false
            
//             // Needed to reset the comparisons to next cycle so we dont redundantly check inside the string more.
//             l = origL + 1
//             r = origR
//         }

//         l++
        
//         if (l >= (r))
//         {
//             l = 0
//             r = s.length - 1 - counter
//             counter++
//         }
//     }

//     return (max == 1) ? retString: s.substring(maxStart, maxEnd + 1);
// };

// console.log(longestPalindrome("aacabdkacaa")) // aca
console.log(longestPalindrome("cbbd")) // bb
// console.log(longestPalindrome("babad")) // bab or aba
// console.log(longestPalindrome("abbcccbbbcaaccbababcbcabca")) // bbcccbb or cbababc
// console.log(longestPalindrome("ccd")) // cc
// console.log(longestPalindrome("aaaabaaa")) // aaabaaa
