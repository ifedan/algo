package tasks.leetcode;

import java.util.*;

public class NumberOfAtoms {

    static class Operand {
        int multiplier = 1;
        Operand parent;
        HashMap<String, Integer> map = new HashMap<>();
        List<Operand> children = new ArrayList<>();
        Operand(Operand parent) {
            this.parent = parent;
            parent.children.add(this);
        }
        Operand() {

        }
        public void multiply(int value) {
            multiplier *= value;
            for (Operand child : children) {
                child.multiply(value);
            }
        }
        public void add(String operand, int count) {
            map.compute(operand, (k,v) -> {
                if (v == null) return count;
                else return v + count;
            });
        }
        public Map<String, Integer> eval() {
            HashMap<String, Integer> result = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                result.put(entry.getKey(), entry.getValue() * multiplier);
            }
            for (Operand child : children) {
                Map<String, Integer> childResult = child.eval();
                for (Map.Entry<String, Integer> entry : childResult.entrySet()) {
                    result.compute(entry.getKey(), (k, v) -> {
                       if (v == null) return entry.getValue();
                       else return v + entry.getValue();
                    });
                }
            }
            return result;
        }
    }

    public static String countOfAtoms(String formula) {
        Map<String, Integer> result = parse(formula).eval();
        TreeMap<String, Integer> sortedResult = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            sortedResult.put(entry.getKey(), entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedResult.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static Operand parse(String formula) {
        char[] arr = formula.toCharArray();
        int i = 0;
        Operand current = new Operand();
        while (i < arr.length) {
            if (arr[i] == '(') {
                current = new Operand(current);
                i++;
            } else if (arr[i] == ')') {
                i++;
                int mult = 0;
                while (i < arr.length && Character.isDigit(arr[i])) {
                    mult = mult * 10 + Character.getNumericValue(arr[i]);
                    i++;
                }
                current.multiply(mult == 0 ? 1 : mult);
                current = current.parent;
            } else {
                StringBuilder operand = new StringBuilder();
                operand.append(arr[i]);
                i++;
                while (i < arr.length && Character.isLowerCase(arr[i])) {
                    operand.append(arr[i]);
                    i++;
                }
                int count = 0;
                while (i < arr.length && Character.isDigit(arr[i])) {
                    count = count * 10 + Character.getNumericValue(arr[i]);
                    i++;
                }
                current.add(operand.toString(), count == 0 ? 1 : count);
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("Mg(OH)2"));
    }

}
