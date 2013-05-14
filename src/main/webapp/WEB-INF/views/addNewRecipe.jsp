<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Ashley's Recipes</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="descrsiption" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./resources/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
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
	<div class="container">
		<div id="menu-wrapper">
			<div id="menu">
				<ul>
					<li><a href="">Ashley's Recipes</a></li>
					<li class="current_page_item"><a href="home.do">Home</a></li>
					<li><a href="browseRecipe.do">Browse Recipes</a></li>
					<li><a href="">Your Cookbook</a></li>
					<c:if test="${user.loggedIn == true}">
						<li><a href="logOut.do">Log Out</a></li>
					</c:if>
				</ul>

			</div>
		</div>
		<!--/END OF MENU -->
		<div id="banner">
			<div style="text-align: center;">
				<h1>For all food lovers!</h1>
			</div>
		</div>
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="sidebar">
						<div style="text-align: center">
							<h2>Featured Recipes</h2>
						</div>
					</div>
					<!-- end #sidebar -->
					<div id="content">
						<div class="post">
							<div class="entry">
								<p>Enter the name and a brief description of the recipe
									click add to create it and finish to move on to adding the
									ingredients</p>
								<br> <br> <br>
								<div id="form">
								<form:form class="form-horizontal" commandName="recipe"
									action="addIngrediants.do" method="POST">
									<div class="control-group">
										<div class="controls">
											<form:input type="text" path="name" placeholder="Recipe Name" />
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<form:input type="text" path="description"
												placeholder="Description" />
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Next</button>
										</div>
									</div>
								</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
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