package pl.pjaneczek.service;

/**
 *
 * @author Paweł
 */
public interface PStrategy {

    public <T> void generate(T[] elements, VListener<T> listener);
}
