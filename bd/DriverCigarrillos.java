package bd;

import java.sql.*;
import javax.swing.*;

public class DriverCigarrillos {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Obtenemos la conexión a nuestra base de datos
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cigarrillos", "root" , "");
			
			// 2. Creamos las declaraciones
			myStmt = myConn.createStatement();
			
			// 3. Ejecutamos las consultas			
			//myStmt.executeUpdate("INSERT INTO `gzz_pais` (`PaiCod`,`PaiDes`,`PaiEstReg`)  VALUES ('51','Perú','A');");
			//myStmt.executeUpdate("INSERT INTO `v1m_fabricantes` (`FabCod`,`FabNom`,`PaiCod`)  VALUES ('1004','Hamilton','51');");
			//myStmt.executeUpdate("UPDATE v1m_fabricantes SET FabNom = 'Marlboro' WHERE FabCod=1004;");
			myRs = myStmt.executeQuery("SELECT * FROM v1m_fabricantes;");			
			//int rowsAffected = myStmt.executeUpdate("DELETE FROM v1m_fabricantes WHERE FabCod=1004;");
			//int rowsAffected = myStmt.executeUpdate("DELETE FROM gzz_pais WHERE PaiCod=51;");
			//System.out.println("Lineas borradas: "+ rowsAffected);
			//System.out.println("Borrado Completo");
			// 4. Procesamos el resultado por consola
			System.out.println("v1m_fabricantes");
			while (myRs.next()) {				
				System.out.println(myRs.getString("FabCod") + 
						", " + myRs.getString("FabNom")+ 
						", "+myRs.getString("PaiCod") );
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
		
	}

}
