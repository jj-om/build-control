package bo;

import dto.HerramientaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class HerramientaBO {
    public static HerramientaBO instance;

    private HerramientaBO() {
    }

    public static HerramientaBO getInstance() {
        if (instance == null) {
            instance = new HerramientaBO();
        }
        return instance;
    }
    
    public List<HerramientaDTO> obtenerHerramientasObra(Long idObra) {
        // Lista mock de herramientas disponibles
        List<HerramientaDTO> herramientas = new ArrayList<>();
        
        herramientas.add(new HerramientaDTO("Martillo", "Truper", "M-20"));
        herramientas.add(new HerramientaDTO("Desarmador", "Stanley", "Phillips #2"));
        herramientas.add(new HerramientaDTO("Pinzas", "DeWalt", "Corte diagonal"));
        herramientas.add(new HerramientaDTO("Llave inglesa", "Irwin", "Ajustable 10\""));
        herramientas.add(new HerramientaDTO("Nivel", "Stabila", "Láser 360°"));
        herramientas.add(new HerramientaDTO("Cinta métrica", "Milwaukee", "25 pies"));
        herramientas.add(new HerramientaDTO("Serrucho", "Bahco", "Dientes finos"));
        herramientas.add(new HerramientaDTO("Taladro", "Bosch", "PSB 1800"));
        
        return herramientas;
    }
}
