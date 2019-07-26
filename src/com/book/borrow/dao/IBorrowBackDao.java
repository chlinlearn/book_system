package com.book.borrow.dao;
/* *
 *@author: xuchunlin
 *@createTime: 2019/7/15/19:24
 *@description: null
 */

import com.book.borrow.pojo.BorrowBack;

import java.util.List;

public interface IBorrowBackDao {
    public List<BorrowBack> getAll();

    public void insert(String id, String reader_id);

    public void update(String id);

}
