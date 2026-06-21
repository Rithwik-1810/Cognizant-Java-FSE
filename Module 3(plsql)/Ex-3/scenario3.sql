CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;
    
    IF v_balance >= p_amount THEN
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;
        
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;
        
        COMMIT;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
    END IF;
END;
/
