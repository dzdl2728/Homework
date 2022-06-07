import java.util.Scanner;

public class datesolve {
    public static void main(String[] args) {
        int yuwen =0;
        int suxue =1;
        int yingyu =2;
        int huaxue =3;
        int shengwu =4;
        int wuli =5;
        int totalcont =6;
        String[] name =new String[totalcont];
        name[yuwen]="语文";
        name[suxue]="数学";
        name[yingyu]="英语";
        name[huaxue]="化学";
        name[shengwu]="生物";
        name[wuli]="物理";
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入需要查询总年份");
        int years = scanner.nextInt();
        double[][] scores = new double[years][totalcont];
        for (int i = 0; i <years ; i++) {
            for (int j = 0; j <totalcont ; j++) {
                scores[i][j]=Math.random()*20+80;
                System.out.println("第"+(i+1)+"年，学科为"+name[j]+"分数为"+scores[i][j]);
            }
        }
        boolean cont =true;
        while(cont){
            System.out.println("请输入需要的操作");
            System.out.println("1.求某年最好成绩\n"+
                    "2.求某年的平均成绩\n"+
                    "3.求所有年份的最好成绩\n"+
                    "4.求某门课历年最好成绩\n");
            int pick = scanner.nextInt();
            int year=0;
            switch (pick){
                case 1:
                    System.out.println("请输入求最好成绩年份");
                     year = scanner.nextInt();
                    if(year<=0||year>years){
                        System.out.println("非法年份");
                        cont=false;
                        break;
                    }
                    year-=1;
                    int bestyearscore = 0;
                    for (int i = 0; i <totalcont ; i++) {
                        if(scores[year][bestyearscore]<scores[year][i]){
                            bestyearscore = i;
                        }
                    }
                    System.out.println("第"+(year+1)+"年，成绩为"+scores[year][bestyearscore]);
                    break;
                case 2:
                    System.out.println("请输入求平均值年份");
                     year = scanner.nextInt();
                    if(year<=0||year>years){
                        System.out.println("非法年份");
                        cont=false;
                        break;
                    }
                    int sum=0;
                    for (int i = 0; i <totalcont ; i++) {
                        sum+=scores[year-1][i];
                    }
                    System.out.println("第"+year+"年的平均成绩为"+(sum/totalcont));
                    break;
                case 3:
                    double allbest=0;
                    for (int i = 0; i <years ; i++) {
                        for (int j = 0; j <totalcont ; j++) {
                            if(allbest<scores[i][j])allbest=scores[i][j];
                        }
                        }
                    System.out.println("所有年份最好成绩为"+allbest);
                    break;
                case 4:
                    System.out.println("请输入科目代码");
                    int nameidx = scanner.nextInt();
                    if(nameidx<0||nameidx>=totalcont){
                        System.out.println("非法科目代码");
                        cont=false;
                        break;
                    }
                    int bestyear=0;
                    double bestscoreofclass = 0;
                    for (int i = 0; i <years ; i++) {
                        if(bestscoreofclass<scores[i][nameidx]){
                            bestscoreofclass=scores[i][nameidx];
                            bestyear=i;
                        }
                    }
                    System.out.println(name[nameidx]+"的第"+bestyear+"最好成绩为"+bestscoreofclass);
                    break;
                    default:
                        cont=false;
                        System.out.println("不支持"+pick+"程序结束");
                    }


            }
        }


    }

