package tasks.leetcode;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions test = new ExclusiveTimeOfFunctions();
        test.exclusiveTime(1, Stream.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7").collect(Collectors.toList()));
    }

    class Log {
        int id;
        boolean start;
        int time;
        Log(int i, boolean s, int t) {
            id = i;
            start = s;
            time = t;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] result = new int[n];
        int time = 0;
        for (String str : logs) {
            Log log = parse(str);
            if (stack.isEmpty()) {
                stack.push(log);
                time = log.time;
            } else {
                if (stack.peek().id == log.id && !log.start) {
                    result[stack.peek().id] += (log.time - time + 1);
                    stack.pop();
                    time = log.time + 1;
                } else {
                    result[stack.peek().id] += (log.time - time);
                    stack.push(log);
                    time = log.time;
                }
            }
        }
        return result;
    }

    private Log parse(String str) {
        java.util.StringTokenizer st = new java.util.StringTokenizer(str, ":");
        int id = Integer.parseInt(st.nextToken());
        boolean start = "start".equals(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        return new Log(id, start, time);
    }
}
