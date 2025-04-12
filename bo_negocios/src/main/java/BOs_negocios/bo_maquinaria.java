package BOs_negocios;

import dto.MaquinariaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class bo_maquinaria {
    public static bo_maquinaria maquinariaBO;
    
    public static bo_maquinaria getInstance() {
        if (maquinariaBO == null) {
            maquinariaBO = new bo_maquinaria();
        }
        return maquinariaBO;
    }
    
    public List<MaquinariaDTO> obtenerMaquinaria(Long idObra) {
        // Lista mock de maquinaria disponible
        List<MaquinariaDTO> maquinaria = new ArrayList<>();
        
        maquinaria.add(new MaquinariaDTO("Excavadora", "Caterpillar", "CAT-320"));
        maquinaria.add(new MaquinariaDTO("Retroexcavadora", "John Deere", "JD-310"));
        maquinaria.add(new MaquinariaDTO("Compactadora", "Wacker Neuson", "VPG-155"));
        maquinaria.add(new MaquinariaDTO("Generador", "Honda", "EU70is"));
        maquinaria.add(new MaquinariaDTO("Planta de luz", "Cummins", "C1500D5"));
        maquinaria.add(new MaquinariaDTO("Montacargas", "Toyota", "8FGCU25"));
        maquinaria.add(new MaquinariaDTO("Vibrador de concreto", "Wacker", "IREN-38"));
        maquinaria.add(new MaquinariaDTO("Cortadora de concreto", "Husqvarna", "K-760"));
        
        return maquinaria;
    }
}
