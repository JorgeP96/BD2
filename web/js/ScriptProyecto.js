//Se ejecuta la funcion para rellenar la tabla de mostrarAlmacenes
mostrarAlmacenes();
mostrarClientes();
mostrarVendedores();
mostrarVentas();

var arrayAlmacenes;
var arrayClientes;
var arrayVendedores;
var arrayVentas;

//Mostrar todos los almacenes en tabla y select para eliminar,
//actualizar y buscar
function mostrarAlmacenes(){
    $.ajax({
        url: "buscar-todos-almacen",
        type: 'GET',
        success: function (json) {
            $("#numeroAlmacenActualizar").empty();
            $("#numeroAlmacenBuscar").empty();
            $("#numeroAlmacenEliminar").empty();
            $("#TablaMostrarAlmacen").empty();
            
            $("#numeroAlmacenActualizar").append("<option>--</option>");
            $("#numeroAlmacenBuscar").append("<option>--</option>");
            $("#numeroAlmacenEliminar").append("<option>--</option>");
            
            for(var i = 0; i < json.length; i++){
                $("#TablaMostrarAlmacen").append(
                                                "<tr><td>" + json[i].numeroAlmacen +"</td><td>" +
                                                             json[i].ubicacionAlmacen + "</td></tr>");
                                                     
                $("#numeroAlmacenActualizar").append("<option value=" + json[i].numeroAlmacen + ">" + json[i].numeroAlmacen + "</option>");
                $("#numeroAlmacenBuscar").append("<option value=" + json[i].numeroAlmacen + ">" + json[i].numeroAlmacen + "</option>");
                $("#numeroAlmacenEliminar").append("<option value=" + json[i].numeroAlmacen + ">" + json[i].numeroAlmacen + "</option>");
            }
            arrayAlmacenes = json;
        }
    });
};

//Guardar ALMACEN
function guardarAlmacen(){
    $.ajax({
        type: 'POST',
        url: "guardar-almacen",
        data:{
            numero: $("#txtNumeroAlmacenGuardar").val(),
            ubicacion: $("#txtUbicacionAlmacenGuardar").val()
        },
        success: function (response) {
            $("#txtNumeroAlmacenGuardar").val("");
            $("#txtUbicacionAlmacenGuardar").val("");
            mostrarAlmacenes();
            alert(response);
        }
    });
};

//Actualizar ALMACEN
function actualizarAlmacen(){
    if($("#numeroAlmacenActualizar").val() === "--"){
        alert("Selecciona un almacén válido");
    } else{
        $.ajax({
            type: 'POST',
            url: "actualizar-almacen",
            data:{
                numeroAlmacenActualizar: $("#numeroAlmacenActualizar").val(),
                ubicacionAlmacenActualizar: $("#txtUbicacionAlmacenActualizar").val()
            },
            success: function (response) {
                $("#numeroAlmacenActualizar").val("--");
                $("#txtUbicacionAlmacenActualizar").val("");
                mostrarAlmacenes();
                alert(response);
            }
        });
    }
};

//Eliminar ALMACEN
function eliminarAlmacen(){
    
    if($("#numeroAlmacenEliminar").val() === "--"){
        alert("Selecciona un almacén válido");
    } else {
        $.ajax({
            type: 'POST',
            url: "eliminar-almacen",
            data:{
                numeroAlmacenEliminar: $("#numeroAlmacenEliminar").val()
            },
            success: function (response) {
                $("#numeroAlmacenEliminar").val("--");
                $("#txtUbicacionAlmacenEliminar").val("");
                mostrarAlmacenes();
                alert(response);
            }
        });
    }
};

//Mostrar almacen para buscar por ID
function mostrarBuscarAlmacen(){
    var idAlmacen = $("#numeroAlmacenBuscar").prop('selectedIndex');
    
    if($("#numeroAlmacenBuscar").val() === "--"){
        $("#txtUbicacionAlmacenBuscar").empty();
        alert("Selecciona un almacén válido");
    } else{
        $("#txtUbicacionAlmacenBuscar").html(arrayAlmacenes[idAlmacen - 1].ubicacionAlmacen);
    }
};

//Mostrar almacen para actualizar por ID
function mostrarActualizarAlmacen(){
    var idAlmacen = $("#numeroAlmacenActualizar").prop('selectedIndex');
    
    if($("#numeroAlmacenActualizar").val() === "--"){
        $("#txtUbicacionAlmacenActualizar").val(" ");
        alert("Selecciona un almacén válido");
    } else{
        $("#txtUbicacionAlmacenActualizar").val(arrayAlmacenes[idAlmacen - 1].ubicacionAlmacen);
    }
};

