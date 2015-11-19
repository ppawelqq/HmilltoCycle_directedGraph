package pl.pjaneczek.utils;

import java.util.Arrays;
import pl.pjaneczek.service.PStrategy;
import pl.pjaneczek.service.VListener;

/**
 *
 * @author Paweł
 */
public class PermGen {

    private Object[] ele;
    private final Object[] initElements;
    private final VListener listener;

    /**
     * Konstruktor klasy generującej permutacje
     *
     * @param <T> typ
     * @param ele elementy permutacji
     * @param listener
     */
    public <T> PermGen(T[] ele, VListener<T> listener) {
        this.initElements = ele;
        this.listener = listener;
    }

    /**
     * Funkcja generująca wg wzorca strategii
     *
     * @param strat algorytm generujacy permnutacje
     */
    public void generate(PStrategy strat) {
        this.ele = Arrays.copyOf(initElements, initElements.length);
        strat.generate(ele, listener);
    }

}
