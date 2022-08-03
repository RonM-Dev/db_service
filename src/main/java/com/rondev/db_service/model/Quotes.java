package com.rondev.db_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Quotes {

    private String userName;
    private List<String> quotes;

}
