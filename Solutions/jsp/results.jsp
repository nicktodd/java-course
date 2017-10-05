
<html>
<head><title>Java Test Results</title></head>

<body>
<%
	String[] answers = {"a", "d", "a", "c", "c", "false", "c", "b"};
	int deleTotal = 0;
	for (int i=0; i<answers.length; i++)
	{
	 	String currentAnswer = request.getParameter("q" + i);
		if (currentAnswer.equals(answers[i]))
			deleTotal++;
 	}

 %>

 <h1>Your Score</h1>

 You scored <%= deleTotal %> out of <%= answers.length %>.


</body>
</html>