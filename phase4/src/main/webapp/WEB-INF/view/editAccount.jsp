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
				<p>Here you can list, add, edit or remove bank accounts.</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="post" action="/phase4/admin/detail/account/add/${user.id}" commandName="account"
			class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<fieldset>
				<legend>Account properties</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userId">BankName</label>
					<div class="col-lg-10">
						<form:hidden path="id" />
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="userId">Account Prefix</label>
					<div class="col-lg-10">
						<form:input id="accountPrefix" path="accountPrefix" type="text"
							class="form:input-large" />
						<form:errors path="accountPrefix" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="email">Account Number</label>
					<div class="col-lg-10">
						<form:input id="accountNumber" path="accountNumber" type="text"
							class="form:input-large" />
						<form:errors path="accountNumber" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="telephone">Bank Code</label>
					<div class="col-lg-10">
						<form:input id="bankCode" path="bankCode" type="text"
							class="form:input-large" />
						<form:errors path="bankCode" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<c:if test="${account.id == null}">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Add account" />
						</c:if>
						<c:if test="${account.id != null}">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Modify account" />
						</c:if>
					</div>
				</div>
			</fieldset>
		</form:form>
        <a href="<spring:url value="/admin/detail/{id}"><spring:param name="id" value="${user.id}" /></spring:url>"
            class="btn btn-info btn-md"></span>Back</a>
	</section>

</body>
</html>