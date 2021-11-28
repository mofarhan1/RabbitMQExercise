package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.A")
    private void receive(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)  throws IOException { {
        try {
            MessageController msgController = new MessageController();
            long timeStamp = System.currentTimeMillis() - message.getTime_ms();
            log.info("Message received from Queue queue.A->{}", message );
            // if (timeStamp > 1000)   then we do nothing

           if(timeStamp <=1000 & timeStamp % 2==0 ){ msgController.saveMessage(message);} // gem i mongodb
            if(timeStamp <=1000 & (timeStamp %2)!=0  ){

                log.info("timestamp of msg was an less than 1 minute and uneven  so msg needs to be requeue");

                message.setTime_ms(System.currentTimeMillis());   // set new timeStamp

                GetResponse gr = channel.basicGet("queue.A", false);

                channel.basicNack(gr.getEnvelope().getDeliveryTag(), false, true);

            }

                }catch(Exception e){

            log.info(e.toString());

        }


                }


    /* opgaven:
    Producer app: Producere en besked med en timestamp i et gentage loop.
Consumer app:
Tag besked af køen. Hvis beskedens timestamp er over 1 minut gammel – så smid den væk. (ikke gem den i db)
Hvis timestamp er under 1 min gammelt og sekundviser på timestamp er et lige tal, så gem beskeden i en database (postgres, mongo, andet).
Hvis timestamp er under 1 min gammelt og sekundviser på timestamp er et ulige tal, så lig beskeden tilbage i køen med nyt timestamp
     */


            }


        }





