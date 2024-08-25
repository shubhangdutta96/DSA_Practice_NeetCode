class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }

        for(int i=0;i<words.length-1;i++){
            String current = words[i];
            String next = words[i+1];

            int j=0;
            while(j < current.length() && j < next.length() && current.charAt(j) == next.charAt(j)){
                j++;
            }
            if(j >= next.length() && j < current.length()){
                return false;
            }
            if(j < current.length() && j < next.length() && map.get(current.charAt(j)) > map.get(next.charAt(j))){
                return false;
            }
        }
        return true;
    }
}
