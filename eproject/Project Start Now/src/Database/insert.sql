USE EmployeeTransferManagement_DB;
Go
INSERT INTO SystemAdmin VALUES ('Nguyen Van A', 'admin', '202CB962AC59075B964B07152D234B70')
--select * from SystemAdmin

insert into Location values( 'Ha Noi',10000,'enabled')
insert into Location values('TP. Ho Chi Minh',20000,'enabled')
-- Select * from Location

insert into Department values('FAT',1,'enabled')
insert into Department values('GOS',2,'enabled')
insert into Department values('TIS',1,'enabled')
-- Select * from Department

insert into Project values('Employee Transfer Manager','enabled')
insert into Project values('Book Store','enabled')
insert into Project values('Internet Buy','enabled')

-- Select * from Project

			
insert into WorkItem(DepartmentID,ProjectID,StartDate,EndDate,[Status]) values(1,1,'01/01/2000','01/11/2000','in progress')
insert into WorkItem(DepartmentID,ProjectID,StartDate,EndDate,[Status]) values(1,3,'01/01/2000','01/01/2001','not started')
-- Select * from WorkItem

				
insert into Post([Role],PostAllowance,[Status]) values('Tester',10000,'enabled')
insert into Post([Role],PostAllowance,[Status]) values('Programer',20000,'enabled')
insert into Post([Role],PostAllowance,[Status]) values('Manager',40000,'enabled')
-- Select * from Post

-- Pass mặc định là 123 cho tất cả nhé
insert into Employee(Username,EmployeeName,[Password],RoleID,WorkExperience,WorkItemID,JoiningDate,PhoneNumber,Email,Gender,[Address],[Status])  values('nhahv','Nha Hoang Van','202CB962AC59075B964B07152D234B70', 1, 12,1, '1/1/2001', '0123 10201', 'nhahv@gmail.xom', 'female','Ha Noi','enabled')
insert into Employee(Username,EmployeeName,[Password],RoleID,WorkExperience,WorkItemID,JoiningDate,PhoneNumber,Email,Gender,[Address],[Status])  values('tanvv','Tan Vu Van','202CB962AC59075B964B07152D234B70', 2, 14,1, '1/1/2001', '0124 103201', 'tanvv@gmail.xom', 'female','Ha Noi','enabled')
insert into Employee(Username,EmployeeName,[Password],RoleID,WorkExperience,WorkItemID,JoiningDate,PhoneNumber,Email,Gender,[Address],[Status])  values('tuannv','Tuan Nguyen Anh','202CB962AC59075B964B07152D234B70', 1, 15,2, '1/1/2001', '234 22343', 'tuanna@gmail.xom', 'female','Hoa Binh','enabled')
insert into Employee(Username,EmployeeName,[Password],RoleID,WorkExperience,WorkItemID,JoiningDate,PhoneNumber,Email,Gender,[Address],[Status])  values('phuongdth','Phuong Do Thi Huyen','202CB962AC59075B964B07152D234B70', 3, 10,1, '1/1/2001', '686 8868', 'phuongcs@gmail.xom', 'male','Nam Dinh','enabled')

-- Select * from Employee

insert into TransferRecord(EmployeeID,WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,[Status]) values(1,1,'',1,1234.232,'','','pending')
insert into TransferRecord(EmployeeID,WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,[Status]) values(2,2,'',1,1234.232,'','','approved')
insert into TransferRecord(EmployeeID,WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,[Status]) values(3,2,'',1,1234.232,'','','approved')
insert into TransferRecord(EmployeeID,WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,[Status]) values(4,2,'',1,1234.232,'','','approved')
insert into TransferRecord(EmployeeID,WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,[Status]) values(1,1,'',1,1234.232,'20110411','','pending')

-- Select * from TransferRecord