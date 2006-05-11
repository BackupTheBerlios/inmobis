use  inmobis;

insert into TCliente values ('C101', 'Diego ', 'Alonso','Garc�a', '1981-05-26');
insert into TCliente values ('C102', 'Esther', 'Cocero','Navarro', '1983-10-09');
insert into TCliente values ('C103', 'Ainhoa', 'Borobia', 'Aldanondo','1982-04-16');
insert into TCliente values ('C104', 'Esther', 'Solanas', 'Gonz�lez','1983-10-18');
insert into TCliente values ('C105', 'Jorge ', 'D�az', 'Bizarro','1983-06-10');

insert into TEmpleados values ('AG101', 'Gloria', 'Perez','Vargas', '1981-07-26');
insert into TEmpleados values ('AG102', 'Federico ', 'Blazquez','Rodriguez', '1973-11-09');
insert into TEmpleados values ('G103', 'Cristina', 'Rivero ', ' Rodriguez','1984-12-10');
insert into TEmpleados values ('C104', 'Estefania', 'Tortajada', 'Agudo','1982-11-28');
insert into TEmpleados values ('AD105', 'Ainhoa ', 'Borobia', 'Aldanondo','1983-04-16');

insert into TInmueble values ('I101', '100', 'Alquiler', '1500','Reformado');
insert into TInmueble values ('I102', '80', 'Venta', '250000','Reformado');
insert into TInmueble values ('I103', '90', 'Venta', '250000','Exterior');
insert into TInmueble values ('I104', '70', 'Alquiler', '990','Reformado');
insert into TInmueble values ('I105', '50', 'Alquiler', '250','Reformado');

insert into TDirInmueble values
('I101','casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');
insert into TDirInmueble values
('I102','casa','Castellana','N�12','4�D','28039','Madrid','Madrid','Espa�a');
insert into TDirInmueble values
('I103','casa','Islas Aleutianas','N�11','3�A','28039','Madrid','Madrid','Espa�a');
insert into TDirInmueble values
('I104','casa','Cuatro Caminos','N�10','2�D','28039','Madrid','Madrid','Espa�a');
insert into TDirInmueble values
('I105','casa','Avda. Reina Victoria','N�9','9�W','28039','Madrid','Madrid','Espa�a');

insert into TDirCliente values
('casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a','C101');
insert into TDirCliente values
('trabajo','Castellana','N�12','4�D','28039','Madrid','Madrid','Espa�a','C104');
insert into TDirCliente values
('casa','Islas Aleutianas','N�11','3�A','28039','Madrid','Madrid','Espa�a','C102');
insert into TDirCliente values
('casa','Cuatro Caminos','N�10','2�D','28039','Madrid','Madrid','Espa�a','C103');
insert into TDirCliente values
('casa','Avda. Reina Victoria','N�9','9�W','28039','Madrid','Madrid','Espa�a','C105');

insert into TMailCliente values ('C104', 'estsol20@gmail.com', 'gmailC104');
insert into TMailCliente values ('C105', 'jorge_db@hotmail.com', 'hotmailC105');
insert into TMailCliente values ('C102', 'estheruky@hotmail.com', 'hotmailC102');
insert into TMailCliente values ('C101', 'estheruky@hotmail.com', 'hotmailC101');

insert into TTelfCliente values ('C104','280','618225566','915556622');
insert into TTelfCliente values ('C101','280','652336333',null);
insert into TTelfCliente values ('C103','280','618446655','916698522');

insert into TDirEmpleado values
('AG101', 'casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');
insert into TDirEmpleado values
('AG102', 'casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');
insert into TDirEmpleado values
('G103', 'casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');
insert into TDirEmpleado values
('C104', 'casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');
insert into TDirEmpleado values
('AD105', 'casa','Carnicer','N�13','2�C','28039','Madrid','Madrid','Espa�a');


insert into TMailEmpleado values ('G103', 'cristinitariver@hotmail.com', 'hotmailG103');
insert into TMailEmpleado values ('AD105', 'potota832@yahoo.es', 'yahooAD105');
insert into TMailEmpleado values ('C104', 'estefania@hotmail.com', 'hotmailC104');

insert into TTelfEmpleado values ('C104','280','656225566','915666622');
insert into TTelfEmpleado values ('AG101','280','669336333',null);
insert into TTelfEmpleado values ('G103','280','622446655','917868522');




