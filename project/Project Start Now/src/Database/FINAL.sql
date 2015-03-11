/*
Navicat SQL Server Data Transfer

Source Server         : SQL SERVER 2005
Source Server Version : 90000
Source Host           : NHAHV-PC\SQLEXPRESS:1433
Source Database       : EmployeeTransferManagement_DB
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 90000
File Encoding         : 65001

Date: 2011-04-09 16:59:11
*/

USE EmployeeTransferManagement_DB;
Go
-- ----------------------------
-- Procedure structure for [addADepartment]
-- ----------------------------
DROP PROCEDURE [addADepartment]
GO
/*
Navicat SQL Server Data Transfer

Source Server         : SQL SERVER 2005
Source Server Version : 90000
Source Host           : NHAHV-PC\SQLEXPRESS:1433
Source Database       : EmployeeTransferManagement_DB
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 90000
File Encoding         : 65001

Date: 2011-04-07 15:30:52
*/


-- ----------------------------
-- Procedure structure for [addADepartment]
-- ----------------------------
CREATE PROCEDURE [addADepartment]
@DeptName NVARCHAR(50),
@Locname NVARCHAR(50),
@Status NVARCHAR(10)
AS
	DECLARE @LocID INT
	BEGIN
		SET @LocID = (SELECT Location.LocationID FROM Location WHERE Location.LocationAddress LIKE @Locname)
		INSERT INTO Department(DepartmentName,LocationID,Status) VALUES (@Deptname, @LocID, @Status)
	END
	


GO

-- ----------------------------
-- Procedure structure for [addALocation]
-- ----------------------------
DROP PROCEDURE [addALocation]
GO

-- ----------------------------
-- Procedure structure for [addALocation]
-- ----------------------------
CREATE PROCEDURE [addALocation]
(@add NTEXT,
@all MONEY,
@stt NVARCHAR(10))
AS
BEGIN
  INSERT INTO Location(LocationAddress, LocationAllowance, Status) VALUES (@add, @all, @stt);
	SELECT * FROM Location;
END



GO

-- ----------------------------
-- Procedure structure for [addANewProject]
-- ----------------------------
DROP PROCEDURE [addANewProject]
GO

-- ----------------------------
-- Procedure structure for [addANewProject]
-- ----------------------------
CREATE PROCEDURE [addANewProject]
@name nvarchar(50),
@status nvarchar(10)
AS
	BEGIN
		INSERT INTO Project VALUES (@name, @status)
	END
--exec AddANewProject 'Intern42', 'enabled'



GO

-- ----------------------------
-- Procedure structure for [addAPost]
-- ----------------------------
DROP PROCEDURE [addAPost]
GO

-- ----------------------------
-- Procedure structure for [addAPost]
-- ----------------------------
CREATE PROCEDURE [addAPost]
@role NVARCHAR(50),
@pa MONEY,
@stt NVARCHAR(10)
AS
BEGIN 
INSERT INTO Post([Role],PostAllowance,[Status]) VALUES (@role, @pa, @stt)
END


GO

-- ----------------------------
-- Procedure structure for [addAWorkItem]
-- ----------------------------
DROP PROCEDURE [addAWorkItem]
GO

-- ----------------------------
-- Procedure structure for [addAWorkItem]
-- ----------------------------
CREATE PROCEDURE [addAWorkItem]
@depID int,
@prjID int,
@sdate datetime,
@edate datetime,
@stt nvarchar(20)
AS
BEGIN
DECLARE @oldEnddate datetime-- MAX(EndDate) - Cho kết quả ngày kết thúc muộn nhất của một WorkItem;
SET @oldEnddate = '1900-01-01 00:00:00.000'
SET @oldEnddate = (SELECT MAX(EndDate) FROM WorkItem WHERE DepartmentID = @depID AND ProjectID = @prjID)
IF (@oldEnddate IS NULL OR @oldEnddate < @sdate)
 INSERT INTO WorkItem(DepartmentID, ProjectID, StartDate, EndDate,Status) VALUES (@depID, @prjID,@sdate,@edate,@stt)

END
/*
Một WorkItem chỉ có 1 DepartmentID  và 1 ProjectID
Khi lấy ra, lấy những WorkItem có ngày kết thúc nhỏ hơn ngày hiện tại. (Đối với trường hợp cho Employee chọn lựa WorkItem)

Khi thêm mới:
 Ngày StartDate của wi mới phải lớn hơn ngày kết thúc muộn nhất của một WorkItem; Không cần để ý đến Status.
*/

GO

-- ----------------------------
-- Procedure structure for [addEmployee]
-- ----------------------------
DROP PROCEDURE [addEmployee]
GO

-- ----------------------------
-- Procedure structure for [addEmployee]
-- ----------------------------
CREATE PROC [addEmployee]
@Username NVARCHAR(50),
@Employeename NVARCHAR(50),
@Password nvarchar(32),
@RoleID int,
@WorkExperience INT,
@WorkItemID int,
@JoiningDate datetime,
@Phone nvarchar(15),
@Email nvarchar(30),
@Gender nvarchar(10),
@Address NVARCHAR(50),
@status nvarchar(10)
AS
	BEGIN
		Insert INTO Employee(Username,Employeename,[Password],RoleID,WorkExperience,WorkItemID,JoiningDate,PhoneNumber,Email,Gender,[Address],[Status])
		VALUES(@Username,@Employeename,@Password,@RoleID,@WorkExperience,@WorkItemID,@JoiningDate,@Phone,@Email,@Gender,@Address,@status)
	END
	


