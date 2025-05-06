package controller;

import javax.swing.table.DefaultTableModel;

public class CentroConstoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getCentroConsto() {
		db.Sentencia("call sp_getCentroCostos()");
		return db.getDefaultTableModel();
	}
	public void nuevoCentroCosto( int id, String detalle) {
		String sql = String.format("call sp_GuardarCentroCosto(%d, '%s')", id, detalle);
		db.Sentencia(sql);
		db.ExecuteQuery();
		System.out.println("Se agrgo nuevo cargo ID : " +id+" CARGO -> "+detalle);
	}

	
}
