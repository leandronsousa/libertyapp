package br.com.libertyapp.config;


 import javax.jms.ConnectionFactory;

 import org.springframework.boot.jta.atomikos.AtomikosXAConnectionFactoryWrapper;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.jms.annotation.EnableJms;
 import org.springframework.jms.core.JmsTemplate;

 import com.ibm.mq.jms.MQXAQueueConnectionFactory;
 import com.ibm.msg.client.wmq.WMQConstants;

 @Configuration
 @EnableJms
 public class MQConfiguration {

 	@Bean
     public JmsTemplate jsmTemplate() {
     	JmsTemplate jmsTemplate = new JmsTemplate();
     	jmsTemplate.setSessionTransacted(true);
     	jmsTemplate.setConnectionFactory(xaConnectionFactory());
     	jmsTemplate.setSessionAcknowledgeMode(0);
     	return jmsTemplate;
     }

 	@Bean(initMethod = "init")
 	public ConnectionFactory xaConnectionFactory() {
 		ConnectionFactory factory = null;
 		factory = new AtomikosXAConnectionFactoryWrapper().wrapConnectionFactory(mqXAQueueConnectionFactory());
 		return factory;
 	}

 	private MQXAQueueConnectionFactory mqXAQueueConnectionFactory() {
 		MQXAQueueConnectionFactory factory = new MQXAQueueConnectionFactory();
 		try {
            factory.setHostName("localhost");
 			factory.setPort(1414);
 			factory.setQueueManager("QM1");
 			factory.setChannel("DEV.APP.SVRCONN");

 			factory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return factory;
 	}




}
