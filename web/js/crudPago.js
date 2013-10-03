//DECLARACION DE LAS CLASES
ABML = {
Views: {},
        Models: {},
        Collections: {},
        URL:'http://localhost:8080/crudBD/webresources/pagos',
        id_venta : -1,
        total_venta:0,
        tipo_pago:-1,
        venta:{},
        pago:{}
};
        ABML.Collections.Pagos = Backbone.Collection.extend({
            url: '/crudBD/webresources/pagos/'
        });
       ABML.Models.Pago= Backbone.Model.extend({

            initialize: function() {
                _.bindAll(this);
                
            }
        });
        ABML.Views.GridView = Backbone.View.extend(
{
        events: {
                "click #btnContado": "contado",
                "click #btnCredito": "credito",          
                "click #btnPagar": "realizarPago"
        },
        initialize: function() {

            console.log("Se inicializo la vista GRID");
            console.log(ABML.URL);
            $.ajax({
                    type: 'GET',
                    url: 'http://localhost:8080/crudBD/webresources/ventas/ultimaVenta',
                    dataType: "json",
                    success: function(data, textStatus, jqXHR) {
                       ABML.total_venta=data.total;
                       ABML.venta=data;
                       $('#montoId').val(ABML.total_venta);
                        console.log("Se trajo el id de venta " + data.id );
                        ABML.id_venta = data.id;
                         var obj = {
                                'venta':{'id':data.id,
                                            'total':data.total
                                            //'detalles' : data.detalles
                                               // 'cliente': data.comprador
                                }
                                 
           
                        };
                        $.ajax({
                            type: 'POST',
                            contentType: 'application/json',
                            url: ABML.URL,
                            dataType: "json",
                            data: JSON.stringify(obj),
                            success: function(data, textStatus, jqXHR) {
                                    console.log('Pago Creado de la gran pistola, se genero un PRE-PAGO');
                                    ABML.pago=data; 
                            },
                            error: function(jqXHR, textStatus, errorThrown) {
                                alert('agregarPago error: ' + textStatus);
                                console.log("kilombo frente al arco al guardar");
                            }
                        });
                } 
            });
             

},

        contado: function(){
            console.log("hiciste click en contado");
            $("#confir").val("Va a pagar al contado, favor click en confirmar");
            $("#confir").show();
            
            ABML.tipo_pago=0;
            return false;
        },   
        
        credito: function(){
            console.log("hiciste click en credito");
            $("#confir").val("Va a pagar a credito, favor click en confirmar");
            $("#confir").show();
            
            ABML.tipo_pago=1;
            return false;
        },
                
        realizarPago: function(){
            console.log("ESTAS EN REALIZAR PAGO");
            console.log("venta id " + ABML.pago.venta.id + "  total "+ ABML.pago.venta.total);
            alert("El pago ha sido confirmado");
            
            return false;
        }            
    
});
        // ACA EMPIEZA LA ACCION

        ABML.gridView = new ABML.Views.GridView({el:'#main'});



