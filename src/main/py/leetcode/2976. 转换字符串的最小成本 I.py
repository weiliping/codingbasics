from typing import List


class Solution:
    MAX_V = 10**10+1

    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        dict_ch = [[self.MAX_V for _ in range(26)] for _ in range(26)]
        base_v = ord("a")
        for i in range(len(original)):
            j, k = ord(original[i]) - base_v, ord(changed[i]) - base_v
            dict_ch[j][k] = min(dict_ch[j][k], cost[i])

        for i in range(26):
            visit = [False for _ in range(26)]
            visit[i] = True
            self.routeHelper(dict_ch, i, i, 0, visit)
        cVal = 0
        for i in range(len(source)):
            if source[i] == target[i]:
                continue
            j, k = ord(source[i]) - base_v, ord(target[i]) - base_v
            if self.MAX_V == dict_ch[j][k]:
                print(j, k, dict_ch[j][k])
                return -1
            cVal += dict_ch[j][k]
        return cVal

    def routeHelper(self, dict_ch: List[List[int]], p: int, c: int, v: int, visit: List[bool]):
        child_vals = dict_ch[c]
        for i in range(26):
            if visit[i] or child_vals[i] == self.MAX_V:
                continue
            if v >= dict_ch[p][i]:
                continue
            visit_child = visit.copy()
            visit_child[i] = True
            child_v = v + child_vals[i]
            if dict_ch[p][i] > child_v:
                dict_ch[p][i] = child_v
            self.routeHelper(dict_ch, p, i, child_v, visit_child)


s = Solution()
# source = "abcd"
# target = "acbe"
# original = ["a", "b", "c", "c", "e", "d"]
# changed = ["b", "c", "b", "e", "b", "e"]
# cost = [2, 5, 5, 1, 2, 20]
# print(s.minimumCost(source, target, original, changed, cost))

source1 = "bnwupvbvphasnbovsowaoynohubwbuyhpezvzpwnlaunoybomlnpaymbsaweznhspzuapzsmhyllamyousvwluyheyvpslyyzehphuuzlauwvnwmhnobaoupeoosehezovolppnmlbpnvyyyypvesennmybhsiylbhiplwyowibysvyimesbvzuholzolyosmsolnvsmlzlnissmhhppseiiebuenvmozuopzpniszvnssoslzaevhuinhouoilaovwvboezhizniyivnmsybelvbaulevpyzwpsizmuishzeaanwhappbnslblinmyyowvyauaoolhabaheobyihnlmyvmoohhoimuzlsnvolbmmavuvbvhnlewleeymospaynzvhnvmuyvuohavpwylbipohbbpmaiiloahyzioeiszlbsphvmomoveszlnzbonbnoeoehonuywnnswzhplneuuvwwsvmmiphvueynpmpnmsonlwam"
target1 = "yzzwuzeluvlzwuvhoamhanbhwouswwlvboipmhybevmmuiswsshabaeevbvuolwyvhyuwszyyasappbbywwouzwwmlzwppilbsmunnmaimuephbvohsezpwueolilpzuowvihzemhvnouobbhsylhahanubzezlulvpsyewavnyewpsylhezmyzommpnelevwhhzeuylsspwuwbmuiahbyyuoyynevluvwsilaaissepaoaalbwobzypmnzuzvubwahmlaesipsvwnaiollymhnenpehwhweoesvywbbiozasmhzmihebobbywzilbzewhhselalzvpouumwmmmbasmaliiipzmhumzoyzyvphbemzoioplbenyivhuybnwlzvuhebpysoivonevavpsohwwshoimwphpobszhysplzvmvuioumewsvhauolppwpappnyuwbwphylvpollliyubnawmnbayozhmpuspzwebaylwshaez"
original1 = ["b", "w", "u", "p", "v", "b", "v", "h", "a", "n", "b", "v", "s", "o", "w", "a", "y", "o", "h", "u", "b", "p", "z", "v", "z", "w", "n", "l", "n", "y", "b", "p", "a", "m", "s", "w", "z", "n", "s", "z", "u", "a", "s", "l", "a", "m", "y", "o", "s", "l", "u", "e", "y", "l", "z", "e", "h", "u", "u", "z", "l", "w", "n", "w", "m", "o", "a", "o", "o", "s", "e", "e", "z", "v", "p", "p", "n", "l", "b", "n", "y", "p", "v", "s", "n", "m", "y", "h", "i", "l", "i",
             "y", "i", "m", "e", "s", "v", "z", "h", "o", "o", "l", "v", "z", "i", "s", "h", "h", "e", "e", "e", "o", "z", "p", "z", "v", "n", "s", "a", "v", "i", "o", "i", "o", "v", "w", "b", "n", "i", "v", "s", "b", "l", "u", "e", "p", "z", "u", "p", "b", "y", "y", "a", "u", "a", "i", "n", "l", "n", "u", "v", "b", "h", "w", "l", "e", "m", "p", "y", "n", "m", "h", "a", "p", "w", "l", "i", "b", "p", "m", "i", "a", "i", "e", "s", "h", "e", "u", "w", "m", "y", "n", "m", "w", "m"]
