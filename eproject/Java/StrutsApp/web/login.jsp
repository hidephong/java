<%-- 
    Document   : login
    Created on : Mar 2, 2012, 3:47:36 PM
    Author     : haohao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html"  uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <html:form action="/login">
            <html:errors/>
            <html:text property="name"/>
            <html:text property="pass"/>
            <html:submit/>
        </html:form>
    </body>
</html>
