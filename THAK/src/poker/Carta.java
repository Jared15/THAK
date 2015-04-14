package poker;

/**
 *
 * @author Andres
 */
public class Carta {

    private int valor;
    private Palo palo;

    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public String getValorPalo() {
        return palo.toString();
    }

    static String[] getPalos() {
        Palo[] valores = Palo.values();
        String[] palos = new String[valores.length];
        for (int i = 0; i < valores.length; i++) {
            palos[i] = valores[i].toString();
        }
        return palos;
    }
}
