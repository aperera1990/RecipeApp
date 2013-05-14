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
				<a class="brand" href="#">Ashley's Recipes</a>
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="browseRecipe.do">Browse Recipes</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<form action="RecipeController" method="GET"
					class="navbar-search pull-right">
					<input type="hidden" id="id" value="1"> <input type="text"
						id="search" class="search-query" placeholder="Search">
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div style="text-align: center;">
		<h2>For all food lovers!</h2>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<!--Sidebar content-->
			</div>
			<div class="span10">
				<!--Body content-->
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