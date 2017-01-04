<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%@ page import="com.bigbank.model.PersonalProfileVO"%>
<%@ page import="com.bigbank.model.Address"%>
<%@ page import="com.bigbank.util.SessionUtil"%>
<%
	Object acctObj = session.getAttribute(SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
	
	Object ppObj = session.getAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);
	PersonalProfileVO ppEdtVO = (ppObj == null) ? new PersonalProfileVO() : (PersonalProfileVO) ppObj;
	Address address = ppEdtVO.getAddress();
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
	<tr><td>&nbsp;&nbsp;&nbsp;&nbsp; <a href="/BigBank/secure/personalProfileUpdate">Update</a></td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp; <a href="/BigBank/secure/personalProfile">Discard</a></td>
	</tr>
</table>

</body>
</html>