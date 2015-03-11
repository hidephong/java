Use ASMDB
GO
Create Table Device(
id int primary key,
DeviceName nvarchar(50),
DvStatus nvarchar(10) 
)
GO

--drop Database ASMDB
insert into Device values(1,'Tivi','off')
insert into Device values(2,'Dieu hoa','on')
GO
Select * from Device
GO