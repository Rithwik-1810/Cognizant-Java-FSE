DECLARE
    CURSOR c_due_loans IS
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r_loan.Name || ', your loan (ID: ' || r_loan.LoanID || ') is due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
