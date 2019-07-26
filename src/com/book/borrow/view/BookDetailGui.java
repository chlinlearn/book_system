package com.book.borrow.view;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/11/20:24
 * @description: 图书详情GUI
 */

import com.book.borrow.vo.BookDetailVO;

import javax.swing.*;
import java.awt.*;

public class BookDetailGui extends JFrame {
    private Container contentPane;
    private JLabel imgLab,detailLab,dataLab;
    private BookDetailVO bookDetailVO;

    public BookDetailGui(BookDetailVO bookDetailVO){
        this.bookDetailVO = bookDetailVO;

        setTitle("图书详情");
        setSize(600,450);
        int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation((x-this.getWidth())/2,(y-this.getHeight())/2);
        //setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        setLayout(null);
        initGui();
        //pack();
    }

    public void initGui(){
        Font font = new Font("楷体",Font.BOLD,18);
        Color color = new Color(193,210,240);
        //图书图片
        ImageIcon icon = new ImageIcon(bookDetailVO.getImgUrl());
        icon.setImage(icon.getImage().getScaledInstance(260,320,Image.SCALE_DEFAULT));
        String dataStr = "<html>书名："+bookDetailVO.getBookName()
                +"<br>作者："+bookDetailVO.getAuthor()+"<br>出版社："
                +bookDetailVO.getBookPublish()+"<br>定价："
                +bookDetailVO.getBookPrice()+"元</html>";
        String detailStr = "<html>~图书详情~<br><br>"+bookDetailVO.getDetail()+"</html>";
        imgLab = new JLabel();
        detailLab = new JLabel(detailStr);
        dataLab = new JLabel(dataStr);
        imgLab.setIcon(icon);
        detailLab.setFont(font);
        dataLab.setFont(font);
        detailLab.setBackground(Color.pink);
        dataLab.setBackground(Color.pink);
        JPanel sPanel = new JPanel();
        JPanel nPanel = new JPanel();
        JPanel wPanel = new JPanel();
        wPanel.add(imgLab);
        nPanel.add(dataLab);
        sPanel.add(detailLab);

        wPanel.setBounds(10,40,250,320);
        nPanel.setBounds(280,40,280,120);
        sPanel.setBounds(280,170,280,190);
        contentPane.add(wPanel);
        contentPane.add(nPanel);
        contentPane.add(sPanel);
        contentPane.setBackground(color);

    }

    public void go(){
        setVisible(true);
    }

}
