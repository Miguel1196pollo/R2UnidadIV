<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Member Manager | Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-member">New Member</a></li>
					<li><a href="all-members">All Member</a></li>

				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Member Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_MEMBERS'}">
			<div class="container text-center" id="membershipsDiv">
				<h3>My member</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Locker Number</th>
								<th>Number</th>
								<th>Rented From Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="membership" items="${members}">
									<tr>
										<td>${member.id}</td>
										<td>${member.lockerNumber}</td>
										<td>${member.number}</td>
										<td>${member.rentedFromDate}</td>
																				
										<td>
											<a href="update-member?id=${member.id}">
												<span class="glyphicon glyphicon-pencil"></span>
											</a>
										</td>
										<td>
											<a href="delete-member?id=${member.id}">
												<span class="glyphicon glyphicon-trash"></span>
											</a>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Member</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-member">
					<input type="hidden" name="id" value="${member.id}"/>
					
						<div class="form-group">
							<label class="control-label col-sm-3">Locker Number:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="lockerNumber" value="${member.lockerNumber}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Number:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="number" value="${member.number }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-3">Rented From Date:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="rentedFromDate" value="${member.rentedFromDate}" />
							</div>
						</div>
												
						
						<div class="form-group">
							<input type="submit" class="btn btn-primary" value="Save" />
						</div>
						
				</form>
			</div>
		
		</c:when>
		
		
		
	</c:choose>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	
</body>
</html>