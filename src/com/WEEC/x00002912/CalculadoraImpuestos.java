package com.WEEC.x00002912;

public final class CalculadoraImpuestos {
    private static double totalRenta = 0, totalISSS = 0, totalAFP = 0;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado empleado) {
        double salarioNeto = 0, salarioBruto = 0, salarioAntesRenta = 0, descAFP = 0, descISSS = 0, descRenta = 0;

        salarioBruto = empleado.getSalario();

        if (empleado instanceof PlazaFija) {

            descAFP = 0.0625 * salarioBruto;
            descISSS = 0.03 * salarioBruto;
            salarioAntesRenta = salarioBruto - descAFP - descISSS;
            if (salarioAntesRenta >= 0.01 && salarioAntesRenta <= 472) {
                descRenta = 0;
            } else if (salarioAntesRenta >= 472.01 && salarioAntesRenta <= 895.24) {
                descRenta = 0.1 * (salarioAntesRenta - 472) + 17.67;
            } else if (salarioAntesRenta >= 895.25 && salarioAntesRenta <= 2038.10) {
                descRenta = 0.2 * (salarioAntesRenta - 895.24) + 60;
            } else if (salarioAntesRenta >= 2038.11) {
                descRenta = 0.3 * (salarioAntesRenta - 2038.10) + 288.57;
            }
            totalAFP += descAFP;
            totalISSS += descISSS;
            totalRenta += descRenta;
            salarioNeto = salarioAntesRenta - descRenta;
        } else if (empleado instanceof ServicioProfesional) {
            descRenta = salarioBruto * 0.1;
            totalRenta += descRenta;
            salarioNeto = salarioBruto - descRenta;
        }

        return salarioNeto;
    }

    public static String mostrarTotales() {
        String totales = "";
        totales="Total Renta= " + totalRenta + "\nTotal AFP= " + totalAFP + "\nTotal ISSS= "+totalISSS;
        return totales;
    }


}