//Mostrar almacen para eliminar por ID
function mostrarEliminarAlmacen(){
    var idAlmacen = $("#numeroAlmacenEliminar").prop('selectedIndex');
    
    if($("#numeroAlmacenEliminar").val() === "--"){
        $("#txtUbicacionAlmacenEliminar").val(" ");
        alert("Selecciona un almacén válido");
    } else{
        $("#txtUbicacionAlmacenEliminar").val(arrayAlmacenes[idAlmacen - 1].ubicacionAlmacen);
    }
};





//Mostrar todos los clientes en tabla y select para eliminar,
//actualizar y buscar
function mostrarClientes(){
    $.ajax({
        url: "buscar-todos-cliente",
        type: 'GET',
        success: function (json) {
            $("#numeroClienteActualizar").empty();
            $("#numeroClienteBuscar").empty();
            $("#numeroClienteEliminar").empty();
            $("#TablaMostrarCliente").empty();
            
            $("#numeroClienteActualizar").append("<option>--</option>");
            $("#numeroClienteBuscar").append("<option>--</option>");
            $("#numeroClienteEliminar").append("<option>--</option>");
            
            for(var i = 0; i < json.length; i++){
                $("#TablaMostrarCliente").append(
                                                "<tr><td>" + json[i].numeroCliente +"</td><td>" +
                                                             json[i].numeroAlmacen + "</td><td>" +
                                                             json[i].nombreCliente + "</td></tr>");
                                                     
                $("#numeroClienteActualizar").append("<option value=" + json[i].numeroCliente + ">" + json[i].numeroCliente + "</option>");
                $("#numeroClienteBuscar").append("<option value=" + json[i].numeroCliente + ">" + json[i].numeroCliente + "</option>");
                $("#numeroClienteEliminar").append("<option value=" + json[i].numeroCliente + ">" + json[i].numeroCliente + "</option>");
            }
            arrayClientes = json;
        }
    });
};

//Guardar CLIENTE
function guardarCliente(){
    $.ajax({
        type: 'POST',
        url: "guardar-cliente",
        data:{
            numeroClienteGuardar: $("#txtNumeroClienteGuardar").val(),
            numeroAlmacenGuardar: $("#txtNumeroAlmacenClienteGuardar").val(),
            nombreClienteGuardar: $("#txtNombreClienteGuardar").val()
        },
        success: function (response) {
            $("#txtNumeroClienteGuardar").val("");
            $("#txtNumeroAlmacenClienteGuardar").val("");
            $("#txtNombreClienteGuardar").val("");
            mostrarClientes();
            alert(response);
        }
    });
};

//Actualizar CLIENTE
function actualizarCliente(){
    if($("#numeroClienteActualizar").val() === "--"){
        alert("Selecciona un cliente válido");
    } else{
        $.ajax({
            type: 'POST',
            url: "actualizar-cliente",
            data:{
                numeroClienteActualizar: $("#numeroClienteActualizar").val(),
                numeroAlmacenClienteActualizar: $("#txtNumeroAlmacenClienteActualizar").val(),
                nombreClienteActualizar: $("#txtNombreClienteActualizar").val()
            },
            success: function (response) {
                $("#numeroClienteActualizar").val("--");
                $("#txtNumeroAlmacenClienteActualizar").val("");
                $("#txtNombreClienteActualizar").val("");
                mostrarClientes();
                alert(response);
            }
        });
    }
};

//Eliminar CLIENTE
function eliminarCliente(){
    
    if($("#numeroClienteEliminar").val() === "--"){
        alert("Selecciona un cliente válido");
    } else {
        $.ajax({
            type: 'POST',
            url: "eliminar-cliente",
            data:{
                numeroClienteEliminar: $("#numeroClienteEliminar").val()
            },
            success: function (response) {
                $("#numeroClienteEliminar").val("--");
                $("#txtNumeroAlmacenClienteEliminar").val("");
                $("#txtNombreClienteEliminar").val("");
                mostrarClientes();
                alert(response);
            }
        });
    }
};

