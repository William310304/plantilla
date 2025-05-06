package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Db {
	Connection cn = null;
	PreparedStatement ps = null;
	String _sql = null;
	String _ip="localHost",_port="3306",_USER="root",_PASSWORD="1234",_DB=null,_SQL=null;
	
	
    public Db(String db) {
    	this._DB = db;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",_ip,_port,_DB),_USER,_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }

    public void Sentencia(String sql) {
    	if(cn == null) return;
    	this._sql = sql;
    	try {
//			ps = cn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.FETCH_REVERSE);
			ps = cn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public int ExecuteQuery(){
		try {
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return -1;	
	}

    public String[] getRegistro() {
        
    	if(cn ==null || ps == null) return null;
    	 try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				var aRegistro = new String [rs.getMetaData().getColumnCount()];
				for (int  i= 0, columnas = aRegistro.length; i < columnas;i++) {
					aRegistro[i] = rs.getString(i+1);
				}
				rs.close();
				return aRegistro;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 return null;
    }

	public DefaultTableModel getDefaultTableModel() {
		if(cn ==null || ps == null) return null;
	   	 try {
				ResultSet rs = ps.executeQuery();
				var rsmd = rs.getMetaData();
				int columnas = rsmd.getColumnCount();
				
				String[] aRegistros = new String[columnas];
				// var modelo = new DefaultTableModel();
				DefaultTableModel modelo = new DefaultTableModel() {
					private static final long serialVersionUID = 1L;
					
					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
				};

				for (int i = 0; i < columnas; i++) 
					modelo.addColumn(rsmd.getColumnName(i + 1));
				
				while(rs.next( )) {
					for(int i = 0;i < columnas;i++) 
						aRegistros[i] = rs.getString(i+1);
					modelo.addRow(aRegistros);
				}
				rs.close();
				return modelo;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   	 return null;
	}

}
