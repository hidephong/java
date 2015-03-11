<%-- 
    Document   : newdevice
    Created on : Jun 7, 2012, 2:30:16 AM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new Device!</h1>
         <form id="form1" name="form1" method="post" action="add">
    <table width="800" border="1">
 <tr>
    <td>ID</td>
    <td>
      <input type="text" name="txtId" id="txtId" width="357"/>
   </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="167">Name </td>
    <td width="357">
      <input type="text" name="txtName" id="txtName" width="357"/>
    </td>
    <td width="254">&nbsp;</td>
  </tr>
  
  <tr>
    <td>Status</td>
    <td>
      <input type="text" name="txtStatus" id="txtStatus" />
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
    </body>
</html>
