<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>Hello</title>
</head>
<body>

<div class="top-bar">
<div>
<jsp:useBean id="Player1" class="nl.sogyo.mancala.controller.dto.PlayersDTO" scope="session" />
<jsp:getProperty name="Players" property="nameP1" />
</div>
<div>
<jsp:useBean id="Player2" class="nl.sogyo.mancala.controller.dto.PlayersDTO" scope="session" />
<jsp:getProperty name="Players" property="nameP2" />
</div>
</div><br>

<div class="flex-container">
		<div class="container kalaha"><jsp:useBean id="Kalaha2" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="kalaha2Content" /></div>
		<div class="holefield">
   			<div class="container hole"><jsp:useBean id="Hole12" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole12Content" /></div>
   			<div class="container hole"><jsp:useBean id="Hole11" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole11Content" /></div>
   			<div class="container hole"><jsp:useBean id="Hole10" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole10Content" /></div>
  			<div class="container hole"><jsp:useBean id="Hole9" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole9Content" /></div>
    		<div class="container hole"><jsp:useBean id="Hole8" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole8Content" /></div>
	    	<div class="container hole"><jsp:useBean id="Hole7" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole7Content" /></div>
    	
    		<div class="container hole"><jsp:useBean id="Hole1" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole1Content" /></div>
   			<div class="container hole"><jsp:useBean id="Hole2" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole2Content" /></div>
    		<div class="container hole"><jsp:useBean id="Hole3" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole3Content" /></div>
    		<div class="container hole"><jsp:useBean id="Hole4" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole4Content" /></div>
    		<div class="container hole"><jsp:useBean id="Hole5" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole5Content" /></div>
    		<div class="container hole"><jsp:useBean id="Hole6" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="hole6Content" /></div>
    	</div>
    	<div class="container kalaha"><jsp:useBean id="Kalaha1" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" /><jsp:getProperty name="Board" property="kalaha1Content" /></div>
    </div>

</body>
</html>