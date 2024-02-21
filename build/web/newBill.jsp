<%-- 
    Document   : newBill
    Created on : 20 Jun, 2021, 12:09:02 AM
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
                <a href="#" class="rblock activepage">New Bill</a><br>
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
                <h1>Form - New Bill!</h1>
            <hr>
                <p>Make sure Date is correct</p>
            <hr>
            <s:form namespace="/Add_Bill" action="addBill">
            <s:textfield label="Name" labelposition="left" maxLength="60" size="30" key="bill_name" />
            <s:textfield label="Date" labelposition="left" size="30" key="bill_date" />
            <s:textfield label="Bill No." labelposition="left" size="30" key="bill_no" />
            <s:textfield label="Debit Ammount" labelposition="left" size="30" key="debit" />
            <s:textfield label="Credit Ammount" labelposition="left" size="30" key="credit" />
            <s:textarea label="Description" labelposition="left" size="30" key="description" />
            <s:submit />
            </s:form>
            <hr>        
        </div>
    </div>
    </body>
</html>
