package com.chen.bean;

public class Book {

    private String bookName;
    private String author;

    public void myInit(){
        System.out.println("图书初始化方法");
    }

    public void myDestroy(){
        System.out.println("图书销毁方法");
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

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
