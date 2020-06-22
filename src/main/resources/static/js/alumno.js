function AlumnoController(opcion) {
	$("#msg1").hide();
	$("#msg1").removeClass("alert-success").addClass("alert-danger");

	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			url : "/alumno/list",
			success : function(res) {
				$('#alumnoTable').bootstrapTable('load', res);
				$('#alumnoTable tbody').on('click', 'tr', function () {
					
					$("#rut").val($(this).find("td:eq(0)").text());
					$("#nombre").val($(this).find("td:eq(1)").text());
					$("#curso").val($(this).find("td:eq(2)").text());
					
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg1").show();
				$("#msg1").html("Error en busqueda de Alumno.")
			}
		});       			
		break;
	case "get":
		$.ajax({
			type : "post",
			url : "/alumno/get",
			data : "rut="+$("#rut").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {	
					$("#rut").val(res.rut);
					$("#nombre").val(res.nombre);
					$("#curso").val(res.curso);
					
				}
			},
			error : function() {
				$("#msg1").show();
				$("#msg1").html("Error en busqueda de Alumno.");
			}
		});       			
		break;
	case "insert":
		var json = 
			{
				'rut': $("#rut").val(),
				'nombre': $("#nombre").val(),
				'curso': $("#curso").val(),
				
			};
	
	    var postData = JSON.stringify(json);

	    $.ajax({
			type : "post",
			url : "/alumno/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg1").removeClass("alert-danger").addClass("alert-success");
					$("#msg1").show();
					$("#msg1").html("Registro ingresado correctamente.");
				} else {
					$("#msg1").show();
					$("#msg1").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg1").show();
				$("#msg1").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	case "update":
		var json = 
			{
			'rut': $("#rut").val(),
			'nombre': $("#nombre").val(),
			'curso': $("#curso").val(),

			};
		;

	    var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
			url : "/alumno/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				
				if (res == 0) {
					$("#msg1").removeClass("alert-danger").addClass("alert-success");
					$("#msg1").show();
					$("#msg1").html("Registro modificado correctamente.");
				} else {
					$("#msg1").show();
					$("#msg1").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg1").show();
				$("#msg1").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "delete":
		$.ajax({
			type : "post",
			url : "/alumno/delete",
			data : "rut="+$("#rut").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg1").removeClass("alert-danger").addClass("alert-success");
					$("#msg1").show();
					$("#msg1").html("Registro eliminado correctamente.");
				} else {
					$("#msg1").show();
					$("#msg1").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg1").show();
				$("#msg1").html("No se pudo eliminar el registro.");
			}
		});
		break;
	default:
		$("#msg1").show();
		$("#msg1").html("Opción incorrecta.");
	}
}
