<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Location</title>
  <script>
  
    window.onload = () => {  // window 객체는 항상 생략할 수 있다. onload = () => {} 로 작성 하셔도 됩니다.
      
      const btn1 = document.getElementById("btn1");
      
      btn1.addEventListener('click', (event) => {
        
        // location 객체의 href 속성을 이용해서 요청할 수 있습니다.
        
        // Java 변수는 JavaScript 내부에서 사용할 수 있습니다. (하지만 반대는 안됩니다.)
        const contextPath = '<%=request.getContextPath()%>';
        
        // JSP 에서는 템플릿 문자열(Template STrings)을 사용할 때 \${} 를 사용합니다
        location.href = `\${contextPath}/webdir5/req1?param=\${event.currentTarget.textContent}`; // 클릭한 요소(event.currentTarget)의 내부 텍스트(text.)
        
      });
      
      const btn2 = document.getElementById('btn2');
      btn2.addEventListener('click', (event) => {
        
        // data 속성(Attribute)의 값은 dataset 속성(Property)에 저장됩니다.
        
        const contextPath = '<%=request.getContextPath()%>';
        location.href = `\${contextPath}/webdir5/req2?param=\${event.currentTarget.dataset.id}`
        
        
      });
    
      const btnDo = document.getElementsByClassName('btn-do');
      for(const btn of btnDo){
        btn.addEventListener('click', (event) =>{
          
          // Node    : Element, Text 등을 지칭하는 상위 개념의 DOM 객체입니다.
          // Element : 한 마디로 태그(HTMLElement)를 의미하는 Node 의 하위 개념 DOM 객체입니다.
          
          // 같은 레벨의 요소(Element)를 '형제 (Sibling) 관계' 라고 합니다.
          // 이전 형제 요소(Element)를 previousElementSibling 이라고 하고, 다음 형제 요소를 nextElementSibling 이라고 합니다.
          
          // value 속성(Attribute)은 value 속성(Property)과 같습니다.
          
          const contextPath = '<%=request.getContextPath()%>';
          //console.log(event.currentTarget.nextElementSibling);   // 콘솔보려면 아래 줄 주석처리필요
          location.href = `\${contextPath}/webdir5/req3?param=\${event.currentTarget.nextElementSibling.value}`;
        });
      }  
    }
    
  </script>
</head>
<body>

  <%-- 요청 만들기 3 : JavaScript 의 Location 객체 활용하기 (<a> 태그와 동일한 요청입니다.) --%>

  <button type="button" id="btn1">요청1</button>
  <br/> 
  
  <button type="button" id="btn2" data-id="1">요청2</button>
  <br/>

  <button type="button" class="btn-do">요청do1</button>
  <input type="hidden" value="1"><br/>
  <button type="button" class="btn-do">요청do2</button>
  <input type="hidden" value="2"><br/>

</body>
</html>