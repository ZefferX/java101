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
        System.out.println("No hay stock suficiente, desea llevar el maximo disponible?");
        System.out.println("Cliente: " + compradorFlexible);
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
        System.out.println("Dinero insuficiente para realizar su compra, tiene " + dineroCliente + " dinero y necesita " + totalCompra);
        throw new GlobalException("Executing mensajeErrorFondosInsuficientesException");
    }

    private static boolean siNoTieneSuficienteDinero(Integer dineroCliente, Integer totalCompra) {
        return dineroCliente < totalCompra;
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
        System.out.println("El total de dinero en caja actualmente es " + totalCaja);
        return new TicketResponse(cantidadAComprar, totalCompra, totalCaja);
    }
}


/*
public class Main {

    public static void main(String[] args) {
        // Hola mundo

        System.out.println("Hola, Java!");

        String pruebaString = "Esto es una cadena de texto";
        pruebaString = "Aqui cambio el valor de la cadena de texto";
        System.out.println(pruebaString);

        final String unaConstante = "Esto es una cadena de texto constante";

        Integer miNumero = 7;
        miNumero = miNumero + 7;
        System.out.println(miNumero);
        System.out.println(miNumero - 1);

        Double unDoble = 6.5;
        System.out.println(unDoble);

        Float unFlotante = 6.35f;
        System.out.println(unFlotante);

        System.out.println(unDoble + " " + pruebaString + " " + unFlotante + " " + miNumero);

        Boolean pruebaBoolean = true;
        pruebaBoolean = false;
        System.out.println(pruebaBoolean);

        pruebaBoolean = null;
        System.out.println(pruebaBoolean);

        unFlotante = null;
        if (unFlotante != null) {
            System.out.println(unFlotante + 10);
            System.out.println("Un flotante es distinto de nulo");
        } else {
            System.out.println("Un flotante es nulo");
        }

        if (miNumero == 11) {
            System.out.println("Mi numero es 11");

        } else if (miNumero == 12) {
            System.out.println("Mi Numero es 12");
        } else {
            System.out.println("El valor no es ni 11 ni 12");
        }

        List<String> primeraLista = new ArrayList();
        primeraLista.add(pruebaString);
        primeraLista.add(miNumero.toString());
        System.out.println(primeraLista);

        Map<String, String> unMapa = new HashMap();
        unMapa.put("string", pruebaString);
        unMapa.put("int", miNumero.toString());
        System.out.println(unMapa);
        System.out.println(unMapa.get("int"));


        for (int i = 0; i < primeraLista.size(); i++) {
            System.out.println(primeraLista.get(i));

        }

        Main miPrincipal = new Main();
        System.out.println(miPrincipal.unaFuncion(5, 2));
        System.out.println(miPrincipal.unaFuncion(3, 212312321));

    }

    public int unaFuncion (int primerNumero, int segundoNumero){
       return primerNumero + segundoNumero;

    }
*/