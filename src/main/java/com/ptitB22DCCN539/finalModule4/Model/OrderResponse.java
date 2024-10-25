package com.ptitB22DCCN539.finalModule4.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String productName;
    private Double unitPrice;
    private Long quantity;
    private String categoryName;
    private Double totalPrice;
    private Date dateCreated;
}
