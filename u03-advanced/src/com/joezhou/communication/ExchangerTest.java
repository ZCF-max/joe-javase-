package com.joezhou.communication;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Exchanger;

/**
 * @author JoeZhou
 */
public class ExchangerTest {
    private Exchanger<String> stringExchanger = new Exchanger<>();

    @Test
    public void exchange() throws IOException {

        new Thread(() -> {
            try {
                String exchangedValue = stringExchanger.exchange("10 yuan");
                System.out.println("Buyer got " + exchangedValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String exchangedValue = stringExchanger.exchange("bread");
                System.out.println("Seller got " + exchangedValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(System.in.read());
    }

}