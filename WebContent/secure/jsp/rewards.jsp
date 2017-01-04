<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%
	Object acctObj = request.getAttribute(com.bigbank.util.SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
%>
<html>
<body>
<%@ include file="header.jsp" %>
&nbsp;&nbsp;<b>Rewards</b> <br /><br/>
&nbsp;&nbsp;&nbsp;&nbsp;Sorry, you have to work really hard to get rewarded. Good Luck!
</body>
</html>