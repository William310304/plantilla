package controller;

import javax.swing.table.DefaultTableModel;

public class CargoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getCargos() {
		db.Sentencia("call sp_getCargos()");
		return db.getDefaultTableModel();
	}

}
