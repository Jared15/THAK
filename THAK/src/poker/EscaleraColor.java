package poker;

/**
 *
 * @author Andres
 */
public class EscaleraColor implements Comparacion {

    private Comparacion siguiente;

    public EscaleraColor( ) {
        this.siguiente = new Poker();
    }

    public Comparacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Comparacion siguiente) {
        this.siguiente = siguiente;
    }

    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("valor"); //ordenar cartas para una facil comparacion    

        int clasificacion = 2;
        String[] palos = mano.getPalos();
        int i = 1, largo = 1, mayor = 0;
        while (i < mano.numCartas()) {
            if (mano.getValorCarta(i) == mano.getValorCarta(i - 1) + 1) {
                if (mano.getPaloCarta(i).equalsIgnoreCase(mano.getPaloCarta(i - 1))) {
                    largo++;
                } else {
                    if (largo > mayor) {
                        mayor = largo;
                    }
                    largo = 1;
                }

            } else {
                if (largo > mayor) {
                    mayor = largo;
                }
                largo = 1;
            }
            i++;
        }
        if (largo > mayor) {
            mayor = largo;
        }
        if (mayor < 5) { //no es escalera de color
            clasificacion = siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=2){
            return siguiente.comparar(mano1, mano2);
        }
        return 0;
    }

    
    
}
