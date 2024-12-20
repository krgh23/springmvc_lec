<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<style>
  .list-wrap {
    width: 500px;
    margin: 0 auto;
  }
</style>
</head>
<body>

  <div class="list-wrap">
    <h1>Board List</h1>
    <div>
      <form action="${contextPath}/board/search.do">
        <input type="text" name="title" placeholder="제목검색"><br/>
        <input type="text" name="usrEmail" placeholder="작성자 이메일 검색"><br/>
        <input type="text" name="usrName" placeholder="작성장 이름 검색"><br/>
        <input type="date" name="beginDt"> - <input type="date" name="endDt"> <br/>
        <button type="submit">검색</button>
      </form>
    </div>
    <div>
      <a href="${contextPath}/board/list.do?sort=DESC" }>최신순</a> | <a href="${contextPath}/board/list.do?sort=ASC" }>과거순</a>
    </div>
    <div>
      <button type="button" onclick="fnWrite()">새 게시글 작성</button>
    </div>
    <form id="form-list" action="${contextPath}/board/removes.do" method="post">
      <div class="btn-wrap">
        <button type="submit">선택삭제</button>
      </div>
      
      <table>
        <thead>
          <tr>
            <td><input type="checkbox" id="chk-all"></td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일자</td>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${boardList}" var="b">
            <tr>
              <td><input type="checkbox" name="numbers" value="${b.boardId}" class="chk-each"></td>
              <td><a href="${contextPath}/board/detail.do?boardId=${b.boardId}">${b.title}</a></td>  <!-- b.getTitle()를 하지 않는 이유는 EL이 불러줘서  -->
              <td>${b.userDto.usrName}</td>
              <td><fmt:formatDate value="${b.createDt}" pattern="yyyy-MM-dd"/></td>
            </tr>
          </c:forEach>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">전체 ${boardCount}개 게시글</td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
  

  
  <script>
    // 전체 선택 체크 상자와 개별 선택 체크 상자가 상호 연동되도록 구현하시오.
    const chkAll = document.getElementById('chk-all');
    const chkEach = document.getElementsByClassName('chk-each');
  
    //전체선택
    chkAll.addEventListener('click',function(event) {
      for(let i = 0; i < chkEach.length; i++){
        chkEach[i].checked = chkAll.checked;
      }
    });
  
    //개별 선택
    for(let i = 0; i < chkEach.length; i++){
      chkEach[i].addEventListener('click', function(event){
        let total = 0;
        for(let j = 0; j < chkEach.length; j++)
          total += chkEach[j].checked; // true 는 1 로 누적되고, false는 0으로 누적된다.
        chkAll.checked = total === chkEach.length;
      })
    }
    
    
    function fnWrite(){
      location.href ='${contextPath}/board/write.do'
    }
    
    const formList = document.getElementById('form-list');
    formList.addEventListener('submit', (event) => {
      if(!confirm("선택한 게시글을 삭제할까요?")){
        event.preventDefault();  // 이벤트 취소
        return;                  // 이벤트 헨들러 실행 종료
      }
    })
    
    
    const msg = '${msg}';
    if(msg !== ''){
      alert(msg)
    }
    
    
    
  </script>
  
  
</body>
</html>