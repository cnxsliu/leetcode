package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 21:21
 * @strategy
 * >> distinct 是为了去重，防止出现 (1, 100), (2, 100) 这种记录
 * >> desc 倒序排列
 */
public class L176 {
/*
select
(select distinct Salary
from Employee order by Salary desc limit 1, 1)
as SecondHighestSalary;
 */
}
