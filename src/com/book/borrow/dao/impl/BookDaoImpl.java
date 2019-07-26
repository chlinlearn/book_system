package com.book.borrow.dao.impl;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/12/9:39
 * @description: null
 */

import com.book.borrow.common.Handler;
import com.book.borrow.common.JDBCTemplate;
import com.book.borrow.common.PrepareSet;
import com.book.borrow.dao.IBookDao;
import com.book.borrow.pojo.Book;
import com.book.borrow.vo.BookDetailVO;
import com.book.borrow.common.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao{
    private Connection conn;
    private List<Book> books = new ArrayList<>();
    private Book book;
    private BookDetailVO bookDetailVO;
    private JDBCTemplate t;

    public BookDaoImpl() {
        this(null);
    }

    public BookDaoImpl(JDBCTemplate template){
        if (template==null){
            template = new JDBCTemplate();
        }
        this.t=template;
    }

    /**
     * 搜索图书信息
     * @param s 输入的字符串
     * @return
     */
    @Override
    public List<Book> findByName(String s) {
        books.clear();
        String sql = "select id,bookId,bookName,author," +
                "bookPublish,bookPrice,count " +
                "from book where bookName like ?";
        t.execute(sql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1,'%'+s+'%');
            }
        }, new Handler() {
            @Override
            public void handler(ResultSet rs) throws SQLException {
                while (rs.next()){
                    book = new Book(rs.getString(1),rs.getString(2),
                            rs.getString(3),rs.getString(4),
                            rs.getString(5),rs.getDouble(6),
                            rs.getInt(7));
                    books.add(book);
                }
            }
        });
        return books;
    }

    /**
     * 点击详情按钮，查询图书详情
     * @param id 图书表的id
     */
    @Override
    public BookDetailVO getDetailById(String id) {
        String sql = "select bookName,author,bookPublish," +
                "bookPrice,imgUrl,detail from book where id=?";
        t.execute(sql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1,id);
            }
        }, new Handler() {
            @Override
            public void handler(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    bookDetailVO = new BookDetailVO(rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getDouble(4),
                            rs.getString(5), rs.getString(6));
                }
            }
        });
        System.out.println("bookDetailVO:"+bookDetailVO);
        return bookDetailVO;
    }
}
