package com.WEEC.x00002912;

import java.util.InputMismatchException;
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
                "0. Salir\n\n" +
                "Ingrese su opción: ";

        String menuadd = "Ingrese el número correspondiente al tipo de empleado que desea agregar\n" +
                "1. Servicio profesional\n" +
                "2. Plaza fija\n" +
                "0. Salir";

        byte op = 0;

        do {
            System.out.println(menu);
            while (true) {
                try {
                    op = scan.nextByte();
                    scan.nextLine();
                    System.out.println("Usted eligió: " + op);
                    break;
                } catch (InputMismatchException exception) {
                    scan.nextLine();
                    System.out.println("Introduzca un número de las opciones:");
                }
            }


            switch (op) {
                case 1:
                    byte op2 = 0;

                    do {
                        System.out.println(menuadd);

                        while (true) {
                            try {
                                op2 = scan.nextByte();
                                scan.nextLine();
                                System.out.println("Opcion ingresada " + op2);
                                break;
                            } catch (InputMismatchException exception) {
                                scan.nextLine();
                                System.out.println("Introduzca un número de las opciones:");
                            }
                        }

                        switch (op2) {
                            case 1:
                                int mesesEmpleado;
                                System.out.print("Nombre: ");
                                nombreEmpleado = scan.nextLine();
                                System.out.print("Puesto: ");
                                puestoEmpleado = scan.nextLine();

                                while (true) {
                                    try {
                                        System.out.print("Salario: ");
                                        salarioEmpleado = scan.nextDouble();
                                        scan.nextLine();
                                        break;
                                    } catch (InputMismatchException exception) {
                                        scan.nextLine();
                                        System.out.println("Introduzca un número:");
                                    }
                                }

                                while (true) {
                                    try {
                                        System.out.print("Duración del contrato (meses): ");
                                        mesesEmpleado = scan.nextInt();
                                        scan.nextLine();

                                        if (mesesEmpleado < 1)
                                            throw new InvalidDataTypeException("Ingrese un valor en meses mayor o igual a 1");
                                        break;
                                    } catch (InputMismatchException exception) {
                                        scan.nextLine();
                                        System.out.println("Introduzca un número:");
                                    } catch (InvalidDataTypeException ex) {
                                        System.out.println(ex.getMessage());

                                    }
                                }


                                unaEmpresa.addEmpleado(new ServicioProfesional(nombreEmpleado, puestoEmpleado, +
                                        salarioEmpleado, mesesEmpleado));
                                op2 = 0;

                                break;
                            case 2:
                                int extEmpleado;
                                boolean extValido = false;
                                System.out.print("Nombre: ");
                                nombreEmpleado = scan.nextLine();
                                System.out.print("Puesto: ");
                                puestoEmpleado = scan.nextLine();

                                while (true) {
                                    try {
                                        System.out.print("Salario: ");
                                        salarioEmpleado = scan.nextDouble();
                                        scan.nextLine();
                                        break;
                                    } catch (InputMismatchException exception) {
                                        scan.nextLine();
                                        System.out.println("Introduzca un número:");
                                    }
                                }

                                while (true) {
                                    try {
                                        System.out.print("Extensión: ");
                                        extEmpleado = scan.nextInt();
                                        scan.nextLine();

                                        if (extEmpleado < 0)
                                            throw new InvalidDataTypeException("Ingrese un valor en meses mayor o igual a 0");
                                        break;
                                    } catch (InputMismatchException exception) {
                                        scan.nextLine();
                                        System.out.println("Introduzca un número:");
                                    } catch (InvalidDataTypeException ex) {
                                        System.out.println(ex.getMessage());

                                    }
                                }

                                unaEmpresa.addEmpleado(new PlazaFija(nombreEmpleado, puestoEmpleado, salarioEmpleado, +
                                        extEmpleado));
                                op2 = 0;

                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion incorrecta!! Intente nuevamente.");
                                break;
                        }

                    } while (op2 != 0);

                    break;
                case 2:
                    System.out.print("Ingrese el nombre del empleado a despedir: ");
                    nombreEmpleado = scan.nextLine();
                    try {
                        unaEmpresa.quitEmpleado(nombreEmpleado);
                    } catch (notFoundEmpleado ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 3:
                    unaEmpresa.getPlanilla().forEach(obj -> System.out.println(obj.toString()));

                    break;
                case 4:
                    System.out.println("Se calcularán los sueldos netos (después de retenciones) de todos los empleados");
                    unaEmpresa.getPlanilla().forEach(emp -> System.out.println("Nombre: " + emp.getNombre() + "," +
                            " Salario neto: " + CalculadoraImpuestos.calcularPago(emp)));

                    break;
                case 5:
                    System.out.println("Los descuentos totales realizados a los empleados son:");
                    System.out.println(CalculadoraImpuestos.mostrarTotales());

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta!! Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (op != 0);


    }
}
