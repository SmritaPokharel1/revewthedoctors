/**
 * 
 */
	function getZoneList(contextPath) {
		$.ajax({
			url : contextPath+'/admin/zones',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var zoneCombo = $("#zone-select");
				$("#zone-select").find("option").remove();
				$.each(data.zoneList, function(index, zone) {
					var option = $("<option>");
					option.attr("id", zone.zoneId);
					option.val(zone.name);
					option.text(zone.name);
					zoneCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	
	function getDistrictList(contextPath){
		$.ajax({
			url:contextPath+'/admin/districts',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createDistrictTable(data.districtList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}


	function createDistrictTable(districtList){
		var tbody = $("#district-list-body");
		tbody.html("");
		$.each(districtList,function(index,district){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index);
			row.append(cell);
			cell = $("<td>");
			cell.append(district.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(district.zone);
			row.append(cell);
			cell=$("<td>");
			cell.append(district.country);
			row.append(cell);
			cell = $("<td>");
			var anchor = $("<a class='district-edit' href='javascript:;' onClick='editdistrict(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='district-delete' onClick='deleteDistrict(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}