package com.triforkopgave.rabbit.mq.springrabbitmqproducer.configuaration;

import com.rabbitmq.client.Channel;
import com.triforkopgave.rabbit.mq.springrabbitmqproducer.model.Message;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;

@Configuration
public class RabbitMQConfig {

    static final String directExchange = "exchange.direct";

    static final String queueName = "queue.A";
    static final String ROUTING_A = "routing.A";

    @Bean
    Queue queueA() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    Binding binding(Queue queueA, DirectExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with(ROUTING_A);
    }


    @Bean
    MessageConverter messageConverter(){

        return new Jackson2JsonMessageConverter();
    }


    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate  = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return  rabbitTemplate;

    }

    @RabbitListener(queues = queueName)
    public void receiveMessage(Message msg, Channel channel,
                               @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {

    }


}