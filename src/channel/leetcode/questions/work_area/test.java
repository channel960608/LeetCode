package channel.leetcode.questions.work_area;

class test {
    public String countOfAtoms(String formula) {
        int size = 26 * 27;
        int[] counter = new int[size];
        int[] multipliers = new int[size];
        int top = 0;

        int curMultiplier = 1;
        int val = 0;
        int x10 = 1;
        int endAtom = -1;
        int charPos = 0;

        for( int i = formula.length() - 1; i >= 0; i--) {
            char ch = formula.charAt(i);
            if (ch == ')') {
                if (val == 0) val = 1;
                multipliers[top++] = val;
                curMultiplier *= val;
                val = 0;
                x10 = 1;
            } else if (ch == '(') {
                curMultiplier /= multipliers[top-1];
                top--;
            } else if (ch <= '9' && ch >= '0') {
                val += x10 * (ch - '0');
                x10 *= 10;
            } else if (ch >= 'a' && ch <= 'z') { //lowercase char is part of Atom
                charPos = ch - 'a' + 1;
            } else {
                charPos += (ch - 'A') * 27;
                if (val == 0) val = 1;
                counter[charPos] = counter[charPos] + val * curMultiplier;
                val = 0;
                x10 = 1;
                charPos = 0;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (counter[i] > 0) {
                char ch = (char) ('A' +  i / 27);
                res.append(ch);
                if (i % 27 > 0) {
                    ch = (char) ('a' + (i % 27) - 1);
                    res.append(ch);
                }

                if (counter[i] > 1) {
                    res.append(counter[i]);
                }
            }
        }

        return res.toString();
    }
}