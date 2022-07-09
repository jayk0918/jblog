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
<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>-->
</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<!-- //admin-menu -->
			<c:import url="/WEB-INF/views/includes/admin-menu.jsp"></c:import>
			
			<div id="admin-content">
				<form action="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm/post" method="post">
			      	<table id="admin-write">
			      		<colgroup>
							<col style="width: 100px;">
							<col style="">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td class="t">포스트 제목</td>
			      			<td >
			      				<input type="text" name="postTitle">
				      		</td>
				      		<td>
				      			<select name="cateNo">
				      				<c:forEach items="${cList}" var = "categoryVo">
				      					<option value ="${categoryVo.cateNo}">${categoryVo.cateName}</option>
				      				</c:forEach>
				      			</select>
				      		</td>
			      		</tr>
			      		<tr>
			      			<td>내용</td>
			      			<td colspan="2"><textarea name="postContent"></textarea></td>
			      		</tr>
			      	</table>
			      	<div id="btnArea">
			      		<button class="btn_l" type="submit" >포스트하기</button>
			      	</div>
				</form>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	</div>
	<!-- //wrap -->
</body>

<!--  
<script type = "text/javascript">

$(document).ready(function(){
	$.ajax({
		url : "${pageContext.request.contextPath}/${authUser.id}/admin/api/category/getList",
		type : "post",
		dataType : "json",
		success : function(categoryVo){
			console.log(categoryVo);
			for(var i=0; i<categoryVo.length; i++){
				render(categoryVo[i]);
			}
		},
		error : function(XHR, status, error) {
			console.log(status + ' : ' + error);
		}
	})
})

function render(categoryVo){
	console.log("render()");
	var str = '';
	str += '    <option value = ' +categoryVo.cateNo+ '">' ;
	str += 		categoryVo.cateName ;
	str += '    </option>' ;
	
	$("#cateNo").append(str);
}
-->


</html>
