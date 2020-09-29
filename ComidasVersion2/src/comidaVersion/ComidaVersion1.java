package comidaVersion;
import java.util.Scanner;

public class ComidaVersion1 {
	public static final String COMIDA_1 = "FALAFEL";
	public static final String COMIDA_2 = "MILANESA DE BERENJENA";
	public static final String COMIDA_3 = "HAMBURGUESA DE LENTEJAS CON PAPAS FRITAS";
	public static final String COMIDA_4 = "SPAGUETTI CON SALSA FILETO";
	public static final String BARRA = "-------------------------------------------------------------";
	public static final String OP1 = "S";
	public static final String OP2 = "N";
	public static final int FALAFEL = 150;
	public static final int MILANESA_BERENJENA = 200;
	public static final int HAMBURGUESA_LENTEJAS = 280;
	public static final int SPAGUETTI_FILETO = 130;
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//// VARIABLES///
		int ingreso;
		int calcularPrec;
		int cantidad = 0;
		double cantidadPedidosRegis=0;
		double contadorHamburguesa = 0;
		double cantidadProductosVendidos=0;
		double totalPago = 0;
		double descuentito = 0.90;
		double totalRecaudado = 0;
		double pedidoCaro = 0;
		double envio=0;
		double porcenHamburguesa = 0;
		int elegirPro = 0;
		String otraCompra = "";
		//// MAIN
		System.out.println(BARRA);
		System.out.println("BIENVENIDO A ETHICAL FOOD");
		System.out.println(BARRA);
		otraCompra = desearComprar();
		while (!otraCompra.equals(OP2)) {
			do {
				System.out.println(BARRA);
				menuEthicalFood();
				System.out.println(BARRA);
				ingreso = ingresoNumeroProducto();
				if(ingreso!=0) {
					System.out.println(BARRA);
					elegirPro = elegirProductos(ingreso,cantidad);
					cantidad = cantidaProductos();
					
					
					////////////////////////////////////////////// IF DE TODO
					if(ingreso==3) {
						contadorHamburguesa+=cantidad;
						
					}
					cantidadProductosVendidos+=cantidad;
					System.out.println(BARRA);
					calcularPrec = elegirProductos(ingreso, cantidad);
					
					// Mostrar Total a Pagar//
					totalPago = totalPago + calcularPrec;
					
				
					System.out.println("El total a pagar es de : " + totalPago);
					
					// descuento al Total a pagar
					if (calcularPrec > 500 && cantidad > 3) {
						totalPago = (totalPago * descuentito);
					}
					////////////////////////////////////
					
					
					// pedido mas caro
					if (calcularPrec > pedidoCaro) {
						pedidoCaro = calcularPrec;
					}
					/////////////////////////
					
					
					// PORCEN HAMBURGUESAS VENDIDAS SOBRE EL TOTAL PRODUCTOS VENDIDOS
					if (contadorHamburguesa > 0) {
						porcenHamburguesa = Math.round(( contadorHamburguesa / cantidadProductosVendidos  ) * 100);
					}
					////////////////////////////////////////////////////
					// RECAUDACION TOTAL
					totalRecaudado = totalRecaudado + totalPago;
					
					/////////////////////////////////////
					
					
					// PEDIDOS REGISTRADOS
					cantidadPedidosRegis++;
					//////////////////////////////
					
				}else {
					System.out.println(BARRA);
					System.out.println("Compra Finalizada");
					System.out.println(BARRA);
				}/////////////////////// IF DE TODO ////////////////////////////////////////////
			
			} while(ingreso!=0);
			envio=totalPago+50;
			otraCompra = desearComprar();
		}
	 mostrarResultado(cantidadPedidosRegis, cantidadProductosVendidos, totalRecaudado, porcenHamburguesa, pedidoCaro);
	}

	public static void menuEthicalFood() {
		System.out.println("Opciones:\r\n" + 
				"1 - Falafel: $150.0\r\n" + 
				"2 - Milanesa de berenjena con ensalada mixta: $200.0\r\n" + 
				"3 - Hamburguesa de lentejas completa con papas: $280.0\r\n" + 
				"4 - Spaguetti con salsa fileto: $130.0\r\n" + 
				"0 - Terminar pedido");
	}

	public static int ingresoNumeroProducto() {
		int num = 0;

		System.out.print("Ingrese el numero de producto que desee elegir : ");
		num = input.nextInt();
		num = validarIngresoProducto(num);

		return num;
	}

	public static int cantidaProductos() {
		int cantidad = 0;
		System.out.print("Ingrese la cantidad de productos : ");
		cantidad = input.nextInt();
		while (cantidad < 0) {
			System.out.println("Error:  la cantidad debe ser mayor a 0 :");
			cantidad = input.nextInt();

		}
		return cantidad;

	}

	public static int elegirProductos(int num , int cantidad) {
		int total = 0;
		String elegir;
		switch (num) {
		case 1:
			total = FALAFEL * cantidad;
			elegir = COMIDA_1;
			break;
		case 2:
			elegir = COMIDA_2;
			total = MILANESA_BERENJENA * cantidad;
			break;
		case 3:
			elegir = COMIDA_3;
			total = HAMBURGUESA_LENTEJAS * cantidad;
			break;
		case 4:
			elegir = COMIDA_4;
			total = SPAGUETTI_FILETO * cantidad;
			break;
		default:
			break;
		}
		return total;
	}


	public static int validarIngresoProducto(int num) {

		while (num <0 || num > 4) {
			System.out.println("Error:  El numero de producto debe ser de  0  a 4 minimo :");
			num = input.nextInt();

		}
		return num;

	}

	public static String desearComprar() {
		String otraCompra = "";
		System.out.print("Desea cargar una compra ?(S/N) : ");
		otraCompra = input.next().toUpperCase();
		while ((!otraCompra.equals(OP1)) && !otraCompra.equals(OP2)) {
			System.out.println("Error :  ingrese nuevamente ");
			System.out.print("Desea cargar una compra ?(S/N)  : ");
			otraCompra = input.next().toUpperCase();
		}

		return otraCompra;
	}
	public static void mostrarResultado(double cantidadPedidosRegis, double cantidadProductosVendidos, double totalRecaudado, double porcenHamburguesa, double pedidoCaro ) {
		System.out.println(BARRA);
		System.out.println("La cantidad de pedidos registrados : " + cantidadPedidosRegis);
		System.out.println("Cantidad de productos vendidos : " + cantidadProductosVendidos);
		System.out.println("Total Recaudado : " + totalRecaudado);
		System.out.println("El porcentaje de hamburguesas vendidas sobre el total de productos vendidos : " + porcenHamburguesa);
		System.out.println("El valor del pedido más caro : " + pedidoCaro);
		System.out.println(BARRA);
	}
	
}