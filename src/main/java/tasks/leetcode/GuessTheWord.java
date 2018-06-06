package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class GuessTheWord {
    public static void findSecretWord(String[] wordlist, Master master) {
        Set<String> words = new HashSet<>();
        for (String word : wordlist) {
            words.add(word);
        }
        while (!words.isEmpty()) {
            String pivot = words.iterator().next();
            int similarityLevel = master.guess(pivot);
            if (similarityLevel == 0) {
                words.removeIf(w -> similarity(pivot, w, true) > 0);
            } else if (similarityLevel < pivot.length()) {
                words.remove(pivot);
                words.removeIf(w -> similarity(pivot, w, false) < similarityLevel);
            } else {
                return;
            }
        }
    }

    static int similarity(String a, String b, boolean breakOnFirst) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                if (breakOnFirst) return 1;
                result++;
            }
        }
        return result;
    }

    static interface Master {
        int guess(String word);
    }

    public static void main(String[] args) {
        Master m = new Master() {
            @Override
            public int guess(String word) {
                System.out.println(word);
                //char[] c1 = "hbaczn".toCharArray();
                char[] c1 = "acckzz".toCharArray();
                char[] c2 = word.toCharArray();
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (c1[i] == c2[i]) count++;
                }
                return count;
            }
        };
        //findSecretWord(new String[]{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"}, m);

        findSecretWord(new String[]{"acckzz","ccbazz","eiowzz","abcczz"}, m);
    }
}
