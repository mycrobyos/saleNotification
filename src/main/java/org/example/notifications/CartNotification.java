package org.example.notifications;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class CartNotification {
    private final PublishSubject<Integer> cartNotifications = PublishSubject.create();

    public void send(Integer productId){
        cartNotifications.onNext(productId);
    }

    public PublishSubject<Integer> getCartNotifications(){
        return cartNotifications;
    }
}
