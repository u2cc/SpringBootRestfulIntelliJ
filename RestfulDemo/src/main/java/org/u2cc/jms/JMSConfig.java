package org.u2cc.jms;

import com.solacesystems.jcsmp.XMLContentMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.naming.NamingException;

import com.solacesystems.jcsmp.TextMessage;


@Configuration
@EnableJms
@ImportResource("classpath:beans.xml")
public class JMSConfig {
    @Autowired
    JndiTemplate solaceJndiTemplate;

    @Value("${solace.jndiName}")
    String jndiName;

    @Value("${solace.destination}")
    String destination;

    private static final Logger LOGGER = LoggerFactory.getLogger(JMSConfig.class);

    @JmsListener(destination = "${solace.destination}",containerFactory = "jmsContainerFactory")
    public void handle(Message message){
        System.out.println("incoming message");
        if (message instanceof TextMessage){
            System.out.printf("TextMessage received: '%s'%n", ((TextMessage) message).getText());
        } else if (message instanceof XMLContentMessage) {
            System.out.println("Message received.");
            ((XMLContentMessage) message).getXMLContent();
        }
        System.out.println("Msg Type: "+message.getClass().toString());
        System.out.printf("Message Dump:%n%s%n",message.toString());
    }


    @Bean
    public DefaultJmsListenerContainerFactory jmsContainerFactory() throws IllegalArgumentException, NamingException {
        LOGGER.info("DefaultJmsListenerContainerFactory");
        LOGGER.info("jndiName injected with value: "+jndiName);
        LOGGER.info("destination injected with value "+destination);

        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setPubSubDomain(true);
        containerFactory.setConnectionFactory(connectionFactory());

        return containerFactory;

    }

    @Bean
    public ConnectionFactory connectionFactory() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean jndiFactory = new JndiObjectFactoryBean();
        jndiFactory.setJndiTemplate(solaceJndiTemplate);
        jndiFactory.setJndiName(jndiName);
        jndiFactory.setResourceRef(true);

        jndiFactory.setLookupOnStartup(true);
        jndiFactory.afterPropertiesSet();
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiFactory.getObject();
        return connectionFactory;
    }

}
