package com.algorithm.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Permutations {

    public static List<Integer> perm(String s, String[] words) {
        List<String[]> res = null;
        for (int j = words.length - 1; j >= 0; j--) {
            String word = words[j];
            if (res == null) {
                res = Collections.singletonList(new String[] { word });
                continue;
            }
            List<String[]> previousRes = res;
            res = new ArrayList<>();
            for (String[] preRes : previousRes) {
                for (int i = 0; i < preRes.length + 1; i++) {
                    res.add(insertX(preRes.length, preRes, word, i + 1));
                }
            }
        }

        if (res != null) {
            Set<String> sets = new HashSet<>();
            for (String[] strs : res) {
                sets.add(String.join("", strs));
            }

            List<Integer> ints = new ArrayList<>();
            String lowerCaseTextString = s.toLowerCase();
            for (String str : sets) {
                List<Integer> indexes = new ArrayList<>();
                String lowerCaseWord = str.toLowerCase();
                int wordLength = 0;
                int index = 0;
                while (index != -1) {
                    index = lowerCaseTextString.indexOf(lowerCaseWord, index);
                    if (index != -1) {
                        indexes.add(index);
                        index++;
                    }
                    if (wordLength == 0) {
                        wordLength = str.length();
                    }
                }
                ints.addAll(indexes);
            }
            Collections.sort(ints);
            return ints;
        }
        return Arrays.asList(new Integer[0]);
    }

    public static List<String[]> permutations(String[] words) {
        if (words.length == 1) {
            return Collections.singletonList(new String[] { words[0] });
        }
        List<String[]> res = new ArrayList<>();
        List<String[]> sunRes = permutations(Arrays.copyOfRange(words, 1, words.length));
        String[] appendStr = new String[] { words[0] };
        for (String[] strs : sunRes) {
            res.add(mergeArray(appendStr, strs));
            for (int i = 0; i < strs.length; i++) {
                String[] pre = mergeArray(Arrays.copyOfRange(strs, 0, i + 1), appendStr);
                res.add(mergeArray(pre, Arrays.copyOfRange(strs, i + 1, strs.length)));
            }
        }
        return res;
    }

    //    public static <T> void printAllRecursive(int n, T[] elements, char delimiter) {
    //        if(n == 1) {
    //            printArray(elements, delimiter);
    //        } else {
    //            for(int i = 0; i < n-1; i++) {
    //                printAllRecursive(n - 1, elements, delimiter);
    //                if(n % 2 == 0) {
    //                    swap(elements, i, n-1);
    //                } else {
    //                    swap(elements, 0, n-1);
    //                }
    //            }
    //            printAllRecursive(n - 1, elements, delimiter);
    //        }
    //    }

    //    private static void swap(T[] input, int a, int b) {
    //        T tmp = input[a];
    //        input[a] = input[b];
    //        input[b] = tmp;
    //    }
    //
    //    private static void printArray(T[] input) {
    //        System.out.printout('\n');
    //        for(int i = 0; i < input.length; i++) {
    //            System.out.printout(input[i]);
    //        }
    //    }

    //    public static List<String[]> insertToArrays()
    public static void permutations(List<String> items, Stack<String> permutation, int size) {
        /* permutation stack has become equal to size that we require */
        if (permutation.size() == size) {
            /* printout the permutation */
            System.out.println(String.join("", permutation));
            //            res.add(StringUtils.join(permutation, ""));
        }

        /* items available for permutation */
        for (int i = 0; i < items.size(); i++) {
            /* add current item */
            permutation.push(items.get(i));
            /* remove item from available item set */
            items.remove(i);

            /* pass it on for next permutation */
            permutations(items, permutation, size);
            /* pop and put the removed item back */
            items.add(permutation.pop());
        }
    }

    public static String[] mergeArray(String[] arr1, String[] arr2) {
        int fal = arr1.length;        //determines length of firstArray
        int sal = arr2.length;   //determines length of secondArray
        String[] result = new String[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(arr1, 0, result, 0, fal);
        System.arraycopy(arr2, 0, result, fal, sal);
        return result;
    }

    public static List<String> transArray(String[] strs) {
        List<String> arr = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return arr;
        }
        for (String str : strs) {
            arr.add(str);
        }
        return arr;
    }

    public static Set<String> getUniqueWords(List<String[]> strings) {
        Set<String> sets = new HashSet<>();
        for (String[] strs : strings) {
            sets.add(String.join("", strs));
        }
        return sets;
    }

    public static List<Integer> findWordIndexes(String textString, String word) {
        List<Integer> indexes = new ArrayList<>();
        String lowerCaseTextString = textString.toLowerCase();
        String lowerCaseWord = word.toLowerCase();
        //        int wordLength = 0;

        int index = 0;
        while (index != -1) {
            //            index = lowerCaseTextString.indexOf(lowerCaseWord, index + wordLength);
            index = lowerCaseTextString.indexOf(lowerCaseWord, index);
            if (index != -1) {
                indexes.add(index);
                index++;
            }
            //            if (wordLength == 0) {
            //                wordLength = word.length();
            //            }
        }
        return indexes;
    }

    public static List<Integer> matchIndexes(String s, String[] p) {
        List<String[]> res = permutations(p);
        Set<String> patterns = getUniqueWords(res);
        List<Integer> ints = new ArrayList<>();
        for (String str : patterns) {
            //            ints.addAll(findWordIndexes(s, str));
        }
        Collections.sort(ints);
        return ints;
    }

    public static String[] insertX(int n, String arr[], String x, int pos) {
        int i;

        // create a new array of size n+1
        String newarr[] = new String[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till pos
        // then insert x at pos
        // then insert rest of the elements
        for (i = 0; i < n + 1; i++) {
            if (i < pos - 1)
                newarr[i] = arr[i];
            else if (i == pos - 1)
                newarr[i] = x;
            else
                newarr[i] = arr[i - 1];
        }
        return newarr;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || "".equals(s.trim()) || words == null || words.length == 0) {
            return Arrays.asList(new Integer[0]);
        }

        Set<String> targetSet = new HashSet<>();
        for (String word : words) {
            targetSet.add(word);
        }
        if (targetSet != null && targetSet.size() == 2) {
            String[] uniqueStrs = targetSet.toArray(new String[targetSet.size()]);
            List<Integer> mIndes = findWordIndexes(s, uniqueStrs[0] + uniqueStrs[1]);
            List<Integer> mIndes2 = findWordIndexes(s, uniqueStrs[1] + uniqueStrs[0]);
            if (mIndes.size() == 0 && mIndes2.size() == 0) {
                return Arrays.asList(new Integer[0]);
            }
        }
        Arrays.sort(words, Collections.reverseOrder());
        List<Integer> matchIndexes = findWordIndexes(s, words[0]);
        if (matchIndexes.size() == 0) {
            return Arrays.asList(new Integer[0]);
        }
        int el = words[0].length();
        int ptl = words.length * el;
        List<String> matchStr = new ArrayList<>();
        for (Integer in : matchIndexes) {
            int startInt = in + el - ptl;
            if (startInt < 0) {
                while (startInt < 0) {
                    startInt += el;
                }
            }
            int endInt = in + el + ptl;
            if (endInt > s.length()) {
                while (endInt > s.length()) {
                    endInt -= el;
                }
            }
            matchStr.add(s.substring(startInt, endInt));
        }

        int wl = words[0].length();
        Set<Integer> ints = new HashSet<>();
        for (String ms : matchStr) {
            int splitArraySize = ms.length() / wl;
            List<Integer> mIndexes = findWordIndexes(s, ms);
            String[] splitArray = new String[splitArraySize];
            for (int i = 0; i < splitArraySize; i++) {
                splitArray[i] = ms.substring(wl * i, wl * i + wl);
            }
            for (int j = 0; j < splitArraySize && j + words.length <= splitArraySize; j++) {
                String[] str = Arrays.copyOfRange(splitArray, j, j + words.length);
                if (str != null) {
                    Arrays.sort(str, Collections.reverseOrder());
                    if (Arrays.equals(str, words)) {
                        for (Integer mi : mIndexes) {
                            ints.add(j * wl + mi);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ints);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //        String[] words = new String[]{"word","good", "best", "word"};
        //
        //        for (int i=0; i < words.length + 1; i++) {
        //            System.out.println(arrays.toString(insertX(words.length, words, "first", i+1)));
        //        }

        //        String s = "barfoothefoobarman";
        //        System.out.println(arrays.toString(matchIndexes(s, words).toArray()));
        ////
        //        String[] words = new String[]{"foo","bar"};
        //        String s = "barfoothefoobarman";

        //        String s = "wordgoodgoodgoodbestword";
        //        String[] words = new String[] { "word", "good", "best", "good" };

        //        String[] words = new String[]{"a","a"};
        //        String s = "aaa";
        //        String[] words = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        //        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";

        //        String[] words = new String[]{"word","good", "best", "word"};
        //        String s = "wordgoodgoodgoodbestword";
        //        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        //        String[] words = new String[]{"fooo","barr","wing","ding","wing"};

        //        String s = "aaaaaaaa";
        //        String[] words = new String[]{"aa","aa","aa"};

        String s = "ababaab";
        String[] words = new String[] { "ab", "ba", "ba" };

        //        String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        //        String[] words = new String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
        System.out.println(Arrays.toString(findSubstring(s, words).toArray()));
        //        System.out.println(arrays.toString(findSubstring(s, words).toArray()));
        System.out.println(words.length);

        //        System.out.println(arrays.toString(perm(s2, words2).toArray()));

        //        String[] words3 = new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};

        //        permutations(arrays.asList(words3), new Stack<String>(), words3.length);
        //        String s3 = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        //        System.out.println(arrays.toString(perm(s3, words3).toArray()));

        //        String[] words1 = new String[]{"wor1"};
        //        String[] words2 = new String[]{"wor2"};

        //        System.out.println(arrays.toString(arrays.copyOfRange(words, 0, 1)));
        //        permutations(transArray(words), new Stack<String>(), words.length);
        //        System.out.println(arrays.toString(res.toArray(new String[0])));
    }
}
