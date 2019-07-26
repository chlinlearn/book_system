package com.book.borrow.view;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/3/10:22
 * @description: 表格单元格渲染器,implements TableCellRender
 */

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyButtonRender implements TableCellRenderer {
    private MyButton button;

    public MyButtonRender(MyButton button){
        //button = new MyButton("借阅");
        this.button = button;
        //this.button.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        return button;
    }
}