GO

-- ----------------------------
-- Procedure structure for [autoSetWorkItemsStatus]
-- ----------------------------
DROP PROCEDURE [autoSetWorkItemsStatus]
GO

-- ----------------------------
-- Procedure structure for [autoSetWorkItemsStatus]
-- ----------------------------
CREATE PROCEDURE [autoSetWorkItemsStatus]
AS
BEGIN
UPDATE WorkItem SET Status = 'Finished' WHERE EndDate < GETDATE()
UPDATE WorkItem SET Status = 'In Progress' WHERE EndDate > GETDATE()
UPDATE WorkItem SET Status = 'Not Started' WHERE StartDate > GETDATE()
END

GO

-- ----------------------------
-- Procedure structure for [ChangeEmployeePassword]
-- ----------------------------
DROP PROCEDURE [ChangeEmployeePassword]
GO

-- ----------------------------
-- Procedure structure for [ChangeEmployeePassword]
-- ----------------------------
CREATE PROC [ChangeEmployeePassword]
@pwd nvarchar(32),
@id int
AS
	BEGIN
		UPDATE Employee SET [Password] = @pwd WHERE EmployeeID = @id
	END


GO

-- ----------------------------
-- Procedure structure for [ChangePassword]
-- ----------------------------
DROP PROCEDURE [ChangePassword]
GO

-- ----------------------------
-- Procedure structure for [ChangePassword]
-- ----------------------------
CREATE PROC [ChangePassword]
@pwd nvarchar(32),
@id int
AS
	BEGIN
		UPDATE SystemAdmin SET [Password] = @pwd WHERE AdminID = @id
	END



GO

-- ----------------------------
-- Procedure structure for [checkConfictWorkItems]
-- ----------------------------
DROP PROCEDURE [checkConfictWorkItems]
GO

-- ----------------------------
-- Procedure structure for [checkConfictWorkItems]
-- ----------------------------
CREATE PROCEDURE [checkConfictWorkItems]
@Wiid int,
@depID int,
@prjID int,
@sdate DATETIME,
@edate DATETIME
AS
BEGIN 
 SELECT * FROM WorkItem WHERE ProjectID = @prjID AND WorkItemID NOT LIKE @Wiid 
AND  Enddate > @sdate AND StartDate < @edate
	
END

GO

-- ----------------------------
-- Procedure structure for [delEmployee]
-- ----------------------------
DROP PROCEDURE [delEmployee]
GO

-- ----------------------------
-- Procedure structure for [delEmployee]
-- ----------------------------
CREATE PROC [delEmployee]
@Emp_ID INT
AS
	BEGIN
		DELETE FROM Employee WHERE Employee.EmployeeID = @Emp_ID
	END
	


GO

-- ----------------------------
-- Procedure structure for [deleteADepartment]
-- ----------------------------
DROP PROCEDURE [deleteADepartment]
GO

-- ----------------------------
-- Procedure structure for [deleteADepartment]
-- ----------------------------
CREATE PROCEDURE [deleteADepartment]
@Id INT
AS
	BEGIN
		DELETE FROM Department WHERE DepartmentID = @Id
	END
	


GO

-- ----------------------------
-- Procedure structure for [deleteALocation]
-- ----------------------------
DROP PROCEDURE [deleteALocation]
GO

-- ----------------------------
-- Procedure structure for [deleteALocation]
-- ----------------------------
CREATE PROCEDURE [deleteALocation]
@id INT
AS
	BEGIN
		DELETE FROM Location WHERE LocationID = @id
	END



GO

-- ----------------------------
-- Procedure structure for [deleteAPost]
-- ----------------------------
DROP PROCEDURE [deleteAPost]
GO

-- ----------------------------
-- Procedure structure for [deleteAPost]
-- ----------------------------
CREATE PROCEDURE [deleteAPost]
@id INT
AS
BEGIN 
DELETE FROM Post WHERE RoleID = @id
END


GO

-- ----------------------------
-- Procedure structure for [deleteAProject]
-- ----------------------------
DROP PROCEDURE [deleteAProject]
GO

-- ----------------------------
-- Procedure structure for [deleteAProject]
-- ----------------------------
CREATE PROCEDURE [deleteAProject]
@id int
AS
	BEGIN
		DELETE FROM Project WHERE ProjectID = @id
	END



GO

-- ----------------------------
-- Procedure structure for [deleteAWorkItem]
-- ----------------------------
DROP PROCEDURE [deleteAWorkItem]
GO

-- ----------------------------
-- Procedure structure for [deleteAWorkItem]
-- ----------------------------
CREATE PROCEDURE [deleteAWorkItem]
@wiID int
AS
BEGIN
 DELETE FROM WorkItem WHERE WorkItemID = @wiID
END

GO

-- ----------------------------
-- Procedure structure for [E_RequestATransfer]
-- ----------------------------
DROP PROCEDURE [E_RequestATransfer]
GO
-- ----------------------------
-- Procedure structure for [Employee Send a transfer Request]
-- ----------------------------

CREATE PROCEDURE [E_RequestATransfer]

