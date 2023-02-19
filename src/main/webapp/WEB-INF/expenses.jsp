<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Save Tacos</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/main.css" />
		<!-- change to match your file/naming structure -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/app.js"></script>
		<!-- change to match your file/naming structure -->
	</head>
	<body>
    <h1>Save Travels</h1>
    <table class="table">
      <thead>
        <tr>
          <th>Expense</th>
          <th>Vendor</th>
          <th>Amount</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="save" items="${saves}">
          <tr>
            <td><a href="/expenses/${save.id}">${save.expense}</a></td>
            <td>${save.vendor}</td>
            <td>${save.amount}</td>
            <td><a href="/expenses/edit/${save.id}"><button>Edit</button></a>
              <form action="/expenses/${save.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <button type="submit" value="delete">Delete</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <h1>Add an Expense</h1>
  <form:form action="/addExpense" method="post" modelAttribute="save">
    <div class="form-control">
      <form:label path="expense">Expense Name:</form:label>
      <form:errors path="expense"/>
      <form:input path="expense"/>
    </div>
      <div class="form-control">
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor" />
      </div>
      <div class="form-control">
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
      <div class="form-control">
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
      <button type="submit">Submit</button>
  </form:form>
    <!-- <table>
      <thead>
        <tr>
          <th>Burger Name</th>
          <th>Restaurant Name</th>
          <th>Notes</th>
          <th>Rating</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="b" items="${saves}">
        <tr>
          <td><c:out value="${b.expense}"></c:out></td>
          <td><c:out value="${b.restaurant}"></c:out></td>
          <td><c:out value="${b.description}"></c:out></td>
          <td><c:out value="${b.amount}"></c:out></td>
          <td><a href="/saves/edit/${b.id}">Edit</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table> -->
	</body>
</html>
