package pl.pjaneczek.algorytm;

import pl.pjaneczek.service.PStrategy;
import pl.pjaneczek.service.VListener;
import pl.pjaneczek.utils.AuxMethods;

/**
 *
 * @author Paweł
 */
public class Algorytm implements PStrategy {

    private Object[] ele;
    private VListener listener;

    @Override
    public <T> void generate(T[] ele, VListener<T> listener) {
        this.ele = ele;
        this.listener = listener;
        generate(ele.length - 1);
    }

    /**
     * Funkcja generująca permutacji grafu
     *
     * @param count licznik
     */
    public void generate(int count) {
        if (count == 0) {
            listener.action(ele);
        } else {
            for (int i = 0; i <= count; i++) {
                generate(count - 1);
                if (i < count) {
                    AuxMethods.swapPlace(ele, i, count);
                    AuxMethods.rev(ele, count - 1);
                }
            }
        }
    }

}
