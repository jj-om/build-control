/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package negocio_enums;

/**
 *
 * @author rocha
 */
public enum TipoMaterialNegocio {
    CEMENTO(UnidadBaseNegocio.KILOGRAMO),
    ARENA(UnidadBaseNegocio.METRO_CUBICO),
    GRAVA(UnidadBaseNegocio.METRO_CUBICO),
    LADRILLO(UnidadBaseNegocio.PIEZA),
    CLAVO(UnidadBaseNegocio.PIEZA),
    PINTURA(UnidadBaseNegocio.LITRO),
    MADERA(UnidadBaseNegocio.METRO),
    RESINA(UnidadBaseNegocio.LITRO);
    
    private UnidadBaseNegocio unidad;

    private TipoMaterialNegocio(UnidadBaseNegocio unidad) {
        this.unidad = unidad;
    }

    public UnidadBaseNegocio getUnidad() {
        return unidad;
    }
    
    
}
