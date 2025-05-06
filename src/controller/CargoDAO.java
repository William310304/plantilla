package controller;

import javax.swing.table.DefaultTableModel;

public class CargoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getCargos() {
		db.Sentencia("call sp_getCargos()");
		return db.getDefaultTableModel();
	}
	public void nuevoCargo(int id , String cargo){
		String sql = String.format("call sp_GuardarCargo(%d, '%s')", id, cargo);
		db.Sentencia(sql);
		db.ExecuteQuery();
		System.out.println("Se agrgo nuevo cargo ID : " +id+" CARGO -> "+cargo);
		
	}

}
