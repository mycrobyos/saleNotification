package org.example.service;

import org.example.bd.Database;
import org.example.model.Sale;
import org.example.notifications.SaleNotification;

import java.util.List;

public class SaleService {
    Database database = new Database();

    public void saveSale(String clientName, List<Integer> productsId, SaleNotification saleNotification){
        Sale sale = new Sale(clientName, productsId);
        database.setSales(sale);
        saleNotification.send(sale);
    }
}