@empID int,
@wiID int,
@treasion NTEXT
AS
BEGIN
INSERT INTO TransferRecord(EmployeeID, WorkItemID, RelievingDate, ReportingManager, Allowance, CreationDate, TransferReason,Status )
VALUES(@empID,@wiID,GETDATE(),0,0,GETDATE(),@treasion,'Pending')
END

GO

-- ----------------------------
-- Procedure structure for [get_AllDepartment]
-- ----------------------------
DROP PROCEDURE [get_AllDepartment]
GO

-- ----------------------------
-- Procedure structure for [get_AllDepartment]
-- ----------------------------
CREATE PROCEDURE [get_AllDepartment]
AS
BEGIN
  SELECT * FROM Department
END

GO

-- ----------------------------
-- Procedure structure for [get_AllLocation]
-- ----------------------------
DROP PROCEDURE [get_AllLocation]
GO

-- ----------------------------
-- Procedure structure for [get_AllLocation]
-- ----------------------------
CREATE PROCEDURE [get_AllLocation]
AS
BEGIN
  SELECT * FROM Location ORDER BY LocationID ASC;
END

GO

-- ----------------------------
-- Procedure structure for [get_AllProject]
-- ----------------------------
DROP PROCEDURE [get_AllProject]
GO

-- ----------------------------
-- Procedure structure for [get_AllProject]
-- ----------------------------
CREATE PROCEDURE [get_AllProject]
AS
BEGIN
	SELECT * FROM Project ORDER BY ProjectID ASC 
END

GO

-- ----------------------------
-- Procedure structure for [get_AllRole]
-- ----------------------------
DROP PROCEDURE [get_AllRole]
GO

-- ----------------------------
-- Procedure structure for [get_AllRole]
-- ----------------------------
CREATE PROCEDURE [get_AllRole]
AS
BEGIN
SELECT * FROM Post ORDER BY RoleID
END

GO

-- ----------------------------
-- Procedure structure for [get_LocationAllowanceByName]
-- ----------------------------
DROP PROCEDURE [get_LocationAllowanceByName]
GO

-- ----------------------------
-- Procedure structure for [get_LocationAllowanceByName]
-- ----------------------------
CREATE PROCEDURE [get_LocationAllowanceByName]
@name nvarchar(50)
AS
	BEGIN
	  SELECT * FROM Location WHERE LocationAddress like @name
	END


GO

-- ----------------------------
-- Procedure structure for [get_PostAllowanceByName]
-- ----------------------------
DROP PROCEDURE [get_PostAllowanceByName]
GO

-- ----------------------------
-- Procedure structure for [get_PostAllowanceByName]
-- ----------------------------
create PROCEDURE [get_PostAllowanceByName]
@name nvarchar(50)
AS
	BEGIN
	  SELECT * FROM Post WHERE Role like @name
	END


GO

-- ----------------------------
-- Procedure structure for [getAdminData]
-- ----------------------------
DROP PROCEDURE [getAdminData]
GO

-- ----------------------------
-- Procedure structure for [getAdminData]
-- ----------------------------
CREATE PROC [getAdminData]
@adminID int
AS
	BEGIN
		SELECT AdminName, Username, [Password] FROM SystemAdmin WHERE AdminID = @adminID
	END



GO

-- ----------------------------
-- Procedure structure for [getAllDepartment]
-- ----------------------------
DROP PROCEDURE [getAllDepartment]
GO

-- ----------------------------
-- Procedure structure for [getAllDepartment]
-- ----------------------------
CREATE PROCEDURE [getAllDepartment]
AS
	BEGIN
		SELECT Department.DepartmentID, Department.DepartmentName,Location.LocationAddress,Department.Status,Department.LocationID FROM Department
		INNER JOIN Location ON Department.LocationID = Location.LocationID
	END
	


GO

-- ----------------------------
-- Procedure structure for [getAllEmployee]
-- ----------------------------
DROP PROCEDURE [getAllEmployee]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployee]
-- ----------------------------
CREATE PROC [getAllEmployee]
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName, Employee.RoleID
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
	END					



GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByAddress]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByAddress]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByAddress]
-- ----------------------------
CREATE PROC [getAllEmployeeByAddress]
@addr nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  [Address]like @addr
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByDepartment]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByDepartment]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByDepartment]
-- ----------------------------
CREATE PROC [getAllEmployeeByDepartment]
@Depar nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Department.DepartmentName like @Depar
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByEmail]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByEmail]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByEmail]
-- ----------------------------
CREATE PROC [getAllEmployeeByEmail]
@useremail nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.Email like @useremail
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByExperience]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByExperience]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByExperience]
-- ----------------------------
CREATE PROC [getAllEmployeeByExperience]
@userexp int
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.WorkExperience = @userexp
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByFullname]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByFullname]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByFullname]
-- ----------------------------
CREATE PROC [getAllEmployeeByFullname]
@user nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.EmployeeName like @user
	END					

-----------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByGender]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByGender]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByGender]
-- ----------------------------
CREATE PROC [getAllEmployeeByGender]
@usergen nvarchar(10)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.Gender like @usergen
	END					

------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByID]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByID]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByID]
-- ----------------------------
CREATE PROC [getAllEmployeeByID]
@id int
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.EmployeeID=@id
	END					

