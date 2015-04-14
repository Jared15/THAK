package poker;

/**
 *
 * @author Andres
 */
public interface Comparacion {

    public int clasificarMano(Mano mano);
    public int comparar(Mano mano1,Mano mano2);
}
