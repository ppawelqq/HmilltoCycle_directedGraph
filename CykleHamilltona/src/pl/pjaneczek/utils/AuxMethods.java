package pl.pjaneczek.utils;

/**
 *
 * @author Paweł
 */
public class AuxMethods {

    /**
     * Funkcja tworząca z wprowadzonych danych macierz sąsiedztwa grafu
     *
     * @param inputData dane wejsciowe
     * @param size rozmiar macieerzy
     *
     * @return macierz sasiedztwa
     */
    public static int[][] setAdjencyMatrix(int[] inputData, int size) {
        int adjencyMatrix[][] = new int[size][size];
        int len = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjencyMatrix[i][j] = inputData[len];
                len++;
            }
        }
        return adjencyMatrix;
    }

    /**
     * Funckja sprawdzająca poprawnośc permutacji wg cyklu Hamilltona w grafie skierowanym
     *
     * @param permutation permutacja
     * @param adjencyMatrix macierz sąsiedztwa
     * @return cykl Hamilltona
     */
    public static Integer[] checkPermutation(Integer[] permutation, int[][] adjencyMatrix) {
        int wart1;
        int wart2;
        Integer[] hamilltonCycle = new Integer[permutation.length];

        for (int m = 0; m < permutation.length; m++) {
            wart1 = permutation[m];
            if (m < permutation.length - 1) {
                wart2 = permutation[m + 1];
            } else {
                wart2 = permutation[0];
            }
            if (!(adjencyMatrix[wart1 - 1][wart2 - 1] == 1)) {
                System.out.println("Nie jest cyklem Hamilltona: " + permutation);
                break;
            }
        }
        hamilltonCycle = permutation;
        return hamilltonCycle;
    }

    /**
     * Funckja obsługująca zdarzenie zamiany miejsc
     *
     * @param ele tablica obiektów
     * @param srcId indeks początkowy
     * @param destId indeks końcowy
     */
    public static void swapPlace(Object[] ele, int srcId, int destId) {
        Object tmp = ele[srcId];
        ele[srcId] = ele[destId];
        ele[destId] = tmp;
    }

    /**
     * Funkcja odwracająca kolejnośc elementów
     *
     * @param ele tablica elementów
     * @param count licznik
     */
    public static void rev(Object[] ele, int count) {
        int i = 0;
        int j = count;
        while (i < j) {
            swapPlace(ele, i, j);
            i++;
            j--;
        }
    }
}
