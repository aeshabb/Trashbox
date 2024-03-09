
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        short[] c1 = new short[18];

        for (short i = 20; i > 2; i--) {
            c1[20-i] = i;
        }
        double[] x = new double[14];
        double min = -8;
        double max = 15;

        for (int i = 0; i < 14; ++i) {
            double num = min + random() * (max - min);
            x[i] = num;
        }
        double[][] c = new double[18][14];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 14; j++) {
                if (c1[i] == 3) {
                    c[i][j] = pow((sin(asin((x[j] + 3.5) / 23))), (pow(2 * 2 * x[j], 3) / 2));
                } else if (c1[i] == 5 | c1[i] == 9 | c1[i] == 12 | c1[i] == 13 | c1[i] == 15 | c1[i] == 16 | c1[i] == 17 | c1[i] == 18 | c1[i] == 19) {
                    c[i][j] = tan(pow(x[j], ((double) 1 / 3))) / 2;
                } else {
                    c[i][j] = asin(pow(E, pow((-pow((pow(2 * abs(x[j]), 2)), (double) 1 / 2)), (double) 1 / 3)));
                }
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 14; j++) {
                if (c[i][j] > 10000) {
                    System.out.printf("%.2e", c[i][j]);
                    System.out.print(" ");
                } else {
                    System.out.printf("%.2f", c[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println("\n");
        }
    }
}