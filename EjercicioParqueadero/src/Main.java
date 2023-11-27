import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();
        int opcion = 0;


        while (opcion != 9) {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    ingresarCarro(sc, parqueadero);
                    break;
                case 2:
                    sacarCarro(sc, parqueadero);
                    break;
                case 3:
                    System.out.println("Ingresos del parqueadero: " + parqueadero.darMontoCaja());
                    break;
                case 4:
                    System.out.println("Puestos libres: " + parqueadero.calcularPuestosLibres());
                    break;
                case 5:
                    parqueadero.avanzarHora();
                    System.out.println("Hora actual del parqueadero: " + parqueadero.darHoraActual());
                    break;
                case 6:
                    cambiarTarifa(sc, parqueadero);
                    break;
                case 7:
                    ejecutarFuncionesAdicionales(parqueadero);
                    break;
                case 8:
                    desocuparParqueadero(parqueadero);
                    break;
                case 9:
                    System.out.println("Saliendo");
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú del Parqueadero ---");
        System.out.println("1. Ingresar un carro");
        System.out.println("2. Sacar un carro");
        System.out.println("3. Ver ingresos del parqueadero");
        System.out.println("4. Ver puestos libres");
        System.out.println("5. Avanzar la hora");
        System.out.println("6. Cambiar tarifa");
        System.out.println("7. Funciones adicionales");
        System.out.println("8. Desocupar parqueadero");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ingresarCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro: ");
        String placa = scanner.nextLine();
        int resultado = parqueadero.entrarCarro(placa);
        if ( resultado == 0){
            System.out.println("Ingreso de carro existoso");
        }else {
            System.out.println("Error entrada de carro");
        }
    }

    private static void sacarCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro a sacar: ");
        String placa = scanner.nextLine();
        int resultado = parqueadero.sacarCarro(placa);
        if ( resultado == 0){
            System.out.println("Egreso de carro existoso");
        }else {
            System.out.println("Error egreso de carro");
        }
    }

    private static void cambiarTarifa(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la nueva tarifa por hora: ");
        int tarifa = scanner.nextInt();
        scanner.nextLine();
        parqueadero.cambiarTarifa(tarifa);
        System.out.println("Tarifa actualizada a " + tarifa);
    }

    private static void desocuparParqueadero(Parqueadero parqueadero) {
        int carrosDesocupados = parqueadero.desocuparParqueadero();
        System.out.println("Se han desocupado " + carrosDesocupados + " carros del parqueadero.");
    }

    private static void ejecutarFuncionesAdicionales(Parqueadero parqueadero) {
        System.out.println("\n--- Funciones Adicionales ---");

        // Tiempo promedio de los carros en el parqueadero
        System.out.println("Tiempo promedio de los carros en el parqueadero: " + parqueadero.darTiempoPromedio() + " horas");

        // Verificar si hay algún carro más de 8 horas
        if (parqueadero.hayCarroMasDeOchoHoras()) {
            System.out.println("Hay al menos un carro que ha estado más de 8 horas en el parqueadero.");
        } else {
            System.out.println("No hay carros que hayan estado más de 8 horas en el parqueadero.");
        }

        // Listar los carros con más de tres horas parqueados
        System.out.println("Carros parqueados por más de 3 horas:");
        ArrayList<Carro> carrosMasDeTresHoras = parqueadero.darCarrosMasDeTresHorasParqueados();
        if (carrosMasDeTresHoras.isEmpty()) {
            System.out.println("No hay carros parqueados por más de 3 horas.");
        } else {
            for (Carro carro : carrosMasDeTresHoras) {
                System.out.println("- Placa: " + carro.darPlaca());
            }
        }

        // Verificar si hay carros con placas iguales
        if (parqueadero.hayCarrosPlacaIgual()) {
            System.out.println("Existen carros con placas iguales en el parqueadero.");
        } else {
            System.out.println("No hay carros con placas iguales en el parqueadero.");
        }

        // Contar carros con placa que inicia con "PB"
        int cantidadCarrosPB = parqueadero.contarCarrosQueComienzanConPlacaPB();
        System.out.println("Cantidad de carros con placa que inicia con 'PB': " + cantidadCarrosPB);

        // Verificar si hay carros con más de 24 horas
        if (parqueadero.hayCarroCon24Horas()) {
            System.out.println("Hay al menos un carro que ha estado 24 horas o más en el parqueadero.");
        } else {
            System.out.println("No hay carros que hayan estado 24 horas o más en el parqueadero.");
        }

        //Metodo 1
        System.out.println(parqueadero.metodo1());

        //Metodo 2
        System.out.println(parqueadero.metodo2());

    }
}
