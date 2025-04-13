package bo;

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

public class BitacoraBO {
    private static BitacoraBO instance;

    private BitacoraBO() {
    }

    public static BitacoraBO getInstance() {
        if (instance == null) {
            instance = new BitacoraBO();
        }
        return instance;
    }
    
    public BitacoraDTO registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO) throws BOException {
        return detallesBitacoraDTO.getBitacora();
    }
    
    public boolean validarBitacoraRegistrada(Long idObra) {
        // Cambiar valor para probar error de bitácora ya registrada
        return false;
    }
}
