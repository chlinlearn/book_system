package com.book.borrow.vo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/9/19:27
 * @description: null
 */

public class TotalDataVO {
    private String id;//编号
    private String bookId;//图书ID
    private String bookName;//书名
    private String author;//作者
    private String bookPublish;//出版社
    private double bookPrice;//价格
    private int count;//库存

    public TotalDataVO(){}

    public TotalDataVO(String id, String bookId, String bookName,
                       String author, String bookPublish, double bookPrice, int count) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookPublish = bookPublish;
        this.bookPrice = bookPrice;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "AllDataVO{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookPublish='" + bookPublish + '\'' +
                ", bookPrice=" + bookPrice +
                ", count=" + count +
                '}';
    }
}
