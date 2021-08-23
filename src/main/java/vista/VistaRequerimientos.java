package vista;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1() {
        try {
            var requerimiento1s = controlador.consultarRequerimiento1();
        
            for (Requerimiento_1Vo requerimiento_1Vo : requerimiento1s) {
                System.out.printf("%d %d %s %n", requerimiento_1Vo.getId_Lider(), requerimiento_1Vo.getSalario(), requerimiento_1Vo.getC_residencia());
            }
        
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
            
        }
    }
    public static void requerimiento2() {
        try {
            var requerimiento2s = controlador.consultarRequerimiento2();
        
            for (Requerimiento_2Vo requerimiento_2Vo : requerimiento2s) {
                System.out.printf("%d %s %s %n", requerimiento_2Vo.getId_proyecto(), requerimiento_2Vo.getNom_Material(), requerimiento_2Vo.getImportado());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }
    public static void requerimiento3() {
        try {
            var requerimiento3s = controlador.consultarRequerimiento3();
        
            for (Requerimiento_3Vo requerimiento_3Vo : requerimiento3s) {
                System.out.printf("%d %s %n", requerimiento_3Vo.getId_proyecto(), requerimiento_3Vo.getProveedor());
            }
        } catch (Exception e) {
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        }
    }
}
