package controller;

import javax.swing.table.DefaultTableModel;

public class CentroConstoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getCentroConsto() {
		db.Sentencia("call sp_getCentroCostos()");
		return db.getDefaultTableModel();
	}

}
