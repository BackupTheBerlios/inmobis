 <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina de Login </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>

				<html:errors property="login"/>
				
		<div id="sectionLinks">
		
		
				<h3>&nbsp;<fmt:message key="login.message"/></h3><br>
					
				<html:form action="login.do" focus="userName">
				&nbsp;<fmt:message key="login.username"/><br>
	
				
				&nbsp;<html:text 	property="userName" 
	    								size="15" 
	    								maxlength="20" />
				&nbsp;<html:errors property="userName" /><br><br>


				&nbsp;<fmt:message key="login.password"/><br>


				&nbsp;<html:password 	property="password" 
	    									size="15" 
	    									maxlength="20" 
	    									redisplay="false"/>
				&nbsp;<html:errors property="password" /><br><br>

 
				&nbsp;<html:submit>
				<fmt:message key="login.button.signon"/>
				</html:submit><br>


				
				
				
				</div>
				
				</html:form>
				
              </div>