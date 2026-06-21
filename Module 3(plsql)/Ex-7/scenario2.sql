CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_pos IN VARCHAR2, p_sal IN NUMBER, p_dept IN VARCHAR2, p_hiredate IN DATE);
    PROCEDURE UpdateEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_pos IN VARCHAR2, p_sal IN NUMBER);
    FUNCTION GetAnnualSalary(p_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_pos IN VARCHAR2, p_sal IN NUMBER, p_dept IN VARCHAR2, p_hiredate IN DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_pos, p_sal, p_dept, p_hiredate);
        COMMIT;
    END HireEmployee;
    
    PROCEDURE UpdateEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_pos IN VARCHAR2, p_sal IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, Position = p_pos, Salary = p_sal
        WHERE EmployeeID = p_id;
        COMMIT;
    END UpdateEmployee;
    
    FUNCTION GetAnnualSalary(p_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetAnnualSalary;
END EmployeeManagement;
/
