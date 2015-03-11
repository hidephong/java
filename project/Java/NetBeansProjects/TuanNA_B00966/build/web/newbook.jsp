<%--
    Document   : newjsp
    Created on : Feb 21, 2012, 1:02:57 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="tl" uri="http://java.sun.com/jstl/core_rt"%>
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
        <h1 class="art-logo-name"><a>Book Library</a></h1>
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




</div>
</div>
<div class="cleared reset-box"></div>
<div class="art-layout-wrapper">
    <div class="art-content-layout">
        <div class="art-content-layout-row">

<div class="art-layout-cell art-content">
 <form id="form1" name="form1" method="post" action="AddBook">
    <table width="800" border="1">
  <tr>
    <td colspan="3">Add new book</td>
  </tr>
  <tr>
    <td width="167">Name book</td>
    <td width="357">
      <input type="text" name="txtName" id="txtName" width="357"/>
    </td>
    <td width="254">&nbsp;</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>
      <input type="text" name="txtAuthor" id="txtAuthor" width="357"/>
   </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Publisher</td>
    <td>
      <input type="text" name="txtPublisher" id="txtPublisher" />
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Year</td>
    <td>
      <input type="text" name="txtYear" id="txtYear" />
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Description</td>
    <td>
      <input type="text" name="txtDesc" id="txtDesc" />
   </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Category</td>
    <td>
      <select name="txtCateID" id="txtCateID">
         <tl:forEach items="${ sessionScope.list}" var="s" >
          <option value="${s.cateID}">${s.cateName}</option>
         </tl:forEach>
      </select>
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
      <input type="submit" name="txtSubmit" id="txtSubmit" value="Submit" />
      <input type="reset" name="txtClear" id="txtClear" value="Reset" />
   </td>
    <td>&nbsp;</td>
  </tr>
</table> </form>
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
