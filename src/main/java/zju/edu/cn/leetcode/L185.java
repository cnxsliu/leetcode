package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/26 15:26
 * @strategy SQL关联查询 + 子查询 + join
 * >> join on where xxx = xxx，联合两个表一起查询
 */
public class L185 {
/*
select d.Name as 'Department', e1.Name as 'Employee', e1.Salary
from
Employee e1 join Department d on e1.DepartmentId = d.Id
where
3 > (
select count(distinct e2.Salary) from Employee e2
where e2.Salary > e1.Salary and e1.DepartmentId = e2.DepartmentId
)
;
*/
}
