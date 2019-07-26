package com.book.borrow.pojo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/10/16:44
 * @description: null
 */

public class Book {
    private String id;//编号
    private String bookId;//图书ID
    private String bookName;//书名
    private String author;//作者
    private String bookPublish;//出版社
    private double bookPrice;//价格
    private int count;//库存
    private String imgUrl;
    private String detail;

    public Book(String id, String bookId, String bookName, String author, String bookPublish, double bookPrice, int count) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
