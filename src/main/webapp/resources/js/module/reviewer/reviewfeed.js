/**
 * 
 */

$(document).ready(function(){
	getReviewList();
	$("#review-feed-anchor").class("is-active");
});

function getReviewList(){
	$.ajax({
		url:'/revewthedoctors/admin/reviews',
		type:'GET',
		beforeSend : function(request){
			request.setRequestHeader("List_Type","MULTIPLE");
		},
		success: function(data){
			$("#review-feed").html("");
			createReviewFeed(data.reviewList);
		},
		fail: function(data){
			alert("failed to retrieve data");
		}
		
	});
}

function createReviewFeed(reviewList){
	var counter = 1;
	//var grid=$("#review-feed-grid") ;
	$.each(reviewList,function(index,review){
		/*console.log("reviewlist "+reviewList.length);
		console.log("index is "+index);
		console.log("remainder "+reviewList.length%3!=0);
		console.log("remainder "+reviewList.length%3);
		
		if(index%3==0 && reviewList.length%3==1){
			$("#review-feed").append(grid);
		}
		if(index%4==0 &&reviewList.length%3==2){
			$("#review-feed").append(grid);
		}
		
		if(counter==4){
			counter=1;
			$("#review-feed").append(grid);
			grid= $("<div class='mdl-grid'></div>");
		}
		
		if(counter<4){*/
			
			var triColumnDiv =$("<div class='mdl-cell mdl-cell--4-col'></div>");
			var cardMainDiv=$("<div class='demo-card-wide mdl-card mdl-shadow--2dp' style='min-height:80px !important;min-width:350px !important;'></div>");
			var supportingTextDiv=$("<div class='mdl-card__supporting-text' ></div>");
			var table = $("<table>");
			var row=$("<tr>");
			var cell=$("<td>");
			cell.append("Doctor");
			row.append(cell);
			cell=$("<td>");
			cell.append(review.doctor.firstName+" "+review.doctor.middleName+" "+review.doctor.lastName);
			console.log(review.doctor.firstName+" "+review.doctor.middleName+" "+review.doctor.lastName);
			row.append(cell);
			table.append(row);
			row=$("<tr>");
			cell=$("<td>");
			cell.append("");
			row.append(cell);
			cell=$("<td style='max-height:50px !important;'>");
			cell.append("<a id='"+review.reviewId+"' href='/revewthedoctors/reviewer/individualreview?reviewId="+review.reviewId+"'> "+review.review.substring(1,80)+"..... </a>");
			row.append(cell);
			table.append(row);
			/*row=$("<tr>");
			cell=$("<td>");*/
			row=$("<tr>");
			cell=$("<td>");
			cell.append("Reviewed By");
			row.append(cell);
			cell=$("<td>");
			cell.append(review.user.firstName+" "+review.user.middleName+" "+review.user.lastName);
			console.log(review.user.firstName+" "+review.user.middleName+" "+review.user.lastName);
			row.append(cell);
			table.append(row);
			supportingTextDiv.append(table);
			cardMainDiv.append(supportingTextDiv);
			triColumnDiv.append(cardMainDiv);
			$("#review-feed-grid").append(triColumnDiv);
			counter++;
		//}
	});
}

function onReviewClick(object){
	var id = $(object).closest("td").attr("id");
	$.ajax({
		url:'admin/reviews',
		type:'GET',
		beforeSend : function(request){
			request.setRequestHeader("List_Type","SINGLE");
		},
		data:{
			reviewId:id
		}, 
		success:function(data){
			
		}
		
		
		
	});
}

