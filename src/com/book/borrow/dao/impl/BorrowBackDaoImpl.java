package com.book.borrow.dao.impl;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/10/13:46
 * @description: 获取数据库中所有数据
 */

import com.book.borrow.Main;
import com.book.borrow.dao.IBorrowBackDao;
import com.book.borrow.pojo.BorrowBack;
import com.book.borrow.Main;
import com.book.borrow.pojo.BorrowBack;
import com.book.borrow.common.ConnectionFactory;
import com.book.borrow.common.Handler;
import com.book.borrow.common.JDBCTemplate;
import com.book.borrow.common.PrepareSet;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BorrowBackDaoImpl implements IBorrowBackDao {
    private List<BorrowBack> list = new ArrayList<>();
    private Connection conn;
    private BorrowBack borrowBack;
    private JDBCTemplate t;

    public BorrowBackDaoImpl() {
        this(null);
    }

    public BorrowBackDaoImpl(JDBCTemplate template) {
        if (template==null){
            template = new JDBCTemplate();
        }
        this.t = template;
    }

    /**
     * 获取该读者的所有借阅数据
     * @return
     */
    @Override
    public List<BorrowBack> getAll() {
        list.clear();
        String sql = "select bb.id,bb.user_userid,b.bookId,b.bookName,b.author," +
                "b.bookPublish,b.bookPrice,bb.borrowTime,bb.backTime," +
                "bb.renew,bb.state from borrowback bb,book b where bb.book_id=b.id and user_userid=?";
        t.execute(sql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1,Main.userVO.getUserId());
            }
        }, new Handler() {
            @Override
            public void handler(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    borrowBack = new BorrowBack(rs.getString(1),
                            rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getDouble(7),
                            rs.getDate(8), rs.getDate(9),
                            rs.getInt(10), rs.getInt(11));
                    list.add(borrowBack);
                }
            }
        });
        return list;
    }

    /**
     * 借书后将数据插入借阅表
     * @param id 图书表的id
     * @param reader_id 用户表的user_id
     */
    @Override
    public void insert(String id, String reader_id) {
        String selectSql = "select count from book where id=?";
        t.execute(selectSql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1, id);
            }
        }, new Handler() {
            @Override
            public void handler(ResultSet rs) throws SQLException {
                int count = 0;
                while (rs.next()){
                    count = rs.getInt(1);
                }
                if (count<=0){
                    System.out.println("图书库存不足");
                    JOptionPane.showMessageDialog(null,"图书库存不足，无法完成借阅！");
                    return;
                }
                final int c = count;
                //插入数据库
                String insertSql = "insert into borrowback values(sequence_borrowback_id.nextval,?,?,?,?,0,0)";
                t.execute(insertSql, new PrepareSet() {
                    @Override
                    public void setter(PreparedStatement pst) throws SQLException {
                        java.sql.Date b1 = null;
                        java.sql.Date b2 = null;
                        try {
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                            Calendar c = Calendar.getInstance();
                            //c.set(2011, 1, 1);
                            String borrowTime = df.format(c.getTime());//借书期限2个月
                            c.add(Calendar.MONTH, 2);
                            String backTime = df.format(c.getTime());
                            b1 = new java.sql.Date(df.parse(borrowTime).getTime());
                            b2 = new java.sql.Date(df.parse(backTime).getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        pst.setString(1, reader_id);
                        pst.setString(2, id);
                        pst.setDate(3, b1);
                        pst.setDate(4, b2);
                    }
                });
                //更新库存count的值
                String updateSql = "update book set count=? where id =?";
                t.execute(updateSql, new PrepareSet() {
                    @Override
                    public void setter(PreparedStatement pst) throws SQLException {
                        pst.setInt(1,c-1);
                        pst.setString(2,id);
                    }
                });
                JOptionPane.showMessageDialog(null,"借书成功！");
            }
        });

    }

    /**
     * 还书后更新借阅表的还书状态和图书表的库存
     * @param
     */
    @Override
    public void update(String id) {
        //通过当前借阅表的id查询到bookId
        String selectSql = "select book_id from borrowback where id=?";
        t.execute(selectSql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1, id);
            }
        }, new Handler() {
            @Override
            public void handler(ResultSet rs) throws SQLException {
                while (rs.next()){
                    //通过bookId查询到当前库存
                    String bookId = rs.getString(1);
                    String sql1 = "select count from book where id = ?";
                    t.execute(sql1, new PrepareSet() {
                        @Override
                        public void setter(PreparedStatement pst) throws SQLException {
                            pst.setString(1,bookId);
                        }
                    }, new Handler() {
                        @Override
                        public void handler(ResultSet rs) throws SQLException {
                            while (rs.next()){
                                //更改库存
                                int count = rs.getInt(1);
                                String sql2 = "update book set count=? where id=?";
                                t.execute(sql2, new PrepareSet() {
                                    @Override
                                    public void setter(PreparedStatement pst) throws SQLException {
                                        pst.setInt(1,count+1);
                                        pst.setString(2,bookId);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
        String sql = "update borrowback set state=1 where id = ?";
        t.execute(sql, new PrepareSet() {
            @Override
            public void setter(PreparedStatement pst) throws SQLException {
                pst.setString(1,id);
            }
        });
        JOptionPane.showMessageDialog(null,"还书成功！");
    }
}
