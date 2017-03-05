<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%@ page import="com.bigbank.model.PersonalProfileVO"%>
<%@ page import="com.bigbank.model.Address"%>
<%@ page import="com.bigbank.util.MyEncoder" %>
<%@ page import="com.bigbank.util.SessionUtil" %>
<%@ page import="com.bigbank.controller.ConfigController" %>

<%
	Object acctObj = session.getAttribute(SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
	
	Object ppObj = session.getAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);
	PersonalProfileVO ppVO = (ppObj == null) ? new PersonalProfileVO() : (PersonalProfileVO) ppObj;
	Address address = ppVO.getAddress();
	boolean isValid = ppVO.isValid();
	
	String streetInd = (address.isStreetValid()) ? "" : "**";
	String cityInd = (address.isCityValid())  ? "" : "**";
	String stateInd = (address.isStateValid()) ? "" : "**";
	String zipInd = (address.isZipCodeValid()) ? "" : "**";
	String phoneInd = (ppVO.isPhoneNbrValid()) ? "" : "**";
	String emailInd = (ppVO.isEmailAddressValid()) ? "" : "**";
	
	Object obj = session.getAttribute(SessionUtil.ATTRIB_CSRF_TOKEN);
	String csrfToken = (obj == null) ? "" : obj.toString();
%>
<html>
<body>
<%@ include file="header.jsp" %>
&nbsp;&nbsp;Make changes to your Personal Profile <br /><br/> 
<% if (!isValid) { %>
  &nbsp;&nbsp;<b>Entries indicated by '<font color="red">**</font>' are invalid. Please correct them</b>
<% } %>
<form method="post" name="personalProfileForm" id="personalProfileForm" action="personalProfileEditSubmit">
<% if (ConfigController.isEnabled(ConfigController.ADD_CSRF_TOKEN_ENABLED)) { %>
	<input type="hidden" name="csrfToken" id="csrfToken" value="<%=csrfToken%>" />
<% } %>

&nbsp;&nbsp;
<table>
	<tr> <td>Address : &nbsp;</td></tr>
	<tr> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Street </td>
	     <td> <input type="text" name="street" value="<%=MyEncoder.encode(address.getStreet())%>" /><font color="red"><%=streetInd%></font></td>
	</tr>
	<tr> <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; City </td>
	     <td> <input type="text" name="city" id="city" value="<%= MyEncoder.encode(address.getCity()) %>"/><font color="red"><%=cityInd%></font></td>
	</tr>
	<tr> <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; State </td>
	     <td> <input type="text" name="state" id="state" value="<%=MyEncoder.encode(address.getState()) %>"/><font color="red"><%=stateInd%></font> </td>
	</tr>
	<tr> <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ZipCode </td>
	     <td> <input type="text" name="zipCode" id="zipCode" value="<%=MyEncoder.encode(address.getZipCode()) %>"/><font color="red"><%=zipInd%></font></td>
	</tr>
	<tr><td>Phone Number: &nbsp;</td>
	    <td><input type="text" name="phoneNbr" id="phoneNbr" value="<%=MyEncoder.encode(ppVO.getPhoneNbr()) %>"/> <font color="red"><%=phoneInd%></font></td>
	</tr>
	<tr><td>Email Address: &nbsp;</td>
	    <td><input type="text" name="emailAddress" id="emailAddress" value="<%=MyEncoder.encode(ppVO.getEmailAddres()) %>"/><font color="red"><%=emailInd%></font></td>
	</tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan="2" >&nbsp; &nbsp; &nbsp; &nbsp; 
		<input type="submit" name="submit" id="submit" value="Continue"/></td>
	</tr>
</table>

</form>

</body>
</html>