<%-- 
    Document   : adminlogin
    Created on : Feb 23, 2012, 3:16:36 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
                                <li><a href="#" class=" active"><span class="l"></span><span class="r"></span><span class="t">Home</span></a></li>
                                <li><a href="#"><span class="l"></span><span class="r"></span><span class="t">Menu Item</span></a>
                                    <ul>
                                        <li><a href="#">Menu Subitem 1</a></li>
                                        <li><a href="#">Menu Subitem 2</a></li>
                                        <li><a href="#">Menu Subitem 3</a></li>
                                    </ul>
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
                                    <form action="AdminLogin" method="GET">
                                        <table><tr><td>Username:</td><td><input type="text" name="txtUser" value="" /></td><td></td></tr>
                                            <tr><td>Password:</td><td><input type="password" name="txtPassword" value="" /></td><td></td></tr>
                                            <tr><td><input type="radio" name="rdRemember" value="Remember me." >Remember me.</td></tr>
                                            <tr><td><input type="submit" value="Login" /><input type="reset" value="Reset" /></td><td></td><td></td></tr>

                                        </table>
                                    </form>
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

