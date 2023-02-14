package org.example.aulaExemplo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Exemplos {
    public static void main(String[] args) {

        Observable<String> observable = Observable.just("Oi eu sou um evento");

        observable.subscribe(evento -> System.out.println(evento));

        String[] clientes = {"Maria", "jose", "Paula"};
        Observable<String> observable2 = Observable.fromArray(clientes).map(String::toUpperCase);

        observable2.subscribe(
                evento -> System.out.println(evento), // OnNext
                Throwable::printStackTrace, //OnError
                () -> System.out.println("Sequencia de eventos completa") //OnCompleted
        );


        Observable<Integer> numero = Observable.range(1,5).filter(n -> n % 2 == 0);

        numero.subscribe(System.out::println);

        Observable<Object> observableNull = Observable.empty().defaultIfEmpty("ta vazio");

        observableNull.subscribe(System.out::println);

        Single<String> single = Single.just("oiii").map(String::toUpperCase);

        single.subscribe(System.out::println);

        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(event -> System.out.println("Observer 1 "+ event));

        subject.onNext("Evento 1");
        subject.onNext("Evento 2");

        subject.subscribe(event -> System.out.println("Observer 2 "+ event));

        subject.onNext("Evento 3");
        subject.onNext("Evento 4");

    }
}
