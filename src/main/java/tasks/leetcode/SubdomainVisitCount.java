package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer>  counter = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int spaceIndex = cpdomain.indexOf(" ");
            String timeStr = cpdomain.substring(0, spaceIndex);
            int time = Integer.parseInt(timeStr);
            String domain = cpdomain.substring(spaceIndex + 1);
            counter.compute(domain, (k, v) -> {
                if (v == null) return time;
                else return v + time;
            });
            int start = domain.length() - 1;
            int indexOfComma = -1;
            do {
                indexOfComma = domain.lastIndexOf('.', start);
                if (indexOfComma < 0) break;
                String subdomain = domain.substring(indexOfComma + 1);
                counter.compute(subdomain, (k, v) -> {
                   if (v == null) return time;
                   else return v + time;
                });
                start = indexOfComma - 1;
            } while (start > 0);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }
}
