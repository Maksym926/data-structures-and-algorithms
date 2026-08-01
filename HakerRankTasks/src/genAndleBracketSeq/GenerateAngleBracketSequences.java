package genAndleBracketSeq;

import java.util.ArrayList;
import java.util.List;

public class GenerateAngleBracketSequences {
    static List<String> res = new ArrayList<>();
    public static List<String> generateAngleBracketSequences(int n) {
        StringBuilder sb = new StringBuilder();
        helper(n * 2,sb, n, n);
        return res;

    }
    private static void helper(int n, StringBuilder seq, int opened, int closed){
        if(n == 0){
            res.add(seq.toString());
            return;
        }
        if(!seq.isEmpty() && closed > opened ){
            helper(n-1, seq.append('>'), opened, closed-1);
            seq.deleteCharAt(seq.length() - 1);
        }
        if(opened > 0){
            helper(n-1, seq.append('<'), opened-1, closed);
            seq.deleteCharAt(seq.length() - 1);
        }
    }
}
