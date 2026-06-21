DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
    v_age NUMBER;
BEGIN
    FOR r_cust IN c_customers LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r_cust.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
