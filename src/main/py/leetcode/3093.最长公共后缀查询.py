#
# @lc app=leetcode.cn id=3093 lang=python3
#
# [3093] 最长公共后缀查询
#
from typing import List
# @lc code=start
class Trie:
    child = [None] * 26
    inds = []
    def __init__(self, l: int, i: int) -> None:
        self.inds.append([l, i])
    
class Solution:
    CH_INT = ord('a')
    def buildTrie(self, words: str, root: Trie, i: int, chInd: int):
            if chInd == -1:
                return
            ind = ord(words[chInd]) - self.CH_INT
            if not root.child[ind]:
                root.child[ind] = Trie(len(words), i)
            root.child[ind].inds.append([len(words), i])
            self.buildTrie(words, root.child[ind], i, chInd - 1)
    def queryTrie(self, word: str, root: Trie, chInd: int):
        if chInd < 0:
            return -1
        c = ord(word[chInd]) - self.CH_INT
        if root.child[c] and chInd > 0:
            self.queryTrie(word, root.child[c], chInd - 1)
        else:
            if len(root.inds) == 1:
                return root.inds[0][1]
            else:
                root.inds.sort(key=lambda x:(-x[0], x[1]))
                return root.inds[0][1]
                
    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        n = len(wordsContainer)
        l, ind = len(wordsContainer[0]), 0
        for i in range(1, n):
            if l < len(wordsContainer[i]):
                l = len(wordsContainer[i])
                ind = i
        root = Trie(l, ind)
        for i, words in enumerate(wordsContainer):
            self.buildTrie(words, root, i, len(words) - 1)
        
        res = []
        for query in wordsQuery:
            res.append(self.queryTrie(query, root, len(query) - 1))
        return res
    
s = Solution()
wordsContainer = ["abcd","bcd","xbcd"]
wordsQuery = ["xyz"]
print(s.stringIndices(wordsContainer, wordsQuery))