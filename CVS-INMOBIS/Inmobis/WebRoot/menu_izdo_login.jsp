 <%@ include file="menu_izdo_general.jsp" %>

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