package bd;

import java.sql.*;

public class DriverCurriculum {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Obtenemos la conexión a nuestra base de datos
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcurriculum2", "root" , "");
			
			// 2. Creamos las declaraciones
			myStmt = myConn.createStatement();
			
			// 3. Ejecutamos las consultas
			//myStmt.executeUpdate("INSERT INTO persona (`DNI`,`Apellido`,`Nombre`,`Dirección`,`Telefono`) VALUES ('73050183','Macedo','Alexis','Lima 1713','9994798');");
			//myStmt.executeUpdate("UPDATE persona SET Dirección = 'La Paz 503' WHERE DNI=73050182;");
			//myRs = myStmt.executeQuery("SELECT * FROM persona where Apellido='Macedo';");			
			//int rowsAffected = myStmt.executeUpdate("DELETE FROM v1m_fabricantes WHERE FabCod=1004;");
		
			int rowsAffected = myStmt.executeUpdate("DELETE FROM persona WHERE Apellido='Macedo';");
			System.out.println("Lineas borradas: "+ rowsAffected);
			System.out.println("Borrado Completo");
			
			// 4. Procesamos el resultado por consola
			/*System.out.println("Persona");
			while (myRs.next()) {				
				System.out.println(myRs.getString("DNI") + 
						", " + myRs.getString("Apellido")+ 
						", " + myRs.getString("Nombre")+
						", " + myRs.getString("Dirección")+
						", "+myRs.getString("Telefono") );
			}*/
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
