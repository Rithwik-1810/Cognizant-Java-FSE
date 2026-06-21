DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
BEGIN
    FOR r_loan IN c_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF c_loans;
    END LOOP;
    COMMIT;
END;
/
