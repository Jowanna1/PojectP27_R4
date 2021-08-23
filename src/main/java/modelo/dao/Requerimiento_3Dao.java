package modelo.dao;
import java.util.ArrayList;
import java.sql.*;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        ArrayList<Requerimiento_3Vo> respuesta = new ArrayList<>();
        String consulta = "SELECT c.ID_Proyecto, c.Proveedor"
                        + " FROM compra c"
                        + " WHERE c.ID_Proyecto BETWEEN 120 AND 124;";
        try (Connection conex = JDBCUtilities.getConnection();
            PreparedStatement statement = conex.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();){
            while (resultado.next()) {
                var requerimiento3 = new Requerimiento_3Vo();
                requerimiento3.setId_proyecto(resultado.getInt("ID_proyecto"));
                requerimiento3.setProveedor(resultado.getString("Proveedor"));
                respuesta.add(requerimiento3);
            }
        }
        return respuesta;
    }  
}