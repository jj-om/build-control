/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Obra;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para gestionar las obras en la base de datos.
 * 
 * @author Alejandra García 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class ObraDAO {
    
    /**
     * Lista mock de obras existentes.
     */
    private final List<Obra> obras;

    /**
     * Constructor privado (patrón Singleton). Previene la creación de múltiples
     * instancias desde fuera de la clase.
     */
    public ObraDAO() {
        this.obras = new ArrayList<>();
        inicializarObrasMock();
    }
    
    /**
     * Inicializa datos de prueba para simular obras en la base de datos.
     */
    private void inicializarObrasMock() {
        Obra obra1 = new Obra(1L, "Camino de los Mayos #716", 500.0);
        obra1.setIdObra(1L); 
        
        Obra obra2 = new Obra(2L, "Camino de los Yaquis #623", 750.0);
        obra2.setIdObra(2L);
        
        Obra obra3 = new Obra(3L, "Vícam #314", 600.0);
        obra3.setIdObra(3L);

        obras.add(obra1);
        obras.add(obra2);
        obras.add(obra3);
    }
    
    /**
     * Verifica si una obra existe en el sistema según su número identificador.
     *
     * @param numero Número identificador de la obra a verificar
     * @return true si la obra existe, false en caso contrario
     * @throws DAOException Si ocurre un error durante la verificación
     */
    public boolean obraExiste(Long numero) throws DAOException {
        try {
            // Verificar si existe una obra con el número especificado
            for (Obra obra : obras) {
                if (obra.getNumero().equals(numero)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new DAOException("Error al validar si la obra existe.", e);
        }
    }
    
    /**
     * Obtiene el identificador interno (ID) de una obra a partir de su número
     * externo.
     *
     * En la implementación actual, simplemente retorna el mismo número como ID,
     * pero en una versión completa debería realizar la consulta a la base de
     * datos.
     *
     * @param numero Número externo o de referencia de la obra
     * @return El ID interno de la obra en el sistema
     * @throws DAOException Si ocurre un error durante la consulta
     */
    public Long obtenerIdPorNumero(Long numero) throws DAOException {
        // En esta implementación mock, simplemente devolvemos el mismo número
        // En la implementación real, se buscaría en la base de datos y se devuelve el ID 
        return numero;
    }
    
    /**
     * Obtiene la dirección física de una obra a partir de su ID.
     *
     * @param id Identificador interno de la obra
     * @return La dirección física de la obra
     * @throws DAOException Si ocurre un error durante la consulta
     */
    public String obtenerDireccionObra(Long id) throws DAOException {
        // Buscar la obra por ID y retornar su dirección
        for (Obra obra : obras) {
            if (obra.getNumero().equals(id)) {
                return obra.getDireccion();
            }
        }
        return null;
    }
    
    public Obra obtenerObra(Long id) throws DAOException {
        try {
            for (Obra obra : obras) {
                if (obra.getIdObra().equals(id)) {
                    return obra;
                }
            }
            
            return null;
        } catch (Exception e) {
            throw new DAOException("Error al obtener la obra.", e);
        }
    }
    
}
