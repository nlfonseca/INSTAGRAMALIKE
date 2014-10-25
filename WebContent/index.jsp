<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en" class="no-js">
    <head>
    
    <meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>Instagram</title>
		
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="css/menu_topside.css" />
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>

    <body>
    	<div class="main-container">
    		<!-- nav -->
			<div class="menu-wrap">
				<nav class="menu-top">
					<div class="profile">
						<img src="img/avatar.png" alt="Matthew Greenberg" style="width:42px;"/>
						<span>Matthew Greenberg</span>
					</div>
					<div class="icon-list">
						<a href="#"><i class="fa fa-fw fa-star-o"></i></a>
						<a href="#"><i class="fa fa-fw fa-bell-o"></i></a>
						<a href="#"><i class="fa fa-fw fa-envelope-o"></i></a>
						<a href="#"><i class="fa fa-fw fa-comment-o"></i></a>
					</div>
				</nav>
				<nav class="menu-side">
					<a href="#">
						<i class="glyphicon glyphicon-search"></i>
						<input class="search-tag" id="search-tag" name="search-tag" title="search tag" type="text" placeholder="Insert the tag...">
						<!-- <div class="loader"></div> -->
					</a>
					<a href="#">Profile</a>
					<a href="#">Feed</a>
				</nav>
			</div>
			<button class="menu-button" id="open-button">Open Menu</button>
			
			<!-- content -->
			<div class="content-wrap">
				<div class="main-content">
					<header class="content__header">
						<h1>Profile</h1>
					</header>
					
					<section class="content__main" style="min-height: 80vh;">
						 
						 <!-- result -->
			            <div id="container-photos" class="row text-center"></div>
			            
			            <div class="row section-row text-center">
			                <div class="col-md-12">
			                    <button class="btn load-more">View More...</button>
			                </div>
			            </div>

					</section>
				</div>
		
		        <div class="modal fade">
		            <div class="modal-dialog">
		                <div class="modal-content" id="mContent">
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/popup.js"></script>
        <script src="js/connect-instagram.js"></script>
        
		<script src="js/classie.js"></script>
		<script src="js/main.js"></script>
    </body>

</html>