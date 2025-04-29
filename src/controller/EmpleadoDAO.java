package controller;

import db.Db;
import model.Empleado;

public class EmpleadoDAO {
    Db db = new Db("planilla");

    public boolean Login(Empleado empleado) {
        db.Sentencia(String.format( "call sp_getEmpleadoLogin('%s','%s')", empleado.getDni() , empleado.getPasswordd()));
        empleado.setRegistro( db.getRegistro());
        return empleado.getId() > 0;
    }

}
