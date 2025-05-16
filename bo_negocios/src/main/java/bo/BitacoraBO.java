package bo;

import dao.BitacoraDAO;
import dominio.Bitacora;
import dominio.DetallesBitacora;
import dto.BitacoraDTO;
import dto.DetallesBitacoraDTO;
import excepciones.BOException;
import excepciones.DAOException;
import mappers.BitacoraMapper;
import mappers.DetallesBitacoraMapper;

/**
 * Clase BitacoraBO
 *
 * Objeto de negocio (Business Object) que gestiona la lógica relacionada con
 * las bitácoras de obra en el sistema. Esta clase implementa el
 * patrón Singleton para garantizar una única instancia en toda la aplicación.
 * 
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class BitacoraBO {
    
    /**
     * Instancia única de la clase (patrón Singleton). Garantiza que solo exista
     * una instancia en toda la aplicación.
     */
    private static BitacoraBO instance;
    
    /**
     * DAO para bitácoras. Gestiona el acceso a los datos de
     * bitácoras en la persistencia.
     */
    private BitacoraDAO bitacoraDAO;


    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    private BitacoraBO() {
        this.bitacoraDAO = new BitacoraDAO();
    }

    /**
     * Método para obtener la instancia única de BitacoraBO (patrón Singleton).
     * Si no existe una instancia, la crea; de lo contrario, devuelve la
     * existente.
     *
     * @return La instancia única de BitacoraBO
     */
    public static BitacoraBO getInstance() {
        if (instance == null) {
            instance = new BitacoraBO();
        }
        return instance;
    }
    
    /**
     * Registra una nueva bitácora en el sistema.
     *
     * @param detallesBitacoraDTO Objeto que contiene todos los componentes de
     * la bitácora
     * @return El objeto BitacoraDTO con la información básica de la bitácora
     * registrada
     * @throws BOException Si ocurre un error durante el proceso de registro
     */
    public BitacoraDTO registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO) throws BOException {
        try {
            // Convertir DTO a entidad de dominio
            DetallesBitacora detallesBitacoraEntidad = DetallesBitacoraMapper.toEntity(detallesBitacoraDTO);
            
            Bitacora bitacoraRegistrada = bitacoraDAO.registrarBitacora(detallesBitacoraEntidad);
            
            return BitacoraMapper.toDTO(bitacoraRegistrada);
        } catch (DAOException ex) {
            throw new BOException("Error al registrar la bitácora: " + ex.getMessage());
        }
    }
    
    /**
     * Verifica si ya existe una bitácora registrada para una obra en la fecha
     * actual.
     *
     * @param idObra Identificador de la obra a verificar
     * @return true si ya existe una bitácora para hoy, false en caso contrario
     */
    public boolean validarBitacoraRegistrada(Long idObra) {
        return bitacoraDAO.validarBitacoraRegistrada(idObra);
    }
}