------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByJoiningDate]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByJoiningDate]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByJoiningDate]
-- ----------------------------
CREATE PROC [getAllEmployeeByJoiningDate]
@dt Datetime
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.JoiningDate = @dt
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByLocation]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByLocation]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByLocation]
-- ----------------------------
CREATE PROC [getAllEmployeeByLocation]
@userLocation nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Location.LocationAddress like @userLocation
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByPhoneNumber]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByPhoneNumber]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByPhoneNumber]
-- ----------------------------
CREATE PROC [getAllEmployeeByPhoneNumber]
@userphone nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.PhoneNumber like @userphone
	END					

--------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByProject]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByProject]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByProject]
-- ----------------------------
CREATE PROC [getAllEmployeeByProject]
@proj nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Project.ProjectName like @proj
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByRole]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByRole]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByRole]
-- ----------------------------
CREATE PROC [getAllEmployeeByRole]
@rol nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Post.[Role] like @rol
	END					

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByStatus]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByStatus]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByStatus]
-- ----------------------------
 --DRop PROC [getAllEmployeeByStatus]       
CREATE PROC [getAllEmployeeByStatus]
@userstt nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.[Status] like @userstt
	END					

--------------------------------------
---------------------
-- PROCs for managing Profile of Admin and Employee
---------------------



GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByUsername]
-- ----------------------------
DROP PROCEDURE [getAllEmployeeByUsername]
GO

-- ----------------------------
-- Procedure structure for [getAllEmployeeByUsername]
-- ----------------------------
 CREATE PROC [getAllEmployeeByUsername]
@user nvarchar(50)
AS
	BEGIN
		SELECT     Employee.EmployeeID,Employee.EmployeeName,Employee.Username,Post.[Role],Employee.WorkExperience,Employee.JoiningDate,Employee.PhoneNumber,Employee.Email,Employee.Gender,Employee.[Address],Employee.[Status],Location.LocationAddress, Project.ProjectName,  Department.DepartmentName
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
									Where  Employee.Username like @user
	END					

-----------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllLocation]
-- ----------------------------
DROP PROCEDURE [getAllLocation]
GO

-- ----------------------------
-- Procedure structure for [getAllLocation]
-- ----------------------------
CREATE PROCEDURE [getAllLocation]
AS
	BEGIN
	  SELECT * FROM Location ORDER BY LocationID ASC;
	END
	


GO

-- ----------------------------
-- Procedure structure for [getAllPendingTransfer]
-- ----------------------------
DROP PROCEDURE [getAllPendingTransfer]
GO
-- ----------------------------
-- Procedure structure for [getAllPendingTransfer]
-- ----------------------------

CREATE PROCEDURE [getAllPendingTransfer]
AS
BEGIN
   	SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,Location.LocationAddress  From TransferRecord INNER JOIN
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
									Location ON Location.LocationID = Department.LocationID INNER JOIN
							    		Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID
WHERE TransferRecord.Status LIKE 'Pending'
	ORDER BY TransferRecord.CreationDate
END

GO

-- ----------------------------
-- Procedure structure for [getAllPost]
-- ----------------------------
DROP PROCEDURE [getAllPost]
GO

-- ----------------------------
-- Procedure structure for [getAllPost]
-- ----------------------------
CREATE PROCEDURE [getAllPost]
AS
BEGIN 
SELECT * FROM Post ORDER BY RoleID
END



GO

-- ----------------------------
-- Procedure structure for [getAllProject]
-- ----------------------------
DROP PROCEDURE [getAllProject]
GO

-- ----------------------------
-- Procedure structure for [getAllProject]
-- ----------------------------
CREATE PROCEDURE [getAllProject] 
AS 
	BEGIN 
		SELECT * FROM Project ORDER BY ProjectID ASC 
	END
	


GO

-- ----------------------------
-- Procedure structure for [getAllProjectOnDepartment]
-- ----------------------------
DROP PROCEDURE [getAllProjectOnDepartment]
GO

-- ----------------------------
-- Procedure structure for [getAllProjectOnDepartment]
-- ----------------------------
CREATE PROC [getAllProjectOnDepartment]
AS
	BEGIN
		SELECT     WorkItem.WorkItemID,Department.DepartmentID,Project.ProjectID,StartDate,EndDate,WorkItem.Status,Project.projectName,Department.DepartmentName,LocationAddress	FROM       WorkItem INNER JOIN 
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
	END	

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllProjectOnDepartmentByLoc]
-- ----------------------------
DROP PROCEDURE [getAllProjectOnDepartmentByLoc]
GO

-- ----------------------------
-- Procedure structure for [getAllProjectOnDepartmentByLoc]
-- ----------------------------
CREATE PROC [getAllProjectOnDepartmentByLoc]
@name NVARCHAR(50)
AS
	BEGIN
		SELECT     WorkItem.WorkItemID,Department.DepartmentID,Project.ProjectID,StartDate,EndDate,WorkItem.Status,Project.projectName,Department.DepartmentName,LocationAddress	FROM       WorkItem INNER JOIN 
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
											Where LocationAddress like @name
	END	

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getAllTransferNotComplete]
-- ----------------------------
DROP PROCEDURE [getAllTransferNotComplete]
GO

-- ----------------------------
-- Procedure structure for [getAllTransferNotComplete]
-- ----------------------------
CREATE PROC [getAllTransferNotComplete]
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,Location.LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							     Location ON Location.LocationID = Department.LocationID INNER JOIN
									Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID
												WHERE TransferRecord.Status like '%approved%'
	END	

