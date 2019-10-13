package InterView.WangYi;

        import java.util.Random;
        import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int t  =scanner.nextInt();

            for (int i=0; i<t; i++){
                solve(scanner);
            }
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i=0; i<n; i++){
            array[i] = scanner.nextInt();
        }

        Random random =new Random();
        int x = random.nextInt(10000);
        if (x%2==1)
            System.out.println("YES");
        else
            System.out.println("No");
    }
}
