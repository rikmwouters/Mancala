<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>The Mancala Game</title>
</head>
<body>

<div class="top-bar">
	<div>
		<jsp:useBean id="Player2" class="nl.sogyo.mancala.controller.dto.PlayersDTO" scope="session" />
		<jsp:getProperty name="Players" property="nameP2" />
	</div>
	<div>
		<jsp:useBean id="Player1" class="nl.sogyo.mancala.controller.dto.PlayersDTO" scope="session" />
		<jsp:getProperty name="Players" property="nameP1" />
	</div>
</div><br>

<div class="flex-container">
	<div class="container kalaha">
		<jsp:useBean id="Kalaha2" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" />
		<jsp:getProperty name="Board" property="kalaha2Content" />
	</div>
		<form action="./play.do" method="post" class="holefield">
			<jsp:useBean id="Hole" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" />
   			<button type="submit" name="MakeMove" value="13" class="container hole"><jsp:getProperty name="Board" property="hole12Content" /></button>
   			<button type="submit" name="MakeMove" value="12" class="container hole"><jsp:getProperty name="Board" property="hole11Content" /></button>
   			<button type="submit" name="MakeMove" value="11" class="container hole"><jsp:getProperty name="Board" property="hole10Content" /></button>
  			<button type="submit" name="MakeMove" value="10" class="container hole"><jsp:getProperty name="Board" property="hole9Content" /></button>
    		<button type="submit" name="MakeMove" value="9" class="container hole"><jsp:getProperty name="Board" property="hole8Content" /></button>
	    	<button type="submit" name="MakeMove" value="8" class="container hole"><jsp:getProperty name="Board" property="hole7Content" /></button>
    	
    		<button type="submit" name="MakeMove" value="1" class="container hole"><jsp:getProperty name="Board" property="hole1Content" /></button>
   			<button type="submit" name="MakeMove" value="2" class="container hole"><jsp:getProperty name="Board" property="hole2Content" /></button>
    		<button type="submit" name="MakeMove" value="3" class="container hole"><jsp:getProperty name="Board" property="hole3Content" /></button>
    		<button type="submit" name="MakeMove" value="4" class="container hole"><jsp:getProperty name="Board" property="hole4Content" /></button>
    		<button type="submit" name="MakeMove" value="5" class="container hole"><jsp:getProperty name="Board" property="hole5Content" /></button>
    		<button type="submit" name="MakeMove" value="6" class="container hole"><jsp:getProperty name="Board" property="hole6Content" /></button>
    		<input type="hidden" name="action" value="MakeMove"/>
    	</form>
    <div class="container kalaha">
    	<jsp:useBean id="Kalaha1" class="nl.sogyo.mancala.controller.dto.BoardDTO" scope="session" />
    	<jsp:getProperty name="Board" property="kalaha1Content" />
    </div>
</div>
<div class="top-bar" style="margin-top:0px;">
	<jsp:useBean id="Message" class="nl.sogyo.mancala.controller.dto.MessageDTO" scope="session" />
	<jsp:getProperty name="Message" property="currentMessage" />
</div>

</body>
</html>