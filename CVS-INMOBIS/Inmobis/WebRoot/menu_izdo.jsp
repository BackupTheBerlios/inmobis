<!--pagecell1-->
<div id="pageName"> 
	<h2><%= subtitulo%></h2>
</div>
<div id="pageNav"> 
	<div id="sectionLinks"><a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
<%if(tipoMenu=="general"){%>
	</div><!--del pageNav-->
<%}else if(tipoMenu=="login"){%>
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
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->
		<html:form action="VerEmpleadosPrev.do" >					
			<html:submit>
				<fmt:message key="menuAdministrador.button.lista"/>
			</html:submit>
		 </html:form>
	   
		 <html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAdministrador.button.registra"/>
			</html:submit>
		</html:form>				
	</div>
 </div><!--del pageNav-->
<%}else if(tipoMenu=="agente"){%>
	<html:errors property="menuAgente"/>				 	
	<div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuAgente.message"/></h3> 
		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->
		<html:form action="verClientesAgentePrev.do" >					
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
		<html:form action="registraClienteCliente.do" >					
			<html:submit>
				<fmt:message key="menuAgente.button.clientes2"/>
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
		</html:form>
	</div>
</div><!--del pageNav-->	
<%}else if(tipoMenu=="cliente"){%>
	<html:errors property="menuCliente"/>
	<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->		
	 <div id="sectionLinks2">
		<h3>&nbsp;<fmt:message key="menuCliente.message"/></h3>			

		<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
		<html:form action="registraClienteCliente.do" >
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
		</html:form>
	</div>
</div><!--del pageNav-->
<%}else if(tipoMenu=="gerente"){%>
	<div id="sectionLinks2">
		<h3>MEN&Uacute; GERENTE</h3>
		<br><br>
		<FONT SIZE="2px" COLOR="RED">EN CONSTRUCCIÓN</FONT>
	</div>
</div><!--del pageNav-->
<%}%>