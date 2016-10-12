/**
 * 
 */
	function getDistrictList(contextPath) {
		$.ajax({
			url : contextPath+'/admin/districts',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var districtCombo = $("#district-select");
				$("#district-select").find("option").remove();
				$.each(data.districtList, function(index, district) {
					var option = $("<option>");
					option.attr("id", district.districtId);
					option.val(district.name);
					option.text(district.name);
					districtCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	
	function getCityList(contextPath){
		$.ajax({
			url:contextPath+'/admin/cities',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createCityTable(data.cityList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}


	function createCityTable(cityList){
		var tbody = $("#city-list-body");
		tbody.html("");
		$.each(cityList,function(index,city){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index+1);
			row.append(cell);
			cell = $("<td>");
			cell.append(city.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(city.district);
			row.append(cell);
			cell=$("<td>");
			cell.append(city.zone);
			row.append(cell);
			cell=$("<td>");
			cell.append(city.country);
			row.append(cell);
			cell = $("<td>");
			var anchor = $("<a class='city-edit' href='javascript:;' onClick='editCity(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='city-delete' onClick='deleteCity(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}