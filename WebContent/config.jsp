
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
	
	isSet = ConfigController.isEnabled(ConfigController.SET_CSRF_TOKEN_ENABLED);
	String setCSRFTokenYesVal = isSet ? "checked" : "";
	String setCSRFTokenNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.CSRF_TOKEN_VERIFY_ENABLED);
	String csrfTokenVerifyYesVal = isSet ? "checked" : "";
	String csrfTokenVerifyNoVal  = isSet ? "" : "checked";
	
	isSet = ConfigController.isEnabled(ConfigController.X_FRAME_OPTIONS_ENABLED);
	String xFrameOptionsYesVal = isSet ? "checked" : "";
	String xFrameOptionsNoVal  = isSet ? "" : "checked";
%>

<html>
<body>
<br/>
 <h1>BigBank Admin</h1><br/>
 <b> This is a highly restricted area! Stay away ...</b><br/><br/><br/>
 
 &nbsp;&nbsp;<b>For Personal Profile Changes...</b><br/>
<form name="configForm" action="setConfig" method="post">
  <p style="margin-left: 40px">

   <table>
   
   <tr>
   <td>Enable output encoding:  </td>
   <td>
     <input type="radio" name="radio_encode" value="yes" <%=encodeYesVal%>>yes
     <input type="radio" name="radio_encode" value="no"  <%=encodeNoVal%>>no
     </td>
   </tr>
     
   <tr>  
   <td>Enable Update Verification: </td>
   <td>
     <input type="radio" name="radio_verify" value="yes" <%=verifyYesVal%>>yes
     <input type="radio" name="radio_verify" value="no" <%=verifyNoVal%>>no
   </td>
   </tr>
   
   <tr>  
   <td>Enable Setting Anti-CSRF Token: </td>
   <td>
     <input type="radio" name="radio_set_csrf_token" value="yes" <%=setCSRFTokenYesVal%>>yes
     <input type="radio" name="radio_set_csrf_token" value="no" <%=setCSRFTokenNoVal%>>no
   </td>
   </tr>
   
   <tr>  
   <td>Enable Anti-CSRF Token Verification: </td>
   <td>
     <input type="radio" name="radio_csrf_token_verify" value="yes" <%=csrfTokenVerifyYesVal%>>yes
     <input type="radio" name="radio_csrf_token_verify" value="no" <%=csrfTokenVerifyNoVal%>>no
   </td>
   </tr>
   
   <tr>  
   <td>Enable X-Frame-Options Header: </td>
   <td>
     <input type="radio" name="radio_x_frame_options" value="yes" <%=xFrameOptionsYesVal%>>yes
     <input type="radio" name="radio_x_frame_options" value="no" <%=xFrameOptionsNoVal%>>no
   </td>
   </tr>
   
   </table>
	 <p style="margin-left: 100px"><input type="submit" name="submit" value="submit"/></p>

 </form>
 
</body>
</html>