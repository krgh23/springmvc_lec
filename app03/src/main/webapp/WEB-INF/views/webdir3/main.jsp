<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
  
  <!-- HTML �ּ� : ������ �ҽ����⿡�� �ּ��� ���Դϴ�. -->
  <%--  JSP �ּ� : ������ �ҽ����⿡�� �ּ��� �Ⱥ��Դϴ�. Java �ڵ�� �� �ּ��� ����� �� �ֽ��ϴ�. --%>
  <%-- 
    ȭ��(View)���� ��û �ּҸ� ���� ���� "���ؽ�Ʈ �н�"�� �ۼ��ؾ� �մϴ�.(����ó�����̶�� ������ /app03)
    "���ý�Ʈ �н�"�� ������ ó���ϴ� ���� �����ϴ�.
  --%>
  
  <%--  html ������ �ڹٸ� �ּ�ó���� �� ����. jsp �ּ� �ʿ�
    "���ý�Ʈ �н�(/app03)"�� ������ ó���ϴ� ���
    
    1. ǥ���� �̿��ϱ� (�ڹ� ������(ǥ����) : <%=  %>
      <%=request.getContextPath()%>

    2. JSTL �� ǥ�� ��� �̿��ϱ�
      <%@ taglib uri="c" prefix="http://java.sun.com/jsp/jstl/core"%>
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
      ${contextPath}
  --%>
  
  <%-- ��û����� 1 : <a>�±� (<a> �±״� �׻� GET ������� ��û�մϴ�.) --%>
  <div>
    <a href="<%=request.getContextPath()%>/webdir3/req1">��û1</a>
    <br/>
    <a href="<%=request.getContextPath()%>/webdir3/req2?sort=ASC&page=1">��û2</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req3?flowers=ROSE&flowers=TULIP">��û3</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req4">��û4</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req5?sort=ASC">��û5</a>
    <br>
    <a href="<%=request.getContextPath()%>/webdir3/req6?sort=ASC&page=1">��û6</a>
    
  </div>

</body>
</html>