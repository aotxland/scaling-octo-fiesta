package test;

import org.junit.Test;
import utils.JDBCUtils;

/**
 * @author AoTxLand
 * @date 2020-06-11 23:29
 */
public class JDBCUtilsTest {
    @Test
    public void test1(){
        System.out.println(JDBCUtils.getConnection());
    }
}
