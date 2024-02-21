<%-- 
    Document   : updateCustomer
    Created on : 27 Jun, 2021, 12:24:52 PM
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
                <a href="deleteBill.jsp" class="rblock">Delete Bill</a><br>
                <a href="displayBill.jsp" class="rblock">Display Bills</a><br>
            <h2>Customer Data</h2>
                <a href="newCustomer" class="rblock">New Customer</a><br>
                <a href="deleteCustomer.jsp" class="rblock">Delete Customer</a><br>
                <a href="#" class="rblock activepage">Update Customer</a><br>
                <a href="displayCustomer.jsp" class="rblock">Display Customers</a>
        </div>
        <div class="main">
            <br>
                <h1>Form - Update Customer!</h1>
            <hr>
                <p>Fill correctly</p>
            <hr>
            <s:form namespace="/Update_Customer" action="getcustomer">
            <s:textfield label="Get Customer Data" labelposition="left" maxLength="50" size="30" key="d_name" />
            <s:textfield label="Contact" labelposition="left" maxLength="10" size="30" key="d_contact"/>
            <s:submit cssClass="button" value="Get data" />
            </s:form>
            <hr>
            <s:form namespace="/Update_Customer" action="updatecustomer">
            Customer ID - <s:property value="d_table"/>
            <s:textfield label="Name" labelposition="left" maxLength="50" size="30" key="d_name" name="d_name" />
            <s:textfield label="Contact" labelposition="left" maxLength="10" size="30" key="d_contact" name="d_contact"/>
            <s:textfield label="Email" labelposition="left" maxLength="50" size="30" key="d_email" />
            <s:submit cssClass="button" value="Update"/>
            </s:form>
            <hr>        
        </div>
    </div>
<%--
        <s:form namespace="/Update_Customer" action="getname">
            <s:submit value="Get List"/>
        </s:form>
        <s:form namespace="/Update_Customer" action="getcustomer">
            <s:select label="Get Customer Data" headerKey="-1" headerValue="Select name" list="nameList" name="d_table" value="defaultName" />
            <s:submit value="Get data" />
        </s:form>    
--%>

<s:form namespace="/Update_Customer" action="glist">
    <s:submit />
</s:form>

    </body>
</html>
