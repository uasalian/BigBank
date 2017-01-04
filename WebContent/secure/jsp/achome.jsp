<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="com.bigbank.model.AccountSummaryVO"%>
<%
	Object acctObj = request.getAttribute(com.bigbank.util.SessionUtil.ATTRIB_ACCT_SUMMARY);
	AccountSummaryVO acctVO = (acctObj == null) ? new AccountSummaryVO() : (AccountSummaryVO) acctObj;
%>
<html>
<body>
<%@ include file="header.jsp" %>
&nbsp;&nbsp;<b>ACHome</b> <br /><br/>
&nbsp;&nbsp;Welcome <%=acctVO.getName() %> <br /><br/>
&nbsp;&nbsp;Your current balance : $ <%=acctVO.getBalance() %> <br/>
&nbsp;&nbsp;Your rewards balance : $ <%=acctVO.getReqwardsBalance() %> <br/>
</body>
</html>