/*function Listado_Notas(opcion){
	
	
	if curso= 1
		var promedio1=( nota) 
		
	
	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
			url : "/notas/list",
			success : function(res) {
				$('#notasTable').bootstrapTable('load', res);
				$('#notasTable tbody').on('click', 'tr', function () {
					
					$("#curso").val($(this).find("td:eq(0)").text());
					$("#promedio").val($(this).find("td:eq(1)").text());
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
	
	
}