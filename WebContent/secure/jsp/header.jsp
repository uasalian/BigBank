<%@ page import="com.bigbank.controller.ConfigController"%>
<%
	if (ConfigController.isEnabled(ConfigController.X_FRAME_OPTIONS_ENABLED)) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
	}
%>
&nbsp;&nbsp;<br/>
&nbsp;&nbsp;<b>BigBank</b> <br/>
&nbsp;&nbsp;<br/>
&nbsp;&nbsp;<A href="/BigBank/secure/achome">Account Summary</A>&nbsp;&nbsp;|
&nbsp;&nbsp;<A href="/BigBank/secure/personalProfile">Personal Profile</A>&nbsp;&nbsp;|
&nbsp;&nbsp;<A href="/BigBank/secure/jsp/rewards.jsp">Rewards</A>&nbsp;&nbsp;|
&nbsp;&nbsp;<A href="/BigBank/logout">Log Out</A>
&nbsp;&nbsp;<br/><br/>