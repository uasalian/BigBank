<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%@ page import="com.bigbank.model.PersonalProfileVO"%>
<%@ page import="com.bigbank.model.Address"%>
<%@ page import="com.bigbank.util.SessionUtil"%>
<%@ page import="com.bigbank.controller.ConfigController" %>

<%
	Object acctObj = session.getAttribute(SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
	
	Object ppObj = session.getAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);
	PersonalProfileVO ppEdtVO = (ppObj == null) ? new PersonalProfileVO() : (PersonalProfileVO) ppObj;
	Address address = ppEdtVO.getAddress();

	Object obj = session.getAttribute(SessionUtil.ATTRIB_CSRF_TOKEN);
	String csrfToken = (obj == null) ? "" : obj.toString();
%>
	
<html>
<body>
<%@ include file="header.jsp" %>
&nbsp;&nbsp;<b>Please verify that your Personal Profile changes are correct</b> <br/>
&nbsp;&nbsp;&nbsp;&nbsp;<b>Then click on "Update" to save changes</b> <br /><br/> 
&nbsp;&nbsp;
<table>
	<tr> <td>Address : &nbsp;</td><td> <%=address.getStreet() %> </td></tr>
	<tr> <td> &nbsp;</td><td> <%=address.getCity() %>, <%=address.getState() %> <%=address.getZipCode() %> </td></tr>
	<tr><td>Phone Number: &nbsp;</td><td><%=ppEdtVO.getPhoneNbr() %> </td></tr>
	<tr><td>Email Address: &nbsp;</td><td><%=ppEdtVO.getEmailAddres() %></td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan=2>&nbsp;&nbsp;&nbsp;&nbsp;
	    <form method="post" name="profileVerifyForm" action="/BigBank/secure/personalProfileVerifySubmit">
<% if (ConfigController.isEnabled(ConfigController.ADD_CSRF_TOKEN_ENABLED)) { %>
	      <input type="hidden" name="csrfToken"  id="csrfToken" value="<%=csrfToken%>" />
<% } %>
	      <button type="submit" name="submit" id="submit">Update</button> &nbsp;&nbsp;&nbsp;&nbsp;
	      <button type="submit" formaction="/BigBank/secure/personalProfileEdit">Edit</button>&nbsp;&nbsp;&nbsp;&nbsp;
	      <button type="submit" formaction="/BigBank/secure/personalProfileDiscard">Discard</button>
	    </form>
	   </td>
	</tr>
</table>

</body>
</html>