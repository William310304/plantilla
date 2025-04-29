package controller;

import javax.swing.table.DefaultTableModel;

public class DepartamentoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getDepartamento() {
		db.Sentencia("call sp_getDepartamentos()");
		return db.getDefaultTableModel();
	}

}
