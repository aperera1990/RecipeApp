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
<link
	href="http://fonts.googleapis.com/css?family=Arvo|Open+Sans:400,300,600,700"
	rel="stylesheet" type="text/css" />
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
					<li><a href="viewCookBook.do">Your Cookbook</a></li>
					<c:if test="${user.loggedIn == true}">
						<li><a href="logOut.do">Log Out</a></li>
					</c:if>
				</ul>

			</div>
		</div>
		<!--/END OF MENU -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="sidebar">
						
							<h2>Ingredients</h2>
							<table class="table">
								<c:forEach items="${ingrediants}" var="ingrediants">
									<tr>
										<td><c:out
												value="${ingrediants.amount} ${ingrediants.unit} ${ingrediants.ingredientName}" />
									</tr>
								</c:forEach>
							</table>
	
					</div>
					<!-- end #sidebar -->
					<div id="content">
						<div class="post">
							<div class="entry">
								<div style="text-align: center;">
									<h2>
										<c:out value="${recipe.name}"></c:out>
									</h2>
								</div>
								<div class="recipeImage">
									<div style="text-align: center;">
										<img src="${recipe.imageUrl}" />
									</div>
								</div>
								<table class="table">
									<tr>

										<th>Instructions</th>
									</tr>

									<c:forEach items="${instructions}" var="instructions"
										varStatus="status">

										<tr>
											<td><c:out value="${status.count}" />
											<td><c:out value="${instructions.instruction}" />
										</tr>
									</c:forEach>
								</table>
							</div>
							<div style="clear: both;">&nbsp;</div>
						</div>
						<!-- end #content -->
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