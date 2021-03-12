<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력페이지</h2>
<form action="ex05.bit" method="post">
	<div>
		<label for="deptno">deptno</label>
		<input type="text" id="deptno" name="bean.deptno"/>
	</div>
	<div>
		<label for="dname">dname</label>
		<input type="text" id="dname" name="bean.dname"/>
	</div>
	<div>
		<label for="loc">loc</label>
		<input type="text" id="loc" name="bean.loc"/>
	</div>
	<div>
		<button>전달</button>
	</div>
</form>
</body>
</html>
