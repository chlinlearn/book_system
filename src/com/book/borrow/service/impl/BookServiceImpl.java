package com.book.borrow.service.impl;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/15/19:03
 * @description: null
 */

import com.book.borrow.dao.IBookDao;
import com.book.borrow.dao.impl.BookDaoImpl;
import com.book.borrow.pojo.Book;
import com.book.borrow.service.IBookService;
import com.book.borrow.view.BookDetailGui;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private IBookDao bookDao;

    public BookServiceImpl() {
        this(null);
    }

    public BookServiceImpl(IBookDao bookDao) {
        if (bookDao==null){
            bookDao = new BookDaoImpl();
        }
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> search(String s) {
       return bookDao.findByName(s);
    }

    /**
     * 图书详情展示
     * @param id
     */
    public void detailOpt(String id){
        new BookDetailGui(bookDao.getDetailById(id)).go();
    }
}
