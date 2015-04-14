package poker;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Manos {

    List<Mano> manos;

    public void encontrarGanador() {
        for (Mano m : manos) {
            m.clasificar();
        }
        
    }

}
