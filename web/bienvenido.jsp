<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/ScriptProyecto.js"></script>
        
        <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <div class="container">
            <!--Inician pestañas de navegación-->
            <ul class="nav nav-tabs">
                <!--Primera pestaña "Almacen"-->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">Almacen
                    <span class="caret"></span></a>
                    <!--Submenú de Almacen-->
                    <ul class="dropdown-menu">
                        <li><a href="#GuardarAlmacen" data-toggle="tab">Agregar</a></li>
                        <li><a href="#ActualizarAlmacen" data-toggle="tab">Actualizar</a></li>
                        <li><a href="#EliminarAlmacen" data-toggle="tab">Eliminar</a></li>
                        <li><a href="#BuscarAlmacen" data-toggle="tab">Buscar</a></li>
                        <li><a href="#MostrarAlmacen" data-toggle="tab">Mostrar</a></li> 
                    </ul>
                </li>
                
                <!--Segunda pestaña "Cliente"-->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cliente
                    <span class="caret"></span></a>
                    <!--Submenú de Cliente-->
                    <ul class="dropdown-menu">
                        <li><a href="#GuardarCliente" data-toggle="tab">Agregar</a></li>
                        <li><a href="#ActualizarCliente" data-toggle="tab">Actualizar</a></li>
                        <li><a href="#EliminarCliente" data-toggle="tab">Eliminar</a></li>
                        <li><a href="#BuscarCliente" data-toggle="tab">Buscar</a></li>
                        <li><a href="#MostrarCliente" data-toggle="tab">Mostrar</a></li> 
                    </ul>
                </li>
                
                <!--Tercera pestaña "Vendedor"-->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Vendedor
                    <span class="caret"></span></a>
                    <!--Submenú de Vendedor-->
                    <ul class="dropdown-menu">
                        <li><a href="#GuardarVendedor" data-toggle="tab">Agregar</a></li>
                        <li><a href="#ActualizarVendedor" data-toggle="tab">Actualizar</a></li>
                        <li><a href="#EliminarVendedor" data-toggle="tab">Eliminar</a></li>
                        <li><a href="#BuscarVendedor" data-toggle="tab">Buscar</a></li>
                        <li><a href="#MostrarVendedor" data-toggle="tab">Mostrar</a></li> 
                    </ul>
                </li>
                
                <!--Cuarta pestaña "Ventas"-->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Venta
                    <span class="caret"></span></a>
                    <!--Submenú de Ventas-->
                    <ul class="dropdown-menu">
                        <li><a href="#GuardarVenta" data-toggle="tab">Agregar</a></li>
                        <li><a href="#ActualizarVenta" data-toggle="tab">Actualizar</a></li>
                        <li><a href="#EliminarVenta" data-toggle="tab">Eliminar</a></li>
                        <li><a href="#BuscarVenta" data-toggle="tab">Buscar</a></li>
                        <li><a href="#MostrarVenta" data-toggle="tab">Mostrar</a></li> 
                    </ul>
                </li>
            </ul>
        
            <div class="tab-content">
                <!--Contenido de la pestaña ALMACEN, submenú GUARDAR-->
                <div class="tab-pane fade" id="GuardarAlmacen">
                    Número de almacén:
                    <input type="text" id="txtNumeroAlmacenGuardar">
                    <br>

                    Ubicación de almacén:
                    <input type="text" id="txtUbicacionAlmacenGuardar">
                    <br>

                    <button id="btnGuardarAlmacen" onClick="guardarAlmacen();">Guardar</button>
                </div>

                <!--Contenido de la pestaña ALMACEN, submenú ACTUALIZAR-->
                <div class="tab-pane fade" id="ActualizarAlmacen">
                    Número de almacén:
                    <select id="numeroAlmacenActualizar" onChange="mostrarActualizarAlmacen();">
                    </select>
                    <br>

                    Ubicación de almacén:
                    <input type="text" id="txtUbicacionAlmacenActualizar">
                    <br>

                    <button id="btnActualizarAlmacen" onClick="actualizarAlmacen();">Actualizar</button>
                </div>
                
                <!--Contenido de la pestaña ALMACEN, submenú ELIMINAR-->
                <div class="tab-pane fade" id="EliminarAlmacen">
                    Número de almacén:
                    <select id="numeroAlmacenEliminar" onChange="mostrarEliminarAlmacen();">
                        <option value="--">--</option>
                    </select>
                    <br>

                    Ubicación de almacén:
                    <input type="text" id="txtUbicacionAlmacenEliminar">
                    <br>

                    <button id="btnEliminarAlmacen" onClick="eliminarAlmacen();">Eliminar</button>
                </div>

                <!--Contenido de la pestaña ALMACEN, submenú BUSCAR-->
                <div class="tab-pane fade" id="BuscarAlmacen">
                    Número de almacén:
                    <select id="numeroAlmacenBuscar" onChange="mostrarBuscarAlmacen();">
                    </select>
                    <br>
                        
                    Ubicación de almacén:
                    <div id="txtUbicacionAlmacenBuscar"></div>
                    <br>
                </div>
                
                <!--Contenido de la pestaña ALMACEN, submenú MOSTRAR TODOS-->
                <div class="tab-pane fade" id="MostrarAlmacen">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Id</th>
                          <th>Ubicación</th>
                        </tr>
                      </thead>
                      <tbody id="TablaMostrarAlmacen">
                      </tbody>
                    </table>
                </div>
                
                
                
                
                <!--Contenido de la pestaña CLIENTE, submenú GUARDAR-->
                <div class="tab-pane fade" id="GuardarCliente">
                    Número de cliente:
                    <input type="text" id="txtNumeroClienteGuardar">
                    <br>

                    Número de almacén:
                    <input type="text" id="txtNumeroAlmacenClienteGuardar">
                    <br>
                    
                    Nombre de cliente:
                    <input type="text" id="txtNombreClienteGuardar">
                    <br>

                    <button id="btnGuardarCliente" onClick="guardarCliente();">Guardar</button>
                </div>

                <!--Contenido de la pestaña CLIENTE, submenú ACTUALIZAR-->
                <div class="tab-pane fade" id="ActualizarCliente">
                    Número de cliente:
                    <select id="numeroClienteActualizar" onChange="mostrarActualizarCliente();">
                    </select>
                    <br>

                    Número de almacén:
                    <input type="text" id="txtNumeroAlmacenClienteActualizar">
                    <br>
                    
                    Nombre de cliente:
                    <input type="text" id="txtNombreClienteActualizar">
                    <br>
                    
                    <button id="btnActualizarCliente" onClick="actualizarCliente();">Actualizar</button>
                </div>
                
                <!--Contenido de la pestaña CLIENTE, submenú ELIMINAR-->
                <div class="tab-pane fade" id="EliminarCliente">
                    Número de almacén:
                    <select id="numeroClienteEliminar" onChange="mostrarEliminarCliente();">
                    </select>
                    <br>

                    Número de almacén:
                    <input type="text" id="txtNumeroAlmacenClienteEliminar">
                    <br>
                    
                    Nombre de cliente:
                    <input type="text" id="txtNombreClienteEliminar">
                    <br>

                    <button id="btnEliminarCliente" onClick="eliminarCliente();">Eliminar</button>
                </div>

                <!--Contenido de la pestaña CLIENTE, submenú BUSCAR-->
                <div class="tab-pane fade" id="BuscarCliente">
                    Número de almacén:
                    <select id="numeroClienteBuscar" onChange="mostrarBuscarCliente();">
                    </select>
                    <br>

                    Número de almacén:
                    <input type="text" id="txtNumeroAlmacenClienteBuscar">
                    <br>
                    
                    Nombre de cliente:
                    <input type="text" id="txtNombreClienteBuscar">
                    <br>
                </div>
                
                <!--Contenido de la pestaña CLIENTE, submenú MOSTRAR TODOS-->
                <div class="tab-pane fade" id="MostrarCliente">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Número de cliente</th>
                          <th>Número de almacén</th>
                          <th>Nombre de cliente</th>
                        </tr>
                      </thead>
                      <tbody id="TablaMostrarCliente">
                      </tbody>
                    </table>
                </div>
                
                
                
                
                
                <!--Contenido de la pestaña VENDEDOR, submenú GUARDAR-->
                <div class="tab-pane fade" id="GuardarVendedor">
                    Número de vendedor:
                    <input type="text" id="txtNumeroVendedorGuardar">
                    <br>

                    Nombre de vendedor:
                    <input type="text" id="txtNombreVendedorGuardar">
                    <br>
                    
                    Área de ventas:
                    <input type="text" id="txtAreaVentasGuardar">
                    <br>

                    <button id="btnGuardarVendedor" onClick="guardarVendedor();">Guardar</button>
                </div>

                <!--Contenido de la pestaña VENDEDOR, submenú ACTUALIZAR-->
                <div class="tab-pane fade" id="ActualizarVendedor">
                    Número de vendedor:
                    <select id="numeroVendedorActualizar" onChange="mostrarActualizarVendedor();">
                    </select>
                    <br>

                    Nombre de vendedor:
                    <input type="text" id="txtNombreVendedorActualizar">
                    <br>
                    
                    Área de ventas:
                    <input type="text" id="txtAreaVentasActualizar">
                    <br>
                    
                    <button id="btnActualizarVendedor" onClick="actualizarVendedor();">Actualizar</button>
                </div>
                
                <!--Contenido de la pestaña VENDEDOR, submenú ELIMINAR-->
                <div class="tab-pane fade" id="EliminarVendedor">
                    Número de vendedor:
                    <select id="numeroVendedorEliminar" onChange="mostrarEliminarVendedor();">
                    </select>
                    <br>

                    Nombre de vendedor:
                    <input type="text" id="txtNombreVendedorEliminar">
                    <br>
                    
                    Área de ventas:
                    <input type="text" id="txtAreaVentasEliminar">
                    <br>

                    <button id="btnEliminarVendedor" onClick="eliminarVendedor();">Eliminar</button>
                </div>

                <!--Contenido de la pestaña VENDEDOR, submenú BUSCAR-->
                <div class="tab-pane fade" id="BuscarVendedor">
                    Número de vendedor:
                    <select id="numeroVendedorBuscar" onChange="mostrarBuscarVendedor();">
                    </select>
                    <br>

                    Nombre de vendedor:
                    <input type="text" id="txtNombreVendedorBuscar">
                    <br>
                    
                    Área de ventas:
                    <input type="text" id="txtAreaVentasBuscar">
                    <br>
                </div>
                
                <!--Contenido de la pestaña VENDEDOR, submenú MOSTRAR TODOS-->
                <div class="tab-pane fade" id="MostrarVendedor">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Número de vendedor</th>
                          <th>Nombre de vendedor</th>
                          <th>Área de ventas</th>
                        </tr>
                      </thead>
                      <tbody id="TablaMostrarVendedor">
                      </tbody>
                    </table>
                </div>
                
                
                
                
                <!--Contenido de la pestaña VENTAS, submenú GUARDAR-->
                <div class="tab-pane fade" id="GuardarVenta">
                    Número de cliente:
                    <input type="text" id="txtNumeroClienteVentaGuardar">
                    <br>

                    Número de vendedor:
                    <input type="text" id="txtNumeroVendedorVentaGuardar">
                    <br>
                    
                    Monto de venta:
                    <input type="text" id="txtMontoVentaGuardar">
                    <br>

                    <button id="btnGuardarVenta" onClick="guardarVenta();">Guardar</button>
                </div>

                <!--Contenido de la pestaña VENTAS, submenú ACTUALIZAR-->
                <div class="tab-pane fade" id="ActualizarVenta">
                    Número de venta:
                    <select id="numeroVentaActualizar" onChange="mostrarActualizarVenta();">
                    </select>
                    <br>

                    Número de cliente:
                    <input type="text" id="txtNumeroClienteVentaActualizar">
                    <br>
                    
                    Número de vendedor:
                    <input type="text" id="txtNumeroVendedorVentaActualizar">
                    <br>
                    
                    Monto de venta:
                    <input type="text" id="txtMontoVentaActualizar">
                    <br>
                    
                    <button id="btnActualizarVenta" onClick="actualizarVenta();">Actualizar</button>
                </div>
                
                <!--Contenido de la pestaña VENTAS, submenú ELIMINAR-->
                <div class="tab-pane fade" id="EliminarVenta">
                    Número de venta:
                    <select id="numeroVentaEliminar" onChange="mostrarEliminarVenta();">
                    </select>
                    <br>

                    Número de cliente:
                    <input type="text" id="txtNumeroClienteVentaEliminar">
                    <br>
                    
                    Número de vendedor:
                    <input type="text" id="txtNumeroVendedorVentaEliminar">
                    <br>
                    
                    Monto de venta:
                    <input type="text" id="txtMontoVentaEliminar">
                    <br>
                    
                    <button id="btnEliminarVenta" onClick="eliminarVenta();">Eliminar</button>
                </div>

                <!--Contenido de la pestaña VENTAS, submenú BUSCAR-->
                <div class="tab-pane fade" id="BuscarVenta">
                    Número de venta:
                    <select id="numeroVentaBuscar" onChange="mostrarBuscarVenta();">
                    </select>
                    <br>

                    Número de cliente:
                    <input type="text" id="txtNumeroClienteVentaBuscar">
                    <br>
                    
                    Número de vendedor:
                    <input type="text" id="txtNumeroVendedorVentaBuscar">
                    <br>
                    
                    Monto de venta:
                    <input type="text" id="txtMontoVentaBuscar">
                    <br>
                </div>
                
                <!--Contenido de la pestaña VENTAS, submenú MOSTRAR TODOS-->
                <div class="tab-pane fade" id="MostrarVenta">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Número de venta</th>
                          <th>Número de cliente</th>
                          <th>Número de vendedor</th>
                          <th>Monto de venta</th>
                        </tr>
                      </thead>
                      <tbody id="TablaMostrarVenta">
                      </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>

