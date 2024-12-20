<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>form submit</title>
</head>
<body>

  <%-- ��û ����� 2 : <form> �±��� submit (GET, POST ����� ������ �� �ֽ��ϴ�. --%>
  <%-- 
    action : ��û �ּ� �ۼ��մϴ�. (���� �ּ�)
    method
      1) ��û �޼ҵ� �ۼ��մϴ�.
      2) get,post ����� ����մϴ�.
      3) ����Ʈ�� get ����Դϴ�.
      4) ��� ��û�� Query String ����� ��û���� ó���˴ϴ�.
      5) get ������� ó���ϸ� ��û �ּҿ� ��û �Ķ���Ͱ� ����˴ϴ�. (������ �����մϴ�.)
      6) post ������� ó���ϸ� ��û �ּҿ� ��û �Ķ���Ͱ� ������� �ʴ´�. (���ȿ� �����ϴ�. ��� �ణ �����ϴ�.)
  --%>

  <form action="<%=request.getContextPath()%>/webdir4/req1" method="get">
    <%-- �Է»���(text, number, email, url, password, date) --%>
    <input type="text"     name="a"><br/>
    <input type="number"   name="b"><br/>
    <input type="email"    name="c"><br/>
    <input type="url"      name="d"><br/>
    <input type="password" name="e"><br/>
    <input type="date"     name="f"><br/>
    
    <%-- ����� action�� �ۼ��� �ּҷ� ����Է� ��ҵ鸦 �����ϴ�.  --%>    
    <button type="submit">�����</button>
   
  </form>
  
  <hr/>
  <form action="<%=request.getContextPath()%>/webdir4/req2" method="get">
  
  <%-- ��� ���� ���ڴ� �������� ��� ����Ʈ value = "on"�� �����ϴ�. --%>
  
  <%-- ���� ���� : ���� ������ ������ chechbox (���� name ���� ������) - ����Ʈ value="on"�� ����� �� �����ϴ�. --%>
  <input type="checkbox" name ="flowers" id="reos" value="rose">
  <label for="rose">���</label>
  <input type="checkbox" name ="flowers" id="tulip" value = "tulip">
  <label for="tulip">ƫ��</label>
  <br/>
  
  <%-- ���� ���� : ���� ������ ������ chechbox (�ٸ� name ���� ������) - ����Ʈ value="on"�� ����� �� �ֽ��ϴ�. --%>
  <input type="checkbox" name ="kbs" id="kbs">
  <label for="kbs">kbs</label>
  <input type="checkbox" name ="mbc" id="mbc">
  <label for="mbc">mbc</label>
  <input type="checkbox" name ="sbs" id="sbs">
  <label for="sbs">sbs</label>
  <br/>
  
  <%-- ���� ���� : ���� ���ø� ������ readio - ����Ʈ value="on"�� ����� �� �����ϴ�. --%>
  <input type="radio" name ="choice" id="yes" value = "y">
  <label for="yes">yes</label>
  <input type="radio" name ="choice" id="no"  value = "n">
  <label for="no">no</label>
  
  <%-- ����� action�� �ۼ��� �ּҷ� ����Է� ��ҵ鸦 �����ϴ�.  --%>    
  <button type="submit">�����</button>
  
  <hr/>
  </form>
  
  <form action "<%=request.getContextPath()%>/webdir4/req3" method="get">
  
    <%-- ��� ��� ��Ҵ� <option> �±��� �����ؽ�Ʈ(textContent)�� value �� ���޵˴ϴ�. --%>
    <%-- <option> �±׿� value �Ӽ��� �߰��ϸ� value �Ӽ� ���� ���޵˴ϴ�. --%>
  
    <%-- ��Ͽ�� : <select> �±׿� <option> �±� --%>
    <selcet tpye="text" name= "city">
      <option>seoul</option>
      <option>jeju</option>
    </selcet> 
    </br>
  
    <%-- �޺���� : <input> �±׿� <datalist> �±� --%>
    <input type="text" name="domain" list="domain-list">
    <datalist id="domain-list">
      <option value="naver">naver.com</option>
      <option value="kakao">kakao.com</option>
    </datalist>
    </br>
    
    
    <%-- ���� ���� �Է� ��� : <textarea> �±� --%>
    <textarea name="content"></textarea>
    </br>

    <%-- ����� action�� �ۼ��� �ּҷ� ����Է� ��ҵ鸦 �����ϴ�.  --%>    
    <button type="submit">�����</button>

    </br>
  </form>

</body>
</html>