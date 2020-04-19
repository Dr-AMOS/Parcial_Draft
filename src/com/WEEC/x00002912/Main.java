package com.WEEC.x00002912;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Empresa unaEmpresa = new Empresa("Daliam");
        String nombreEmpleado, puestoEmpleado;
        double salarioEmpleado;
        byte opTipoEmpleado = 0;
        //System.out.println(unaEmpresa.getNombre());
        String menu = "1. Agregar empleado\n" +
                "2. Despedir empleado\n" +
                "3. Ver empleados\n" +
                "4. Calcular sueldo\n" +
                "5. Mostrar totales\n" +
                "0. Salir";

        String menuadd = "Ingrese el número correspondiente al tipo de empleado que desea agregar\n" +
                "1. Servicio profesional\n" +
                "2. Plaza fija\n" +
                "0. Salir";

        byte op = 0;

        do {
            System.out.println(menu);
            op = scan.nextByte();
            scan.nextLine();

            switch (op) {
                case 1:
                    byte op2 = 0;

                    do {
                        System.out.println(menuadd);
                        op2 = scan.nextByte();
                        scan.nextLine();

                        switch (op2) {
                            case 1:
                                int mesesEmpleado;
                                boolean mesesValido = false;
                                System.out.print("Nombre: ");
                                nombreEmpleado = scan.nextLine();
                                System.out.print("Puesto: ");
                                puestoEmpleado = scan.nextLine();
                                System.out.print("Salario: ");
                                salarioEmpleado = scan.nextDouble();
                                scan.nextLine();
                                do {
                                    System.out.print("Duración del contrato (meses): ");
                                    mesesEmpleado = scan.nextInt();
                                    scan.nextLine();
                                    if (mesesEmpleado>0) {
                                        mesesValido = true;
                                        ServicioProfesional unServicio = new ServicioProfesional(nombreEmpleado,puestoEmpleado,salarioEmpleado,mesesEmpleado);
                                    }
                                    else
                                        System.out.println("Ingrese un valor de meses mayor a cero");
                                } while (mesesValido = false);


                                break;
                            case 2:
                                //instrucciones caso 2
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                                break;
                        }

                    } while (op2 != 0);

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println();
        } while (op != 0);


    }
}