GO
-- ----------------------------
-- Procedure structure for [getAllTransfer]
-- ----------------------------
DROP PROCEDURE [getAllTransfer]
GO

-- ----------------------------
-- Procedure structure for [getAllTransfer]
-- ----------------------------
CREATE PROC [getAllTransfer]
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,Location.LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							     Location ON Location.LocationID = Department.LocationID INNER JOIN
									Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID
	END	

GO

-- ----------------------------
-- Procedure structure for [getAllWorkItems]
-- ----------------------------
DROP PROCEDURE [getAllWorkItems]
GO

-- ----------------------------
-- Procedure structure for [getAllWorkItems]
-- ----------------------------
CREATE PROCEDURE [getAllWorkItems]
AS
BEGIN
 SELECT WorkItem.WorkItemID,WorkItem.DepartmentID,WorkItem.ProjectID,WorkItem.StartDate,WorkItem.EndDate,WorkItem.Status,Department.DepartmentName,Project.ProjectName,Location.LocationAddress, Location.LocationID
		FROM WorkItem
				INNER JOIN
						Department ON WorkItem.DepartmentID = Department.DepartmentID
								INNER JOIN
										Project ON WorkItem.ProjectID = Project.ProjectID
													INNER JOIN 
															Location ON Location.LocationID = Department.LocationID
								ORDER BY WorkItem.StartDate DESC 

END

GO

-- ----------------------------
-- Procedure structure for [GetEmployeeInfo]
-- ----------------------------
DROP PROCEDURE [GetEmployeeInfo]
GO

-- ----------------------------
-- Procedure structure for [GetEmployeeInfo]
-- ----------------------------
CREATE PROC [GetEmployeeInfo]
@empID int
AS
	BEGIN
		SELECT     Employee.EmployeeName,Employee.Username,Employee.[Password],Post.[Role],Project.ProjectName,Department.DepartmentName,Employee.PhoneNumber,Employee.JoiningDate,Employee.WorkExperience,Employee.Email,Employee.Gender,Employee.[Address],Location.LocationAddress
		FROM       Employee INNER JOIN 
					Post ON Employee.RoleID = Post.RoleID INNER JOIN 
						 WorkItem ON Employee.WorkItemID = WorkItem.WorkItemID INNER JOIN
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
							WHERE Employee.EmployeeID = @empID
	END	

--exec [GetEmployeeInfo] 1



GO

-- ----------------------------
-- Procedure structure for [getEmployeeTransferByEmpID]
-- ----------------------------
DROP PROCEDURE [getEmployeeTransferByEmpID]
GO
-- ----------------------------
-- Procedure structure for [getEmployeeTransferByEmpID]
-- ----------------------------

CREATE PROCEDURE [getEmployeeTransferByEmpID]
@emId INT
AS
BEGIN
 	SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName, Location.LocationAddress  From TransferRecord INNER JOIN
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN 
											Location ON Location.LocationID = Department.LocationID INNER JOIN
							    		Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID
WHERE TransferRecord.EmployeeID = @emId
	ORDER BY TransferRecord.CreationDate
END

GO

-- ----------------------------
-- Procedure structure for [getLastestWoktItem]
-- ----------------------------
DROP PROCEDURE [getLastestWoktItem]
GO

-- ----------------------------
-- Procedure structure for [getLastestWoktItem]
-- ----------------------------
CREATE PROCEDURE [getLastestWoktItem]
@pID int,
@dID int
AS
BEGIN
DECLARE @lastest datetime
SET @lastest = (SELECT MAX(EndDate) FROM WorkItem WHERE DepartmentID = @dID AND ProjectID = @pID)
SELECT * FROM WorkItem WHERE ProjectID = @pID AND DepartmentID = @dID AND EndDate = @lastest

END

GO

-- ----------------------------
-- Procedure structure for [getPendingTransfer]
-- ----------------------------
DROP PROCEDURE [getPendingTransfer]
GO

-- ----------------------------
-- Procedure structure for [getPendingTransfer]
-- ----------------------------
CREATE PROCEDURE [getPendingTransfer]
AS
BEGIN
 SELECT * FROM TransferRecord WHERE [Status] LIKE 'Pending';
END

GO

-- ----------------------------
-- Procedure structure for [getWorkItem]
-- ----------------------------
DROP PROCEDURE [getWorkItem]
GO

-- ----------------------------
-- Procedure structure for [getWorkItem]
-- ----------------------------
CREATE PROC [getWorkItem]
AS
	BEGIN
		SELECT     WorkItem.WorkItemID,Department.DepartmentID,Project.ProjectID,StartDate,EndDate,WorkItem.Status,Project.projectName,Department.DepartmentName,LocationAddress	FROM       WorkItem INNER JOIN 
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
	END	

------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getWorkItemIDByProjDep]
-- ----------------------------
DROP PROCEDURE [getWorkItemIDByProjDep]
GO

-- ----------------------------
-- Procedure structure for [drop proc getWorkItemIDByProjDep '%Book store on GOS%']
-- ----------------------------
CREATE PROC [getWorkItemIDByProjDep]
@name NVARCHAR(250)
AS
	BEGIN
		SELECT     WorkItem.WorkItemID,Department.DepartmentID,Project.ProjectID,StartDate,EndDate,WorkItem.Status,Project.projectName,Department.DepartmentName,LocationAddress	FROM       WorkItem INNER JOIN 
						  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							Location ON Location.LocationID = Department.LocationID
											Where (Project.projectName +' on ' + Department.DepartmentName) like @name
	END	

