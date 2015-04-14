package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Mano {

    private int clasificacion;
    private List<Carta> cartas;

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Mano(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void OrdenarMano(String prioridad) {

        if (prioridad.equalsIgnoreCase("valor")) {
            Collections.sort(cartas, new ComparadorValor());
        }
        if (prioridad.equalsIgnoreCase("palo")) {
            Collections.sort(cartas, new ComparadorPalo());
        }
    }

    public int getTamano() {
        return cartas.size();
    }

    public int getValorCarta(int i) {
        return cartas.get(i).getValor();
    }

    public String[] getPalos() {
        return Carta.getPalos();
    }

    public int numCartas() {
        return cartas.size();
    }

    public String getPaloCarta(int i) {
        return cartas.get(i).getValorPalo();
    }
    
    public int mayorDistinto(List<Integer> valores){
        int mayor=0;
        for(Carta c:cartas){
            if(valores.contains(new Integer(c.getValor()))){
                if(mayor<c.getValor()){
                    mayor=c.getValor();
                }
            }
        }
        return mayor;
    }
    

    void clasificar() {
        EscaleraReal escalera = new EscaleraReal();
        clasificacion = escalera.clasificarMano(this);
    }

}
