<!--Día de Nacimiento-->
<html:select property="diaNacimiento" size="1">
	<%!
	 int dia=1;
	 int dias=31;
	 %>
	 <html:option value="<%=("")%>">
D&iacute;a
	      </html:option>
	 <%
	 while (dia<=dias)
	 {
	%>
	      <html:option value="<%=(""+dia)%>">
<%=(""+dia)%>
	      </html:option>
<%
	 dia=(dia+1);
	 };
	 dia=1;
	 dias=31;
	%>                
            </html:select>  

<!--Mes de Nacimiento-->
<html:select property="mesNacimiento" size="1">
	<%!
	 int mes=1;
	 String STR="Enero";
	 %>
	 <html:option value="<%=("")%>">
Mes
	      </html:option>
	 <%
	 while (mes<=12)
	 {
	 if (mes==1)
	 {
	 STR="Enero";
	 };
	 if (mes==2)
	 {
	 STR="Febrero";
	 };
	 if (mes==3)
	 {
	 STR="Marzo";
	 };
	 if (mes==4)
	 {
	 STR="Abril";
	 };
	 if (mes==5)
	 {
	 STR="Mayo";
	 };
	 if (mes==6)
	 {
	 STR="Junio";
	 };
	 if (mes==7)
	 {
	 STR="Julio";
	 };
	 if (mes==8)
	 {
	 STR="Agosto";
	 };
	 if (mes==9)
	 {
	 STR="Septiembre";
	 };
	 if (mes==10)
	 {
	 STR="Octubre";
	 };
	 if (mes==11)
	 {
	 STR="Noviembre";
	 };
	 if (mes==12)
	 {
	 STR="Diciembre";
	 };
	%>
	      <html:option value="<%=(""+mes)%>">
<%=(STR)%>
	      </html:option>
<%
	 mes=(mes+1);
	 };
	 mes=1;
	%>                
            </html:select>

<!--Año de Nacimiento-->
            <html:select property="anioNacimiento" size="1">
	<%!
	 int anio=1900;
	 %>
	 <html:option value="<%=("")%>">
Anio
	      </html:option>
	 <%
	 while (anio<=2006)
	 {
	%>
	      <html:option value="<%=(""+anio)%>">
<%=(""+anio)%>
	      </html:option>
<%
	 anio=(anio+1);
	 };
	 anio=1900;
	%>                
            </html:select>

<html:errors property="diaNacimiento" />
<html:errors property="mesNacimiento" />
<html:errors property="anioNacimiento" />
