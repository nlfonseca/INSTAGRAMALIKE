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
        <div class = "header">
            <div class = "header__wrapper">
                <div class = "imageInstagram"></div>
                <div class = "disciplina"></div>
                <!-- <div class = "desenvolvido"></div> -->
            </div>
        </div>

        <div class = "container-fluid">
            <div class="row text-center search-box">
                <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                    <h2 class="search__title">Search Tag in Instagram</h2>
                    <div class="input-group elements">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                        <input class="form-control search-tag" type="text" placeholder="Insert the tag...">
                        <div class="loader"></div>
                    </div>
                </div>
            </div>

            <!-- result -->
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
    </body>

</html>