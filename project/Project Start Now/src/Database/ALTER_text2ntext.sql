ALTER TABLE Location
(
				LocationID				int			PRIMARY KEY			identity(1,1)	NOT NULL,
				LocationAddress			NTEXT							NOT NULL,
				LocationAllowance		money							NOT NULL,
				[Status]				nvarchar(10)		CHECK(Status IN('enabled', 'disabled'))		NOT NULL
)
go
ALTER TABLE Employee(
				EmployeeID			int			 PRIMARY KEY		identity(1,1)		NOT NULL,
				EmployeeName		nvarchar(50)					NOT NULL,
				Username			nvarchar(50)					NOT NULL,
				[Password]			nvarchar(32)					NOT NULL,
				RoleID				int								NOT NULL,
				WorkExperience		int								NOT NULL,
				WorkItemID			int								NOT NULL,
				JoiningDate			datetime						NOT NULL,
				PhoneNumber			nvarchar(15)					NOT NULL,
				Email				nvarchar(30)					NOT NULL,
				Gender				nvarchar(10)	CHECK(Gender IN ('Male', 'Female'))				NOT NULL,
				[Address]			NTEXT															NOT NULL,
				[Status]			nvarchar(10)		CHECK(Status IN('enabled', 'disabled'))	NOT NULL,
				FOREIGN KEY (RoleID) REFERENCES	Post(RoleID),
				FOREIGN KEY (WorkItemID) REFERENCES WorkItem(WorkItemID)
)
go
ALTER TABLE TransferRecord(
				RecordID				int			PRIMARY KEY			identity(1,1)		NOT NULL,
				EmployeeID				int								NOT NULL,
				WorkItemID				int								NOT NULL,
				RelievingDate			datetime,
				ReportingManager		nvarchar(50),
				Allowance				money							NOT NULL,
				CreationDate			datetime						NOT NULL,
				TransferReason			NTEXT							NOT NULL,
				[Status]				nvarchar(10)		CHECK(Status IN('pending', 'approved', 'denied'))		NOT NULL,
				FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
				FOREIGN KEY (WorkItemID) REFERENCES WorkItem(WorkItemID)
)


--==============================
ALTER PROCEDURE [E_RequestATransfer]

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
-- Procedure structure for [updateADepartment]
-- ----------------------------
ALTER PROCEDURE [updateADepartment]
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
ALTER PROCEDURE [updateALocation]
@id INT, @add NTEXT, @all MONEY, @stt NVARCHAR(10)
AS
	BEGIN
		UPDATE Location SET LocationAddress = @add, LocationAllowance = @all, Status = @stt WHERE LocationID = @id
		SELECT * FROM Location;
	END
	


GO
ALTER PROCEDURE [addALocation]
(@add NTEXT,
@all MONEY,
@stt NVARCHAR(10))
AS
BEGIN
  INSERT INTO Location(LocationAddress, LocationAllowance, Status) VALUES (@add, @all, @stt);
	SELECT * FROM Location;
END



GO
