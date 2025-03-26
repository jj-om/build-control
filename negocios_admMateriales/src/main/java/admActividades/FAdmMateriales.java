package admActividades;

import BOs_negocios.bo_material;
import dto.MaterialDTO;
import dto.MaterialIngresadoDTO;
import dto.RecursoDTO;
import excepciones.AdmMaterialesException;
import excepciones.BOMaterialException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jesús Osuna 240549
 */

public class FAdmMateriales implements IAdmMateriales {
    private bo_material boMaterial;

    public FAdmMateriales() {
        this.boMaterial = new bo_material();
    }

    @Override
    public boolean registrarMateriales(List<MaterialIngresadoDTO> materialIngresado) throws AdmMaterialesException {
        return true;
    }

    @Override
    public List<RecursoDTO> obtenerRecursosObra() throws AdmMaterialesException {
        try {
            return boMaterial.obtenerRecursosObra();
        } catch (BOMaterialException e) {
            throw new AdmMaterialesException("Error al obtener los recursos: " + e.getMessage());
        }
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