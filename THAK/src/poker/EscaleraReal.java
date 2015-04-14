package poker;

import java.util.List;

/**
 *
 * @author Andres
 */
public class EscaleraReal implements Comparacion {
    
    private Comparacion siguiente;
    
    public EscaleraReal() {
        this.siguiente = new EscaleraColor();
    }
    
    public Comparacion getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Comparacion siguiente) {
        this.siguiente = siguiente;
    }
    
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("palo"); //ordenar cartas para una facil comparacion           
        int valor = 10;
        int clasificacion = 1;
        String[] palos = mano.getPalos();
        int i = 0, j = 0, largo = 0, mayor = 0;
        while (i < mano.numCartas()) {
            if (palos[j].trim().equalsIgnoreCase(mano.getPaloCarta(i).trim())) {
                if (mano.getValorCarta(i) == valor) {
                    largo++;
                    i++;
                    valor++;
                } else {
                    valor = 10;
                    largo = 0;
                    if (mano.getValorCarta(i) != valor) {
                        i++;
                    }
                    
                    if (largo > mayor) {
                        mayor = largo;
                    }
                }
            } else {
                valor = 10;
                largo = 0;
                if (largo > mayor) {
                    mayor = largo;
                }
                j++;
            }
        }
        if (largo > mayor) {
            mayor = largo;
        }
        if (mayor < 5) { //no es escalera real
            clasificacion = siguiente.clasificarMano(mano);
        }
        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=1){
            return siguiente.comparar(mano1, mano2);
        }
        return 0;
    }

    

    
}
