import java.util.Scanner;

public class SplitTextWithLongestShortest {
    public static int stringLength(String s){
        int cnt = 0;
        while(true){
            try{ s.charAt(cnt); cnt++; }
            catch(StringIndexOutOfBoundsException e){ break; }
        }
        return cnt;
    }

    public static int countWords(String text){
        int n = text.length();
        int count = 0;
        boolean in = false;
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            if(!Character.isWhitespace(ch)){
                if(!in){ count++; in = true; }
            } else in = false;
        }
        return count;
    }

    public static String[] splitIntoWords(String text){
        int total = countWords(text);
        String[] res = new String[total];
        int idx = 0;
        StringBuilder cur = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(!Character.isWhitespace(ch)) cur.append(ch);
            else {
                if(cur.length() > 0){
                    res[idx++] = cur.toString();
                    cur.setLength(0);
                }
            }
        }
        if(cur.length() > 0) res[idx++] = cur.toString();
        return res;
    }

    public static String[][] wordsWithLengths(String[] words){
        String[][] out = new String[words.length][2];
        for(int i = 0; i < words.length; i++){
            int len = stringLength(words[i]);
            out[i][0] = words[i];
            out[i][1] = String.valueOf(len);
        }
        return out;
    }

    public static int[] findShortestLongest(String[][] arr){
        if(arr.length == 0) return new int[]{-1, -1};
        int min = 0, max = 0;
        for(int i = 1; i < arr.length; i++){
            int L = Integer.parseInt(arr[i][1]);
            int Lmin = Integer.parseInt(arr[min][1]);
            int Lmax = Integer.parseInt(arr[max][1]);
            if(L < Lmin) min = i;
            if(L > Lmax) max = i;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();
        String[] words = splitIntoWords(text);
        if(words.length == 0){
            System.out.println("No words found.");
            return;
        }
        String[][] wlen = wordsWithLengths(words);
        int[] mm = findShortestLongest(wlen);
        System.out.println("Shortest: " + wlen[mm[0]][0] + " (length " + wlen[mm[0]][1] + ")");
        System.out.println("Longest: "  + wlen[mm[1]][0] + " (length " + wlen[mm[1]][1] + ")");
    }
}
