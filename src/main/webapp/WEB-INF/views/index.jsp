<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Ashley's Recipes</title>
<link
	href="http://fonts.googleapis.com/css?family=Arvo|Open+Sans:400,300,600,700"
	rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="descrsiption" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./resources/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />

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
	<div class="container">
		<div id="menu-wrapper">
			<div id="menu">
				<ul>
					<li><a href="">Ashley's Recipes</a></li>
					<li class="current_page_item"><a href="home.do">Home</a></li>
					<li><a href="browseRecipe.do">Browse Recipes</a></li>
					<li><a href="viewCookBook.do">Your Cookbook</a></li>
				</ul>
			</div>
		</div>
		<!-- END OF MENU -->
		<!--/.nav-collapse -->
		<div id="banner">
			<div style="text-align: center;">
				<h1>For all food lovers!</h1>
			</div>
		</div>
	</div>

	<div style="text-align: center;">
		<h2>Log in</h2>
	</div>
	<br>
	<br>
	<div id="form">
		<form:form class="form-horizontal" commandName="user"
			action="logIn.do" method="POST">
			<div class="control-group">

				<div class="controls">
					<form:input type="text" path="username" placeholder="Username" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<form:input type="password" path="password" placeholder="Password" />

				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Sign in</button>
				</div>
			</div>
		</form:form>

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