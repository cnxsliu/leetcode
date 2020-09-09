package zju.edu.cn.leetcode;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/25 21:44
 * @strategy SQL子查询
 * >> Rank 是关键字，需要添加 ''
 */
public class L178 {
/*
select a.Score as Score,
(select count(distinct b.Score) from Scores b where b.Score >= a.Score) as 'Rank'
from Scores a
order by a.Score DESC
 */
}
