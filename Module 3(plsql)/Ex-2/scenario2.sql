CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
) IS
    emp_not_found EXCEPTION;
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE emp_not_found;
    END IF;
    
    COMMIT;
EXCEPTION
    WHEN emp_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/
