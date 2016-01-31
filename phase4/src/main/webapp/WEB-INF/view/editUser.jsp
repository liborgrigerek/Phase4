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
				<h2>User Management Screen</h2>
				<p>Here you can list, add, edit or remove users.</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="post" action="/phase4/admin/add" commandName="user"
			class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<fieldset>
				<legend>User properties</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userId">Firstname</label>
					<div class="col-lg-10">
						<form:hidden path="id" />
						<form:input id="firstname" path="firstname" type="text"
							class="form:input-large" />
						<form:errors path="firstname" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userId">Lastname</label>
					<div class="col-lg-10">
						<form:input id="lastname" path="lastname" type="text"
							class="form:input-large" />
						<form:errors path="lastname" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Email</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text"
							class="form:input-large" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="telephone">Telephone</label>
					<div class="col-lg-10">
						<form:input id="telephone" path="telephone" type="text"
							class="form:input-large" />
						<form:errors path="telephone" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<c:if test="${user.id == null}">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Add user" />
						</c:if>
						<c:if test="${user.id != null}">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Modify user" />
						</c:if>
					</div>
				</div>
			</fieldset>
		</form:form>
        <a href="<spring:url value="/admin/"></spring:url>"
            class="btn btn-info btn-md"></span>Back</a>
	</section>

</body>
</html>