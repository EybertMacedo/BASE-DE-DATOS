package bd;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Scrollbar;
import javax.swing.JTable;

public class Regswing {

	JFrame frmCigarrillosCrud;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblPaises;
	private JPanel panel_4;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnInactivar;
	private JButton btnNewButton_4;
	private JButton btnInactivar_1;
	private JButton btnInactivar_2;
	private JLabel lblCdigo;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblDescripcin_1;
	private JPanel panel_7;
	private JLabel lblEstadoRegistro;
	private JTable table;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regswing window = new Regswing();
					window.frmCigarrillosCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Regswing() throws SQLException {
		
		initialize();
	}

	private void initialize() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/db_cigarrillos";
		String username = "root";
		String password = "";
		
		frmCigarrillosCrud = new JFrame();
		frmCigarrillosCrud.setTitle("CIGARRILLOS - CRUD - JBDC");
		frmCigarrillosCrud.getContentPane().setBackground(SystemColor.activeCaption);
		frmCigarrillosCrud.getContentPane().setForeground(Color.WHITE);
		frmCigarrillosCrud.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registro de Regiones"));
		panel.setBounds(10, 56, 541, 99);
		frmCigarrillosCrud.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 21, 169, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 46, 169, 14);
		panel.add(lblDescripcin);
		
		JLabel lblEstadoDeRegistro = new JLabel("Estado de registro");
		lblEstadoDeRegistro.setBounds(10, 71, 164, 14);
		panel.add(lblEstadoDeRegistro);
		
		textField = new JTextField();
		textField.setBounds(189, 18, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 43, 314, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 68, 28, 20);
		panel.add(textField_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Tabla_Regiones"));
		panel_1.setBounds(10, 166, 541, 209);
		frmCigarrillosCrud.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 21, 2, 2);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 21, 521, 177);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 521, 22);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(0, 0, 177, 22);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 0, 157, 22);
		panel_5.add(lblCdigo);
		lblCdigo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCdigo.setBackground(SystemColor.activeCaption);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setLayout(null);
		panel_6.setBounds(177, 0, 169, 22);
		panel_3.add(panel_6);
		
		lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDescripcin_1.setBackground(SystemColor.activeCaption);
		lblDescripcin_1.setBounds(10, 0, 130, 22);
		panel_6.add(lblDescripcin_1);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setLayout(null);
		panel_7.setBounds(344, 0, 177, 22);
		panel_3.add(panel_7);
		
		lblEstadoRegistro = new JLabel("Estado Registro");
		lblEstadoRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEstadoRegistro.setBackground(SystemColor.activeCaption);
		lblEstadoRegistro.setBounds(10, 0, 142, 22);
		panel_7.add(lblEstadoRegistro);
		
		JTable table = new JTable() {
	         public Component prepareRenderer(TableCellRenderer renderer, 
	                 int row, int column ) 
	                 {
	                    Component c = super.prepareRenderer(renderer, row, column);	                    
	                    JLabel label = (JLabel) c;
	                    label.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 0));
	                    
	                    Color color1 = new Color(176, 178, 181);
	                    Color color2 = Color.WHITE;
	                    Color color3 = new Color(198, 202, 207);
	                    	                    
	                    boolean isInactive=getValueAt(row, 2).toString().equals("I");	                   
	                    if(isInactive) {	                    	   
	                    	c.setForeground(color3);	                    	                   	
                     }else c.setForeground(Color.BLACK);	
	                    
	                    if(!c.getBackground().equals(getSelectionBackground())) {
	                       Color coleur = (row % 2 == 0 ? color1 : color2);
	                       c.setBackground(coleur);	                       	                       
	                       coleur = null;
	                    }	     
	                    
	                    super.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	                    
	                    return c;
	                 }
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		table.setBackground(Color.WHITE);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setBounds(10, 33, 501, 108);
		panel_2.add(table);
		try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM gzz_region;");	
			while(myRs.next()) {
				String RegCod=myRs.getString("RegCod");
				String RegDes=myRs.getString("RegDes");
				String RegEstReg=myRs.getString("RegEstReg");
								
				String []tbData= {RegCod,RegDes,RegEstReg};						
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				tblModel.addRow(tbData);					
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	String TablaCod = table.getModel().getValueAt(row, 0).toString();
		        	String TablaDes = table.getModel().getValueAt(row, 1).toString();
		        	String TablaEstReg = table.getModel().getValueAt(row, 2).toString();
		        	textField.setText(TablaCod);
		        	textField_1.setText(TablaDes);
		        	textField_2.setText(TablaEstReg);
		        }
		    }
		});
		
		lblPaises = new JLabel("REGION");
		lblPaises.setBackground(SystemColor.activeCaption);
		lblPaises.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPaises.setBounds(10, 11, 169, 34);
		frmCigarrillosCrud.getContentPane().add(lblPaises);
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(10, 386, 541, 78);
		frmCigarrillosCrud.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RegCod = textField.getText();
				String RegDes = textField_1.getText();
				String RegEstReg = textField_2.getText();				
				if (!isInteger(RegCod)||RegCod.equals("")||RegDes.equals("")||RegEstReg.equals("")||(!RegEstReg.equals("I")&&!RegEstReg.equals("A"))) {
					JOptionPane.showMessageDialog(panel, "Datos erróneos");
				}else {
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("INSERT INTO `gzz_region` (`RegCod`, `RegDes`, `RegEstReg`)  VALUES ('"+RegCod+"','"+RegDes+"','"+RegEstReg+"');");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Añadido!");
				}
			}			
		});
		btnNewButton.setBounds(164, 11, 89, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 2;
				int row = table.getSelectedRow();
				String tablePaiEstReg = table.getModel().getValueAt(row, column).toString();
				if(tablePaiEstReg.equals("I")) {
					JOptionPane.showMessageDialog(panel, "El registro está inactivo, no se puede modificar");
				}else {
				column = 0;				
				row = table.getSelectedRow();
				String Regcodigo = table.getModel().getValueAt(row, column).toString();
				
				String RegCod = textField.getText();
				String RegDes = textField_1.getText();
				String RegEstReg = textField_2.getText();
										
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzz_region SET RegCod ='"+RegCod+"',RegDes ='"+RegDes+"',RegEstReg ='"+RegEstReg+"' WHERE RegCod = "+Regcodigo+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Modificado!");
			}
			}
		});
		btnNewButton_1.setBounds(44, 11, 89, 23);
		panel_4.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 2;
				int row = table.getSelectedRow();
				String tablePaiEstReg = table.getModel().getValueAt(row, column).toString();
				if(tablePaiEstReg.equals("I")) {
					JOptionPane.showMessageDialog(panel, "El registro está inactivo, no se puede eliminar");
				}else {
				int result = JOptionPane.showConfirmDialog(panel, "¿Deseas eliminar este registro?");
				switch (result) {
		         case JOptionPane.YES_OPTION:
		        	column = 0;
					row = table.getSelectedRow();
					String RegCod = table.getModel().getValueAt(row, column).toString();
					
		        	 try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
							Statement myStmt = myConn.createStatement();
							myStmt.executeUpdate("DELETE FROM gzz_region WHERE RegCod = '"+RegCod+"';");					
						} catch (SQLException e1) {
							e1.printStackTrace();
						}		        	 
		        	 JOptionPane.showMessageDialog(panel, "Registro eliminado");
		         break;
		         case JOptionPane.NO_OPTION:
		        	 JOptionPane.showMessageDialog(panel, "Registro no eliminado");
		         break;		         
		      }
			}
			}
		});
		btnNewButton_2.setBounds(284, 11, 89, 23);
		panel_4.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(panel, "¿Deseas salir del programa?");
				switch (result) {
		         case JOptionPane.YES_OPTION:
		        	 System.exit(0);
		         case JOptionPane.NO_OPTION:
		        	 break;
		     	}
			}
		});
		btnNewButton_3.setBounds(404, 45, 89, 23);
		panel_4.add(btnNewButton_3);
		
		btnInactivar = new JButton("Inactivar");
		btnInactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				String RegCod = table.getModel().getValueAt(row, column).toString();
				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzz_region SET RegEstReg ='I' WHERE RegCod = "+RegCod+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Inactivado!");
			}
		});
		btnInactivar.setBounds(44, 45, 89, 23);
		panel_4.add(btnInactivar);
		
		btnNewButton_4 = new JButton("Cancelar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				JOptionPane.showMessageDialog(panel, "Registros reestablecidos");
			}
		});
		btnNewButton_4.setBounds(404, 11, 89, 23);
		panel_4.add(btnNewButton_4);
		
		btnInactivar_1 = new JButton("Reactivar");
		btnInactivar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				String RegCod = table.getModel().getValueAt(row, column).toString();
				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzz_region SET RegEstReg ='A' WHERE RegCod = "+RegCod+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Activado!");
			}
		});
		btnInactivar_1.setBounds(164, 45, 89, 23);
		panel_4.add(btnInactivar_1);
		
		btnInactivar_2 = new JButton("Actualizar");
		btnInactivar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("SELECT * FROM gzz_region;");
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					tblModel.setRowCount(0);
					while(myRs.next()) {
						String RegCod=myRs.getString("RegCod");
						String RegDes=myRs.getString("RegDes");
						String RegEstReg=myRs.getString("RegEstReg");
						
						System.out.println(myRs.getString("RegCod") + 
								", " + myRs.getString("RegDes")+ 
								", "+myRs.getString("RegEstReg") );						
						String []tbData= {RegCod,RegDes,RegEstReg};	
						tblModel.addRow(tbData);					
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}						
			}						
		});		
		btnInactivar_2.setBounds(284, 45, 89, 23);
		panel_4.add(btnInactivar_2);
		frmCigarrillosCrud.setBounds(100, 100, 577, 514);
		frmCigarrillosCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
