/**
 * 
 */
/*function getAllCountries(contextPath){
	
	$.ajax({
		url:contextPath+'/admin/countryList',
		type:'GET',
		beforeSend : function(request){
			request.setRequestHeader("List_Type","MULTIPLE");
		},
		success: function(data){
			alert("data is "+data);
			createCountryTable(data.countryList);
		},
		fail: function(data){
			alert("failed to retrieve data");
		}
		
	});
}


function createCountryTable(countryList){
	var tbody = $("#country-list-body");
	
	$.each(countryList,function(index,country){
		var row=$("<tr>");
		var cell =$("<td>");
		cell.append(index);
		row.append(cell);
		cell = $("<td>");
		cell.append(country.name);
		row.append(cell);
		cell = $("<td>");
		var editAnchor = $("<a href='#' onClick='editCountry('"+country.id+"')'><i class='material-icons'>ic_mode_edit</i></a><a href='#' onClick='deleteCountry('"+country.id+"')'><i class='material-icons'>ic_mode_delete</i></a>"); 
		//var deleteAnchor = $("<a href='#' onClick='deleteCountry('"+country.id+"')'><i class='material-icons'>ic_mode_delete</i></a>");
		cell.append(editAnchor);
	//	cell.append(deleteAnchor);
		row.append(cell);
		tbody.append(row);
	});
}*/

function getAllCountries(contextPath){
	
	$.ajax({
		url:contextPath+'/admin/countries',
		type:'GET',
		beforeSend : function(request){
			request.setRequestHeader("List_Type","MULTIPLE");
		},
		success: function(data){
			createCountryTable(data.countryList);
		},
		fail: function(data){
			alert("failed to retrieve data");
		}
		
	});
}


function createCountryTable(countryList){
	$("#country-list-body").html("");
	var tbody = $("#country-list-body");
	
	$.each(countryList,function(index,country){
		var row=$("<tr countryId='"+country.countryId+"'>");
		var cell =$("<td>");
		cell.append(index+1);
		row.append(cell);
		cell = $("<td>");
		cell.append(country.name);
		row.append(cell);
		cell = $("<td>");
		var editAnchor = $("<a class='country-edit' href='javascript:;' onClick='editCountry(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='country-delete' onClick='deleteCountry(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
	//	var deleteAnchor = $("<a href='#' onClick='deleteCountry('"+country.id+"')'><i class='material-icons'>ic_mode_delete</i></a>");
		cell.append(editAnchor);
	//	cell.append(deleteAnchor);
		row.append(cell);
		tbody.append(row);
	});
}

function deleteCountry(contextPath,object){
	var tr = $(object).closest("tr");
	var countryId = tr.attr("countryId");
	$.ajax({
		url:contextPath+"/admin/countries",
		type:"DELETE",
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		data:countryId,
		success:function(data){
			$("#country-section-2-anchor").click();
			alert(data);
		},
		fail:function(data){}
	
		
	});
}
	
