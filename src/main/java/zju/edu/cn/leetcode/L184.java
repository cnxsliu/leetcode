package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 22:55
 * @strategy
 */
public class L184 {
/*
select
Department.name as 'Department',
Employee.name as 'Employee',
Salary
from Employee join Department on Employee.DepartmentId = Department.Id
where
(Employee.DepartmentId, Salary)
in
(select DepartmentId, MAX(Salary) from Employee group by departmentId)
;
*/
}
