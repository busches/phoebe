<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<g:render template="/layouts/navBar"/>
<div class="container page-container">
    <div class="row">
        <div class="col-xs-12 page-content font-size-md">
            <h1 class="page-header">
                Meet Phoebe!
            </h1>

            <div id="myTabContent" class="page-content">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    <span class="icon icon-caret-right"></span><span class="icon icon-caret-down"></span>ChatBot Code
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                Put chat bot code here
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed">
                                    <span class="icon icon-caret-right"></span><span class="icon icon-caret-down"></span>Quote/Bind Stats
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                Commission Amount:
                                Number of quotes:
                                Number of policies written:
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed">
                                    <span class="icon icon-caret-right"></span><span class="icon icon-caret-down"></span>Commission Breakdown
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse">
                            <div class="panel-body">
                                Commission data table here
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--end page-content-->
        </div><!--end row-->
    </div><!--end page-container-->
</body>
</html>
