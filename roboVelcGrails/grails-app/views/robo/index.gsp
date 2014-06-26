
<%@ page import="robovelc.Robo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'robo.label', default: 'Robo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-robo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-robo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nomeRobo" title="${message(code: 'robo.nomeRobo.label', default: 'Nome Robo')}" />
					
						<g:sortableColumn property="tipoGrafico" title="${message(code: 'robo.tipoGrafico.label', default: 'Tipo Grafico')}" />			
					</tr>
				</thead>
				<tbody>
				<g:each in="${roboInstanceList}" status="i" var="roboInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${roboInstance.id}">${fieldValue(bean: roboInstance, field: "nomeRobo")}</g:link></td>
					
						<td>${fieldValue(bean: roboInstance, field: "tipoGrafico")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${roboInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