//Mostrar cliente para buscar por ID
function mostrarBuscarCliente(){
    var idCliente = $("#numeroClienteBuscar").prop('selectedIndex');
    
    if($("#numeroClienteBuscar").val() === "--"){
        $("#txtNumeroAlmacenClienteBuscar").val("");
        $("#txtNombreClienteBuscar").val("");
        alert("Selecciona un cliente válido");
    } else{
        $("#txtNumeroAlmacenClienteBuscar").val(arrayClientes[idCliente - 1].numeroAlmacen);
        $("#txtNombreClienteBuscar").val(arrayClientes[idCliente - 1].nombreCliente);
    }
};

//Mostrar cliente para actualizar por ID
function mostrarActualizarCliente(){
    var idCliente = $("#numeroClienteActualizar").prop('selectedIndex');
    
    if($("#numeroClienteActualizar").val() === "--"){
        $("#txtNumeroAlmacenClienteActualizar").val("");
        $("#txtNombreClienteActualizar").val("");
        alert("Selecciona un cliente válido");
    } else{
        $("#txtNumeroAlmacenClienteActualizar").val(arrayClientes[idCliente - 1].numeroAlmacen);
        $("#txtNombreClienteActualizar").val(arrayClientes[idCliente - 1].nombreCliente);
    }
};

//Mostrar cliente para eliminar por ID
function mostrarEliminarCliente(){
    var idCliente = $("#numeroClienteEliminar").prop('selectedIndex');
    
    if($("#numeroClienteEliminar").val() === "--"){
        $("#txtNumeroAlmacenClienteEliminar").val("");
        $("#txtNombreClienteEliminar").val("");
        alert("Selecciona un cliente válido");
    } else{
        $("#txtNumeroAlmacenClienteEliminar").val(arrayClientes[idCliente - 1].numeroAlmacen);
        $("#txtNombreClienteEliminar").val(arrayClientes[idCliente - 1].nombreCliente);
    }
};





//Mostrar todos los vendedores en tabla y select para eliminar,
//actualizar y buscar
function mostrarVendedores(){
    $.ajax({
        url: "buscar-todos-vendedor",
        type: 'GET',
        success: function (json) {
            $("#numeroVendedorActualizar").empty();
            $("#numeroVendedorBuscar").empty();
            $("#numeroVendedorEliminar").empty();
            $("#TablaMostrarVendedor").empty();
            
            $("#numeroVendedorActualizar").append("<option>--</option>");
            $("#numeroVendedorBuscar").append("<option>--</option>");
            $("#numeroVendedorEliminar").append("<option>--</option>");
            
            for(var i = 0; i < json.length; i++){
                $("#TablaMostrarVendedor").append(
                                                "<tr><td>" + json[i].numeroVendedor +"</td><td>" +
                                                             json[i].nombreVendedor + "</td><td>" +
                                                             json[i].areaVentas + "</td></tr>");
                                                     
                $("#numeroVendedorActualizar").append("<option value=" + json[i].numeroVendedor + ">" + json[i].numeroVendedor + "</option>");
                $("#numeroVendedorBuscar").append("<option value=" + json[i].numeroVendedor + ">" + json[i].numeroVendedor + "</option>");
                $("#numeroVendedorEliminar").append("<option value=" + json[i].numeroVendedor + ">" + json[i].numeroVendedor + "</option>");
            }
            arrayVendedores = json;
        }
    });
};

//Guardar CLIENTE
function guardarVendedor(){
    $.ajax({
        type: 'POST',
        url: "guardar-vendedor",
        data:{
            numeroVendedorGuardar: $("#txtNumeroVendedorGuardar").val(),
            nombreVendedorGuardar: $("#txtNombreVendedorGuardar").val(),
            areaVentasGuardar: $("#txtAreaVentasGuardar").val()
        },
        success: function (response) {
            $("#txtNumeroVendedorGuardar").val("");
            $("#txtNombreVendedorGuardar").val("");
            $("#txtAreaVentasGuardar").val("");
            mostrarVendedores();
            alert(response);
        }
    });
};

//Actualizar CLIENTE
function actualizarVendedor(){
    if($("#numeroVendedorActualizar").val() === "--"){
        alert("Selecciona un vendedor válido");
    } else{
        $.ajax({
            type: 'POST',
            url: "actualizar-vendedor",
            data:{
                numeroVendedorActualizar: $("#numeroVendedorActualizar").val(),
                nombreVendedorActualizar: $("#txtNombreVendedorActualizar").val(),
                areaVentasActualizar: $("#txtAreaVentasActualizar").val()
            },
            success: function (response) {
                $("#numeroVendedorActualizar").val("--");
                $("#txtNombreVendedorActualizar").val("");
                $("#txtAreaVentasActualizar").val("");
                mostrarVendedores();
                alert(response);
            }
        });
    }
};

