package com.rondev.db_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "quote", catalog="stock")
public class Quote {

    @Id
    @Reference
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String quote;

    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }
}
