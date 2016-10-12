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
			url : contextPath+'/admin/hospitals',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var hospitalCombo = $("#hospital-select");
				$("#hospital-select").find("option").remove();
				$.each(data.hospitalList, function(index, hospital) {
					var option = $("<option>");
					option.attr("id", hospital.hospitalId);
					option.val(hospital.name);
					option.text(hospital.name);
					hospitalCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	function getSpecialityList(contextPath){
		$.ajax({
			url : contextPath+'/admin/specialities',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var specialityCombo = $("#speciality-select");
				$("#speciality-select").find("option").remove();
				$.each(data.specialityList, function(index, speciality) {
					var option = $("<option>");
					option.attr("id", speciality.specialityId);
					option.val(speciality.specialityName);
					option.text(speciality.specialityName);
					specialityCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	
	function getDoctorList(contextPath){
		$.ajax({
			url:contextPath+'/admin/doctors',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createDoctorTable(data.doctorList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}

	function createDoctorTable(doctorList){
		var tbody = $("#doctor-list-body");
		tbody.html("");
		$.each(doctorList,function(index,doctor){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index+1);
			row.append(cell);
			cell= $("<td>");
			cell.append(doctor.firstName+" "+doctor.middleName+" "+doctor.lastName);
			row.append(cell);
			cell=$("<td>");
			cell.append(doctor.speciality.specialityName);
			row.append(cell);
			cell = $("<td>");
			
			cell=$("<td>");
			cell.append(doctor.hospital.name);
			row.append(cell);
			cell = $("<td>");
			
			cell.append(doctor.hospital.city.name);
			row.append(cell);
			cell=$("<td>");
			cell.append(doctor.hospital.city.district);
			row.append(cell);
			cell=$("<td>");
			cell.append(doctor.hospital.city.zone);
			row.append(cell);
			cell=$("<td>");
			cell.append(doctor.hospital.city.country);
			row.append(cell);
			cell = $("<td>");
			var anchor = $("<a class='user-edit' href='javascript:;' onClick='editDoctor(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='doctor-delete' onClick='deleteDoctor(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}