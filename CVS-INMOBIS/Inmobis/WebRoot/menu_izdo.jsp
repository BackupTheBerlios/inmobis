<!--pagecell1-->
<div id="pageName"> 
	<h2><%= subtitulo%></h2>
</div>
<div id="pageNav"> 
<%if(tipoMenu=="inicio"){%>
	<div id="sectionLinks"><a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
	</div><!--del pageNav-->
<%}else if(tipoMenu=="general"){%>				
	<div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuGenerico.message"/></h3>
		<a href="verPisos.do">
			<fmt:message key="menuGenerico.button.inmuebles"/>
		</a>
		<a href="PonerQueja.jsp">
			<fmt:message key="menuGenerico.button.quejas"/>
		</a>
		<a href="login.jsp">
			<fmt:message key="menuGenerico.button.identificarse"/>
		</a>
		<!--<html:form action="registraClienteCliente.do" >
			<html:submit>
				<fmt:message key="menuGenerico.button.inmuebles"/>
			</html:submit>
		 </html:form>
		 <br>
		 <html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuGenerico.button.quejas"/>
			</html:submit>
		</html:form>
		<br>
		<html:form action="login.jsp" >					
			<html:submit>
				<fmt:message key="menuGenerico.button.identificarse"/>
			</html:submit>
		</html:form>-->
	</div>
  </div><!--del pageNav-->
<%}else if(tipoMenu=="login"){%><!--Este menu tiene que ser asi-->
	<html:errors property="login"/>				
	<div id="sectionLinks">
		<h3>&nbsp;<fmt:message key="login.message"/></h3>
		<br>		
		<html:form action="login.do" focus="userName">
		&nbsp;<fmt:message key="login.username"/>
		<br>	
		&nbsp;<html:text 	property="userName" 
							size="15" 
							maxlength="20" />
		&nbsp;<html:errors property="userName" />
		<br><br>
		&nbsp;<fmt:message key="login.password"/>
		<br>
		&nbsp;<html:password 	property="password" 
								size="15" 
								maxlength="20" 
								redisplay="false"/>
		&nbsp;<html:errors property="password" />
		<br><br>
		&nbsp;<html:submit>
					<fmt:message key="login.button.signon"/>
		</html:submit><br>
	</div>
	</html:form>
  </div><!--del pageNav-->
<%}else if(tipoMenu=="administrador"){%>
	<html:errors property="menuAdministrador"/>
	<div id="sectionLinks2">	
		<h3>&nbsp;<fmt:message key="menuAdministrador.message"/></h3>	
		<a href="VerEmpleadosPrev.do">
			<fmt:message key="menuAdministrador.button.lista"/>
		</a>
		<a href="registraClienteCliente.jsp">
			<fmt:message key="menuAdministrador.button.registra"/>
		</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!--<html:form action="VerEmpleadosPrev.do" >					
			<html:submit>
				<fmt:message key="menuAdministrador.button.lista"/>
			</html:submit>
		 </html:form>
	   
		 <html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAdministrador.button.registra"/>
			</html:submit>
		</html:form>-->				
	</div>
 </div><!--del pageNav-->
<%}else if(tipoMenu=="agente"){%>
	<html:errors property="menuAgente"/>				 	
	<div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuAgente.message"/></h3> 
		<a href="verClientesAgentePrev.do">
			<fmt:message key="menuAgente.button.clientes"/>
		</a>
		<a href="listaAlertasPrev">
			<fmt:message key="menuAgente.button.alertas"/>
		</a>
		<a href="listaMensajesPrev.do">
			<fmt:message key="menuAgente.button.mensajes"/>
		</a>		 
		<a href="verPisosAgente.do">
			<fmt:message key="menuAgente.button.inmuebles"/>
		</a>
		<a href="registraClienteAgente.jsp">
			<fmt:message key="menuAgente.button.registraCliente"/>
		</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->
		<!--<html:form action="verClientesAgentePrev.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.clientes"/>
			</html:submit>
		 </html:form>
		 <html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.alertas"/>
			</html:submit>
		</html:form>
		<html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.mensajes"/>
			</html:submit>
		</html:form>
		<html:form action="verPisosAgente.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.inmuebles"/>
			</html:submit>
		</html:form>
		<html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.registraCliente"/>
			</html:submit>
		</html:form>-->
	</div>
</div><!--del pageNav-->	
<%}else if(tipoMenu=="cliente"){%>
	<html:errors property="menuCliente"/>
	<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->		
	 <div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuCliente.message"/></h3>			
		<a href="verPisos.do">
			<fmt:message key="menuCliente.button.inmuebles"/>
		</a>
		<a href="PonerQueja.jsp">
			<fmt:message key="menuCliente.button.quejas"/>
		</a>
		<a href="PonerMensaje.jsp">
			<fmt:message key="menuCliente.button.mensajes"/>
		</a>		 
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!--<html:form action="registraClienteCliente.do" >
					<html:submit>
						<fmt:message key="menuCliente.button.inmuebles"/>
					</html:submit>
		 </html:form>
		 <html:form action="registraClienteCliente.do" >					
					<html:submit>
						<fmt:message key="menuCliente.button.quejas"/>
					</html:submit>
		</html:form>
		<html:form action="registraClienteCliente.do" >					
					<html:submit>
						<fmt:message key="menuCliente.button.mensajes"/>
					</html:submit>
		</html:form>-->
	</div>
</div><!--del pageNav-->
<%}else if(tipoMenu=="gerente"){%>
	<html:errors property="menuGerente"/>
	<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->		
	 <div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuGerente.message"/></h3>			
		<a href="verAgentesPrev.do">
			<fmt:message key="menuGerente.button.agentes"/>
		</a>
		<a href="verClientesPrev.do">
			<fmt:message key="menuGerente.button.clientes"/>
		</a>
		<a href="verQuejasPrev.do">
			<fmt:message key="menuGerente.button.quejas"/>
		</a>
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!--<html:form action="verAgentesPrev.do" >
			<html:submit>
				<fmt:message key="menuGerente.button.agentes"/>
			</html:submit>
		 </html:form>
		 <html:form action="verClientesPrev.do" >					
			<html:submit>
				<fmt:message key="menuGerente.button.clientes"/>
			</html:submit>
		</html:form>
		<html:form action="verQuejasPrev.do" >					
			<html:submit>
				<fmt:message key="menuGerente.button.quejas"/>
			</html:submit>
		</html:form>-->
	</div>
</div><!--del pageNav-->
<%}%>