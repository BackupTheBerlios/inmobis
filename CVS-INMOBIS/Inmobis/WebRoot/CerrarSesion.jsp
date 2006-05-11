<%@ page session="true" %>
<%
	HttpSession sesionOk = request.getSession();
	if (sesionOk != null) {
		sesionOk.invalidate();
	}
%>
<jsp:forward page="index.jsp" />