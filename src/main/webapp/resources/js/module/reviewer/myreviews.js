/**
 * 
 */

function getDoctorList(contextPath){
		$.ajax({
			url : contextPath+'/reviewer/doctors',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var doctorCombo = $("#doctor-select");
				$("#doctor-select").find("option").remove();
				$.each(data.doctorList, function(index, doctor) {
					var option = $("<option>");
					option.attr("id", doctor.doctorId);
					option.val(doctor.doctorId);
					option.text(doctor.firstName+" "+doctor.middleName+" "+doctor.lastName);
					doctorCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}
	
	function getUserList(contextPath){
		$.ajax({
			url : contextPath+'/reviewer/users',
			type : 'GET',
			beforeSend : function(request) {
				request.setRequestHeader("List_Type", "MULTIPLE");
			},
			success : function(data) {
				var userCombo = $("#user-select");
				$("#user-select").find("option").remove();
				$.each(data.userList, function(index, user) {
					var option = $("<option>");
					option.attr("id", user.userId);
					option.val(user.userId);
					option.text(user.firstName+" "+user.middleName+" "+user.lastName);
					userCombo.append(option);
				});

			},
			fail : function(data) {
				alert("failed to retrieve data");
			}

		});
	}