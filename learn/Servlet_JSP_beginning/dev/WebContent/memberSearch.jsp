<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>조회</title>
</head>
<body>

<h3>회원 정보 검색 </h3>
${error}
<form action="memberSearch.do" method="post">
   ID : <input type="text"  name="id" />
  <input type="submit"  value="검색" />
  <input type="hidden" name="job" value="search" />
</form>
</body>
</html>