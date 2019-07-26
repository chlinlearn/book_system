package com.book.borrow.service.impl;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/15/20:05
 * @description: null
 */

import com.book.borrow.dao.IBookDao;
import com.book.borrow.dao.IBorrowBackDao;
import com.book.borrow.dao.impl.BorrowBackDaoImpl;
import com.book.borrow.service.IBorrowBackService;
import com.book.borrow.view.BookDetailGui;

public class BorrowBackServiceImpl implements IBorrowBackService {
    private IBorrowBackDao borrowBackDao;

    public BorrowBackServiceImpl() {
        this(null);
    }

    public BorrowBackServiceImpl(IBorrowBackDao borrowBackDao) {
        if (borrowBackDao==null){
            borrowBackDao = new BorrowBackDaoImpl();
        }
        this.borrowBackDao = borrowBackDao;
    }

    /**
     * 读取行数据并写入借阅表
     * @param id
     */
    public void borrowOpt(String id,String user_id){
        borrowBackDao.insert(id,user_id);
    }

    /**
     * 读取行数据并更新借阅表
     * @param id
     */
    public void backOpt(String id){
        borrowBackDao.update(id);
    }

}
