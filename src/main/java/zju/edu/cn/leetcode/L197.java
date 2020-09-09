package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/27 16:33
 * @strategy SQl关联查询
 * >> 使用 join on 和 直接用 where 都可以，join on 的效率稍微高一些
 */
public class L197 {
/*
select w1.Id as 'Id'
from Weather w1 join Weather w2
on
DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
and
w1.Temperature > w2.Temperature;

select w1.Id as 'Id'
from Weather w1, Weather w2
where
DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
and
w1.Temperature > w2.Temperature;
*/
}
