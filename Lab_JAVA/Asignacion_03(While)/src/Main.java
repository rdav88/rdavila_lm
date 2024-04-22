import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num_empleados = 3; // número de empleados
        int contador = 0;

        float horas_trabajadas;
        float horas_trabajadas_overtime = 0;
        float pago_por_hora;
        float sueldo_bruto;
        float sueldo_neto;
        float total_pago = 0;
        float total_overtime = 0;
        float overtime_horas = 0;
        float total_pago_empleados = 0;
        float total_nomina = 0;

        System.out.println("---------------------------------------------------------------------------------");
        while (contador < num_empleados) 
        {
            contador++;
            System.out.println("Para el empleado: " + contador);
            System.out.print("Ingresa las horas trabajadas: ");
            horas_trabajadas = scanner.nextFloat(); // Almacenamiento de horas trabajadas

            System.out.print("Ingresa el pago por hora: $");
            pago_por_hora = scanner.nextFloat();

            if (horas_trabajadas > 40) 
            {
                // Calcula las horas de overtime si el empleado trabajó más de 40 horas
                overtime_horas = horas_trabajadas - 40;
                horas_trabajadas_overtime += overtime_horas;
                // Calcula el pago de las horas de overtime, que es el doble del pago normal por hora
                total_overtime = overtime_horas * (pago_por_hora * 2);
                // Ajusta las horas trabajadas del empleado restando las horas de overtime
                horas_trabajadas -= overtime_horas;
            }

            // Calcula el sueldo bruto sumando el pago por hora y las horas trabajadas, más el pago de overtime si aplica
            sueldo_bruto = pago_por_hora * horas_trabajadas + total_overtime;
            // Calcula el sueldo neto después de aplicar un descuento del 7%
            sueldo_neto = sueldo_bruto - (sueldo_bruto * 0.07f);

            System.out.println("El sueldo bruto del empleado es de: $" + sueldo_bruto);
            System.out.println("El sueldo neto del empleado es de: $" + sueldo_neto);

            total_pago = sueldo_neto + total_overtime;

            System.out.println("Sueldo con descuentos/overtime (si aplica) es de: $" + total_pago);
            System.out.println("---------------------------------------------------------------------------------");

            // Suma el sueldo bruto del empleado al total de pago de todos los empleados
            total_pago_empleados += sueldo_bruto;
            // Suma el sueldo neto más el pago de overtime al total de pago con overtime de todos los empleados
            total_nomina += sueldo_neto + total_overtime;

            // Reinicia el total de overtime para el próximo empleado al empezar el ciclo
            total_overtime = 0;
        }

        System.out.println("Para este periodo:");
        System.out.println("El total en nomina de los empleados (Sueldo Bruto) fue de: $" + total_pago_empleados);
        System.out.println("El total en nomina de los empleados despues de descuentos y overtime (si aplica) fue de: $" + total_nomina);
        System.out.println("El total de horas trabajadas de overtime de los empleados fue de: " + horas_trabajadas_overtime);
        System.out.println("---------------------------------------------------------------------------------");
    }
}