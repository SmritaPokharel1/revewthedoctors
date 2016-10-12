/**
 * 
 */
function getSpecialityList(contextPath){
		$.ajax({
			url:contextPath+'/admin/specialities',
			type:'GET',
			beforeSend : function(request){
				request.setRequestHeader("List_Type","MULTIPLE");
			},
			success: function(data){
				createSpecialityTable(data.specialityList);
			},
			fail: function(data){
				alert("failed to retrieve data");
			}
			
		});
	}


	function createSpecialityTable(specialityList){
		var tbody = $("#speciality-list-body");
		tbody.html("");
		$.each(specialityList,function(index,speciality){
			var row=$("<tr>");
			var cell =$("<td>");
			cell.append(index+1);
			row.append(cell);
			cell = $("<td>");
			cell.append(speciality.specialityName);
			row.append(cell);
			cell=$("<td>");
			cell.append(speciality.category);
			row.append(cell);
			cell=$("<td>")
			var anchor = $("<a class='speciality-edit' href='javascript:;' onClick='editSpeciality(this)' ><i class='material-icons'>ic_mode_edit</i></a><a style='margin-left:-184px;'class='speciality-delete' onClick='deleteSpeciality(this)' href='javascript:;'><i class='material-icons'>ic_mode_delete</i></a>"); 
			cell.append(anchor);
			row.append(cell);
			tbody.append(row);
		});
	}