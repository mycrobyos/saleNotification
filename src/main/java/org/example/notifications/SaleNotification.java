package org.example.notifications;

import io.reactivex.rxjava3.subjects.PublishSubject;
import org.example.model.Sale;

public class SaleNotification {
    private final PublishSubject<Sale> salePublishSubject = PublishSubject.create();

    public void send(Sale sale){
        salePublishSubject.onNext(sale);
    }

    public  PublishSubject<Sale> getSalePublishSubject(){
        return salePublishSubject;
    }

}
