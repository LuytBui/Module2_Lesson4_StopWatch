import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Viết chương trình đo thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số.
        // Tạo mảng 100000 float random từ 0-100;
        // Tạo đối tượng StopWatch
        // chạy sort() cho mảng
        // dừng stopWatch, tính thời gian

        final int ARRAY_SIZE = 100000;
        final int TEST_SIZE = 100;
        final double BOUND = 100;
        StopWatch stopWatch = new StopWatch();

        long initArrayTimeTotal = 0;
        long sortArrayTimeTotal = 0;

        for (int i = 1; i <= TEST_SIZE; i++) {
            double[] arr = new double[ARRAY_SIZE];

            System.out.printf("Lần chạy %d:\n", i);
            stopWatch.start();
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Math.random() * BOUND;
            }
            stopWatch.stop();
            long initArrayTime = stopWatch.getElapsedTime();
            initArrayTimeTotal += initArrayTime;
            System.out.printf("  - Thời gian khởi tạo mảng chứa %d số thực: %d ms\n", ARRAY_SIZE, initArrayTime);

            stopWatch.start();
            Arrays.sort(arr);
            stopWatch.stop();
            long sortArrayTime = stopWatch.getElapsedTime();
            sortArrayTimeTotal += sortArrayTime;
            System.out.printf("  - Thời gian chạy hàm sắp xếp mảng: %d ms\n", sortArrayTime);
        }

        long initArrayTimeAverage = initArrayTimeTotal / TEST_SIZE;
        long sortArrayTimeAverage = sortArrayTimeTotal / TEST_SIZE;

        System.out.printf("*** Khởi tạo %d lần test ngẫu nhiên\n", TEST_SIZE);
        System.out.printf("*** Thời gian trung bình để khởi tạo mảng chứa %d số thực: %d ms\n", ARRAY_SIZE, initArrayTimeAverage);
        System.out.printf("*** Thời gian trung bình để chạy hàm sắp xếp mảng: %d ms\n", sortArrayTimeAverage);

    }
}
