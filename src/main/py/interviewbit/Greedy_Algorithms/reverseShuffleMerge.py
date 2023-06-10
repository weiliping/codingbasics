#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'reverseShuffleMerge' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#


def reverseShuffleMerge(s):
    # Write your code here
    cnts, inds, words = [], [[] for i in range(26)], [0] * 26
    n = len(s)
    for i in range(n):
        a = s[i]
        ind = ord(a) - ord('a')
        words[ind] += 1
        inds[ind].append(i)
        cnts.append(words.copy())
    pickWords, leftWords = [0] * 26, [0] * 26

    for i in range(26):
        pickWords[i] = (words[i] >> 1)
        leftWords[i] = words[i] - pickWords[i]
    i, h, maxInd = 0, (n >> 1), n
    res = ''
    while i < h:
        for j in range(26):
            if pickWords[j] == 0:
                continue
            indexes = inds[j]
            curInd = indexes[-1]
            haveCnts = cnts[curInd]
            avail = True
            for k in range(26):
                if haveCnts[k] < pickWords[k]:
                    avail = False
                    break
            if not avail:
                continue
            totalCnts = cnts[maxInd - 1]
            removCnts = [0] * 26
            for k in range(26):
                removCnts[k] = totalCnts[k] - haveCnts[k]
                if leftWords[k] < removCnts[k]:
                    avail = False
                    break
            if not avail:
                continue
            for k in range(26):
                if removCnts[k] == 0:
                    continue
                leftWords[k] -= removCnts[k]
                while len(inds[k]) > 0 and inds[k][-1] > curInd:
                    inds[k].pop(-1)
            maxInd = curInd
            pickWords[j] -= 1
            indexes.pop(-1)
            res += chr(ord('a') + j)
            break
        i += 1
    return res


# print(reverseShuffleMerge('eggegg'))
# print(reverseShuffleMerge('agagggccgg'))
# print(reverseShuffleMerge('agggagccgg'))
# print(reverseShuffleMerge('abcdefgabcdefg'))
# print(reverseShuffleMerge('aeiouuoiea'))

# print(reverseShuffleMerge('bdabaceadaedaaaeaecdeadababdbeaeeacacaba'))
# aaaaabccigicgjihidfiejfijgidgbhhehgfhjgiibggjddjjd
# print(reverseShuffleMerge(
    # 'djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida'))

s1 = 'aaaaaavvcembskuabxddlpbbsgiaskucosdlhndqzovpjlcyerauvrbcugnbluescevrnubgvtzrcwccfzrqgmfpbjnpdqybtsdvobhzsslojqsyfhoghrifhtclcoiputjhpklkrhsdyhlcuevikwyrqxpxhspxllimlowtghssqzivhrjtywweuvejxokgyrnqxzns'
s2 = reverseShuffleMerge(
    'sbcnzxqnrygkocahxjebvueaawwcythjdrhvizqsshgtwdolmillxpshxpxqrywkivceufclhydhshrklkphajbftuapiocjlcthfirhgaohfysqjolssbzhbovdstbyqdpnjbpfmgqrzfctcwcrztvgbegunarvecseoulabaonguckqbtrvuagreyclyjytpvozqdnhldlnsocenuzksawirgsbjobpldjdlrxbricrauuksbmecvvwagnnacaqghmjpzrlsvlpbbcuaddgvlhvuvkxexjcfhxrodmcwlrzyyiksuksshhonahsyzbbprwuitmoyoqurtqsaslevgvpfbzkkhgcnpjdpseuiylluvdetsqssbrxpiclxxvosuqipsqvvwsezhl')
print(s1 == s2)

# aaaaaaaaaccddeikusbccfseagluimqvagocfqqcikvcjvhnuezxdcoxffortjyzjmsjvivcxujlsnxcfztwtegpvqqtgkwgijyzkohzhqmfhapweqbqmtfnumdzgolmmsmpgmeoggrtsdcebcvxectzjqeezjplvunofppmnyzzbgheghgklphkqcsjmsjmqabwkoeehktblvgnsbiltyvfrktrpcdkgjwnuckcijpvixosgrssokcmgltbhedgodkhvhtmrnryosnxfdyhbvdtykhddkjvsrmxyfltlztuwpmrftjrgjjlowzrnztizdgtrbkelrjkpeoqpmiwqzzhgoxbkrkfggptbozuyrfehrezenttskjqjyurfkkrjyggnusejtjjonzmkxfjldyltdwrxfervfixqhpyolzvvfnnnmlvmwuyyxzlxrlvlnpvlexixqkwpfmgvvyldysetmyrxqduulqojlfzjolffpgwrfwf

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     s = input()

#     result = reverseShuffleMerge(s)

#     fptr.write(result + '\n')

#     fptr.close()
