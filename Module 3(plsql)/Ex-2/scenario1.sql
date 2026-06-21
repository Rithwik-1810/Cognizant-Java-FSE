CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) IS
    v_from_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;
    
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;
    
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account_id);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transaction failed. ' || SQLERRM);
END;
/
