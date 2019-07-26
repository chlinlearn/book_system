package com.book.borrow.pojo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/2/9:38
 * @description: 借还表POJO类
 */
import java.util.Date;

public class BorrowBack {
    private String id;//编号
    private String readerId;//读者ID
    private String bookId;//图书ID
    private String bookName;//书名
    private String author;//作者
    private String bookPublish;//出版社
    private double bookPrice;//价格
    private Date borrowTime;//借书时间
    private Date backTime;//到期时间
    private int renew;//是否已续借,只能续借一次
    private int state;//是否归还,0表示未归还，1表示已归还

    public BorrowBack(String id, String readerId, String bookId,
                      String bookName, String author, String bookPublish,
                      double bookPrice, Date borrowTime,
                      Date backTime, int renew, int state) {
        this.id = id;
        this.readerId = readerId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookPublish = bookPublish;
        this.bookPrice = bookPrice;
        this.borrowTime = borrowTime;
        this.backTime = backTime;
        this.renew = renew;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public int getRenew() {
        return renew;
    }

    public void setRenew(int renew) {
        this.renew = renew;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
