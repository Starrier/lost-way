package org.starrier.dreamwar.model.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Starrier
 * @Time 2018/6/8.
 */
@Accessors(chain = true)
@Data
@Table(name = "book")
@Entity
public class Book implements Serializable{

    private static final long serialVersionUID = 8604990093149376515L;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    @Column(name = "topic")
    private String topic;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "book_store_id")
    private Long bookStoreId;
}
