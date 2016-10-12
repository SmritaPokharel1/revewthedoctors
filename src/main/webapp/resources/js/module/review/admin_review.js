/**
 * 
 */
	function getDoctorList(contextPath){
		$.ajax({
			url : contextPath+'/admin/doctors',
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
			url : contextPath+'/admin/users',
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
	
	
	function getReviewList(contextPath){
		$.ajax({
			url:contextPath+'/admin/reviews',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createReviewTable(data.reviewList,contextPath);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}

	function createReviewTable(reviewList,contextPath){
		var tbody = $("#review-list-body");
		tbody.html("");
		$.each(reviewList,function(index,review){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index+1);
			row.append(cell);
			cell= $("<td>");
			cell.append("<a href='"+contextPath+"/admin/individualreview?reviewId="+review.reviewId+"'>"+review.review+"</a>");
			row.append(cell);
			cell=$("<td>");
			cell.append(review.rating);
			row.append(cell);
			cell = $("<td>");
			
			cell=$("<td>");
			cell.append(review.doctor.firstName+" "+review.doctor.middleName+" "+review.doctor.lastName);
			row.append(cell);
			cell = $("<td>");
			
			cell.append(review.user.firstName+" "+review.user.middleName+" "+review.user.lastName);
			row.append(cell);
			
			cell = $("<td>");
			var anchor = $("<a class='user-edit' href='javascript:;' onClick='editDoctor(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='doctor-delete' onClick='deleteDoctor(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}