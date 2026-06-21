DECLARE
    v_exists NUMBER := 0;
BEGIN
    SELECT COUNT(*)
    INTO v_exists
    FROM user_tab_cols
    WHERE table_name = 'CUSTOMERS' AND column_name = 'ISVIP';
    
    IF v_exists = 0 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP VARCHAR2(10) DEFAULT ''FALSE''';
    END IF;
END;
/

BEGIN
    FOR r_cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
