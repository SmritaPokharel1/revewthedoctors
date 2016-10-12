/**
 * 
 */

	function getCityList(contextPath) {
		$.ajax({
			url : contextPath+'/admin/cities',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var districtCombo = $("#city-select");
				$("#city-select").find("option").remove();
				$.each(data.cityList, function(index, city) {
					var option = $("<option>");
					option.attr("id", city.cityId);
					option.val(city.name);
					option.text(city.name);
					districtCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	
	function getHospitalList(contextPath){
		$.ajax({
			url:contextPath+'/admin/hospitals',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createHospitalTable(data.hospitalList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}

	function createHospitalTable(hospitalList){
		var tbody = $("#hospital-list-body");
		tbody.html("");
		$.each(hospitalList,function(index,hospital){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index+1);
			row.append(cell);
			cell= $("<td>");
			cell.append(hospital.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(hospital.hospitalType);
			row.append(cell);
			cell = $("<td>");
			cell.append(hospital.city.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(hospital.city.district);
			row.append(cell);
			cell=$("<td>");
			cell.append(hospital.city.zone);
			row.append(cell);
			cell=$("<td>");
			cell.append(hospital.city.country);
			row.append(cell);
			cell = $("<td>");
			var anchor = $("<a class='user-edit' href='javascript:;' onClick='editUser(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='user-delete' onClick='deleteUser(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}