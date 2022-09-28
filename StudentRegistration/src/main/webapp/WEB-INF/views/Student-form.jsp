<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student</title>
</head>

<body style="background-color:#94aca4">
<a href="/StudentRegistration/"> 
			<h4 style="color:#ffffff; padding-left: 10.77%; padding-top: 0">HOME</h4>
	</a>
	<div class="container border border-dark border-5 grid text-center" style="margin-top: 5%">

		<h3>Student Directory</h3>
		<hr>

		<form action="/StudentRegistration/students/save" method="POST" >

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}"  />

			<div class="form-inline " style="margin-left: 33%; width: 100%">
				<input type="text" name="name" value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Name">



			</div>

			<div class="form-inline" style="margin-left: 33%; width: 100%">

				<input type="text" name="department" value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">



			</div>

			<div class="form-inline" style="margin-left: 33%; width: 100%">

				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/StudentRegistration/students/list">Back to Students List</a>

	</div>
</body>

</html>










