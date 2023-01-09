import math


def reverse(x):
    if x < 10 and x > -10:
        return x
    
    ret = 0
    if x > (math.pow(2, 31)) or x < (-1 * (math.pow(2, 31))):
        return ret

    isNeg = False
    
    if (x < -9):
        isNeg = True
        x = -1 * x
    
    currPow = 1
    rem = 0
    
    while x != 0:
        rem = x % 10

        ret = (ret * 10) + rem

        # if rem == 0 and currPow == 1:
        #     continue

        x = int((x - rem) / 10)

    if ret > (math.pow(2, 31)) or ret < (-1 * (math.pow(2, 31))):
        return 0
    
    if isNeg:
        return -1 * ret
        
    return ret

if __name__ == "__main__":
    print(reverse(123))
    print(reverse(-123))
    print(reverse(120))
    print(reverse(1))
    print(reverse(0))
    print(reverse(-10))
    print(reverse(309678))
    print(reverse(73248912313212312321))
    print(reverse(9000))
    print(reverse(1534236469))