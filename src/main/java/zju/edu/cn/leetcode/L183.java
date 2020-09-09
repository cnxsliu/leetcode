package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 22:52
 * @strategy SQL子查询 + not in
 */
public class L183 {
/*
select a.Name as Customers
from Customers a
where
a.Id not in
(select b.CustomerId from Orders b)
;
*/
}
