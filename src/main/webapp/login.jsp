<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("idKey");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function loginCheck() {
		if(document.loginFrm.id.value == "") {
			alert("���̵� �Է��� �ּ���");
			document.loginFrm.id.focus();
			return;
		}
		if(document.loginFrm.pwd.value == "") {
			alert("��й�ȣ�� �Է��� �ּ���");
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}
</script>
</head>
<body bgcolor="#ffffcc">
	<div>
	<%if(id != null) {%>
		<b><%=id%></b>�� ȯ�� �մϴ�.
		<p>���ѵ� ����� ��� �Ҽ��� �ֽ��ϴ�.</p>
		<a href="logout.jsp">�α׾ƿ�</a>
	<%} else { %>
	
		
	
	<form name="loginFrm" method="post" action="loginProc.jsp">
		<table>
			<tr>
				<td align="center" colspan="2"><h4>�α���</h4></td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
			<td colspan="2">
				<div align="right">
					<input type="button" value="�α���" onclick="loginCheck()">&nbsp;
					<input type="button" value="ȸ������" onclick="javascript:location.href='member.jsp'">
				</div>
			</td>
			</tr>	
		</table>
	</form>
	<%}%>		
	</div>
</body>
</html>