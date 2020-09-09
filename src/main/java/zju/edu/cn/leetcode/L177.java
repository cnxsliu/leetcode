package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 21:30
 * @strategy SQL函数
 */
public class L177 {
/*
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE P1 INT;
	DECLARE P2 INT;
	IF (N<1)
		THEN SET P1 = 0, P2 = 0;
	ELSE SET P1 = N-1, P2 = 1;
	END IF;
	RETURN (
		SELECT IFNULL(
			(
				SELECT DISTINCT Salary
				FROM Employee
				ORDER BY Salary DESC
				LIMIT P1, P2
			), NULL
		) AS SecondHighestSalary
	);
END
 */
}
