<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title><g:layoutTitle default="Pheobe Administration"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>

    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${asset.assetPath(src: 'images/apple-touch-icon-114x114.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${asset.assetPath(src: 'images/apple-touch-icon-72x72.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${asset.assetPath(src: 'images/apple-touch-icon-144x144.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="60x60" href="${asset.assetPath(src: 'images/apple-touch-icon-60x60.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="120x120" href="${asset.assetPath(src: 'images/apple-touch-icon-120x120.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="76x76" href="${asset.assetPath(src: 'images/apple-touch-icon-76x76.png')}"/>
    <link rel="apple-touch-icon-precomposed" sizes="152x152" href="${asset.assetPath(src: 'images/apple-touch-icon-152x152.png')}"/>
    <link rel="icon" type="image/png" href="${asset.assetPath(src: 'images/favicon-196x196.png')}" sizes='196x196'/>
    <link rel="icon" type="image/png" href="${asset.assetPath(src: 'images/favicon-96x96.png')}" sizes='96x96'/>
    <link rel="icon" type="image/png" href="${asset.assetPath(src: 'images/favicon-32x32.png')}" sizes='32x32'/>
    <link rel="icon" type="image/png" href="${asset.assetPath(src: 'images/favicon-16x16.png')}" sizes='16x16'/>
    <link rel="icon" type="image/png" href="${asset.assetPath(src: 'images/favicon-128.png')}" sizes='128x128'/>
    <link rel="shortcut icon" type="image/x-icon" href="${asset.assetPath(src: 'favicon-16x16.ico')}"/>
    <meta name="application-name" content="&nbsp;"/>
    <meta name="msapplication-TileColor" content="#FFFFFF"/>
    <meta name="msapplication-TileImage" content="${asset.assetPath(src: 'images/mstile-144x144.png')}"/>
    <meta name="msapplication-square70x70logo" content="${asset.assetPath(src: 'images/mstile-70x70.png')}"/>
    <meta name="msapplication-square150x150logo" content="${asset.assetPath(src: 'images/mstile-150x150.png')}"/>
    <meta name="msapplication-wide310x150logo" content="${asset.assetPath(src: 'images/mstile-310x150.png')}"/>
    <meta name="msapplication-square310x310logo" content="${asset.assetPath(src: 'images/mstile-310x310.png')}"/>
    <g:layoutHead/>
</head>
<body>
    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
