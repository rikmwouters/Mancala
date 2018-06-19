<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Content per container:
	<jsp:useBean id="allContent" class="nl.sogyo.mancala.Mancala" scope="request"/>       
	<jsp:getProperty name="firstKalaha" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(1)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(2)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(3)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(4)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(5)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(6)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(7)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(8)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(9)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(10)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(11)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(12)" property="getContent()"/>
	<jsp:getProperty name="firstKalaha.stepsForward(13)" property="getContent()"/>
</body>
</html>