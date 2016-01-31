<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Morosystems phase 4</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2>User Setting Screen</h2>
				<p>Here you can list, add, edit or remove properties of given user.</p>
			</div>
		</div>
	</section>
    <section>
        <h3>Selected User:</h3>
        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Telephone</th>
            </tr>
            <tr>
                <td>${user.lastname},${user.firstname}</td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
            </tr>
        </table>
    </section>

    <h3>List of his books:</h3>
	<c:if test="${!empty bookList}">
		<section>
			<table class="table table-hover">
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.title}</td>
						<td>${book.description}</td>
						<td><a
							href="<spring:url value="/admin/detail/book/edit/{userid}/{bookid}"><spring:param name="userid" value="${user.id}" /><spring:param name="bookid" value="${book.id}" /></spring:url>"
							class="label label-info"><span
								class="glyphicon glyphicon-edit" /></span>Edit</a></td>
						<td><a
							href="<spring:url value="/admin/detail/book/delete/{userid}/{bookid}"><spring:param name="userid" value="${user.id}" /><spring:param name="bookid" value="${book.id}" /></spring:url>"
							class="label label-danger"><span
								class="glyphicon glyphicon-remove" /></span>Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</c:if>
    <section>
        <div class="container">
            <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/admin/detail/book/add/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
                    class="btn btn-info btn-md"><span class="glyphicon glyphicon-plus" /></span>Add
                    new book</a>
            </div>
            </div>
        </div>
    </section>

    <h3>List of his accounts:</h3>
    <c:if test="${!empty accountList}">
        <section>
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Account Prefix</th>
                    <th>Account Number</th>
                    <th>Bank Code</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${accountList}" var="account">
                    <tr>
                        <td>${account.name}</td>
                        <td>${account.accountPrefix}</td>
                        <td>${account.accountNumber}</td>
                        <td>${account.bankCode}</td>
                        <td><a
                            href="<spring:url value="/admin/detail/account/edit/{userid}/{accountid}"><spring:param name="userid" value="${user.id}" /><spring:param name="accountid" value="${account.id}" /></spring:url>"
                            class="label label-info"><span
                                class="glyphicon glyphicon-edit" /></span>Edit</a></td>
                        <td><a
                            href="<spring:url value="/admin/detail/account/delete/{userid}/{accountid}"><spring:param name="userid" value="${user.id}" /><spring:param name="accountid" value="${account.id}" /></spring:url>"
                            class="label label-danger"><span
                                class="glyphicon glyphicon-remove" /></span>Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </c:if>
    <section>
        <div class="container">
            <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/admin/detail/account/add/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
                    class="btn btn-info btn-md"><span class="glyphicon glyphicon-plus" /></span>Add
                    new account</a>
            </div>
            </div>
        </div>
    </section>

    <section>
        <div class="container">
            <div class="row">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <a href="<spring:url value="/admin/"></spring:url>"
                    class="btn btn-info btn-lg">Back</a>
            </div>
            </div>
        </div>
    </section>
</body>
</html>