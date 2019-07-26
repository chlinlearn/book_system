package com.book.borrow;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/10/9:23
 * @description: 程序入口，启动类(启动前先在jdbc包下的JDBC.java中配置数据库信息，
 *              并把数据库文件导入数据库)
 */

import com.book.borrow.view.BorrowBackGui;
import com.book.borrow.vo.UserVO;

public class Main{
    //伪代码，应该由主界面传入
    public static UserVO userVO = new UserVO("2016211001","张三",
            "男",20,0);

    public static void main(String[] args) {
        BorrowBackGui b = new BorrowBackGui(userVO);
        b.go();
    }
}
