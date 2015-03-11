<%-- 
    Document   : login
    Created on : Mar 7, 2012, 1:45:44 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>
            <h:form>
                Username:  <h:inputText value="#{login.username}"></h:inputText><br>
                Password:<h:inputSecret value="#{login.password}"></h:inputSecret><br>
                <h:commandButton id="submit" value="login" action="#{login.check}"></h:commandButton>
            </h:form>
        </body>
    </html>
</f:view>
