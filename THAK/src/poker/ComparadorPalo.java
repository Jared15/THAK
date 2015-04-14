package poker;

import java.util.Comparator;

/**
 *
 * @author Andres
 */
public class ComparadorPalo implements Comparator {

    public int compare(Object o1, Object o2) {
        Carta c1 = (Carta) o1;
        Carta c2 = (Carta) o2;
        int comparacion = c1.getPalo().compareTo(c2.getPalo());
        if (comparacion != 0) {
            return comparacion;
        }
        if (c1.getValor() < c2.getValor()) {
            return -1;
        }
        if (c1.getValor() > c2.getValor()) {
            return 1;
        }
        return 0;

    }

}
