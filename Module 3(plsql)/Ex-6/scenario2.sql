DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;
    v_fee CONSTANT NUMBER := 50;
BEGIN
    FOR r_acc IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF c_accounts;
    END LOOP;
    COMMIT;
END;
/
