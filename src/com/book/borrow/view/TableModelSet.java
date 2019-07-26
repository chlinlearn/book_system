package com.book.borrow.view;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/10/10:40
 * @description: null
 */
import com.book.borrow.dao.IBookDao;
import com.book.borrow.dao.IBorrowBackDao;
import com.book.borrow.dao.impl.BookDaoImpl;
import com.book.borrow.dao.impl.BorrowBackDaoImpl;
import com.book.borrow.pojo.Book;
import com.book.borrow.pojo.BorrowBack;
import com.book.borrow.service.IBookService;
import com.book.borrow.service.IBorrowBackService;
import com.book.borrow.service.impl.BookServiceImpl;
import com.book.borrow.service.impl.BorrowBackServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.util.List;

public class TableModelSet {
    private DefaultTableModel totalModel = null;
    private DefaultTableModel searchModel = null;
    private DefaultTableModel borrowModel = null;
    private DefaultTableModel backModel = null;
    private String[] totalTitle = {"编号","读者ID","图书编码","书名","作者","出版社","定价","借书时间","到期时间","是否已续借","是否归还"};
    private String[] borrowTitle = {"编号","读者ID","图书编码","书名","作者","出版社","定价","借书时间","到期时间","是否已续借","是否归还","操作"};
    private String[] backTitle = {"编号","读者ID","图书编码","书名","作者","出版社","定价","借书时间","是否归还"};
    private String[] searchTitle = {"编号","图书编码","书名","作者","出版社","定价","库存","详情","操作"};
    private JTable totalTable;
    private JTable searchTable;
    private JTable borrowedTable;
    private JTable backedTable;
    private IBookService bookService;
    private IBorrowBackDao borrowBackDao;

    public TableModelSet(JTable totalTable, JTable searchTable,
                         JTable borrowedTable, JTable backedTable) {
        this.totalTable = totalTable;
        this.searchTable = searchTable;
        this.borrowedTable = borrowedTable;
        this.backedTable = backedTable;
        bookService = new BookServiceImpl();
        borrowBackDao = new BorrowBackDaoImpl();

        //构建TableSet对象时创建表格数据模型
        totalModel = new DefaultTableModel(totalTitle,0);
        totalTable.setModel(totalModel);

        searchModel = new DefaultTableModel(searchTitle,0);
        searchTable.setModel(searchModel);

        borrowModel = new DefaultTableModel(borrowTitle,0);
        borrowedTable.setModel(borrowModel);

        backModel = new DefaultTableModel(backTitle,0);
        backedTable.setModel(backModel);
    }

    //为表格设置数据模型
    public void setTotalTable(){
        setTableModel(totalTable,totalModel,null);
    }

    public void setSearchTable(String s){
        setTableModel(searchTable,searchModel,s);
    }

    public void setBorrowedTable(){
        setTableModel(borrowedTable,borrowModel,null);
    }

    public void setBackedTable(){
        setTableModel(backedTable,backModel,null);
    }

    public void setTableModel(JTable table,DefaultTableModel model,String s){
        if (table != searchTable) {
            //获取borroeback表中的所有数据
            List list = borrowBackDao.getAll();
            if (table==totalTable) {
                model.setRowCount(0);//每次调用此方法前，先清空原来的数据
                for (int i = 0; i < list.size(); i++) {
                    BorrowBack data = (BorrowBack) list.get(i);
                    String state = "";
                    if (data.getState()==0){
                        state = "否";
                    }else {
                        state = "是";
                    }
                    Object[] rowData = {data.getId(),data.getReaderId(), data.getBookId(),
                            data.getBookName(), data.getAuthor(),
                            data.getBookPublish(),data.getBookPrice(),
                            data.getBorrowTime(), data.getBackTime(),
                            data.getRenew(),state};
                    model.addRow(rowData);
                    table.setModel(model);
                }
            }else if(table==borrowedTable){
                model.setRowCount(0);//每次调用此方法前，先清空原来的数据
                for (int i = 0; i < list.size(); i++) {
                    BorrowBack data = (BorrowBack) list.get(i);
                    if(data.getState()==0){
                        Object[] rowData = {data.getId(),data.getReaderId(), data.getBookId(),
                                data.getBookName(), data.getAuthor(),
                                data.getBookPublish(),data.getBookPrice(),
                                data.getBorrowTime(), data.getBackTime(),
                                data.getRenew(),"否"};
                        model.addRow(rowData);
                        table.setModel(model);
                    }
                }
            }else {
                //table==backedTable
                model.setRowCount(0);//每次调用此方法前，先清空原来的数据
                for (int i = 0; i < list.size(); i++) {
                    BorrowBack data = (BorrowBack) list.get(i);
                    if(data.getState()==1){
                        Object[] rowData = {data.getId(),data.getReaderId(), data.getBookId(),
                                data.getBookName(), data.getAuthor(),
                                data.getBookPublish(),data.getBookPrice(),
                                data.getBorrowTime(), "是"};
                        model.addRow(rowData);
                        table.setModel(model);
                    }
                }
            }
        }else {
            //table==searchTable
            model.setRowCount(0);//每次调用此方法前，先清空原来的数据
            //判读输入是否为空
            if (s.equals("")){
                JOptionPane.showMessageDialog(null,"请先输入要检索的书名");
                return;
            }
            List<Book> list = bookService.search(s);
            for(Object data:list){
                Book book = (Book)data;
                Object[] rowData = {book.getId(),book.getBookId(),
                        book.getBookName(),book.getAuthor(),
                        book.getBookPublish(),book.getBookPrice(),
                        book.getCount()};
                model.addRow(rowData);
                table.setModel(model);
            }
        }
    }

    /**
     * 设置列表某几列的宽度
     * @param table
     * @param i
     * @param preferedWidth
     * @param maxWidth
     * @param minWidth
     */
    public void setSomeColumnSize(JTable table, int[] i, int preferedWidth, int maxWidth, int minWidth){
        TableColumnModel cm = table.getColumnModel();
        if(i.length == 0){
            return;
        }
        for(int j = 0; j < i.length; j++){
            TableColumn column = cm.getColumn(i[j]);
            column.setPreferredWidth(preferedWidth);
            column.setMaxWidth(maxWidth);
            column.setMinWidth(minWidth);
        }
    }
}
