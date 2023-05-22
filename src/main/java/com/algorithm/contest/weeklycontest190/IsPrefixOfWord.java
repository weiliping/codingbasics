package com.algorithm.contest.weeklycontest190;

public class IsPrefixOfWord {
    public static void main(String[] args) {

        IsPrefixOfWord i = new IsPrefixOfWord();
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(i.isPrefixOfWord(sentence, searchWord));
        String sentence1 = "this problem is an easy problem", searchWord1 = "pro";
        System.out.println(i.isPrefixOfWord(sentence1, searchWord1));
        String sentence2 = "i am tired", searchWord2 = "you";
        System.out.println(i.isPrefixOfWord(sentence2, searchWord2));

        String sentence3 = "i use triple pillow", searchWord3 = "pill";
        System.out.println(i.isPrefixOfWord(sentence3, searchWord3));
        String sentence4 = "hello from the other side", searchWord4 = "they";
        System.out.println(i.isPrefixOfWord(sentence4, searchWord4));

        String sentence5 = "hellohello hellohellohello", searchWord5 = "ell";
        System.out.println(i.isPrefixOfWord(sentence5, searchWord5));

        String sentence6 = "pillow love winstontang i pillow corona you errichto love", searchWord6 = "i";
        System.out.println(i.isPrefixOfWord(sentence6, searchWord6));


        String sentence7 = "i dumb", searchWord7 = "jiezcqu";
        System.out.println(i.isPrefixOfWord(sentence7, searchWord7));
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence = " " + sentence;
        int firstInd = sentence.indexOf(" "+ searchWord);
        if (firstInd == -1) {
            return -1;
        }
        int cnt = 0;
        for (int i = 0; i <= firstInd; i++) {
            if (sentence.charAt(i) == ' ') {
                cnt++;
            }
        }
        return cnt;
    }
}
