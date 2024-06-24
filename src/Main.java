public class Main {
    //private static final Integer EDAD_MINIMA = 18;

    public static void main(String[] args) {
        //Crear variables iniciales predefinidas, variables intermedias y finales
        //Colocar condiciones y actualizar datos en caso de ser necesario
        //Validar que los datos sean los requeridos, sino devolver mensaje de error
        //Ejemplo usemos compra de un usuario (Stock, dinero, edad, precio)


        // Definir los valores de las variables

        //Esto serian variables iniciales
        Integer dineroCliente = 500;
        Integer edadCliente = 22;
        Integer cantidadAComprar = 8;
        Boolean compradorFlexible = false;

        Integer precioProducto = 50;
        Integer stockProducto = 10;
        Integer totalCompra;

        Integer totalCaja = 300;

        //Variables intermedias
        totalCompra = calcularTotalPorSumaDeProductos(precioProducto, cantidadAComprar);

        Boolean siEsMenor = siNoTieneSuficienteEdad(edadCliente);
        if (siEsMenor) noCumpleConLaEdadRequeridaException();
        boolean esCantidadSolicitadaMayorALaDisponible = cantidadAComprar > stockProducto;
        if (esCantidadSolicitadaMayorALaDisponible && !compradorFlexible ) throw new GlobalException("No es posible continuar con la compra");
        if (esCantidadSolicitadaMayorALaDisponible && compradorFlexible){
            cantidadAComprar = actualizarCantidadAComprar(stockProducto);
            totalCompra = calcularTotalPorSumaDeProductos(precioProducto, cantidadAComprar);
        }
        Boolean tieneSuficienteDinero = siNoTieneSuficienteDinero(dineroCliente, totalCompra);
        if (tieneSuficienteDinero) mensajeErrorFondosInsuficientesException(dineroCliente, totalCompra);

        TicketResponse ticketResponse = imprimirTicket(cantidadAComprar, totalCompra, totalCaja);
        System.out.println(ticketResponse);
    }


    private static void noCumpleConLaEdadRequeridaException() {
        String message = "Edad requerida no cumplida, no puede continuar ";
        System.out.println(message);
        throw new GlobalException(message);

    }

    private static Integer calcularTotalPorSumaDeProductos(Integer precioProducto, Integer cantidadAComprar) {
        Integer totalCompra;
        totalCompra = precioProducto * cantidadAComprar;
        return totalCompra;
    }

    private static Integer actualizarCantidadAComprar(Integer stockProducto) {
        Integer cantidadAComprar;
        cantidadAComprar = stockProducto;
        return cantidadAComprar;
    }


    private static void mensajeErrorFondosInsuficientesException(Integer dineroCliente, Integer totalCompra) {
        throw new GlobalException("Executing mensajeErrorFondosInsuficientesException");
    }

    private static boolean siNoTieneSuficienteDinero(Integer dineroCliente, Integer totalCompra) {
        Boolean hasRequiredMoney = dineroCliente < totalCompra;
        return hasRequiredMoney;
    }
    private static boolean siNoTieneSuficienteEdad(Integer edadCliente) {
        Boolean isUsa= false;
        Integer EDAD_MINIMA;
        if (isUsa){
            EDAD_MINIMA = 21;
        }
        else {
            EDAD_MINIMA = 18;
        }
        return edadCliente < EDAD_MINIMA;
    }


    private static TicketResponse imprimirTicket(Integer cantidadAComprar, Integer totalCompra, Integer totalCaja) {
        // Compra realizada, crea un ticket donde se defina cantidad vendida/precio y suma total
        System.out.println("Compra realizada con exito");
        System.out.println("------------------------");
        System.out.println("Cantidad comprada: " + cantidadAComprar);
        System.out.println("Total pagado: " + totalCompra);
        System.out.println("------------------------");

        totalCaja = totalCaja + totalCompra;

        return new TicketResponse(cantidadAComprar, totalCompra, totalCaja);
    }
}
