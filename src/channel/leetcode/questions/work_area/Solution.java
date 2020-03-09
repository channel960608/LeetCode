import java.util.Map;

import java.util.TreeMap;

class Solution {
    int muil = 0;
    public String count(String str) {
        StringBuffer ans = new StringBuffer();
        muil = 0;
        Map<String, Integer> map = parse(str);
        for (String atom: map.keySet()) {
            ans.append(atom);
            int time = map.get(atom);
            if (time > 1) {
                ans.append(String.valueOf(time));
            }
        }

        String n_str = String.valueOf(ans);
        return n_str;
    }

    public Map<String, Integer> parse(String str) {
        int len = str.length();
        Map<String, Integer> m_map = new TreeMap();
        while (muil < len && str.charAt(muil) != ')') {
            if (str.charAt(muil) == '(') {
                muil++;
                for (Map.Entry<String, Integer> entry: parse(str).entrySet()) {
                    m_map.put(entry.getKey(), m_map.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = muil++;
                while (muil < len && Character.isLowerCase(str.charAt(muil))) muil++;
                String name = str.substring(iStart, muil);
                iStart = muil;
                while (muil < len && Character.isDigit(str.charAt(muil))) muil++;
                int multiplicity = iStart < muil ? Integer.parseInt(str.substring(iStart, muil)) : 1;
                m_map.put(name, m_map.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++muil;
        while (muil < len && Character.isDigit(str.charAt(muil))) muil++;
        if (iStart < muil) {
            int multiplicity = Integer.parseInt(str.substring(iStart, muil));
            for (String key: m_map.keySet()) {
                m_map.put(key, m_map.get(key) * multiplicity);
            }
        }
        return m_map;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().count("K4(ON(SO3)2)2"));
    }
}