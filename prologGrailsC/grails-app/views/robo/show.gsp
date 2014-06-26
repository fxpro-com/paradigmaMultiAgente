
<%@ page import="robovelc.Robo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'robo.label', default: 'Robo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-robo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-robo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list robo">
			
				<g:if test="${roboInstance?.nomeRobo}">
				<li class="fieldcontain">
					<span id="nomeRobo-label" class="property-label"><g:message code="robo.nomeRobo.label" default="Nome Robo" /></span>
					
						<span class="property-value" aria-labelledby="nomeRobo-label"><g:fieldValue bean="${roboInstance}" field="nomeRobo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${roboInstance?.tipoGrafico}">
				<li class="fieldcontain">
					<span id="tipoGrafico-label" class="property-label"><g:message code="robo.tipoGrafico.label" default="Tipo Grafico" /></span>
					
						<span class="property-value" aria-labelledby="tipoGrafico-label"><g:fieldValue bean="${roboInstance}" field="tipoGrafico"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:roboInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${roboInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link class="edit" action="ativarRobo" resource="${roboInstance}"><g:message code="Ativar Robo" default="Ativar Robô" /></g:link>
				</fieldset>


			</g:form>
		</div>
	</body>
</html>
