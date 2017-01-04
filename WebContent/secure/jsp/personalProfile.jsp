<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%@ page import="com.bigbank.model.PersonalProfileVO"%>
<%@ page import="com.bigbank.model.Address"%>
<%
	Object acctObj = request.getAttribute(com.bigbank.util.SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
	
	Object ppObj = request.getAttribute(com.bigbank.util.SessionUtil.ATTRIB_PERSONAL_PROFILE);
	PersonalProfileVO ppVO = (ppObj == null) ? new PersonalProfileVO() : (PersonalProfileVO) ppObj;
	Address address = ppVO.getAddress();
	System.out.println("In Personal Profile jsp: ppVO: \n" + ppVO);
%>
<html>
<body>
<%@ include file="header.jsp" %>
&nbsp;&nbsp;<b>Personal Profile</b> <br /><br/> 
&nbsp;&nbsp;
<table>
	<tr> <td>Address : &nbsp;</td><td> <%=address.getStreet() %> </td></tr>
	<tr> <td> &nbsp;</td><td> <%=address.getCity() %>, <%=address.getState() %> <%=address.getZipCode() %> </td></tr>
	<tr><td>Phone Number: &nbsp;</td><td><%=ppVO.getPhoneNbr() %> </td></tr>
	<tr><td>Email Address: &nbsp;</td><td><%=ppVO.getEmailAddres() %></td></tr>
	<tr><td colspan=2>&nbsp;</td></tr>
	<tr><td colspan="2" >&nbsp; &nbsp; &nbsp; &nbsp; 
	<a href="/BigBank/secure/personalProfileEdit">Edit Personal Profile</a></td></tr>
</table>

</body>
</html>