/**
 * 
 */


	function getCityList(contextPath) {
		$.ajax({
			url : contextPath+'/main/cities',
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
	
