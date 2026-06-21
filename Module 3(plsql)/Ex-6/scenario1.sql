DECLARE
    CURSOR c_monthly_statements IS
        SELECT c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType, a.AccountID
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
    FOR r_statement IN c_monthly_statements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_statement.Name || 
                             ' | Account: ' || r_statement.AccountID || 
                             ' | Txn ID: ' || r_statement.TransactionID || 
                             ' | Date: ' || TO_CHAR(r_statement.TransactionDate, 'YYYY-MM-DD') || 
                             ' | Type: ' || r_statement.TransactionType || 
                             ' | Amount: ' || r_statement.Amount);
    END LOOP;
END;
/
