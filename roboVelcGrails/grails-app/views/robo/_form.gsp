<%@ page import="robovelc.Robo" %>



<div class="fieldcontain ${hasErrors(bean: roboInstance, field: 'nomeRobo', 'error')} ">
	<label for="nomeRobo">
		<g:message code="robo.nomeRobo.label" default="Nome Robo" />
		
	</label>
	<g:textField name="nomeRobo" maxlength="30" value="${roboInstance?.nomeRobo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roboInstance, field: 'tipoGrafico', 'error')} required">
	<label for="tipoGrafico">
		<g:message code="robo.tipoGrafico.label" default="Tipo Grafico" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoGrafico" from="${roboInstance.constraints.tipoGrafico.inList}" required="" value="${roboInstance?.tipoGrafico}" valueMessagePrefix="robo.tipoGrafico"/>

</div>

