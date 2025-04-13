/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admBitacora;

import bo.BitacoraBO;
import bo.HerramientaBO;
import bo.MaquinariaBO;
import bo.PersonalBO;
import bo.RecursoBO;
import admObraSeleccionada.FAdmObraSeleccionada;
import admObraSeleccionada.IAdmObraSeleccionada;
import dto.BitacoraDTO;
import dto.DetallesBitacoraDTO;
import dto.HerramientaDTO;
import dto.MaquinariaDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmBitacoraException;
import excepciones.AdmObraSeleccionadaException;
import excepciones.BOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ximena
 */
public class ControlAdmBitacora {
    private IAdmObraSeleccionada admObraSeleccionada;
    
    // BOs
    private BitacoraBO boBitacora;
    private HerramientaBO boHerramienta;
    private MaquinariaBO boMaquinaria;
    private PersonalBO boPersonal;
    private RecursoBO boRecurso;

    public ControlAdmBitacora() {
        this.admObraSeleccionada = new FAdmObraSeleccionada();
        
        this.boBitacora = BitacoraBO.getInstance();
        this.boHerramienta = HerramientaBO.getInstance();
        this.boMaquinaria = MaquinariaBO.getInstance();
        this.boPersonal = PersonalBO.getInstance();
        this.boRecurso = RecursoBO.getInstance();
    }
    
    // Métodos para bitácora
    public boolean registrarBitacora(DetallesBitacoraDTO detallesBitacoraDTO) throws AdmBitacoraException {
        try {
            Long idObra = null;
            
            try {
                idObra = admObraSeleccionada.obtenerSesion();
            } catch (AdmObraSeleccionadaException ex) {
                throw new AdmBitacoraException(ex.getMessage(), ex);
            }
            
            if (!validarDatosBitacora(detallesBitacoraDTO, idObra)) {
                throw new AdmBitacoraException("Datos de bitácora incompletos o inválidos");
            }

            // Validar materiales (si hay)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                validarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            // Registrar en el BO
            BitacoraDTO bitacoraDTO = new BitacoraDTO(LocalDate.now(), idObra);
            detallesBitacoraDTO.setBitacora(bitacoraDTO);
            BitacoraDTO bitacoraRegistrada = boBitacora.registrarBitacora(detallesBitacoraDTO);
            
            if (bitacoraRegistrada == null) {
                throw new AdmBitacoraException("Error al guardar la bitácora");
            }

            //Actualizar inventario (si hay materiales)
            if (detallesBitacoraDTO.getMaterialesIngresados() != null && !detallesBitacoraDTO.getMaterialesIngresados().isEmpty()) {
                restarRecursos(detallesBitacoraDTO.getMaterialesIngresados());
            }

            return true;
        } catch (AdmBitacoraException | BOException e) {
            throw new AdmBitacoraException("Error en sistema: " + e.getMessage());
        }
    }

    private boolean validarDatosBitacora(DetallesBitacoraDTO detallesBitacoraDTO, Long idObra) {
        return detallesBitacoraDTO != null
                && idObra != null
                && detallesBitacoraDTO.getActividades() != null
                && !detallesBitacoraDTO.getActividades().isEmpty();
    }

    public boolean validarBitacoraRegistrada() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            return boBitacora.validarBitacoraRegistrada(idObra);
        } catch (AdmObraSeleccionadaException ex) {
            throw new AdmBitacoraException("Fallo al validar la bitacora.");
        }
    }

    // Métodos para materiales
    public List<RecursoDTO> obtenerRecursosObra() throws AdmBitacoraException {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerSesion();

            // Obtiene el recurso de la obra mediante el BO
            List<RecursoDTO> recursos = boRecurso.obtenerRecursosObra(idObra);

            // Valida la lista de personal
            if (recursos == null || recursos.isEmpty()) {
                throw new AdmBitacoraException("No hay recursos asignados a la obra.");
            }

            return recursos;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }

    public boolean validarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            if (material.getCantidad() > material.getRecurso().getCantidad()) {
                throw new AdmBitacoraException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
        return true;
    }

    private void restarRecursos(List<MaterialIngresadoDTO> materialIngresado) throws AdmBitacoraException {
        try {
            // Obtener lista de los recursos de la obra
            List<RecursoDTO> recursosObra = obtenerRecursosObra();
            Long idObra;
            try {
                idObra = admObraSeleccionada.obtenerSesion();
            } catch (AdmObraSeleccionadaException ex) {
                throw new AdmBitacoraException("Fallo al obtener el id de la obra.");
            }
            // Para cada material ingresado para usarse, revisar los recursos dentro de la obra
            for (MaterialIngresadoDTO material : materialIngresado) {
                for (RecursoDTO recurso : recursosObra) {
                    // Si el nombre del material dentro del recurso y del recurso ingresado coindide, restarle la cantidad
                    if (recurso.getMaterial().getNombre().equals(material.getRecurso().getMaterial().getNombre())) {
                        // Si la cantidad que hay en los recursos es mayor o igual a la cantidad ingresada, se le resta y actualiza la cantidad de recursos
                        if (recurso.getCantidad() >= material.getCantidad()) {
                            Integer nuevoStock = recurso.getCantidad() - material.getCantidad();
                            boolean actualizado = boRecurso.actualizarCantidadRecurso(idObra, recurso.getMaterial().getNombre(), recurso.getMaterial().getUnidadPeso(), nuevoStock);
                            if (actualizado) {
                                return;
                            }
                        } else { // Sino se lanza excepción de que no hay stock
                            throw new AdmBitacoraException("No hay suficiente stock de " + recurso.getMaterial().getNombre() + " . Favor de registrar manualmente");
                        }
                    }
                }
            }
        } catch (BOException e) {
            throw new AdmBitacoraException("Fallo al restar los recursos de la obra.");
        }
    }

    // Métodos para herramientas y maquinaria
    // Falta que le llamen al subsistema para obtener id,  llamen al BO y validen
    public List<HerramientaDTO> obtenerHerramientasObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            List<HerramientaDTO> herramientas = boHerramienta.obtenerHerramientasObra(idObra);

            if (herramientas == null || herramientas.isEmpty()) {
                throw new AdmBitacoraException("No hay herramientas asignadas a esta obra");
            }

            return herramientas;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }

    public List<MaquinariaDTO> obtenerMaquinariaObra() throws AdmBitacoraException {
        try {
            Long idObra = admObraSeleccionada.obtenerSesion();
            List<MaquinariaDTO> maquinaria = boMaquinaria.obtenerMaquinariaObra(idObra);

            if (maquinaria == null || maquinaria.isEmpty()) {
                throw new AdmBitacoraException("No hay maquinaria asignada a esta obra");
            }

            return maquinaria;
        } catch (AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("Error al obtener obra: " + e.getMessage());
        }
    }

    // Métodos para personal
    public List<String> obtenerPersonalObra() throws AdmBitacoraException {
        try {
            // Obtiene el id mediante el subsistema
            Long idObra = admObraSeleccionada.obtenerSesion();

            // Obtiene el personal de la obra mediante el BO
            List<String> listaPersonal = boPersonal.obtenerPersonalObra(idObra);

            // Valida la lista de personal
            if (listaPersonal == null || listaPersonal.isEmpty()) {
                throw new AdmBitacoraException("No hay personal asignado a la obra.");
            }

            return listaPersonal;
        } catch (BOException | AdmObraSeleccionadaException e) {
            throw new AdmBitacoraException("No se pudo obtener el personal de la obra.");
        }
    }
}
