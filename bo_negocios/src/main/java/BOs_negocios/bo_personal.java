/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs_negocios;

/**
 * @author Alejandra Garcia 252444
 * @author Isabel Valenzuela 253301
 * @author Ximena Rosales 253088
 * @author Dario Cortez 252267
 * @author Jesús Osuna 240549
 */
public class bo_personal {
    public static bo_personal personalBO;
    
    public static bo_personal getInstance() {
        if (personalBO == null) {
            personalBO = new bo_personal();
        }
        return personalBO;
    }
    /*public List<Strign> obtenerPersonalObra(Long idObra){
        List<String> personal = new ArrayList<>();
        
        personal
    }*/
}