------------------------------------


GO

-- ----------------------------
-- Procedure structure for [getWorkItemsForTransfer]
-- ----------------------------
DROP PROCEDURE [getWorkItemsForTransfer]
GO

-- ----------------------------
-- Procedure structure for [getWorkItemsForTransfer]
-- ----------------------------
CREATE PROCEDURE [getWorkItemsForTransfer]
AS
BEGIN
DECLARE @today DATETIME
SET @today = GETDATE()


 SELECT WorkItem.WorkItemID,WorkItem.DepartmentID,WorkItem.ProjectID,WorkItem.StartDate,WorkItem.EndDate,WorkItem.Status,Department.DepartmentName,Project.ProjectName,Location.LocationAddress, Location.LocationID
		FROM WorkItem
				INNER JOIN
						Department ON WorkItem.DepartmentID = Department.DepartmentID
								INNER JOIN
										Project ON WorkItem.ProjectID = Project.ProjectID
													INNER JOIN 
															Location ON Location.LocationID = Department.LocationID


WHERE (WorkItem.EndDate - @today) > 30 
			AND	(WorkItem.StartDate - @today) < 7 

ORDER BY WorkItem.StartDate ASC								              


END

GO

-- ----------------------------
-- Procedure structure for [searchByProjectName]
-- ----------------------------
DROP PROCEDURE [searchByProjectName]
GO

-- ----------------------------
-- Procedure structure for [searchByProjectName]
-- ----------------------------
CREATE PROCEDURE [searchByProjectName]
@name nvarchar(50)
AS
	BEGIN
		SELECT * FROM Project
		WHERE ProjectName LIKE @name
	END
--EXECUTE [SearchByProjectName] '%Transfer%'



GO

-- ----------------------------
-- Procedure structure for [searchByProjectStatus]
-- ----------------------------
DROP PROCEDURE [searchByProjectStatus]
GO

-- ----------------------------
-- Procedure structure for [searchByProjectStatus]
-- ----------------------------
CREATE PROCEDURE [searchByProjectStatus]
@projectStatus nvarchar(10)
AS
	BEGIN
		SELECT * FROM Project
		WHERE [Status] LIKE @projectStatus
	END
	


GO

-- ----------------------------
-- Procedure structure for [SearchByRoleName]
-- ----------------------------
DROP PROCEDURE [SearchByRoleName]
GO

-- ----------------------------
-- Procedure structure for [SearchByRoleName]
-- ----------------------------
CREATE PROCEDURE [SearchByRoleName]
@name NVARCHAR(50)
AS
	BEGIN
		SELECT * FROM Post WHERE [Role] = @name
	END

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [SearchByWorkItemID]
-- ----------------------------
DROP PROCEDURE [SearchByWorkItemID]
GO

-- ----------------------------
-- Procedure structure for [SearchByWorkItemID]
-- ----------------------------
CREATE PROCEDURE [SearchByWorkItemID]
@name NVARCHAR(50)
AS
	BEGIN
		SELECT * FROM Post WHERE [Role] = @name
	END

-------------------------------------


GO

-- ----------------------------
-- Procedure structure for [searchPost]
-- ----------------------------
DROP PROCEDURE [searchPost]
GO

-- ----------------------------
-- Procedure structure for [searchPost]
-- ----------------------------
CREATE PROCEDURE [searchPost]
@role NVARCHAR(50),
@status NVARCHAR(10)
AS
BEGIN
 SELECT * FROM Post WHERE Role LIKE '%'+@role+'%' AND Status LIKE '%'+@status+'%'
END

GO

-- ----------------------------
-- Procedure structure for [Statitics]
-- ----------------------------
DROP PROCEDURE [Statitics]
GO
CREATE PROCEDURE [Statitics]
AS
BEGIN
 SELECT DISTINCT 

(SELECT COUNT(*) FROM TransferRecord WHERE Status LIKE 'Pending') AS PendingTransfer,
(SELECT COUNT(*) FROM WorkItem WHERE Status LIKE 'In Progress') AS InprogressWorkItems,
(SELECT COUNT(*) FROM WorkItem) AS AllWorkItems,
(SELECT COUNT(*) FROM Project WHERE Status LIKE 'Enabled') AS EnabledProject,
(SELECT COUNT(*) FROM Project) AS AllProject,
(SELECT COUNT(*) FROM Employee WHERE Status LIKE 'Enabled') AS WorkingEmployee,
(SELECT COUNT(*) FROM Employee) AS AllEmplyee,
(SELECT COUNT(*) FROM Department WHERE Status LIKE 'Enabled') AS EnabledDepartment,
(SELECT COUNT(*) FROM Department) AS AllDepartment,
(SELECT COUNT(*) FROM Location WHERE Status LIKE 'Enabled') AS EnabledLocation,
(SELECT COUNT(*) FROM Location) AS AllLocaion
END

GO

-- ----------------------------
-- Procedure structure for [updateADepartment]
-- ----------------------------
DROP PROCEDURE [updateADepartment]
GO

