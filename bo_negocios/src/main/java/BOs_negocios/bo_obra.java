package BOs_negocios;

import excepciones.BOException;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class bo_obra {
    public static bo_obra obraBO;
    
    public static bo_obra getInstance() {
        if (obraBO == null) {
            obraBO = new bo_obra();
        }
        return obraBO;
    }
    
    public boolean validarObraExiste(Long numero) throws BOException {
        return true;
    }
    
    public Long obtenerIdPorNumero(Long numero) throws Exception{
        return numero;
    }
}
