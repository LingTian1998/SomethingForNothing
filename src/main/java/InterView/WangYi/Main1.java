package InterView.WangYi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            student[] students = new student[n];
            for (int i=0; i< n; i++){
                students[i] = new student(scanner.nextInt(),i+1);
            }

            Arrays.sort(students, new Comparator<student>() {
                @Override
                public int compare(student o1, student o2) {
                    return o1.score-o2.score;
                }
            });

            for (int i=0; i<n; i++){
                int j = 0;
                for (j= i; j<n-1; ){
                    if (students[j].score == students[j+1].score)
                        j++;
                    else
                        break;
                }
                students[i].num_below_score = j;
            }

            Arrays.sort(students, new Comparator<student>() {
                @Override
                public int compare(student o1, student o2) {
                    return o1.index - o2.index;
                }
            });


            int q = scanner.nextInt();
            int[] tar =new int[q];
            for (int i=0; i<q ; i++) {
                tar[i] = scanner.nextInt();
            }

            for (int i=0; i<q; i++){
                double result = (double) students[tar[i]-1].num_below_score / n;
                result *= 100;
                System.out.println(String.format("%.6f", result));
            }
        }
    }
}
class student{
    int score;
    int index;
    int num_below_score=0;

    public student(int score,int index){
        this.score = score;
        this.index = index;
    }
}