package tasks.leetcode;

import java.util.*;

/**
 * Created by ifedan on 7/25/16.
 */
public class SubstringwithConcatenationofAllWords {

    public static void main(String[] args) {
        String s = "xcsgedisbnkkiperkawetuiokxjmrapqcjyjpgbqulcecgxoitudpcrcccotcglhpjqeptwlhasjgpaqlutaznebptwszhbostvhmtvtunfcehtpboscbwdrpzlqgohahcivxfpruwuydpqgdijhgmaymloubxvizfdxkuqeqmetduajejqnxqlldbgezdoaitzuosagegakdcthnjwmzjyeleimjyotrqphipooxqyasrihagtbqthdzppipfbhvqodheufushomrvmyrqokxrkpiuepwnloeqyikfdfmrrepfcgvqsvjektbqixetnkmlsyqxddpwhgclozdgumnghoxpndlapxohvghbjyxsebfsbiaxwnedddvsggvxdjgapnbblbvpcbhdjibixhlbkgtsooptzvurlxswynmdoviafjidsvgcebwsslmrjiiufcsgqgjgcrghdomvmuaqwwkokwhvgsrmujskqbruszdxqqtckvuirewddgyjypxszpdrswlnvoklefprajzsqyxtewecncuorzfmvqztfjglrwcrfelxcjqghvkuzgjsgoedfdwmpdxgbcxiglgiuyqdtaxuginoxrsevqsmvpuwrrhxenhalxdhzbbilqwiiqofjgrewldpemplzwlmupvvsxddncoxsccdlvkjinypbnaamloiakdujhyylmwdqajbwtkgijvjyvlkhzsjlyeufctsorvergipzswhdrqcpbowdjfohjjonegdvdkoksejkcrovjsklgiorqeybnmprusoyedkwjthnmxkwpxjxfzpvdpxtcokyibwnggjrcseopqmgnvgtuvqamntqbfpmgnzowifydloscdbpyhkvebvqqqhuvwgclfshpyfsjwnnzodzxpudqrtjhcddajhmqztfzbajxnywddxatsdllyuvbzabkjnaihikiivhvtfyxcaswfdidafebfimovoyeyioidvfzadwffqbkvlovquzvcnjydkecstkyoqxrvvwdlznildebyfzasiavufznamnqcmhzhfcufscsvitvpswhdyfxdemfqbwundwwlaqsuvkqffnvalcfkjepotvgurdiwzehbxbwsnozvbuvnzcxigmyzjfuaicxjigkfkgzxuzuytplutkdaybbiixisbhdkqopawrztqurlleghojhmmkuxifrjovtellghcicsetfrxlylwhalsuiczblqwhuhsdpwlrqpnvimhhafoaqiuakwcwmyfiizlzvyqlpfiysrfsxvsneoqomsmasrjaqwznvsakzjiraplxlfnrwdfixujpluseqtrlluyldiedasdlxscvvjeudplrjdxbxqpkkpxpxctxuyktqornyxhdmuwxytaxmphwefoejhbfhmazarmaovecpczpwcokrwiydwcofftmttlwnzwbwceoffddhsnbqxzvubjzieocxbymduozzungztjjlykdxlarojtwpjyokwbntppujcakvlvilfniqnceyvdnebcqadgtuvpfzppxanhlsvvlkxrjuuyywarwdzrzwgevxwuzjemdzholfgwzcvayvtwbspaoxhlwdivmmhpnpgywovxqqzrnsnqmfrceaobdywrkeixvovrcsqtkqkyizovghxljnmmlkfvqoulesehkvcxlo";
        String[] words = new String[]{"dbpyhkvebvqqqhuvwgclfshpyfs","jwnnzodzxpudqrtjhcddajhmqzt","fzbajxnywddxatsdllyuvbzabkj","naihikiivhvtfyxcaswfdidafeb","fimovoyeyioidvfzadwffqbkvlo","vquzvcnjydkecstkyoqxrvvwdlz","nildebyfzasiavufznamnqcmhzh","fcufscsvitvpswhdyfxdemfqbwu","ndwwlaqsuvkqffnvalcfkjepotv","gurdiwzehbxbwsnozvbuvnzcxig","myzjfuaicxjigkfkgzxuzuytplu","tkdaybbiixisbhdkqopawrztqur","lleghojhmmkuxifrjovtellghci","csetfrxlylwhalsuiczblqwhuhs","dpwlrqpnvimhhafoaqiuakwcwmy","fiizlzvyqlpfiysrfsxvsneoqom","smasrjaqwznvsakzjiraplxlfnr","wdfixujpluseqtrlluyldiedasd","lxscvvjeudplrjdxbxqpkkpxpxc","txuyktqornyxhdmuwxytaxmphwe","foejhbfhmazarmaovecpczpwcok","rwiydwcofftmttlwnzwbwceoffd","dhsnbqxzvubjzieocxbymduozzu","ngztjjlykdxlarojtwpjyokwbnt","ppujcakvlvilfniqnceyvdnebcq"};

        int len = words[0].length();
        if (s.length() < len) return;

        long hash = 0;
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            hash += hash(words[i], 0, len);
            count++;
        }

        long t[] = new long[s.length()];
        t[0] = hash(s, 0, len);
        for (int i = 1; i <= s.length() - len; i++) {
            t[i] = rehash(t[i-1], s.charAt(i-1), s.charAt(i+len-1), len-1);
        }
        int totalLen = len * count;
        for (int i = 0; i <= t.length - totalLen; i++) {
            for (int j = 1; j < count && i + (j * len) < s.length(); j++) {
                t[i] += t[i + (j*len)];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i< t.length; i++) {
            if (t[i] == hash && check(words, s, i, len, count)) {
                result.add(i);
            }
        }

    }

    private static boolean check(String[] words, String s, int start, int len, int count) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < words.length; i++) {
            Integer c = map.get(words[i]);
            if (c == null) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], c+1);
            }
        }
        for (int i = 0; i < len*count; i= i+len) {
            String word = new String(s.toCharArray(), start+i, len);

            Integer c = map.get(word);
            if (c == null) return false;
            if (c == 1) map.remove(word);
            else map.put(word, c-1);
        }
        return map.isEmpty();
    }

    private static long rehash(long prevHash, char prevChar, char nextChar, int size) {
        if (size == 0) {
            return nextChar;
        }
        return ((prevHash - prevChar) / 2) + (nextChar * (1l << size));
    }

    private static long hash(String s, int start, int end) {
        long hash = 0;
        for (int i = start; i < end; i++) {
            hash += s.charAt(i) * (1l<<(i-start));
        }
        return hash;
    }


}
