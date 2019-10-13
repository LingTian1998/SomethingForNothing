package InterView.YITu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int b = scanner.nextInt();

            House[] houses = new House[n];
            Car[] cars = new Car[m];

            int min_house_price = Integer.MAX_VALUE;
            for (int i=0; i<n; i++){
                houses[i] = new House(scanner.nextInt(),scanner.nextInt(), scanner.nextInt());
                if (houses[i].price < min_house_price)
                    min_house_price = houses[i].price;
            }

            int min_car_price = Integer.MAX_VALUE;
            for (int i=0; i<m; i++){
                cars[i] = new Car(scanner.nextInt(),scanner.nextInt());
                if (cars[i].price < min_car_price)
                    min_car_price = cars[i].price;
            }

            if (b < min_car_price+min_house_price) {
                System.out.println(0);
                continue;
            }

            Arrays.sort(houses, new Comparator<House>() {
                @Override
                public int compare(House o1, House o2) {
                    int temp1 = Math.abs(o1.area*10-o1.dist);
                    int temp2 = Math.abs(o2.area*10 - o2.dist);
                    return temp2 - temp1;
                }
            });

            Arrays.sort(cars, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    if (o1.speed == o2.speed){
                        return o1.price - o2.price;
                    }
                    return o2.speed - o1.speed;
                }
            });

            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int i= 0 ;i< n; i++){
                if (count == 3)
                    break;
                for (int j= 0; j<m;j++){
                    int sum_price = houses[i].price + cars[j].price;
                    if (sum_price <= b) {
                        int time = houses[i].dist / cars[j].speed;
                        int temp = 10 * houses[i].area - time;
                        if (temp > max)
                            max = temp;

                        count++;
                        break;
                    }
                }
            }

            System.out.println(max);

        }
    }
}
class House{
    int area;
    int dist;
    int price;
    public House(int area, int dist, int price){
        this.area = area;
        this.dist = dist;
        this.price = price;
    }
}
class  Car{
    int speed;
    int price;
    public Car(int speed, int price){
        this.speed = speed;
        this.price = price;
    }
}