package modelo.dao;
import java.sql.*;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        ArrayList<Requerimiento_2Vo> respuesta = new ArrayList<>();
        String consulta = "SELECT p.ID_Proyecto, mc.Nombre_Material, mc.Importado"
        + " FROM Proyecto p JOIN Compra c ON(p.ID_Proyecto=c.iD_Proyecto)"
        + " JOIN MaterialConstruccion mc ON(c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion)"
        + "WHERE c.ID_Proyecto IN (1,184,400)" 
        + " ORDER BY p.ID_Proyecto ASC;";
        try (Connection conex = JDBCUtilities.getConnection();
            PreparedStatement statement = conex.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();){
            while (resultado.next()) {
                var requerimiento2 = new Requerimiento_2Vo();
                requerimiento2.setId_proyecto(resultado.getInt("id_Proyecto"));
                requerimiento2.setNom_Material(resultado.getString("Nombre_Material"));
                requerimiento2.setImportado(resultado.getString("Importado"));
                respuesta.add(requerimiento2);
            }
        }
        return respuesta;
    }
}