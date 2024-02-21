<%-- 
    Document   : newCustomer
    Created on : 19 Jun, 2021, 7:52:21 PM
    Author     : RIYA PATIDAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Customer</title>
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
                <a href="index.jsp" class="rblock">Today's Reading</a><br>
                <a href="Page1.html" class="rblock">Display Readings</a><br>
            <h2>Bill Data</h2>
                <a href="newBill.jsp" class="rblock">New Bill</a><br>
                <a href="deleteBill.jsp" class="rblock">Delete Bill</a><br>
                <a href="displayBill.jsp" class="rblock">Display Bills</a><br>
            <h2>Customer Data</h2>
                <a href="#" class="rblock activepage">New Customer</a><br>
                <a href="deleteCustomer.jsp" class="rblock">Delete Customer</a><br>
                <a href="customer.jsp" class="rblock">Update Customer</a><br>
                <a href="displayCustomer.jsp" class="rblock">Display Customers</a>
        </div>
        <div class="main">
            <br>
                <h1>Form - New Customer Registration!</h1>
            <hr>
                <p>Fill correctly</p>
            <hr>
            <s:form namespace="/Add_Customer" action="addNewCus">
            <s:textfield label="Name" labelposition="left" maxLength="60" size="30" key="d_name" />
            <s:textfield label="Contact" labelposition="left" maxLength="10" size="30" key="d_contact" />
            <s:textfield label="Address" labelposition="left" maxLength="100" size="30" key="d_address" />
            <s:textfield label="Email" labelposition="left" maxLength="50" size="30" key="d_email" />
            <s:submit cssClass="button"/>
            </s:form>
            <hr>        
        </div>
    </div>
    </body>
</html>
