<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Latest Bootstrap min CSS -->
<link rel="stylesheet" href="../assets/css/bootstrap.min.css"
	type="text/css">
<!-- Dropdownhover CSS -->
<link rel="stylesheet"
	href="../assets/css/bootstrap-dropdownhover.min.css" type="text/css">
<!-- latest fonts awesome -->
<link rel="stylesheet" href="../assets/font/css/font-awesome.min.css"
	type="text/css">
<!-- simple line fonts awesome -->
<link rel="stylesheet"
	href="../assets/simple-line-icon/css/simple-line-icons.css"
	type="text/css">
<!-- stroke-gap-icons -->
<link rel="stylesheet"
	href="../assets/stroke-gap-icons/stroke-gap-icons.css" type="text/css">
<!-- Animate CSS -->
<link rel="stylesheet" href="../assets/css/animate.min.css"
	type="text/css">
<!-- Style CSS -->
<link rel="stylesheet" href="../assets/css/style.css" type="text/css">
<!-- Style CSS -->
<link rel="stylesheet" href="../assets/css/slider.css" type="text/css">
<!--  baguetteBox -->
<link rel="stylesheet" href="../assets/css/baguetteBox.css">
<!-- Owl Carousel Assets -->
<link href="../assets/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="../assets/owl-carousel/owl.theme.css" rel="stylesheet">
<!-- Style CSS -->
<!-- HTML5 Shim and Respond.js IE8 support  of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you  view the page via file:// -->
<!--[if lt IE 9]>
      <script  src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script  src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
<!--  Preloader  -->
<div id="preloader">
	<div id="loading"></div>
</div>
<header class="header2">
	<!--  top-header  -->
	<div class="top-header">
		<div class="container">
			<div class="col-md-6">
				<div class="top-header-left">
					<ul>
						<li><img src="../assets/images/logo.png" alt="logo" /></li>
						<li><span>Hello ${USER_SESSION.username==null?"Custumer - <a  href='../user/login.action'>Login</a> or <a  href='../user/registe.action'>Registe</a>":USER_SESSION.username}!</span></li>
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<div class="top-header-right">
					<ul>
						<li><i class="icon-location-pin icons" aria-hidden="true"></i>
							Store Location</li>
						<li><i class="icon-note icons" aria-hidden="true"></i> Track
							Your Order</li>
						<li>
							<div class="dropdown">
								<a href="#" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" data-hover="dropdown"> <i
									class="icon-settings icons" aria-hidden="true"></i> Setting
								</a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">One more dropdown</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--  /top-header  -->
	</div>
	<section class="top-md-menu">
		<div class="container">
			<div class="col-sm-12">
				<img src="../assets/images/Grid-banner.png"
					class="img-responsive center-block" alt="Grid-banner" />
			</div>
		</div>
	</section>
</header>