package controller;

import javax.swing.table.DefaultTableModel;

public class DepartamentoDAO {
	db.Db db = new db.Db("planilla");

	public DefaultTableModel getDepartamento() {
		db.Sentencia("call sp_getDepartamentos()");
		return db.getDefaultTableModel();
	}

	public void nuevoDepartamento(int _id, String detalle, String cuenta) {
		String sql = String.format("call sp_GuardarDepartamento(%d,'%s','%s')", _id, detalle, cuenta);
		db.Sentencia(sql);
		db.ExecuteQuery();
		System.out.println("Se agrego nuevo departamento ID : " + _id + " DEPARTAMENTO -> " + detalle+" CUENTA -> " + cuenta);
	}

}