-- ----------------------------
-- Procedure structure for [updateADepartment]
-- ----------------------------
CREATE PROCEDURE [updateADepartment]
@id INT,
@Deptname NVARCHAR(50),
@Location NTEXT,
@Stt NVARCHAR(10)
AS
	DECLARE @LocID INT
	BEGIN
		SET @LocID = (SELECT Location.LocationID FROM Location WHERE Location.LocationAddress LIKE @Location)
		UPDATE Department SET DepartmentName = @Deptname,Department.LocationID = @LocID , Status = @Stt WHERE DepartmentID = @id	
	END
	


GO

-- ----------------------------
-- Procedure structure for [UpdateAdminInfo]
-- ----------------------------
DROP PROCEDURE [UpdateAdminInfo]
GO

-- ----------------------------
-- Procedure structure for [UpdateAdminInfo]
-- ----------------------------
CREATE PROC [UpdateAdminInfo]
@fullName nvarchar(50),
@id int
AS
	BEGIN
		UPDATE SystemAdmin SET AdminName = @fullName WHERE AdminID = @id
	END



GO

-- ----------------------------
-- Procedure structure for [updateALocation]
-- ----------------------------
DROP PROCEDURE [updateALocation]
GO

-- ----------------------------
-- Procedure structure for [updateALocation]
-- ----------------------------
CREATE PROCEDURE [updateALocation]
@id INT, @add NTEXT, @all MONEY, @stt NVARCHAR(10)
AS
	BEGIN
		UPDATE Location SET LocationAddress = @add, LocationAllowance = @all, Status = @stt WHERE LocationID = @id
		SELECT * FROM Location;
	END
	


GO

-- ----------------------------
-- Procedure structure for [updateAPost]
-- ----------------------------
DROP PROCEDURE [updateAPost]
GO

-- ----------------------------
-- Procedure structure for [updateAPost]
-- ----------------------------
CREATE PROCEDURE [updateAPost]
@id INT,
@role NVARCHAR(50),
@pa MONEY,
@stt NVARCHAR(10)
AS
BEGIN 
UPDATE Post SET [Role] = @role, PostAllowance = @pa, [Status] = @stt WHERE RoleID = @id
END


GO

-- ----------------------------
-- Procedure structure for [updateAProject]
-- ----------------------------
DROP PROCEDURE [updateAProject]
GO

-- ----------------------------
-- Procedure structure for [updateAProject]
-- ----------------------------
CREATE PROCEDURE [updateAProject]
@id int,
@name nvarchar(50),
@status nvarchar(10)
AS
	BEGIN
		UPDATE Project SET ProjectName = @name, [Status] = @status WHERE ProjectID = @id
	END
	


GO

-- ----------------------------
-- Procedure structure for [UpdateAWorkItem]
-- ----------------------------
DROP PROCEDURE [UpdateAWorkItem]
GO

-- ----------------------------
-- Procedure structure for [UpdateAWorkItem]
-- ----------------------------
CREATE PROCEDURE [UpdateAWorkItem]
@wiID int,
@depID int,
@prjID int,
@sdate datetime,
@edate datetime,
@stt nvarchar(20)
AS
BEGIN
  UPDATE WorkItem SET DepartmentID = @depID, ProjectID = @prjID, StartDate = @sdate, EndDate = @edate, Status = @stt WHERE WorkItemID = @wiID
END

GO

-- ----------------------------
-- Procedure structure for [updateEmployee]
-- ----------------------------
DROP PROCEDURE [updateEmployee]
GO

-- ----------------------------
-- Procedure structure for [updateEmployee]
-- ----------------------------
 

CREATE PROC [updateEmployee]
@Emp_ID INT,
@Employeename NVARCHAR(50),
@RoleID int,
@WorkExperience INT,
@WorkItemID int,
@JoiningDate datetime,
@Phone nvarchar(15),
@Email nvarchar(30),
@Gender nvarchar(10),
@Address NVARCHAR(50),
@status nvarchar(10)
AS
 BEGIN
		UPDATE Employee SET
		EmployeeName=@Employeename,RoleID= @RoleID,
		WorkExperience= @WorkExperience,WorkItemID = @WorkItemID,JoiningDate = @JoiningDate,PhoneNumber = @Phone,
		Email = @Email,Gender= @Gender,[Address] = @Address,[Status]= @status
		WHERE EmployeeID = @Emp_ID
	END

GO

-- ----------------------------
-- Procedure structure for [UpdateEmployeeInfo]
-- ----------------------------
DROP PROCEDURE [UpdateEmployeeInfo]
GO


-- ----------------------------
-- Procedure structure for [UpdateEmployeeInfo]
-- ----------------------------
CREATE PROC [UpdateEmployeeInfo]
@id int,
@Employeename nvarchar(50),
@Phone nvarchar(15),
@Email nvarchar(30),
@Address nvarchar(50)
AS
	BEGIN
		UPDATE Employee SET EmployeeName=@Employeename,PhoneNumber = @Phone,Email = @Email,[Address] = @Address
		WHERE EmployeeID = @id
	END



GO

-- ----------------------------
-- Procedure structure for [UpdateTransferByID]
-- ----------------------------
DROP PROCEDURE [UpdateTransferByID]
GO

