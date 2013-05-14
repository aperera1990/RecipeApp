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
					<!-- END OF SIDE BAR -->
					<div id="content">
						<div class="post">
							<div class="entry">
								<form:form class="form-horizontal" commandName="ingrediant"
									action="addIngrediants.do" method="POST">
									<div class="control-group">
										<div class="controls">
											<form:input type="text" path="ingredientName"
												placeholder="Ingredient Name" />
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<form:input type="text" path="amount" placeholder="Amount" />
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<form:select path="Unit" placeholder="Unit">
												<form:option value=""></form:option>
												<form:option value="ml">ml</form:option>
												<form:option value="g">g</form:option>
												<form:option value="cups">cups</form:option>
												<form:option value="tsp">tsp</form:option>
												<form:option value="tbsp">tbsp</form:option>
											</form:select>
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Add</button>
											<a href="insertInstructions.do">Finish</a>
										</div>
									</div>
								</form:form>
								<c:if test="${recipe != null}">
									<div style="text-align: center;">
										<h2>
											<c:out value="${recipe.name}" />
										</h2>
									</div>
									<div style="text-align: center;">
										<table class="table">
											<tr>
												<th>Ingredients</th>
											</tr>
											<c:forEach var="ingrediant"
												items="${recipe.listOfIngrediants}">
												<tr>
													<td><c:out
															value="${ingrediant.amount} ${ingrediant.unit} ${ingrediant.ingredientName} " />
												</tr>
											</c:forEach>
										</table>
									</div>
								</c:if>
							</div>
						</div>
					</div>
					<!-- END OF CONTAINER -->
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




