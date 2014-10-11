<!DOCTYPE html>

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Instagram</title>

		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/responsive.css">
	</head>

	<body>

		<div class="userBox"></div>

		<div class="container-fluid">
			<div id="container-photos" class="row text-center"></div>
			
			<div class="row section-row text-center">
                <div class="col-md-12">
                    <button class="btn load-more">View More...</button>
                </div>
            </div>
		</div>

		<div class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content" id="mContent">
				</div>
			</div>
		</div>

		<div class="error">
			<div class="errorImg"></div>
			<p class="errorMsg">PERMISSION DENIED</p>
		</div>

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/connect-instagram.js"></script>

		<script type="text/javascript">
			var query = window.location.search.substring(1);
			var keyValue = query.split("=");
			var id = keyValue[1];
			getInfoInstagram(id, "users", true);
		</script>
</html>