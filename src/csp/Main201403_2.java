package csp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/28 17:14
 * @email fengyuzhuo666@gmail.com
 */
public class Main201403_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        List<Rectangle> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            list.add(new Rectangle(x1, y1, x2, y2,i+1,i+1));
        }

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            click(list, x, y);
        }

    }

    private static void click(List<Rectangle> list, int x, int y) {
        //从顶层开始判断
        for (int i = list.size() - 1; i >= 0; i--){
            Rectangle r = list.get(i);
            //点击成功
            if((r.x1<=x && x<=r.x2)&&(r.y1<= y && y<=r.y2)){
                System.out.println(r.init);
                //将点击成功的放在最上面
                list.remove(r);
                list.add(r);
                return;
            }
        }
        //都没有符合的输出IGNORED
        System.out.println("IGNORED");
    }


}

class Rectangle {
    int x1;
    int x2;
    int y1;
    int y2;

    int init;

    int current;

    public Rectangle(int x1, int y1, int x2, int y2,int init,int current) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.init = init;
        this.current = current;
    }
}
