package com.wang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private String label="1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void useBook(){
        System.out.println("BookDao is use");
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
