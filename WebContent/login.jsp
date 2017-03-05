<%
	// if (ConfigController.isEnabled(ConfigController.X_FRAME_OPTIONS_ENABLED)) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
%>
<html>
<body>
Welcome to Big Bank<br/><br/>

<font color="red"><b></b></font>
Please enter your credentials to login:
<form method="post" name="LoginForm" id="loginForm" action="authenticate">
<table>
	<tr>
		<td>Username: &nbsp;&nbsp; </td>
		<td><input type="text" name="userName" id="userName" value="user1"/> </td>
	</tr>
	<tr>
		<td>Password: &nbsp;&nbsp; </td>
		<td><input type="password" name="passWord" id="passWord" value="pass1"/> </td>
	</tr>
</table>
<br/> <br/>
  <input type="submit" value="login" name="login" id="login" />
</form>

</body>
</html>