//Eliminar CLIENTE
function eliminarVendedor(){
    
    if($("#numeroVendedorEliminar").val() === "--"){
        alert("Selecciona un vendedor válido");
    } else {
        $.ajax({
            type: 'POST',
            url: "eliminar-vendedor",
            data:{
                numeroVendedorEliminar: $("#numeroVendedorEliminar").val()
            },
            success: function (response) {
                $("#numeroVendedorEliminar").val("--");
                $("#txtNombreVendedorEliminar").val("");
                $("#txtAreaVentasEliminar").val("");
                mostrarVendedores();
                alert(response);
            }
        });
    }
};

//Mostrar cliente para buscar por ID
function mostrarBuscarVendedor(){
    var idCliente = $("#numeroVendedorBuscar").prop('selectedIndex');
    
    if($("#numeroVendedorBuscar").val() === "--"){
        $("#txtNombreVendedorBuscar").val("");
        $("#txtAreaVentasBuscar").val("");
        alert("Selecciona un vendedor válido");
    } else{
        $("#txtNombreVendedorBuscar").val(arrayVendedores[idCliente - 1].nombreVendedor);
        $("#txtAreaVentasBuscar").val(arrayVendedores[idCliente - 1].areaVentas);
    }
};

//Mostrar cliente para actualizar por ID
function mostrarActualizarVendedor(){
    var idCliente = $("#numeroVendedorActualizar").prop('selectedIndex');
    
    if($("#numeroVendedorActualizar").val() === "--"){
        $("#txtNombreVendedorActualizar").val("");
        $("#txtAreaVentasActualizar").val("");
        alert("Selecciona un vendedor válido");
    } else{
        $("#txtNombreVendedorActualizar").val(arrayVendedores[idCliente - 1].nombreVendedor);
        $("#txtAreaVentasActualizar").val(arrayVendedores[idCliente - 1].areaVentas);
    }
};

//Mostrar cliente para eliminar por ID
function mostrarEliminarVendedor(){
    var idCliente = $("#numeroVendedorEliminar").prop('selectedIndex');
    
    if($("#numeroVendedorEliminar").val() === "--"){
        $("#txtNombreVendedorEliminar").val("");
        $("#txtAreaVentasEliminar").val("");
        alert("Selecciona un vendedor válido");
    } else{
        $("#txtNombreVendedorEliminar").val(arrayVendedores[idCliente - 1].nombreVendedor);
        $("#txtAreaVentasEliminar").val(arrayVendedores[idCliente - 1].areaVentas);
    }
};








//Mostrar todas los ventas en tabla y select para eliminar,
//actualizar y buscar
function mostrarVentas(){
    $.ajax({
        url: "buscar-todos-venta",
        type: 'GET',
        success: function (json) {
            $("#numeroVentaActualizar").empty();
            $("#numeroVentaBuscar").empty();
            $("#numeroVentaEliminar").empty();
            $("#TablaMostrarVenta").empty();
            
            $("#numeroVentaActualizar").append("<option>--</option>");
            $("#numeroVentaBuscar").append("<option>--</option>");
            $("#numeroVentaEliminar").append("<option>--</option>");
            
            for(var i = 0; i < json.length; i++){
                $("#TablaMostrarVenta").append(
                                                "<tr><td>" + json[i].idVentas +"</td><td>" +
                                                             json[i].numeroCliente + "</td><td>" +
                                                             json[i].numeroVendedor + "</td><td>" +
                                                             json[i].montoVenta + "</td></tr>");
                                                     
                $("#numeroVentaActualizar").append("<option value=" + json[i].idVentas + ">" + json[i].idVentas + "</option>");
                $("#numeroVentaBuscar").append("<option value=" + json[i].idVentas + ">" + json[i].idVentas + "</option>");
                $("#numeroVentaEliminar").append("<option value=" + json[i].idVentas + ">" + json[i].idVentas + "</option>");
            }
            arrayVentas = json;
        }
    });
};

//Guardar CLIENTE
function guardarVenta(){
    $.ajax({
        type: 'POST',
        url: "guardar-venta",
        data:{
            numeroClienteVentaGuardar: $("#txtNumeroClienteVentaGuardar").val(),
            numeroVendedorVentaGuardar: $("#txtNumeroVendedorVentaGuardar").val(),
            montoVentaGuardar: $("#txtMontoVentaGuardar").val()
        },
        success: function (response) {
            $("#txtNumeroClienteVentaGuardar").val("");
            $("#txtNumeroVendedorVentaGuardar").val("");
            $("#txtMontoVentaGuardar").val("");
            mostrarVentas();
            alert(response);
        }
    });
};

