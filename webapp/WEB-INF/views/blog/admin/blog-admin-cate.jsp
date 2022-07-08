<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<!-- javascript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>


</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		

		<div id="content">
			<!-- //admin-menu -->
			<c:import url="/WEB-INF/views/includes/admin-menu.jsp"></c:import>
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
		      			<!--  
		      			<tr>
							<td>1</td>
							<td>자바프로그래밍</td>
							<td>7</td>
							<td>자바기초와 객체지향</td>
						    <td class='text-center'>
						    	<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">
						    </td>
						</tr>
						-->
						<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script type = "text/javascript">

var id = "${authUser.id}";

$(document).ready(function(){
	fetchList();
})

function fetchList(){
	$.ajax({
		url : "${pageContext.request.contextPath}/admin/api/category/getList",
		type : "post",
		dataType : "json",
		success : function(categoryVo){
			console.log(categoryVo);
			for(var i=0; i<categoryVo.length; i++){
				render(categoryVo[i], 'down');
			}
		},
		error : function(XHR, status, error) {
			console.log(status + ' : ' + error);
		}
	});
}


function render(categoryVo, opt){
	console.log("render()");
	var str = '';
	str += '    <tr id = "t' +categoryVo.cateNo+ '">' ;
	str += '        <td>'+categoryVo.cateNo+'</td>' ;
	str += '        <td>'+categoryVo.cateName+'</td>' ;
	str += '        <td>'+categoryVo.count+'</td>' ;
	str += '        <td>'+categoryVo.description+'</td>' ;
	str += '        <td><img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>' ;
	str += '    </tr>' ;
	
	if(opt == "down"){
		$("#cateList").append(str);
	}else if(opt == 'up'){
		$("#cateList").prepend(str);
	}else{
		console.log('opt error');
	}
	
}


</script>

</html>