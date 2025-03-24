package admActividades;

import dto.MaterialDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmMaterialesException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús Osuna 240549
 */

public class FAdmMateriales implements IAdmMateriales {

    public FAdmMateriales() {
    }

    @Override
    public boolean registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws AdmMaterialesException {
        return true;
    }

    @Override
    public List<RecursoDTO> obtenerRecursosObra() {
        // Crear lista para guardar los materiales
        List<RecursoDTO> listaRecursos = new ArrayList<>();
        
        MaterialDTO material1 = new MaterialDTO("Cemento", 50.0f, "Holcim", "kg");
        MaterialDTO material2 = new MaterialDTO("Arena", 100.0f, "Cemex", "kg");
        MaterialDTO material3 = new MaterialDTO("Varilla", 20.5f, "Ternium", "kg");
        MaterialDTO material4 = new MaterialDTO("Pintura Blanca", 4.0f, "Comex", "litros");
        MaterialDTO material5 = new MaterialDTO("Yeso", 25.0f, "Knauf", "kg");
        MaterialDTO material6 = new MaterialDTO("Clavos", 2.0f, "Truper", "kg");
        MaterialDTO material7 = new MaterialDTO("Madera", 30.0f, "Finsa", "kg");
        MaterialDTO material8 = new MaterialDTO("Adhesivo", 1.5f, "Resistol", "litros");
        
        // Instancias de RecursoDTO y añadiéndolas a la lista
        listaRecursos.add(new RecursoDTO(material1, 1));  // 100 unidades de cemento
        listaRecursos.add(new RecursoDTO(material2, 50));   // 50 unidades de arena
        listaRecursos.add(new RecursoDTO(material3, 200));  // 200 unidades de varilla
        listaRecursos.add(new RecursoDTO(material4, 10));   // 10 unidades de pintura blanca
        listaRecursos.add(new RecursoDTO(material5, 75));   // 75 unidades de yeso
        listaRecursos.add(new RecursoDTO(material6, 500));  // 500 unidades de clavos
        listaRecursos.add(new RecursoDTO(material7, 150));  // 150 unidades de madera
        listaRecursos.add(new RecursoDTO(material8, 25));   // 25 unidades de adhesivo
        
        return listaRecursos;
    }

    @Override
    public void validarRecurso(List<MaterialIngresadoDTO> materialIngresado) throws AdmMaterialesException {
        // Valida cada material elegido
        for (MaterialIngresadoDTO material : materialIngresado) {
            boolean recursoValido = true; // Cambiar a false para validar que no hay suficientes recursos en la obra
            if (!recursoValido) {
                throw new AdmMaterialesException("Cantidad de material en la obra insuficiente. Favor de registrar manualmente.");
            }
        }
    }
    
    
    
}
