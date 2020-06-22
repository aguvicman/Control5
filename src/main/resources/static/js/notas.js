function NotasController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");

	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			url : "/notas/list",
			success : function(res) {
				$('#notasTable').bootstrapTable('load', res);
				$('#notasTable tbody').on('click', 'tr', function () {
					
					$("#curso").val($(this).find("td:eq(0)").text());
					$("#alumno").val($(this).find("td:eq(1)").text());
					$("#numero_modulo").val($(this).find("td:eq(2)").text());
					$("#numero_evaluacion").val($(this).find("td:eq(3)").text());
					$("#nota").val($(this).find("td:eq(4)").text());
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de notas.")
			}
		});       			
		break;
	case "get":
		$.ajax({
			type : "post",
			url : "/notas/get",
			data : "curso="+$("#curso").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {	
					$("#curso").val(res.curso);
					$("#alumno").val(res.alumno);
					$("#numero_modulo").val(res.numero_modulo);
					$("#numero_evaluacion").val(res.numero_evaluacion);
					$("#nota").val(res.nota);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de notas.");
			}
		});       			
		break;
	case "insert":
		var json = 
			{
				'curso': $("#curso").val(),
				'alumno': $("#alumno").val(),
				'numero_modulo': $("#numero_modulo").val(),
				'numero_evaluacion': $("#numero_evaluacion").val(),
				'nota': $("#nota").val(),
			};
	
	    var postData = JSON.stringify(json);

	    $.ajax({
			type : "post",
			url : "/notas/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro ingresado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	case "update":
		var json = 
			{
			'curso': $("#curso").val(),
			'alumno': $("#alumno").val(),
			'numero_modulo': $("#numero_modulo").val(),
			'numero_evaluacion': $("#numero_evaluacion").val(),
			'nota': $("#nota").val(),
			};
		;

	    var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
			url : "/notas/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				
				if (res == 0) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro modificado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "delete":
		$.ajax({
			type : "post",
			url : "/notas/delete",
			data : "curso="+$("#curso").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo eliminar el registro.");
			}
		});
		break;
	default:
		$("#msg").show();
		$("#msg").html("Opción incorrecta.");
	}
}
