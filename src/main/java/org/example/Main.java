package org.example;

import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.notifications.CartNotification;
import org.example.notifications.SaleNotification;
import org.example.service.SaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        SaleNotification saleNotification = new SaleNotification();
        SaleService saleService = new SaleService();
        CartNotification cartNotification = new CartNotification();

        saleNotification.getSalePublishSubject().subscribe(sale -> {
            System.out.println(sale.getClientName() + " realizou uma compra");
        });

        cartNotification.getCartNotifications().observeOn(Schedulers.newThread()).subscribe(produto -> {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().sleep(7000);
            System.out.println("Novo produto inserido no carrinho" + produto);
        });

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite seu nome");
            String clientName = scanner.next();
            Integer saveProduct = 0;
            List<Integer> productsId = new ArrayList<>();
            while(saveProduct != 4){
                System.out.println("Digite o produto que deseja adicionar ou 4 para finalizar");
                System.out.println(" 1 - bala \n 2 - refrigerante \n 3 - chocolate \n 4 - finalizar");
                Integer escolha = scanner.nextInt();
                if(escolha != 4){
                    productsId.add(escolha);
                    cartNotification.send(escolha);
                }
                saveProduct = escolha;
            }
            saleService.saveSale(clientName, productsId, saleNotification);
        }
    }
}