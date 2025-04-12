package BOs_negocios;

import dto.BitacoraDTO;
import dto.DetallesBitacoraDTO;
import excepciones.BOException;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class bo_bitacora {
    public static bo_bitacora bitacoraBO;
    
    public static bo_bitacora getInstance() {
        if (bitacoraBO == null) {
            bitacoraBO = new bo_bitacora();
        }
        return bitacoraBO;
    }
    
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacora, Long idObra) throws BOException {
        System.out.println("Registrando bitácora para obra ID: " + idObra);
        System.out.println("Detalles: " + detallesBitacora);
        return true;
    }
    
    public boolean validarBitacoraRegistrada(Long idObra) {
        return true;
    }
}
