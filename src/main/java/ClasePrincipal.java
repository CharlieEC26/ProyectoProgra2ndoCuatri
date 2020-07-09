
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlo
 */
public class ClasePrincipal {
    
    //Listas
    String[] ListaProducto = {"Chayotes", "Papas", "Zanahorias", "Mangos",
        "Chile"};
    int[] listaPrecio = {1300, 600, 4500, 8000, 150};
    String[] ListaCodigoProducto = {"#345CHAY", "#654PAP", "#879ZAN", 
    "#258MANG", "#741CHIL"};
    int[] listaCantidadProducto = {30, 50, 600, 25, 23};
    int[] listaFacturas;
    //Listas
    
    //metodos
    public boolean validarArticuloLista(String producto){
        boolean validador = false;
        for(int x = 0; x < ListaProducto.length; x++){
            if(producto.equals(ListaProducto[x])){
                validador = true;
                break;
            }
            else{
                validador = false;
            }
        }
        if(validador){
            return validador;
        }
        else{
            return validador;
        }
    }
    public boolean validarTextoONumero(String opcionInterna){
        if("1".equals(opcionInterna) || "2".equals(opcionInterna)
                || "3".equals(opcionInterna) || "4".equals(opcionInterna)
                || "5".equals(opcionInterna) || "6".equals(opcionInterna)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean validarPrecioFloat(String precio){
        try{
            double total = Double.parseDouble(precio);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public boolean forList(int cantidad, int item){
        if(cantidad >= listaCantidadProducto[item]){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int productoCargo(String cantidadProducto, int campoLista, String item){
        while(!validarPrecioFloat(cantidadProducto)){
            JOptionPane.showMessageDialog(null, 
                    "El valor de " + item + "es de " + listaPrecio[campoLista]);
            cantidadProducto = JOptionPane.showInputDialog(
                    "Cuantas " + item + " desea comprar? ");
            if(validarPrecioFloat(cantidadProducto)){
                if(forList(Integer.parseInt(cantidadProducto), campoLista)){
                    JOptionPane.showMessageDialog(null, 
                            "Debe digitar de nuevo la cantidad de: " + item 
                    + " que sea menor, ya que no tenemos los suficientes en stock");
                    JOptionPane.showMessageDialog(null, 
                            "\n" + "Cantidad de " + item + " en stock: " + ListaProducto[campoLista]);
                    cantidadProducto = "";
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                            "Tenemos aun en stock de " + item);
                    listaCantidadProducto[campoLista] -= Integer.parseInt(cantidadProducto);
                    JOptionPane.showMessageDialog(null, 
                            "El total que ahora tiene de " + item + " es de " + cantidadProducto
                    + "\n" + " y el que tiene de stock es de " + listaCantidadProducto[campoLista]);
                    break;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Digite otra vez los " + item 
                + " a comprar, ya que no puede escribir letras");
            }
        }
        return Integer.parseInt(cantidadProducto);
    }
    public int forPrecio(int cantidad, int item){
        int precioProducto = cantidad * listaPrecio[item];
        return precioProducto;
    }
    //-metodos

    public void menuPrincipal(){
        boolean banderaSalir = false;
        String opcionSalir = "";
        String variablePrecio = "false";
        
        //Cantidad TOTAL de lo que lleva el cliente en la parte de factura
        int Producto1Total =  0, Producto2Total = 0, 
                Producto3Total = 0, Producto4Total = 0, 
                Producto5Total = 0;
        double TotalCompra = 0;
        int TotalProductos = 0;
        String opcionFactura = "";
        String nombreCliente = "";
        
        while(!"4".equals(opcionSalir)){
            //Parte del menu
            
            boolean banderaMostrarTodo = false;
            int variableContador = 0;
            String variableCantidad = "";
            
            opcionSalir = JOptionPane.showInputDialog("Bienvenido al sistema "
                    + "'Facturando con el mejor sistema de agricultura!' "+ 
                    '\n' +"Ingrese 1 "
                    + "para ver todo su inventario "+ '\n' +"2 para empezar a "
                    + "factura "+ '\n' + "3 para empezar a hacer el cierre de "
                    + "caja " + '\n' +"o 4 para salir: ");
            if("1".equals(opcionSalir)){
                //Parte del control de inventario
                String opcionInterna = "1";
                String producto = "wasd";
                String listaProductoAMostrar = "";
                while(!"5".equals(opcionInterna)){
                    while(!validarArticuloLista(producto)){
                        String productosAMostrar = "";
                        for(int c = 0; c < ListaProducto.length; c++){
                            if((c + 1) == ListaProducto.length){
                                productosAMostrar += ListaProducto[c];
                            }
                            else{
                                productosAMostrar += ListaProducto[c] + ", ";
                            }
                        }
                        
                        producto = JOptionPane.showInputDialog("Digite el"
                                + " producto que se muestra a continuacion: " +
                                 "\n" + productosAMostrar);
                        
                        if(validarArticuloLista(producto)){
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"El producto no "
                                    + "existe, digite uno de los que estan en la"
                                    + " lista previamente mostrada");
                            producto = "";
                        }
                    }
                    String prod = producto;
                    for(int x = 0; x < ListaProducto.length; x++){
                        if(ListaProducto[x].equals(prod)){
                            while(!"5".equals(opcionInterna)){   
                                while(validarTextoONumero(opcionInterna)){
                                    opcionInterna = JOptionPane.showInputDialog("Digite algun numero para modificar el producto: " + prod
                                            + "\n" + "1 para editar el nombre"
                                            + "\n" + "2 para cambiarle el precio"
                                            + "\n" + "3 para cambiarle el codigo"
                                            + "\n" + "4 para editar la cantidad en almacen"
                                            + "\n" + "o 5 para salir del control de inventario");
                                    break;
                                }
                                if("1".equals(opcionInterna)){
                                    prod = JOptionPane.showInputDialog(
                                            "Digite el nuevo nombre para sustituir el siguiente: "
                                                    + prod + ": " + 
                                                    "\n" + "Nombre anterior: " + prod);
                                    ListaProducto[x] = prod;
                                    opcionInterna = "1";
                                }
                                else if("2".equals(opcionInterna)){
                                    variablePrecio = "false";
                                    variableContador = x;
                                    while(!validarPrecioFloat(variablePrecio)){
                                        variablePrecio = JOptionPane.showInputDialog(
                                                "Digite el nuevo precio para el "
                                                        + "producto" + 
                                                        "\n" + 
                                                        "Precio anterior: " + listaPrecio[x]);
                                        if(validarPrecioFloat(variablePrecio)){
                                            listaPrecio[x] = Integer.parseInt(
                                                    variablePrecio);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, 
                                                    "Un preico no puede incluir"
                                                            + "letras. Digite"
                                                            + " un numero valido");
                                        }
                                    }
                                }
                                else if("3".equals(opcionInterna)){
                                    ListaCodigoProducto[x] = "#" + 
                                            JOptionPane.showInputDialog(
                                                    "Digite el nuevo codigo" 
                                                            + " para el siguiente producto: "
                                                            + prod + 
                                                            "\n" + " Codigo anterior: " + ListaCodigoProducto[x]);
                                    variableContador = x;
                                }
                                else if("4".equals(opcionInterna)){
                                    variableCantidad = "wasd";
                                    while(validarPrecioFloat(variableCantidad));
                                    variableCantidad = JOptionPane.showInputDialog(
                                            "Digite la cantidad nueva para el producto" +
                                                    " " + prod + "\n" + "Cantidad en stock anterior: " + 
                                                    listaCantidadProducto[x]);
                                    variableContador = x;
                                    if(validarPrecioFloat(variableCantidad)){
                                        listaCantidadProducto[x] = Integer.parseInt(
                                                variableCantidad);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, 
                                                "Digite un precio valido");
                                    }
                                }
                                else if("5".equals(opcionInterna)){
                                    JOptionPane.showMessageDialog(null, 
                                            "Saliendo del inventario");
                                    opcionInterna = "5";
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Digite un numero correcto");
                                    opcionInterna = "1";
                                }
                            }
                        }
                    }
                }
            }
            else if("2".equals(opcionSalir)){
                //Parte de facturacion
                String Producto1 = "", Producto2 = "",
                            Producto3 = "", Producto4 = "",
                            Producto5 = "";
                nombreCliente = JOptionPane.showInputDialog(
                        "Digite el nombre del cliente");
                
                while(!validarTextoONumero(opcionFactura)){
                    //Cantidad ingresada por el usuario
                    
                    while(!validarTextoONumero(opcionFactura)){
                        opcionFactura = JOptionPane.showInputDialog("Digite: " 
                        + "\n" + "1 para cargar: " + ListaProducto[0]
                        + "\n" + "2 para cargar: " + ListaProducto[1]
                        + "\n" + "3 para cargar: " + ListaProducto[2]
                        + "\n" + "4 para cargar: " + ListaProducto[3]
                        + "\n" + "5 para cargar: " + ListaProducto[4]
                        + "\n" + "O 6 para terminar el proceso de facturacion");
                        
                        if(validarTextoONumero(opcionFactura)){
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                    "Digite un numero valido");
                            opcionFactura = "7";
                        }
                    }
                    switch(opcionFactura){
                        case "1":
                            Producto1Total += productoCargo("", 0, ListaProducto[0]);
                            opcionFactura = "";
                            break;
                        case "2":
                            Producto2Total += productoCargo("", 1, ListaProducto[1]);
                            opcionFactura = "";
                            break;
                        case "3":        
                            Producto3Total += productoCargo("", 2, ListaProducto[2]);
                            opcionFactura = "";
                            break;
                        case "4":        
                            Producto4Total += productoCargo("", 3, ListaProducto[3]);
                            opcionFactura = "";
                            break;
                        case "5":        
                            Producto5Total += productoCargo("", 4, ListaProducto[4]);
                            opcionFactura = "";
                            break;
                        case "6":
                            JOptionPane.showMessageDialog(null, 
                                    "Ahora, vamos a la parte de facturacion");
                            opcionFactura = "1";
                            break;
                    }
                }
                //Parte del detalle de la factura
                TotalCompra = forPrecio(Producto1Total, 0) + forPrecio(Producto2Total, 1) 
                        + forPrecio(Producto3Total, 2) + forPrecio(Producto4Total, 3
                        + forPrecio(Producto5Total, 4));
                
                TotalProductos = Producto1Total + Producto2Total +
                        Producto3Total + Producto4Total + Producto5Total;
                
                JOptionPane.showMessageDialog(null, 
                        "Facturando con el mejor sistema!");
                //poner bienen el orden correcto los productos
                //if statements
                if(Producto1Total != 0){
                    if(Producto2Total != 0){
                        if(Producto3Total != 0){
                            if(Producto4Total != 0){
                                if(Producto5Total != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[0] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 2) + "\n" 
                                    + ListaProducto[3] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 4));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n" 
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3));
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n" 
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2));
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[0] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + "  " + Producto1Total + "  " + forPrecio(Producto1Total, 1));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[0] + "   " + Producto1Total + "      " + forPrecio(Producto1Total, 0));
                    }
                }
                else if(Producto2Total != 0){
                    if(Producto3Total != 0){
                        if(Producto4Total != 0){
                            if(Producto5Total != 0){
                                if(Producto1Total != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n" 
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n" 
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4));
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3));
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1));
                    }
                }
                else if(Producto3Total != 0){
                    if(Producto4Total != 0){
                        if(Producto5Total != 0){
                            if(Producto1Total != 0){
                                if(Producto2Total != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n" 
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n" 
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0));
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4));
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2));
                    }
                }
                else if(Producto4Total != 0){
                    if(Producto5Total != 0){
                        if(Producto1Total != 0){
                            if(Producto2Total != 0){
                                if(Producto3Total != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n" 
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n"
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n" 
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1));
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0));
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3) + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3));
                    }
                }
                else{
                    if(Producto1Total != 0){
                        if(Producto2Total != 0){
                            if(Producto3Total != 0){
                                if(Producto4Total != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n" 
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2) + "\n"
                                    + ListaProducto[3] + Producto1Total + forPrecio(Producto1Total, 3));
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaProducto[1] + Producto1Total + forPrecio(Producto1Total, 1) + "\n" 
                                    + ListaProducto[2] + Producto1Total + forPrecio(Producto1Total, 2));
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaCodigoProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaCodigoProducto[0] + Producto1Total + forPrecio(Producto1Total, 0) + "\n"
                                    + ListaCodigoProducto[1] + Producto1Total + forPrecio(Producto1Total, 1));
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaCodigoProducto[4] + Producto1Total + forPrecio(Producto1Total, 4) + "\n"
                                    + ListaCodigoProducto[0] + Producto1Total + forPrecio(Producto1Total, 0));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                            "Producto   Cantidad    Precio" + "\n"
                                    + ListaCodigoProducto[4] + Producto1Total + forPrecio(Producto1Total, 4));
                    }
                }
                //Parte de pago
            }
            else if("3".equals(opcionSalir)){
                //Parte de cierre de cajas
                int varProductos = 3, varTotal = 1 , varGeneral = 3, varFacturas = 0;
                int sumaTotal = 0, sumaTotalProductos = 0, sumaFacturas = 0;
                
                for(int c = 0; c < listaFacturas.length; c++){
                    if(varGeneral >= listaFacturas.length){
                        break;
                    }
                    else{
                        sumaTotal += listaFacturas[varTotal];
                        sumaTotalProductos += listaFacturas[varProductos];
                        sumaFacturas += 1 ;
                        varProductos += 4;
                        varTotal += 4;
                        varGeneral += 4;
                        
                        JOptionPane.showMessageDialog(null, 
                                "El total del día de hoy fue de: " + sumaTotal + '\n' 
        + " además, se vendieron " + sumaTotalProductos + " productos" 
        + " y se realizaron " + sumaFacturas + " facturas");
                        JOptionPane.showMessageDialog(null, 
                                "Se ha terminado el dia de hoy, puede cerrar "
                                        + "sistema");
                        banderaSalir = true;
                    }
                }
                
            }
            else if("4".equals(opcionSalir)){
                //Parte de cierre de cajas
                if(banderaSalir){
                    JOptionPane.showMessageDialog(null, 
                            "Se ha cerrado el sistema exitosamente");
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                            "No se puede cerrar el sistema debido a que "
                                    + "no se ha hecho el cierre de cajas primero");
                    opcionSalir = "1";
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Digite un numero valido");
            }
            
        }
    }
    
}
