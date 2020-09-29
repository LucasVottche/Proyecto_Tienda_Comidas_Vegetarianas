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
		int cantidad = 0;
		int cantidadPedidosRegis=0;
		int contadorHamburguesa = 0;
		double cantidadProductosVendidos=0;
		double totalPago = 0;
		int productosTotal = 0;
		double descuentito = 0.90;
		double totalRecaudado = 0;
		double pedidoCaro = 0;
		double envio=50;
		int elegirPro;
		int total=0;
		String otraCompra = "";
		//// MAIN
		System.out.println(BARRA);
		System.out.println("BIENVENIDO A ETHICAL FOOD");
		System.out.println(BARRA);
		otraCompra = desearComprar();
		while (!otraCompra.equals(OP2)) {
			System.out.println(BARRA);
			menuEthicalFood();
			do {
				System.out.println(BARRA);
				ingreso = ingresoNumeroProducto();
				System.out.println(BARRA);
				cantidad = cantidaProductos(ingreso);
				if (ingreso == 3) {
					contadorHamburguesa += cantidad;

				}
				cantidadProductosVendidos += cantidad;
				elegirPro = elegirProductos(ingreso, cantidad);
				totalPago = totalPago + elegirPro;
				

			} while (ingreso != 0);
			
			
			if (elegirPro > 500 && cantidadProductosVendidos > 3) {
				totalPago = (totalPago * descuentito);
			}
		
				System.out.println(BARRA);
				if(cantidadProductosVendidos>=1) {
	                cantidadPedidosRegis++;
	                totalPago+=envio;
	                productosTotal  +=cantidadProductosVendidos;
	                totalRecaudado=totalRecaudado+totalPago;
	            	if (totalPago > pedidoCaro) {
						pedidoCaro = totalPago;
					}
	                System.out.println("El precio de su pedido es de: $"+ totalPago);
	                totalPago=0;
	            }
			
			
			otraCompra = desearComprar();
		}
		if (cantidadPedidosRegis > 0) {
			mostrarResultado(cantidadPedidosRegis, cantidadProductosVendidos, totalRecaudado, contadorHamburguesa,
					pedidoCaro, productosTotal);
		} else {
			System.out.println("No hubo ventas");
		}

		
	
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
		int num ;

		System.out.print("Ingrese el numero de producto que desee elegir : ");
		num = input.nextInt();
		num = validarIngresoProducto(num);

		return num;
	}

	public static int cantidaProductos(int ingreso) {
		int cantidad;
		if (ingreso != 0) {
		System.out.print("Ingrese la cantidad de productos : ");
		cantidad = input.nextInt();
		while (cantidad < 0) {
			System.out.println(BARRA);
			System.out.print("Error:  la cantidad debe ser mayor a 0 : ");
			cantidad = input.nextInt();
			System.out.println(BARRA);
		} 
	} else {

			cantidad = 0;
		}
		return cantidad;

	} 
	public static int elegirProductos(int num , int cantidad) {
		int total=0;
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
			System.out.println(BARRA);
			
			System.out.print("Error:  El numero de producto debe ser de  0  a 4 minimo : ");
			num = input.nextInt();
			System.out.println(BARRA);

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
	public static void mostrarResultado(double cantidadPedidosRegis, double cantidadProductosVendidos, double totalRecaudado, double contadorHamburguesa, double pedidoCaro, double productosTotal ) {
		System.out.println(BARRA);
		System.out.println("La cantidad de pedidos registrados : " + cantidadPedidosRegis);
		System.out.println("Cantidad de productos vendidos : " + cantidadProductosVendidos);
		System.out.println("Total Recaudado : " + totalRecaudado);
		System.out.println("La cantidad promedio de productos por pedido es de: " + Math.round(productosTotal / cantidadPedidosRegis));
		System.out.println("El porcentaje de hamburguesas vendidas sobre el total de productos vendidos : " + (contadorHamburguesa/productosTotal)*100+"%");
		System.out.println("El valor del pedido más caro : " + pedidoCaro);
		System.out.println(BARRA);
	}
	
}