-- ----------------------------
-- Procedure structure for [UpdateTransferByID]
-- ----------------------------
--Drop proc UpdateTransferByID
CREATE PROC [UpdateTransferByID]
@id int,
@RelDate datetime,
@RepNm nvarchar(50),
@stt nvarchar(10),
@fAllow float
AS
	BEGIN
 		UPDATE TransferRecord SET RelievingDate=@RelDate,ReportingManager=@RepNm,[Status] = @stt,Allowance= @fAllow WHERE TransferRecord.RecordID = @id
	END
GO
-- ----------------------------
-- Procedure structure for [drop proc getAllTransferByEmpID]
-- ----------------------------
CREATE PROC [getAllTransferByEmpID] 
@id int
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
									Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID INNER JOIN
										Location ON Location.LocationID=Department.LocationID
											WHERE Employee.EmployeeID=@id
	END	
GO
------------------------------------

-- ----------------------------
-- Procedure structure for [getLastTransferByEmpID]
-- ----------------------------
CREATE PROC [getLastTransferByEmpID]
@id int
AS
	BEGIN
		SELECT Top(1)     RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
							     Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID INNER JOIN
										Location ON Location.LocationID=Department.LocationID
										WHERE (Employee.EmployeeID=@id)AND(TransferRecord.[Status] like 'Approved') ORDER BY CreationDate DESC
	END	

GO
-- ----------------------------
-- Procedure structure for [getAllTransferByStatus]
-- ----------------------------
CREATE PROC [getAllTransferByStatus]
@stt nvarchar(50)
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
								Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID INNER JOIN
										Location ON Location.LocationID=Department.LocationID
										Where TransferRecord.Status like @stt 	
	END	


GO

CREATE PROC [getTransferNext]
@empid int
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
								Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID INNER JOIN
										Location ON Location.LocationID=Department.LocationID
										Where (TransferRecord.EmployeeID = @empid) AND  (TransferRecord.Status	like '%approved%')
												ORDER BY RecordID DESC
	END	
GO

CREATE PROCEDURE [dbo].[SearchByDepartmentName]
@name nvarchar(50)
AS
	BEGIN
		SELECT * FROM Department
		WHERE DepartmentName = @name
	END
Go

CREATE PROCEDURE [dbo].[SearchByDepartmentID]
@id int
AS
	BEGIN
		SELECT * FROM Department
		WHERE DepartmentID = @id
	END
Go
CREATE PROC [getTransferByTransferID]
@rid int
AS
	BEGIN
		SELECT      RecordID,Employee.EmployeeID,WorkItem.WorkItemID,RelievingDate,ReportingManager,Allowance,CreationDate,TransferReason,TransferRecord.Status,ProjectName,DepartmentName,EmployeeName,LocationAddress  From TransferRecord INNER JOIN 
			WorkItem ON  WorkItem.WorkItemID = TransferRecord.WorkItemID INNER JOIN
				  Project ON WorkItem.ProjectID = Project.ProjectID INNER JOIN
						   Department ON WorkItem.DepartmentID = Department.DepartmentID INNER JOIN
								Employee ON	 Employee.EmployeeID =  TransferRecord.EmployeeID INNER JOIN
										Location ON Location.LocationID=Department.LocationID
										Where (TransferRecord.RecordID = @rid)
											
	END	
GO

CREATE PROCEDURE [DelTransferByID]
@id INT
AS
BEGIN 
DELETE FROM TransferRecord WHERE RecordID = @id
END
Go

CREATE PROC [UpdateAfterDelete_Transfer]
@ID int
AS
	BEGIN
		UPDATE TransferRecord SET [Status] = 'denied' where RecordID = @id
	END
go


CREATE PROC [UpdateAfterDelete]
@projectID int
AS
	BEGIN
		UPDATE Project SET [Status] = 'disabled' where ProjectID = @projectID
	END
go

CREATE PROC [UpdateAfterDelete_Employee]
@empID int
AS
	BEGIN
		UPDATE Employee SET [Status] = 'disabled' where EmployeeID = @empID
	END
go

CREATE PROC [UpdateAfterDelete_Department]
@depID int
AS
	BEGIN
		UPDATE Department SET [Status] = 'disabled' where DepartmentID = @depID
	END
go

CREATE PROC [UpdateAfterDelete_Location]
@locationID int
AS
	BEGIN
		UPDATE Location SET [Status] = 'disabled' where LocationID = @locationID
	END
go

CREATE PROC [updateEWorkitem]
@empID int,
@Wkid int
AS
	BEGIN
		UPDATE Employee SET WorkItemID = @Wkid where EmployeeID = @empID
	END
go

CREATE PROCEDURE [dbo].[getAllAdmin]
AS
BEGIN
 SELECT * FROM SystemAdmin
END
GO

CREATE PROCEDURE [dbo].[delAAdmin]
@id int
AS
BEGIN
 DELETE FROM SystemAdmin WHERE SystemAdmin.AdminID = @id
END
GO

CREATE PROCEDURE [dbo].[updateAAdmin]
@id int,
@name nvarchar(50),
@user nvarchar(50)
AS
BEGIN
 UPDATE SystemAdmin SET SystemAdmin.Username = @user, SystemAdmin.AdminName = @name WHERE AdminID = @id
END
GO
CREATE PROCEDURE [dbo].[addAAdmin]
@name NVARCHAR(50),
@user NVARCHAR(50),
@pass NVARCHAR(32)
AS
BEGIN
 INSERT INTO SystemAdmin(Username, Password, AdminName) VALUES (@user,@pass,@name)
END
GO