//Actualizar CLIENTE
function actualizarVenta(){
    if($("#numeroVentaActualizar").val() === "--"){
        alert("Selecciona una venta válida");
    } else{
        $.ajax({
            type: 'POST',
            url: "actualizar-venta",
            data:{
                numeroVentaActualizar: $("#numeroVentaActualizar").val(),
                numeroClienteVentaActualizar: $("#txtNumeroClienteVentaActualizar").val(),
                numeroVendedorVentaActualizar: $("#txtNumeroVendedorVentaActualizar").val(),
                montoVentaActualizar: $("#txtMontoVentaActualizar").val()
            },
            success: function (response) {
                $("#numeroVentaActualizar").val("--");
                $("#txtNumeroClienteVentaActualizar").val("");
                $("#txtNumeroVendedorVentaActualizar").val("");
                $("#txtMontoVentaActualizar").val("");
                mostrarVentas();
                alert(response);
            }
        });
    }
};

//Eliminar CLIENTE
function eliminarVenta(){
    
    if($("#numeroVentaEliminar").val() === "--"){
        $("#txtNumeroClienteVentaEliminar").val("");
        $("#txtNumeroVendedorVentaEliminar").val("");
        $("#txtMontoVentaEliminar").val("");
        alert("Selecciona una venta válida");
    } else{
        $.ajax({
            type: 'POST',
            url: "eliminar-venta",
            data:{
                numeroVentaEliminar: $("#numeroVentaEliminar").val()
            },
            success: function (response) {
                $("#numeroVentaEliminar").val("--");
                $("#txtNumeroClienteVentaEliminar").val("");
                $("#txtNumeroVendedorVentaEliminar").val("");
                $("#txtMontoVentaEliminar").val("");
                mostrarVentas();
                alert(response);
            }
        });
    }
};

//Mostrar cliente para buscar por ID
function mostrarBuscarVenta(){
    var idVenta = $("#numeroVentaBuscar").prop('selectedIndex');
    
    if($("#numeroVentaBuscar").val() === "--"){
        $("#txtNumeroClienteVentaBuscar").val("");
        $("#txtNumeroVendedorVentaBuscar").val("");
        $("#txtMontoVentaBuscar").val("");
        alert("Selecciona una venta válida");
    } else{
        $("#txtNumeroClienteVentaBuscar").val(arrayVentas[idVenta - 1].numeroCliente);
        $("#txtNumeroVendedorVentaBuscar").val(arrayVentas[idVenta - 1].numeroVendedor);
        $("#txtMontoVentaBuscar").val(arrayVentas[idVenta - 1].montoVenta);
    }
};

//Mostrar cliente para actualizar por ID
function mostrarActualizarVenta(){
    var idVenta = $("#numeroVentaActualizar").prop('selectedIndex');
    
    if($("#numeroVentaActualizar").val() === "--"){
        $("#txtNumeroClienteVentaActualizar").val("");
        $("#txtNumeroVendedorVentaActualizar").val("");
        $("#txtMontoVentaActualizar").val("");
        alert("Selecciona una venta válida");
    } else{
        $("#txtNumeroClienteVentaActualizar").val(arrayVentas[idVenta - 1].numeroCliente);
        $("#txtNumeroVendedorVentaActualizar").val(arrayVentas[idVenta - 1].numeroVendedor);
        $("#txtMontoVentaActualizar").val(arrayVentas[idVenta - 1].montoVenta);
    }
};

//Mostrar cliente para eliminar por ID
function mostrarEliminarVenta(){
    var idVenta = $("#numeroVentaEliminar").prop('selectedIndex');
    
    if($("#numeroVentaEliminar").val() === "--"){
        $("#txtNumeroClienteVentaEliminar").val("");
        $("#txtNumeroVendedorVentaEliminar").val("");
        $("#txtMontoVentaEliminar").val("");
        alert("Selecciona una venta válida");
    } else{
        $("#txtNumeroClienteVentaEliminar").val(arrayVentas[idVenta - 1].numeroCliente);
        $("#txtNumeroVendedorVentaEliminar").val(arrayVentas[idVenta - 1].numeroVendedor);
        $("#txtMontoVentaEliminar").val(arrayVentas[idVenta - 1].montoVenta);
    }
};