class Solution {
    public boolean checkValidString(String s) {
        if(s.length() == 1) {
            if(s.charAt(0) != '*') {
                return false;
            }

            else {
                return true;
            }
        }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(') {
                open.push(i);
            }

            else if(curr == '*') {
                star.push(i);
            }

            else if(curr == ')') {
                if(!open.isEmpty()) {
                    open.pop();
                }

                else if(!star.isEmpty()) {
                    star.pop();
                }

                else {
                    return false;
                }
            }
        }

        while(!open.isEmpty() && !star.isEmpty()) {
            if(star.peek() > open.peek()) {
                star.pop();
                open.pop();
            }
            else {
                return false;
            }
        }

        return open.isEmpty();
    }
}
