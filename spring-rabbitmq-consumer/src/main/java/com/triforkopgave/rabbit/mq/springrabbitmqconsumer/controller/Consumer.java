package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.controller;

import com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    @RabbitListener(queues = "queue.A")
    private void receive(Message message) throws Exception {
        try {
            long timeStamp = System.currentTimeMillis() - message.getTime_ms();
            log.info("Message received from Queue queue.A->{}", timeStamp);
            // (timeStamp > 1000)   så ikke gøre noget da jeg læser direkte fra køen

           if(timeStamp <=1000 & timeStamp % 2==0 ){} // gem i db
            else{

                throw  new Exception(); // jeg kaster  fejl fordi jeg vil gerne have beskeden i køen igen
           }


                }catch(Exception e){
            log.info("timestamp of msg was an uneven number so msg needs to be requeue");


                }


    /*
    Producer app: Producere en besked med en timestamp i et gentage loop.
Consumer app:
Tag besked af køen. Hvis beskedens timestamp er over 1 minut gammel – så smid den væk. (ikke gem den i db)
Hvis timestamp er under 1 min gammelt og sekundviser på timestamp er et lige tal, så gem beskeden i en database (postgres, mongo, andet).
Hvis timestamp er under 1 min gammelt og sekundviser på timestamp er et ulige tal, så lig beskeden tilbage i køen med nyt timestamp
     */


            }


        }





