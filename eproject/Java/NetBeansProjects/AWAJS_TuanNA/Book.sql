-- Drop Database BookStore
Create Database BookStore
Go
Use BookStore
Go
Create Table Book(
ID int Primary  key Identity(1,1),
[Name] nvarchar(100),
Author nvarchar(100),
Publisher nvarchar(100),
[Year] int,
[Description] ntext ,
img nvarchar(100),
BookCategory int,
BookLink nvarchar(255)
)
GO

Create Table Admin(
AID int primary key identity(1,1),
[AdName] nvarchar(100),
[AdUser] nvarchar(100),
[AdPassword] nvarchar(100),
[AdEmail] nvarchar(100)
)
GO
Insert into Admin(AdName,AdPassword,AdEmail) values('admin','123','')
Insert into Admin(AdName,AdPassword,AdEmail) values('test','123','')

GO

Create Table CommentTbl(
CID int primary key identity(1,1),
UID int,
CComment ntext
)
GO

Create Table [User](
UID int primary key identity(1,1),
[UsName] nvarchar(100),
[UUser] nvarchar(100),
[UsPassword] nvarchar(100),
[UsEmail] nvarchar(100)
)
GO


Insert Into [User](UsName,UUser,UsPassword,UsEmail) values('nguyen anh tuan','tuan','123','')

Insert Into [User](UsName,UUser,UsPassword,UsEmail) values('tran khoai','tran','123','')
Go

Create Table Category(
CateID int primary key identity(1,1),
CateName nvarchar(200),
CateDescription ntext
)
GO
insert into Category(CateName,CateDescription) values ('Maths','Maths')
insert into Category(CateName,CateDescription) values ('Story','Story')
insert into Category(CateName,CateDescription) values ('Education','Education')
insert into Category(CateName,CateDescription) values ('Physic','physic')

Create Table Folder(
FID int primary key identity(1,1),
UID int,
FolderName nvarchar(100)
)
GO

Create Table FAB(
FABID int primary key identity(1,1),
BID int,
FID int
)
GO

Select * from Book inner join  Category On BookCategory=CateID
