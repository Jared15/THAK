package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Andres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EscaleraReal er = new EscaleraReal();
        List<Carta> cartas;
        for(int i=2;i<15-5;i++){
            for(int j=i+1;j<15-3;j++){
                for(int k=j+1;k<15-2;k++){
                    for(int l=k+1;l<15-1;l++){
                        for(int m=l+2;m<15;m++){
                            for(int n=0;n<4;n++){
                                cartas=new ArrayList<>();
                                Carta c=new Carta(i, Palo.values()[n]);
                                cartas.add(c);
                                c=new Carta(j, Palo.values()[n]);
                                cartas.add(c);
                                c=new Carta(k, Palo.values()[n]);
                                cartas.add(c);
                                c=new Carta(l, Palo.values()[n]);
                                cartas.add(c);
                                c=new Carta(m, Palo.values()[n]);
                                cartas.add(c);
                                Mano(cartas, er);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("temino");

    }

    private static void Mano(List<Carta> cartas, EscaleraReal er) {
        Mano mano = new Mano(cartas);
        if (er.clasificarMano(mano) != 5) {
            System.out.println(er.clasificarMano(mano));
            for (Carta c : cartas) {
                System.out.println(c.getValor() + " " + c.getValorPalo());
            }
            System.out.println("");
            System.out.println("");
        }
    }

}
