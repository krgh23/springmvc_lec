<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- css 쪼개서 파일 옮기기 -->
<link rel="stylesheet" href="${contextPath}/assets/css/main.css">

<!-- js 쪼개서 파일 옮기기 -->
<script src="${contextPath}/assets/js/main.js"></script>

<title>Welcome</title>

</head>
<body>

  <h1 id="logo" class="logo">Coupang</h1>


</body>
</html>