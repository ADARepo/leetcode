def convert (s, numRows):
    if (len(s) < 3):
        return s
    Dictionary = {}
    counter = 0
    j = 0
    reverse = False

    for i in range(numRows):
        Dictionary[i] = []

    while (j < len(s)):
        if (counter % numRows) == numRows - 1:
            reverse = True
        elif counter == 0:
            reverse = False
        
        if reverse:
            Dictionary[counter].append(s[j])
            counter -= 1
        else:
            Dictionary[counter].append(s[j])
            counter += 1

        j += 1
        


    finalList = []
    for i in range(numRows):
        finalList += Dictionary[i]

    return "".join(finalList)

if __name__ == "__main__":
    print(convert("AB", 1))