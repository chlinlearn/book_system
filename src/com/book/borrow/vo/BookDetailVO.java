package com.book.borrow.vo;

/* *
 * @author: xuchunlin
 * @createTime: 2019/7/11/20:49
 * @description: null
 */

public class BookDetailVO {
    private String bookName;//书名
    private String author;//作者
    private String bookPublish;//出版社
    private double bookPrice;//价格
    private String imgUrl;
    private String detail;

    public BookDetailVO(String bookName, String author, String bookPublish, double bookPrice, String imgUrl, String detail) {
        this.bookName = bookName;
        this.author = author;
        this.bookPublish = bookPublish;
        this.bookPrice = bookPrice;
        this.imgUrl = imgUrl;
        this.detail = detail;
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
