<%-- 
    Document   : index
    Created on : 27 Jun, 2021, 5:15:20 PM
    Author     : RIYA PATIDAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Home.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
    <div class="header">
        FUEL <b>SYSTEM</b>
        <h4>A easy way to Manage</h4>
    </div>
    <hr>
    <div class="row">
        <div class="lside">
            <h2>Daily Reading</h2>
                <a href="#" class="rblock activepage">Today's Reading</a><br>
                <a href="Page1.html" class="rblock">Display Readings</a><br>
            <h2>Bill Data</h2>
                <a href="newBill.jsp" class="rblock">New Bill</a><br>
                <a href="deleteBill.jsp" class="rblock">Delete Bill</a><br>
                <a href="displayBill.jsp" class="rblock">Display Bills</a><br>
            <h2>Customer Data</h2>
                <a href="newCustomer.jsp" class="rblock">New Customer</a><br>
                <a href="deleteCustomer.jsp" class="rblock">Delete Customer</a><br>
                <a href="cutomer.jsp" class="rblock">Update Customer</a><br>
                <a href="displayCustomer.jsp" class="rblock">Display Customers</a>
        </div>
        <div class="main">
            <br>
                <h1>Where to go ?</h1>
            <hr>
                <p>HTML is the standard markup language for creating Web pages.</p>
            <hr>
            <s:form namespace="/Go_To" action="change">
                <s:submit value="Go to list"/>
            </s:form>
            <hr>        
        </div>
    </div>    
    </body>
</html>