changed1 = ["y", "z", "w", "u", "z", "e", "l", "v", "l", "w", "u", "h", "o", "a", "m", "h", "n", "h", "w", "o", "w", "b", "i", "p", "m", "y", "b", "e", "m", "i", "s", "a", "b", "e", "v", "v", "o", "l", "y", "h", "y", "u", "z", "s", "p", "p", "b", "b", "w", "u", "z", "m", "l", "p", "b", "s", "m", "n", "m", "a", "i", "e", "h", "b", "v", "s", "z", "p", "l", "i", "l", "z", "u", "w", "h", "z", "e", "h", "v", "o", "o", "s", "y", "h", "a", "n", "u", "z", "z", "y", "n",
            "e", "y", "l", "h", "e", "m", "y", "o", "m", "n", "z", "u", "s", "u", "b", "u", "i", "y", "o", "n", "u", "v", "i", "l", "e", "p", "a", "w", "b", "p", "z", "v", "w", "a", "h", "l", "v", "a", "i", "l", "m", "n", "e", "w", "w", "w", "b", "e", "o", "z", "s", "e", "l", "o", "b", "s", "m", "y", "i", "o", "p", "b", "i", "v", "u", "b", "l", "v", "u", "s", "e", "v", "v", "p", "o", "w", "i", "m", "w", "h", "s", "s", "a", "u", "l", "b", "a", "n", "o", "p", "z", "y", "a", "z"]
cost1 = [941165, 653151, 702653, 837663, 470593, 351001, 290461, 620098, 924032, 918283, 970500, 821170, 713882, 870459, 908010, 939906, 659889, 923776, 819189, 901511, 747697, 771190, 772606, 859388, 438602, 811916, 757711, 882461, 870256, 920067, 619174, 913109, 556890, 772061, 549201, 973368, 522690, 963727, 298981, 964554, 207526, 992946, 552655, 970452, 752709, 613696, 799656, 593165, 972163, 947119, 503090, 488012, 884897, 707682, 744201, 868274, 46575, 568277, 891925, 217139, 660055, 827137, 514821, 884275, 809585, 541814, 534253, 979413, 711589, 766694, 944545, 839933, 539363, 923470, 855401, 683827, 993437, 997139, 985689, 446256, 919681, 936063, 258062, 935731, 711580, 587856, 950124, 839267, 759378, 276802, 518845, 851884,
         953359, 757474, 890603, 513293, 852052, 519052, 481227, 891066, 745366, 999212, 990324, 871771, 998893, 656559, 973850, 986660, 996201, 656064, 912790, 852648, 885126, 758133, 873115, 701806, 326189, 934586, 976453, 523996, 793185, 998365, 671659, 938968, 766126, 799703, 921107, 869591, 970971, 862808, 660016, 973563, 930624, 993649, 255694, 976842, 823173, 997811, 952572, 944087, 998099, 704181, 946775, 745312, 837192, 690918, 884260, 949263, 999016, 891068, 471921, 955221, 434918, 648630, 980326, 993795, 961976, 199828, 899650, 635784, 994748, 904416, 563192, 439115, 606438, 839118, 593481, 950189, 999664, 585168, 937809, 706240, 325831, 999190, 960189, 926220, 864715, 878144, 916809, 587180, 971135, 987917, 751245, 626422, 615495]
print(s.minimumCost(source1, target1, original1, changed1, cost1))
