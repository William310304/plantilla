package controller;

import javax.swing.table.DefaultTableModel;

public class SedeDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getSede() {
		db.Sentencia("call sp_getSedes()");
		return db.getDefaultTableModel();
	}

}
