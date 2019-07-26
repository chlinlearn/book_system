package com.book.borrow.view;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/2/10:16
 * @description: 借阅模块GUI实现
 */

import com.book.borrow.vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorrowBackGui extends JFrame implements ActionListener {
    private Container contentPane;
    private JButton totalBtn,borrowedBtn,backedBtn,searchBtn,indexBtn;
    private JLabel userIdLab,usernameLab,genderLab,ageLab,noReturnLab;
    private JTextField inputText;
    private CardLayout card;
    private JPanel showPanel;
    private JTable totalTable = null;
    private JTable searchTable = null;
    private JTable borrowedTable = null;
    private JTable backedTable = null;
    private TableModelSet tableSet = null;

    private UserVO userVO;

    public BorrowBackGui(UserVO userVO){
        //传入当前登录用户的id,borrowback关联的外键
        this.userVO=userVO;

        setTitle("借阅管理");
        setSize(1000,750);
        int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation((x-this.getWidth())/2,(y-this.getHeight())/2);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        setLayout(null);
        initGui();
        //pack();
    }

    public void initGui(){
        Font font = new Font("楷体",Font.BOLD,20);
        Color color = new Color(193,210,240);
        //用户信息
        userIdLab = new JLabel("用户ID：");
        userIdLab.setFont(font);
        usernameLab = new JLabel("姓名：");
        usernameLab.setFont(font);
        genderLab = new JLabel("性别：");
        genderLab.setFont(font);
        ageLab = new JLabel("年龄：");
        ageLab.setFont(font);
        noReturnLab = new JLabel("未归还：");
        noReturnLab.setFont(font);

        //按钮区,搜索区
        indexBtn = new JButton("返回首页");
        indexBtn.setFont(font);
        indexBtn.setBackground(Color.LIGHT_GRAY);
        indexBtn.addActionListener(this);
        totalBtn = new JButton("借阅记录");
        totalBtn.setFont(font);
        totalBtn.addActionListener(this);
        totalBtn.setBackground(Color.LIGHT_GRAY);
        borrowedBtn = new JButton("未归还");
        borrowedBtn.setFont(font);
        borrowedBtn.setBackground(Color.LIGHT_GRAY);
        borrowedBtn.addActionListener(this);
        backedBtn = new JButton("已归还");
        backedBtn.setFont(font);
        backedBtn.setBackground(Color.LIGHT_GRAY);
        backedBtn.addActionListener(this);
        searchBtn = new JButton("搜索");
        searchBtn.setFont(font);
        searchBtn.setBackground(Color.LIGHT_GRAY);
        searchBtn.addActionListener(this);
        inputText = new JTextField("请输入要查询的书名或编号");
        inputText.setColumns(20);
        inputText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1){
                    inputText.setText("");
                }
            }
        });

        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setBounds(0,0,1000,160);
        JPanel nPanel = new JPanel(new GridLayout(2,3,1,15));
        JPanel sPanel = new JPanel(new GridLayout(2,3,20,15));
        nPanel.add(userIdLab);
        nPanel.add(usernameLab);
        nPanel.add(genderLab);
        nPanel.add(ageLab);
        nPanel.add(noReturnLab);
        nPanel.setBackground(color);

        sPanel.add(indexBtn);
        sPanel.add(inputText);
        sPanel.add(searchBtn);
        sPanel.add(totalBtn);
        sPanel.add(borrowedBtn);
        sPanel.add(backedBtn);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,nPanel,sPanel);
        //splitPane.setDividerLocation(10);
        userPanel.add(splitPane,BorderLayout.NORTH);

        MyButton buttonDetail = new MyButton("详情");
        buttonDetail.setBackground(color);
        MyButton buttonBorrow = new MyButton("借阅");
        buttonBorrow.setBackground(color);
        MyButton buttonBack = new MyButton("还书");
        buttonBack.setBackground(color);

        totalTable = new JTable();
        totalTable.setRowHeight(36);
        //totalTable.setEnabled(false);
        searchTable = new JTable();
        searchTable.setRowHeight(36);
        //searchTable.setEnabled(false);
        borrowedTable = new JTable();
        borrowedTable.setRowHeight(36);
        //borrowedTable.setEnabled(false);
        backedTable = new JTable();
        backedTable.setRowHeight(36);
        //backedTable.setEnabled(false);
        //构建表格数据模型
        tableSet = new TableModelSet(totalTable,searchTable,borrowedTable,backedTable);

        //设置表格的渲染器
        searchTable.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRender(buttonDetail));
        //设置表格的编辑器
        searchTable.getColumnModel().getColumn(7).setCellEditor(new MyButtonEditor(buttonDetail));
        searchTable.getColumnModel().getColumn(8).setCellRenderer(new MyButtonRender(buttonBorrow));
        searchTable.getColumnModel().getColumn(8).setCellEditor(new MyButtonEditor(buttonBorrow));
        //禁止掉JTable的行选中功能。否则我们再点击按钮时，JTable不知道是响应为'行选中'还是'按钮单击事件'。
        searchTable.setRowSelectionAllowed(false);

        borrowedTable.getColumnModel().getColumn(11).setCellRenderer(new MyButtonRender(buttonBack));
        borrowedTable.getColumnModel().getColumn(11).setCellEditor(new MyButtonEditor(buttonBack));
        borrowedTable.setRowSelectionAllowed(false);

        card = new CardLayout();
        showPanel = new JPanel(card);
        showPanel.setBounds(10,200,980,500);
        showPanel.add("totalBtn",new JScrollPane(totalTable));
        showPanel.add("searchBtn",new JScrollPane(searchTable));
        showPanel.add("borrowedBtn",new JScrollPane(borrowedTable));
        showPanel.add("backedBtn",new JScrollPane(backedTable));

        //添加用户信息,伪数据
        userIdLab.setText(userIdLab.getText()+userVO.getUserId());
        usernameLab.setText(usernameLab.getText()+userVO.getName());
        genderLab.setText(genderLab.getText()+userVO.getGender());
        ageLab.setText(ageLab.getText()+userVO.getAge());
        noReturnLab.setText(noReturnLab.getText()+userVO.getNoReturnCount());

        //添加到大桌布
        contentPane.add(userPanel);
        //contentPane.add(runPanel);
        contentPane.add(showPanel);
    }

    public void go(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==totalBtn){
            tableSet.setTotalTable();
            card.show(showPanel,"totalBtn");
        }
        if (source==searchBtn){
            tableSet.setSearchTable(inputText.getText());
            card.show(showPanel, "searchBtn");
        }
        if (source==borrowedBtn){
            tableSet.setBorrowedTable();
            card.show(showPanel,"borrowedBtn");
        }
        if (source==backedBtn){
            tableSet.setBackedTable();
            card.show(showPanel,"backedBtn");
        }
        if (source==indexBtn){
            System.out.println("返回首页");
            JOptionPane.showConfirmDialog(this,"返回首页");
        }
    }
}
