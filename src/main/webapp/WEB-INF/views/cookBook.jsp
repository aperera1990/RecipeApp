<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Ashley's Recipes</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="descrsiption" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./resources/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="./resources/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="./assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="./assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="./assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="./assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="./assets/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="home.do">Ashley's Recipes</a>
				<ul class="nav">
					<li><a href="browseRecipe.do">Browse Recipes</a></li>
					<li><a href="viewCookBook.do">Your Cookbook</a>
				</ul>
				<form action="searchForRecipe.do" method="GET"
					class="navbar-search pull-right">
					<input type="text" id="search" class="search-query"
						placeholder="Search">
				</form>
				<c:if test="${user.loggedIn == false}">
					<a href="logInScreen.do">Log In</a>
				</c:if>
				<c:if test="${user.loggedIn == true}">
					<a href="logOut.do">Log Out</a>
				</c:if>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div class="container">
		<div class="row-fluid">
			<div class="span13">
				<div style="text-align: center;">
					<h1>For all food lovers!</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<!--Sidebar content-->
			</div>
			<div class="span10">
				<!--Body content-->
				<table class="table">
					<TH>Name</th>
					<th>Description</th>
					<th>Origin</th>
					<th>Select</th>
					<c:forEach items="${recipes}" var="recipe">
						<tr>
							<td><c:out value="${recipe.name}" />
							<td><c:out value="${recipe.description}" />
							<td><c:out value="${recipe.origin}" />
							<td>
								<form action="selectRecipe.do" method="GET">
									<input type="hidden" name="recipeID" value="${recipe.recipeID}">
									<button type=submit>Select</button>
								</form>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./resources/js/jquery.js"></script>
	<script src="./resources/js/bootstrap-transition.js"></script>
	<script src="./resources/js/bootstrap-alert.js"></script>
	<script src="./resources/js/bootstrap-modal.js"></script>
	<script src="./resources/js/bootstrap-dropdown.js"></script>
	<script src="./resources/js/bootstrap-scrollspy.js"></script>
	<script src="./resources/js/bootstrap-tab.js"></script>
	<script src="./resources/js/bootstrap-tooltip.js"></script>
	<script src="./resources/js/bootstrap-popover.js"></script>
	<script src="./resources/js/bootstrap-button.js"></script>
	<script src="./resources/js/bootstrap-collapse.js"></script>
	<script src="./resources/js/bootstrap-carousel.js"></script>
	<script src="./resources/js/bootstrap-typeahead.js"></script>

</body>
</html>