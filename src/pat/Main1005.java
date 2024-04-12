package pat;
import java.util.*;

public class Main1005 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("0","zero");
        map.put("1","one");
        map.put("2","two");
        map.put("3","three");
        map.put("4","four");
        map.put("5","five");
        map.put("6","six");
        map.put("7","seven");
        map.put("8","eight");
        map.put("9","nine");
        Scanner in = new Scanner(System.in);

        String sOfN = in.next();
        int res = 0;
        for(int i = 0;i < sOfN.length(); i++){
            res += Integer.parseInt(sOfN.substring(i,i+1));
        }
        String sOfRes = String.valueOf(res);
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < sOfRes.length(); i++){
            sb.append(map.get(sOfRes.substring(i,i+1))+" ");
        }
        System.out.println(sb.toString().trim());
    }

}