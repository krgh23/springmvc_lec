<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
  
  <!-- HTML 주석 : 페이지 소스보기에서 주석이 보입니다. -->
  <%--  JSP 주석 : 페이지 소스보기에서 주석이 안보입니다. Java 코드는 이 주석만 사용할 수 있습니다. --%>
  <%-- 
    화면(View)에서 요청 주소를 만들 때는 "컨텍스트 패스"를 작성해야 합니다.(변수처리전이라면 폴더명 /app03)
    "컨택스트 패스"는 변수로 처리하는 것이 좋습니다.
  --%>
  
  <%--  html 문법은 자바를 주석처리할 수 없다. jsp 주석 필요
    "컨택스트 패스(/app03)"를 변수로 처리하는 방법
    
    1. 표현식 이용하기 (자바 변수값(표현식) : <%=  %>
      <%=request.getContextPath()%>

    2. JSTL 과 표현 언어 이용하기
      <%@ taglib uri="c" prefix="http://java.sun.com/jsp/jstl/core"%>
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
      ${contextPath}
  --%>
  
  <%-- 요청만들기 1 : <a>태그 (<a> 태그는 항상 GET 방식으로 요청합니다.) --%>
  <div>
    <a href="<%=request.getContextPath()%>/webdir3/req1">요청1</a>
    <br/>
    <a href="<%=request.getContextPath()%>/webdir3/req2?sort=ASC&page=1">요청2</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req3?flowers=ROSE&flowers=TULIP">요청3</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req4">요청4</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req5?sort=ASC">요청5</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req6?sort=ASC&page=1">요청6</a>
    
  </div>

</body>
</html>