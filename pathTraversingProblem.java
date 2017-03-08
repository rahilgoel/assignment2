import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class pathTraversingProblem {
	
	public static void main(String[] args){
		String[] arg=new String[]{"0 0 0 1","6 6 5 6"};
		System.out.println(numWays(6,6,arg));
	}
	public static long numWays(int width, int height, String[] bad) {
        HashMap<String,HashSet<String>> blocks = new HashMap<String,HashSet<String>>();
        for (String badStr : bad) {
            String[] bl = badStr.split(" ");
            int x1 = Integer.parseInt(bl[0]);
            int y1 = Integer.parseInt(bl[1]);
            int x2 = Integer.parseInt(bl[2]);
            int y2 = Integer.parseInt(bl[3]);
            String p1 = "" + x1+ ":" + y1;
            String p2 = "" + x2 + ":" + y2;
            // p1 -> p2 && p2-> p1 are blocked
            if (!blocks.containsKey(p1)) {
                HashSet<String> set = new HashSet<String>();
                blocks.put(p1, set);
            }
            if (!blocks.containsKey(p2)) {
                HashSet<String> set = new HashSet<String>();
                blocks.put(p2, set);
            }
            blocks.get(p1).add(p2);
            blocks.get(p2).add(p1);
        }
        long mx[][] = new long[width+1][height+1];
         
        for (int i = 0; i < width+1; i++) {
            for (int j = 0; j < height+1; j++) {
                if (i == 0 && j == 0) {
                    mx[i][j] = 1;
                }
                else {
                    String s0 = ""+i+":"+j;
                    String s1 = ""+(i-1)+":"+j;
                    String s2 = ""+i+":"+(j-1);
                    if (i > 0 && !(blocks.containsKey(s1) && blocks.get(s1).contains(s0))) {
                        mx[i][j] += mx[i-1][j];
                    }
                    if (j > 0 && !(blocks.containsKey(s2) && blocks.get(s2).contains(s0))) {
                        mx[i][j] += mx[i][j-1];
                    }
                }
            }
        }
        return mx[width][height];
    }
}
