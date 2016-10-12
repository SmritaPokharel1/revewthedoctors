/**
 * 
 */
function getCountryList(contextPath) {
		$.ajax({
			url : ''+contextPath+'/admin/countries',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var countryCombo = $("#country-select");
				$("#country-select").find("option").remove();
				$.each(data.countryList, function(index, country) {
					var option = $("<option>");
					option.attr("id", country.countryId);
					option.val(country.name);
					option.text(country.name);
					countryCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	
	function getZoneList(contextPath){
		$.ajax({
			url:''+contextPath+'/admin/zones',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createZoneTable(data.zoneList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}


	function createZoneTable(zoneList){
		var tbody = $("#zone-list-body");
		tbody.html("");
		$.each(zoneList,function(index,zone){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index);
			row.append(cell);
			cell = $("<td>");
			cell.append(zone.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(zone.country);
			row.append(cell);
			cell = $("<td>");
			var anchor = $("<a class='zone-edit' href='javascript:;' onClick='editZone(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='zone-delete' onClick='deleteZone(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}