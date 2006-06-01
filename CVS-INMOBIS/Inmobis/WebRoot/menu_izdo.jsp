<!--pagecell1-->
<div id="pageName"> 
	<table width="95%">
		<tr>
			<td>
				<h2><%= subtitulo%></h2>
			</td>
			<%if(tipoMenu.equals("general")||tipoMenu.equals("login")){} else {%>
			<td align="right">
				<font size="2" color="green">Usuario&nbsp;<i><%=session.getAttribute("tipoUsuario")%></i>:</font>&nbsp;<font color="blue"><b><%=session.getAttribute("userName")%></b></font>
			</td>
			<%}%>	
		</tr>
	</table>
</div>
<div id="pageNav"> 
<%if(tipoMenu.equals("general")){%>				
	<div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuGenerico.message"/></h3>
		<a href="login.jsp">
			<fmt:message key="menuGenerico.identificarse"/>
		</a>
		<a href="registraClienteCliente.jsp">
			<fmt:message key="menuGenerico.registrarse"/>
		</a>
		<a href="verPisos.do">
			<fmt:message key="menuGenerico.inmuebles"/>
		</a>
		<a href="PonerQueja.jsp">
			<fmt:message key="menuGenerico.quejas"/>
		</a>
		<a href=javascript:history.go(-1);>Volver</a>
	</div>
<%}else if(tipoMenu.equals("login")){%><!--Este menu tiene que ser asi-->
	<html:errors property="login"/>				
	<div id="sectionLinks">
		<h3>&nbsp;<fmt:message key="login.message"/></h3>
		<br>		
		<html:form action="login.do" focus="userName">
		&nbsp;<fmt:message key="login.username"/>
		<br>	
		&nbsp;<html:text 	property="userName" 
							size="15" 
							maxlength="25" />
		&nbsp;<html:errors property="userName" />
		<br><br>
		&nbsp;<fmt:message key="login.password"/>
		<br>
		&nbsp;<html:password 	property="password" 
								size="15" 
								maxlength="12" 
								redisplay="false"/>
		&nbsp;<html:errors property="password" />
		<br><br>
		&nbsp;<html:submit>
					<fmt:message key="login.button.signon"/>
		</html:submit>
		</html:form>
		<a href=javascript:history.go(-1);>Volver</a>
	</div>	
<%}else if(tipoMenu.equals("administrador")){%>
	<html:errors property="menuAdministrador"/>
	<div id="sectionLinks2">	
		<h3>&nbsp;<fmt:message key="menuAdministrador.message"/></h3>	
		<a href="registraEmpleado.jsp">
			<fmt:message key="menuAdministrador.registraEmpleado"/>
		</a>
		<a href="verEmpleadosPrev.do">
			<fmt:message key="menuAdministrador.lista"/>
		</a>
		<a href=javascript:history.go(-1);>Volver</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
	</div>
<%}else if(tipoMenu.equals("agente")){%>
	<html:errors property="menuAgente"/>				 	
	<div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuAgente.message"/></h3> 
		<a href="verClientesAgentePrev.do">
			<fmt:message key="menuAgente.clientes"/>
		</a>
		<a href="enConstruccion.jsp">
			<fmt:message key="menuAgente.alertas"/>
		</a>
		<a href="listaMensajesPrev.do">
			<fmt:message key="menuAgente.mensajes"/>
		</a>		 
		<a href="verPisosAgente.do">
			<fmt:message key="menuAgente.verInmuebles"/>
		</a>
		<a href="registraPiso.jsp">
			<fmt:message key="menuAgente.registraPiso"/>
		</a>
		<a href="registraClienteAgente.jsp">
			<fmt:message key="menuAgente.registraCliente"/>
		</a>
		<a href=javascript:history.go(-1);>Volver</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
	</div>	
<%}else if(tipoMenu.equals("cliente")){%>
	<html:errors property="menuCliente"/>
	<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->		
	 <div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuCliente.message"/></h3>	
		<a href="verPisos.do">
			<fmt:message key="menuCliente.inmuebles"/>
		</a>
		<a href="listaMensajeClientePrev.do">
			<fmt:message key="menuCliente.quejas"/>
		</a>
		<a href="listaMensajeClientePrev.do">
			<fmt:message key="menuCliente.mensajes"/>
		</a>	
		<a href=javascript:history.go(-1);>Volver</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
	</div>
<%}else if(tipoMenu.equals("gerente")){%>
	<html:errors property="menuGerente"/>
	<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->		
	 <div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuGerente.message"/></h3>			
		<a href="verAgentesPrev.do">
			<fmt:message key="menuGerente.agentes"/>
		</a>
		<a href="verClientesPrev.do">
			<fmt:message key="menuGerente.clientes"/>
		</a>
		<a href="enConstruccion.jsp">
			<fmt:message key="menuGerente.quejas"/>
		</a>
		<a href=javascript:history.go(-1);>Volver</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
	</div>
<%}else if(tipoMenu.equals("contable")){%>
	<html:errors property="menuContable"/>
	<div id="sectionLinks2">	
		<h3>&nbsp;<fmt:message key="menuContable.message"/></h3>	
		<a href="verPisosVendidos.do">
			<fmt:message key="menuContable.verPisos"/>
		</a>
		<a href=javascript:history.go(-1);>Volver</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>		
	</div>
<%}%>
</div><!--del pageNav-->