package com.book.borrow.service;
/* *
 *@author: xuchunlin
 *@createTime: 2019/7/15/20:04
 *@description: null
 */

public interface IBorrowBackService {
    public void borrowOpt(String id, String user_id);
    public void backOpt(String id);
}
