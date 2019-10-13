package InterView.TenCent_2;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            people[] people = new people[n];
            for (int i=0; i<n; i++){
                people[i] = new people(scanner.nextInt(), scanner.nextInt());
            }

            long target = n;
            while (target > 0) {
                for (int i = 0; i+1 < target; i++) {
                    int before = i+1 -1;
                    int after = n- (i+1);
                    long judge_before_swap = people[i].a*before +
                            people[i].b*after +
                            people[i+1].a*(before+1)+
                            people[i+1].b*(after-1);
                    long judge_after_swap = people[i].a*(before+1) +
                            people[i].b*(after-1) +
                            people[i+1].a*before+
                            people[i+1].b*after;
                    if (judge_after_swap < judge_before_swap)
                        swap(people, i, i+1);
                }
                target--;
            }

            long sum = 0;
            for (int i=0; i<n;i++){
                long before = i+1 - 1;
                long after = n- (i+1);
                sum = sum + people[i].a*before + people[i].b*after;
            }

            System.out.println(sum);
        }
    }

    private static void swap(people[] people, int i, int i1) {
        people temp = people[i];
        people[i] = people[i1];
        people[i1] = temp;
    }
}
class people{
    long a;
    long b;
    public people(long a, long b){
        this.a = a;
        this.b = b;
    }
}