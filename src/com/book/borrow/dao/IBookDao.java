package com.book.borrow.dao;
/* *
 *@author: xuchunlin
 *@createTime: 2019/7/15/18:57
 *@description: null
 */

import com.book.borrow.pojo.Book;
import com.book.borrow.vo.BookDetailVO;

import java.util.List;

public interface IBookDao {
    public List<Book> findByName(String s);

    public BookDetailVO getDetailById(String id);
}
