def convert (s, numRows):
    Dictionary = {}

    for i in range(numRows):
        Dictionary[i] = []

    for i in range(len(s)):
        arr = i % (numRows)
        Dictionary[arr].append(s[i])
    finalList = []
    for i in range(numRows):
        finalList += Dictionary[i]

    return "".join(finalList)

if __name__ == "__main__":
    print(convert("PAYPALISHIRING", 3))