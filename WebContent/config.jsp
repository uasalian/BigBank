
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.controller.ConfigController"%>

<%
    boolean isSet = false;

	isSet = ConfigController.isEnabled(ConfigController.OUTPUT_ENCODING_ENABLED);
	String encodeYesVal = isSet ? "checked" : "";
	String encodeNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.VERYFY_CHANGES_ENABLED);	
	String verifyYesVal = isSet ? "checked" : "";
	String verifyNoVal =  isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.ADD_CSRF_TOKEN_ENABLED);
	String addCSRFTokenYesVal = isSet ? "checked" : "";
	String addCSRFTokenNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.SET_CSRF_TOKEN_ENABLED);
	String setCSRFTokenYesVal = isSet ? "checked" : "";
	String setCSRFTokenNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.VERIFY_CSRF_TOKEN_ENABLED);
	String verifyCSRFTokenYesVal = isSet ? "checked" : "";
	String verifyCSRFTokenNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.COOKIE_HTTPONLY_ENABLED);
	String cookieHttpOnlyYesVal = isSet ? "checked" : "";
	String cookieHttpOnlyNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.COOKIE_SECURE_ENABLED);
	String cookieSecureYesVal = isSet ? "checked" : "";
	String cookieSecureNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.X_FRAME_OPTIONS_ENABLED);
	String xFrameOptionsYesVal = isSet ? "checked" : "";
	String xFrameOptionsNoVal  = isSet ? "" : "checked";
%>

<html>
<head>
  <style>
  	table, td {
  	border: 1px solid black; 
  	border-collapse: collapse;
  }
  td {
  	padding: 10px;
  }
  </style>
</head>
<body>
 <h1>BigBank Admin</h1>
 <b> This is a highly restricted area! Stay away ...</b><br/><br/>
 
 &nbsp;&nbsp;<b>For Personal Profile Changes...</b><br/>
<form name="configForm" action="setConfig" method="post">
  <p style="margin-left: 40px">

<table>
   <tr>
   <td>XSS</td>
   <td>Enable output encoding:  </td>
   <td>
     <input type="radio" name="radio_encode" value="yes" <%=encodeYesVal%>>yes
     <input type="radio" name="radio_encode" value="no"  <%=encodeNoVal%>>no
     </td>
   </tr>

   <tr>  
   <td>CSRF</td>
   <td>
   		Enable Update Verification: <br>
   		Add empty Anti-CSRF token: <br>
   		Set Anti-CSRF Token: <br>
   		Verify Anti-CSRF Token: 
   	</td>
   		
   <td>
     <input type="radio" name="radio_verify" value="yes" <%=verifyYesVal%>>yes
     <input type="radio" name="radio_verify" value="no" <%=verifyNoVal%>>no <br>
     <input type="radio" name="radio_add_csrf_token" value="yes" <%=addCSRFTokenYesVal%>>yes
     <input type="radio" name="radio_add_csrf_token" value="no" <%=addCSRFTokenNoVal%>>no <br>
     <input type="radio" name="radio_set_csrf_token" value="yes" <%=setCSRFTokenYesVal%>>yes
     <input type="radio" name="radio_set_csrf_token" value="no" <%=setCSRFTokenNoVal%>>no <br>
     <input type="radio" name="radio_verify_csrf_token" value="yes" <%=verifyCSRFTokenYesVal%>>yes
     <input type="radio" name="radio_verify_csrf_token" value="no" <%=verifyCSRFTokenNoVal%>>no     
   </td>
   </tr>
      
   <tr>  
   <td>Session <br>
       Cookie
   </td>
   <td>
   		Enable Http Only: <br>
   		Enable Secure:
   	</td>
   		
   <td>
     <input type="radio" name="radio_cookie_httpOnly" value="yes" <%=cookieHttpOnlyYesVal%>>yes
     <input type="radio" name="radio_cookie_httpOnly" value="no" <%=cookieHttpOnlyNoVal%>>no <br>
     <input type="radio" name="radio_cookie_secure" value="yes" <%=cookieSecureYesVal%>>yes
     <input type="radio" name="radio_cookie_secure" value="no" <%=cookieSecureNoVal%>>no     
   </td>
   </tr>
      
   <tr>
   <td>Header</td>
   <td>Enable X-Frame-Options Header: </td>
   <td>
     <input type="radio" name="radio_x_frame_options" value="yes" <%=xFrameOptionsYesVal%>>yes
     <input type="radio" name="radio_x_frame_options" value="no" <%=xFrameOptionsNoVal%>>no
   </td>
   </tr>
       
</table>
	 <p style="margin-left: 100px">
	 <button type="submit">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;
	 <button type="submit" formaction="/BigBank/config.jsp">Reload</button>
	 
	 </p>

 </form>
 
</body>
</html>