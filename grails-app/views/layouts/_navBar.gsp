<div class="navbar-fixed-top">
    <nav class="navbar navbar-default navbar-utility hidden-xs" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="navbar-header">
                        <div class="navbar-header-info">
                            <a href="./index" class="brand">${title ?: 'Phoebe'}</a>
                        </div>
                    </div>

                    <div class="collapse navbar-collapse bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav navbar-right utilityLinks">
                            <li class="utility-link"><a href="#" onclick='closeWindow("${params.controller}");'>Close</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <nav class="navbar navbar-default navbar-main" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-xs-3 col-md-3 col-lg-2">
                    <div class="navbar-header">
                        <div class="logo hidden-xs">
                            <svg width="160" height="60">
                                <image xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="${asset.assetPath(src: 'images/nw.svg')}" src="${asset.assetPath(src: 'images/nw-logo.png')}" width="160" height="60"></image>
                            </svg>
                        </div>
                    </div>
                </div>

                <div class="col-xs-9 col-md-9 col-lg-10">
                    <div class="collapse navbar-collapse bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <g:each in="${tabs}" var="tab">
                                <g:if test="${tab && tab.name}">
                                    <g:if test="${tab.isDropDown}">
                                        <g:if test="${tab.links}">
                                            <li>
                                                <a href="javascript:void(0);" class="dropdown-toggle"
                                                   data-toggle="dropdown" id="navBar_${tab.name}">${tab.name}<b
                                                        class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <g:each in="${tab.links}" var="link">
                                                        <%
                                                            def targetDropdown = link.target ?: (link.openInNewWindow ? '_blank' : '_self')
                                                        %>
                                                        <g:if test="${link.onClick}">
                                                            <li><a href="${link.url}"
                                                                   id="navBar_${tab.name}_${link.name}"
                                                                   onclick="${link.onClick}" name="tabNav"
                                                                   target="${targetDropdown}">${link.name}</a></li>
                                                        </g:if>
                                                        <g:else>
                                                            <li><a href="${link.url}"
                                                                   id="navBar_${tab.name}_${link.name}" name="tabNav"
                                                                   target="${targetDropdown}">${link.name}</a></li>
                                                        </g:else>
                                                    </g:each>
                                                </ul>
                                            </li>
                                        </g:if>
                                    </g:if>
                                    <g:else>
                                        <%
                                            def targetIndiv = tab.target ?: (tab.openInNewWindow ? '_blank' : '_self')
                                        %>
                                        <g:if test="${tab.name == activeTab}">
                                            <li class="active"><a href="${tab.url}" id="navBar_${tab.name}"
                                                                  name="tabNav" target="${targetIndiv}">${tab.name}</a>
                                            </li>
                                        </g:if>
                                        <g:else>
                                            <li><a href="${tab.url}" id="navBar_${tab.name}" name="tabNav"
                                                   target="${targetIndiv}">${tab.name}</a></li>
                                        </g:else>
                                    </g:else>
                                </g:if>
                            </g:each>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>