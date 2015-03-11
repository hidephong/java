<%-- 
    Document   : BookView
    Created on : Feb 20, 2012, 3:11:05 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="tl" uri="http://java.sun.com/jstl/core_rt" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en" dir="ltr">
<head >

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><title>

    Welcome To Website.

</title><link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
  <!--[if IE 6]><link rel="stylesheet" href="css/style.ie6.css" type="text/css" media="screen" /><![endif]-->
  <!--[if IE 7]><link rel="stylesheet" href="css/style.ie7.css" type="text/css" media="screen" /><![endif]-->

  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/script.js"></script>
  </head>
<body>


<div id="art-page-background-glare-wrapper">
    <div id="art-page-background-glare"></div>
</div>
<div id="art-main">
    <div class="cleared reset-box"></div>
<div class="art-header">
<div class="art-header-position">
    <div class="art-header-wrapper">
        <div class="cleared reset-box"></div>
        <div class="art-header-inner">


<div class="art-headerobject"></div>
<div class="art-logo">
        <h1 class="art-logo-name"><a>Online Library</a></h1>
            <h2 class="art-logo-text">Reading, Thinking, Feeling.</h2>
    </div>


        </div>
    </div>
</div>


</div>
<div class="cleared reset-box"></div>
<div class="art-box art-sheet">
    <div class="art-box-body art-sheet-body">
<div class="art-bar art-nav">
<div class="art-nav-outer">


<ul class="art-hmenu">
    <li><a href="index.jsp" class=" active"><span class="l"></span><span class="r"></span><span class="t">Home</span></a></li>
    <li><a href="Search"><span class="l"></span><span class="r"></span><span class="t">Search</span></a>
       
    </li>
    <li><a href="#"><span class="l"></span><span class="r"></span><span class="t">About</span></a></li>
</ul>


</div>
</div>
<div class="cleared reset-box"></div>
<div class="art-layout-wrapper">
    <div class="art-content-layout">
        <div class="art-content-layout-row">

<div class="art-layout-cell art-content">
    <table border="1">
            <tl:forEach items="${ sessionScope.list}" var="s" >
                <tr><td width='200'>
                        <img src='imagesbook/${s.img}' width='96' height='120' />
                    </td>
                    <td width='80%' >
                    <table witdh="100%">
                        <tr>  <td>${ s.nameBook}</td></tr>
                        <tr> <td> ${ s.author}</td></tr>
                        <tr> <td> ${ s.publisher}</td></tr>
                         <tr> <td> ${ s.description}</td></tr>
                          <tr> <td> ${ s.bookCategory}</td></tr>
                         <tr> <td>   <a href='Store/${s.bookLink}'>Download</a></td></tr>
                
                    </table>
                    </td>
                </tr>
            </tl:forEach>
        </table>
</div>
    </div>
</div>
<div class="cleared"></div>

<div class="art-footer">
    <div class="art-footer-body">
                <div class="art-footer-text">
<!--p><a href="">Home</a> | <a href="">About</a> | <a href="">Site Map</a></p-->

<p>Copyright © 2012. All Rights Reserved.</p>

<p>&nbsp;</p>

<p>&nbsp;</p>


                </div>
        <div class="cleared"></div>
    </div>
</div>

		<div class="cleared"></div>
    </div>
</div>
<div class="cleared"></div>
</div>
</div>

</body>
</html>

