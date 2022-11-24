package org.example.web.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Book {
    private Integer id;
    @NotBlank
    @Size(min = 2)
    private String author;

    @NotBlank
    @Size(min = 2)
    private String title;

    @Digits(integer = 4, fraction = 0)
    private Integer size;

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isFilled() {
        //return !author.isEmpty()||!title.isEmpty()||size!=0;
        boolean pusto = true;
        if (!author.isEmpty()) {
            pusto = false;
        } else {
            author = "";
        }

        if (!title.isEmpty()) {
            pusto = false;
        } else {
            title = "";
        }
        if (size != null) {
            pusto = false;
        } else size = 0;

        return !pusto;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
