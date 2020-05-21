package performance.cpu;

import java.util.Arrays;
import java.util.Objects;

public class TraverseArray {

    public static final String I_MODEL = "-i";
    public static final String J_MODEL = "-j";
    public static final Integer LENGTH = 4096;

    public static void main(String[] args) {
        Boolean iModel = Arrays.asList(args).stream().anyMatch(arg -> Objects.equals(arg, I_MODEL));
        Boolean jModel = Arrays.asList(args).stream().anyMatch(arg -> Objects.equals(arg, J_MODEL));
        if (iModel) {
            traverseArrayWithIModel();
        } else if (jModel) {
            traverseArrayWithJModel();
        }
    }

    private static void traverseArrayWithIModel() {
        char [][]arr = new char[LENGTH][LENGTH];
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < LENGTH; i++) {
            for(int j = 0; j < LENGTH; j++) {
                //arr[i][j]是连续访问的
                arr[i][j] = 0;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("I model traverse array consuming time " + (endTime - startTime));
    }

    private static void traverseArrayWithJModel() {
        char [][]arr = new char[LENGTH][LENGTH];
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < LENGTH; i++) {
            for(int j = 0; j < LENGTH; j++) {
                //arr[j][i]不是连续访问的
                arr[j][i] = 0;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("J model traverse array consuming time " + (endTime - startTime));
    }
}
