<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">


</head>

<body>
	<div id="wrap">
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="content">
			<!-- //admin-menu -->
			<c:import url="/WEB-INF/views/includes/admin-menu.jsp"></c:import>
			
			<div id="admin-content">
				<form action="upload" method="post" enctype = "multipart/form-data">
	 		      	<table id="admin-basic">
	 		      		<colgroup>
							<col style="width: 100px;">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td><label for="textTitle">블로그 제목</label></td>
			      			<td><input id="textTitle" type="text" name="blogTitle" value=""></td>
			      		</tr>
			      		<tr>
			      			<td><label>로고이미지</label></td>
			      			<c:choose>
			      				<c:when test = "${blogVo.logoFile eq '/assets/images/spring-logo.jpg'}">
			      					<td class="text-left"><img src="${pageContext.request.contextPath}/${blogVo.logoFile}"></td>
								</c:when>
								<c:otherwise>
									<td class="text-left"><img src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}"></td>
								</c:otherwise>
							</c:choose>
			      		</tr>      		
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td><input id="textLogo" type="file" name="file"></td>      			
			      		</tr>           		
			      	</table>
			      	<div id="btnArea">
			      		<button class="btn_l" type="submit" >기본설정변경</button>
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
</html>
