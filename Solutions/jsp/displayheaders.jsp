<%@ page import="java.util.Enumeration" %>
<html>
<head>
<title>Browser Header Information</title>
</head>

<body>
<h1>Header Information</h1>

<%
	Enumeration hNames = request.getHeaderNames();

	while (hNames.hasMoreElements())
	{
		String currentHeader = (String)hNames.nextElement();
		out.println(currentHeader + " = " + request.getHeader(currentHeader) + "<BR>");
	}

%>

</body>
</html>