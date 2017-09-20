package impl;

import com.dao.BaseDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/8/23 13:27
 * @description: xxx
 * own: Aratek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class BaseDaoImplTest {

    @Resource
    private BaseDao baseDao;

    @Test
    public void testCount() throws Exception {
        //若为条件查询，构造查询数据
        Map<String, Object> paramMap = new HashMap<>();
        //获取在库的指纹数
        StringBuffer hql = new StringBuffer(" SELECT COUNT(1) FROM Code");
        Assert.assertEquals(0,baseDao.count(hql.toString(),paramMap));
    }
}