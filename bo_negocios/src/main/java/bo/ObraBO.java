package bo;

import excepciones.BOException;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */

public class ObraBO {
    public static ObraBO instance;

    private ObraBO() {
    }

    public static ObraBO getInstance() {
        if (instance == null) {
            instance = new ObraBO();
        }
        return instance;
    }
    
    public boolean validarObraExiste(Long numero) throws BOException {
        return true;
    }
    
    public Long obtenerIdPorNumero(Long numero) throws Exception{
        return numero;
    }
    
    public String obtenerDireccionObra(Long id) throws Exception{
        return "Camino de los Mayos #716";
    } 
}