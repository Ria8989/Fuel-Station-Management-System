<%-- 
    Document   : deleteBill
    Created on : 27 Jun, 2021, 12:25:42 PM
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
                <a href="index.jsp" class="rblock">Today's Reading</a><br>
                <a href="Page1.html" class="rblock">Display Readings</a><br>
            <h2>Bill Data</h2>
                <a href="newBill.jsp" class="rblock">New Bill</a><br>
                <a href="#" class="rblock activepage">Delete Bill</a><br>
                <a href="displayBill.jsp" class="rblock">Display Bills</a><br>
            <h2>Customer Data</h2>
                <a href="newCustomer.jsp" class="rblock">New Customer</a><br>
                <a href="deleteCustomer.jsp" class="rblock">Delete Customer</a><br>
                <a href="customer.jsp" class="rblock">Update Customer</a><br>
                <a href="displayCustomer.jsp" class="rblock">Display Customers</a>
        </div>
        <div class="main">
            <br>
                <h1>Form - Delete Customer!</h1>
            <hr>
                <p>Fill correctly</p>
            <hr>
            <s:form namespace="/Delete_Bill" action="checkbill">
            <s:textfield label="Bill No." labelposition="left" size="30" key="bill_no" />
            <s:submit cssClass="button" value="Check Bill"/>
            </s:form>
            <hr>
            <s:form namespace="/Delete_Bill" action="deletebill">
            Bill : <s:property value="bill_no" /><br>
            Date : <s:property value="bill_date" /><br>
            Debit Amount : <s:property value="debit" /><br>
            Credit Amount : <s:property value="credit" /><br>
            Description : <s:property value="description" />
            <s:submit cssClass="button" value="Delete"/>
            </s:form>
            <hr>        
        </div>
    </div>
    </body>
</html>
