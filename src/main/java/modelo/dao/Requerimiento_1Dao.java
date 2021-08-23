package modelo.dao;
import java.util.ArrayList;
import java.sql.*;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        ArrayList<Requerimiento_1Vo> respuesta = new ArrayList<>();
        
        String consulta = "SELECT id_Lider, Salario, Ciudad_Residencia" 
                        + " FROM Lider" 
                        + " WHERE salario>(SELECT MIN (Salario) FROM Lider) and Ciudad_Residencia = 'Barranquilla'" 
                        + " ORDER BY Salario ASC;";
        try(Connection conex = JDBCUtilities.getConnection();
            PreparedStatement statement = conex.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();){
            while (resultado.next()){
                var requerimiento1 = new Requerimiento_1Vo();
                requerimiento1.setId_Lider(resultado.getInt("id_Lider"));
                requerimiento1.setSalario(resultado.getInt("Salario"));
                requerimiento1.setC_residencia(resultado.getString("Ciudad_Residencia"));
                respuesta.add(requerimiento1);
            }
        }    
        return respuesta;
    }   
}
