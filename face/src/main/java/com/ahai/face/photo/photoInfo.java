package com.ahai.face.photo;

import lombok.Data;

import java.io.Serializable;

@Data
public class photoInfo implements Serializable {
    private Integer id;
    private String name;
    private static final long serialVersionUID = 1L;
}
