<%@page import="com.tenline.pinecone.platform.web.payment.*"%>
<%@page import="com.tenline.pinecone.platform.web.payment.impl.*"%>
<%@page import="com.tenline.pinecone.platform.web.payment.model.PayInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.text.SimpleDateFormat;"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
	<%
		String id = (String) (session.getAttribute("user"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date from = sdf.parse((String) (request.getParameter("from")));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date to = sdf2.parse((String) (request.getParameter("to")));
		if (id.equals("wangyq")) {
			AliBaBaBatchPayment pay = (AliBaBaBatchPayment)(BatchPaymentFactory.create(AliBaBaBatchPayment.class));
			String rst = pay.createBatchFile(from,to);
			out.println("UserAccountID\t\tPayNumber");
			out.println(rst);
		} else {
			out.println("no result");
		}
	%>
</body>
</html>
