package pl.pjaneczek.main;

import java.util.ArrayList;
import java.util.Arrays;
import pl.pjaneczek.algorytm.Algorytm;
import pl.pjaneczek.service.VListener;
import pl.pjaneczek.utils.AuxMethods;
import pl.pjaneczek.utils.PermGen;

/**
 *
 * @author Paweł
 */
public class MainClass {

    public static void main(String[] args) {

        int[] input = {
            0, 1, 0, 1,
            0, 0, 1, 1,
            0, 0, 0, 1,
            1, 0, 1, 0
        };
        int[][] macierzSa = AuxMethods.setAdjencyMatrix(input, 4);
        Integer[] V = {1, 2, 3, 4};
        VListener<Integer> listener = new VListener<Integer>() {
            ArrayList<Integer[]> hCycle = new ArrayList<Integer[]>();

            @Override
            public void action(Integer[] permutation) {
                int wart1;
                int wart2;
                Integer[] hamilltonCycle = new Integer[permutation.length];

                for (int m = 0; m < permutation.length; m++) {
                    boolean endPath = false;
                    wart1 = permutation[m];
                    if (m < permutation.length - 1) {
                        wart2 = permutation[m + 1];
                    } else {
                        wart2 = permutation[0];
                        endPath = true;
                    }
                    if ((macierzSa[wart1 - 1][wart2 - 1] == 1)) {
                        hamilltonCycle[m] = permutation[m];
                    } else {
                        return;
                    }
                    if (endPath && (hamilltonCycle.length == 4)) {
                        hCycle.add(hamilltonCycle);
                        System.out.println(Arrays.toString(hamilltonCycle));
                    }
                }
            }
        };

        PermGen perm = new PermGen(V, listener);
        perm.generate(new Algorytm());
    }

}
