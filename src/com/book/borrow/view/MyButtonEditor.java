package com.book.borrow.view;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/10:25
 * @description: 继承表结构的默认编辑器
 */

import com.book.borrow.Main;
import com.book.borrow.service.IBookService;
import com.book.borrow.service.IBorrowBackService;
import com.book.borrow.service.impl.BookServiceImpl;
import com.book.borrow.service.impl.BorrowBackServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MyButtonEditor extends DefaultCellEditor{
    private MyButton button;
    private IBorrowBackService borrowBackService;
    private IBookService bookService;

    public MyButtonEditor(MyButton button) {
        super(new JTextField());
        //button = new MyButton("借阅");
        this.button = button;
        borrowBackService=new BorrowBackServiceImpl();
        bookService=new BookServiceImpl();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyButton button = (MyButton)e.getSource();
                //获取表id
                String id = button.getVal();
                System.out.println("id:"+id);
                if (button.getText().equals("借阅"))
                    //读取行数据并写入借阅表
                    borrowBackService.borrowOpt(id,Main.userVO.getUserId());
                if (button.getText().equals("还书"))
                    //读取行数据并更新借阅表
                    borrowBackService.backOpt(id);
                if (button.getText().equals("详情"))
                    //图书详情展示
                    bookService.detailOpt(id);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
        button.setRow(row);
        button.setCol(column);
        //获取表格中点击行的id,也可以是其他的数据
        button.setVal(table.getModel().getValueAt(row,0).toString());
        return button;
    }

}
