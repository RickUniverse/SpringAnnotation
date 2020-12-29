package com.springannotation.dao;

import com.springannotation.entities.Color;
import org.springframework.stereotype.Repository;

/**
 * @author lijichen
 * @date 2020/11/27 - 15:42
 */
@Repository
public class BookDao {
    private Color color;

    public BookDao(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "color=" + color +
                ", label=" + label +
                '}';
    }

    private int label = 1;

    public BookDao() {
    }

    public BookDao(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
