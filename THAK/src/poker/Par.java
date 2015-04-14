package poker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Par implements Comparacion {
    private Comparacion siguiente;
    private int ignorado;
    private int valor;

    public Par() {
        siguiente=new CartaAlta();
    }

    
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIgnorado() {
        return ignorado;
    }

    public void setIgnorado(int ignorado) {
        this.ignorado = ignorado;
    }

    @Override
    public int clasificarMano(Mano mano) {
        mano.OrdenarMano("valor");
        int clasificacion = 9;
        int iguales = 1, mayorIguales = 0;
        for (int i = 1; i < mano.getTamano(); i++) {
            if (mano.getValorCarta(i) != ignorado) {
                if (mano.getValorCarta(i) == mano.getValorCarta(i - 1)) {
                    iguales++;
                } else {
                    if (iguales > mayorIguales) {
                        mayorIguales = iguales;
                        valor = mano.getValorCarta(i - 1);
                    }
                    iguales = 1;
                }
            }
        }
        if (iguales > mayorIguales) {
            mayorIguales = iguales;
            valor = mano.getValorCarta(mano.getTamano() - 2);
        }
        if (mayorIguales < 2) {
            clasificacion = siguiente.clasificarMano(mano);
        }

        return clasificacion;
    }

    @Override
    public int comparar(Mano mano1, Mano mano2) {
        if(mano1.getClasificacion()!=9){
            return siguiente.comparar(mano1, mano2);
        }
        clasificarMano(mano1);
        int valor1=valor;
        clasificarMano(mano1);
        int valor2=valor;
        int diferencia=valor1-valor2;
        if (diferencia!=0){
            return diferencia;
        }
        List<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(valor1);
        List<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(valor2);
        return mano1.mayorDistinto(lista1) - mano2.mayorDistinto(lista2);
        
    }

   

}
