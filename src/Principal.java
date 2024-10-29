
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner( System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;
        double monto;
        Moneda moneda;
        String Menu = """
                *****************************************
                *******    CONVERSOR DE MONEDAS   *******
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real Brasileño =>> Dolar
                5) Dolar =>> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Dolar =>> Peso Chileno
                8) Peso Chileno =>> Dolar
                9) Salir
                Elija una opción valida:
                *****************************************
                """;

            while (opcion != 9) {
                try {
                    System.out.println(Menu);

                    opcion = lectura.nextInt();

                    if (opcion == 9) {
                        System.out.println("Fin APP");
                        break;
                    }

                    if (opcion > 9) {
                        System.out.println("Opcion no valida");
                        continue;
                    }

                    System.out.println("Ingrese monto a convertir:");
                    monto = lectura.nextDouble();

                    switch (opcion) {
                        case 1:
                            moneda = consulta.buscaMoneda("USD", "ARS");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [USD] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " ARS"  );
                            break;
                        case 2:
                            moneda = consulta.buscaMoneda("ARS", "USD");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [ARS] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " USD"  );
                            break;
                        case 3:
                            moneda = consulta.buscaMoneda("USD", "BRL");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [USD] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " BRL"  );
                            break;
                        case 4:
                            moneda = consulta.buscaMoneda("BRL", "USD");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [BRL] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " USD"  );
                            break;
                        case 5:
                            moneda = consulta.buscaMoneda("USD", "COP");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [USD] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " COP"  );
                            break;
                        case 6:
                            moneda = consulta.buscaMoneda("COP", "USD");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [COP] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " USD"  );
                            break;
                        case 7:
                            moneda = consulta.buscaMoneda("USD", "CLP");
                            System.out.println(moneda);
                            System.out.println("El valor " + monto + " [USD] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " CLP"  );
                            break;
                        case 8:
                            moneda = consulta.buscaMoneda("CLP", "USD");
                            System.out.println("El valor " + monto + " [CLP] corresponde al valor final de =>>> "
                                    + consulta.convertirMonto(moneda.conversion_rate(), monto) + " USD"  );
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Moneda no encontrado:" + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("finalizando la aplicacion");
                    break;
                }

            }
    }

}
