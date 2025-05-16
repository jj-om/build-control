/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package dominio_enums;

/**
 *
 * @author rocha
 */
public enum TipoMaterialDatos {
    CEMENTO(UnidadBaseDatos.KILOGRAMO),
    ARENA(UnidadBaseDatos.METRO_CUBICO),
    GRAVA(UnidadBaseDatos.METRO_CUBICO),
    LADRILLO(UnidadBaseDatos.PIEZA),
    CLAVO(UnidadBaseDatos.PIEZA),
    PINTURA(UnidadBaseDatos.LITRO),
    MADERA(UnidadBaseDatos.METRO),
    RESINA(UnidadBaseDatos.LITRO)
    ;
    
    private UnidadBaseDatos unidad;

    private TipoMaterialDatos(UnidadBaseDatos unidad) {
        this.unidad = unidad;
    }

    public UnidadBaseDatos getUnidad() {
        return unidad;
    }
    
    
}
