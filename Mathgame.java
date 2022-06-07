import java.util.Random;
import java.util.Scanner;

public class Mathgame {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int guesstotal =5;
        int numstart=30;
        int numend=50;
        int totaltime = 5;
        boolean gamestop = false;
        while(!gamestop) {
            int guessl = numstart;
            int mod = numend - numstart;
            int guessleft = totaltime-1;
            int totalcont = 0;
            boolean gameastrt = true;
            boolean guesscorrect = false;
            double random = Math.random();
            int num = (int) (random * 20 + guessl);
            System.out.println("======猜数字开始=======");
            System.out.println("随机数字已生产从" + guessl + "到" + numend + "共有" + totaltime + "次机会猜测,输入-1表示退出。");
            int guess = in.nextInt();
            if (guess == -1) {
                System.out.println("游戏停止");
                gamestop = true;
                break;
            }
            if(guess<=guessl||guess>=numend){
                System.out.println("非法数据范围,请核对");
                continue;
            }
            if(gameastrt){
                totalcont++;
                gameastrt = false;
            }
            while (guessleft >=0) {
                if (guess == num) {
                    System.out.println("恭喜答对了共进行了"+(totaltime-guessleft)+"次");
                    guesscorrect = true;
                    totalcont++;
                    break;
                } else if (guess < num) {
                    guessleft--;
                    System.out.println("比猜测数字小,剩余" + (guessleft+1) + "次");
                    guess= in.nextInt();
                } else if (guess > num) {
                    guessleft--;
                    System.out.println("比猜测数字大,剩余" + (guessleft+1) + "次");
                    guess= in.nextInt();
                }
            }
            if(!guesscorrect){
                System.out.println("本次生成的数字为"+num+"很可惜");
            }
            System.out.println("共进行了"+totalcont+"次");
        }
    }
}
