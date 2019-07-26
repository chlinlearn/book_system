package com.book.borrow.service;
/* *
 *@author: xuchunlin
 *@createTime: 2019/7/15/19:00
 *@description: null
 */

import com.book.borrow.pojo.Book;

import java.util.List;

public interface IBookService {
    public List<Book> search(String s);

    public void detailOpt(String id);
}
