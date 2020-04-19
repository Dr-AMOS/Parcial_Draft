package com.WEEC.x00002912;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla= new ArrayList<Empleado>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(Empleado emp){
        planilla.add(emp);

    }

    public void quitEmpleado(String empname) throws notFoundEmpleado{
//        planilla.removeIf(obj -> {
//            if(obj.nombre == empname){
//                return true;
//            }
//            else{
//                throw new notFoundEmpleado("Empleado no existe en el sistema");
//                return false;
//            }
//        });

        Empleado aux = null;

        for(Empleado emp : planilla){
            if(emp.getNombre().equals(empname))
                aux = emp;
        }

        if(aux != null) {
            planilla.remove(aux);
        }
        else
            throw new notFoundEmpleado("Empleado no existe en el sistema. No es posible despedir.");
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "planilla=" + planilla +
                '}';
    }
}
