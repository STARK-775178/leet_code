package pat;

import java.util.*;

public class Main {
   private static int Np;
    private static int Ng;
    private static int[] rank;
    private static List<Mice> loseList;
    private static List<Mice> winList;
    private static List<Mice> contestList;
    private static List<Mice> infoList;
    private static class Mice{
        private int master;
        private int weight;
        private Mice(int master,int weight){
            this.master = master;
            this.weight = weight;
        }
    }
    private static class MiceCompare implements Comparator<Mice>{
        @Override
        public int compare(Mice o1, Mice o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Np = sc.nextInt();
        Ng = sc.nextInt();
        loseList = new LinkedList<>();
        winList = new LinkedList<>();
        contestList = new LinkedList<>();
        infoList = new LinkedList<>();
            rank = new int[Np];
        for(int i = 0; i < Np; i++){
            infoList.add(new Mice(i,sc.nextInt()));
        }
        for (int i = 0; i < infoList.size(); i++) {
            winList.add(i,infoList.get(sc.nextInt()));
        }
        //contest begins
        int total = Np;
        while (total > 1){
            int winNum = 0;
            //the first round
            for (int i = 0; i < total; i+=Ng) {
                int start = i;
                int end = Math.min(i + Ng, total);
                while(start < end){
                    contestList.add(winList.get(start));
                    start++;
                }
                Collections.sort(contestList,new MiceCompare());
                winList.set(winNum++, contestList.remove(contestList.size() - 1));
                while (contestList.size() > 0){
                    loseList.add(contestList.remove(0));
                }
            }
            //Set the rank of losers of this round
            while (loseList.size() > 0){
                rank[loseList.remove(0).master] = winNum + 1;
            }
            total = winNum;
        }
        rank[winList.get(0).master] = 1;
        for (int i = 0; i < rank.length; i++) {
            System.out.print(rank[i]);
            if(i != rank.length - 1){
                System.out.print(" ");
            }
        }
    }
}
