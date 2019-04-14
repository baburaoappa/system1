package publishersubscriber;


import javax.jms.*;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher
{
	private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException
	{
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connect= connectionFactory.createConnection();
		connect.start();
		
		Session session= connect.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic= session.createTopic("Distributed Systems");
		MessageProducer producer = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage("Subscriber is interested in DS");
		
		producer.send(message);
		
		connect.close();
		
		
	
		
	}
}

/*
Terminal :

ccoewlab1-pc84@ccoewlab1pc84-desktop:~$ cd /home/ccoewlab1-pc84/Downloads/publishsubscribe/apache-activemq-5.15.8-bin/apache-activemq-5.15.8/bin
ccoewlab1-pc84@ccoewlab1pc84-desktop:~/Downloads/publishsubscribe/apache-activemq-5.15.8-bin/apache-activemq-5.15.8/bin$ sudo sh activemq start
[sudo] password for ccoewlab1-pc84: 
INFO: Loading '/home/ccoewlab1-pc84/Downloads/publishsubscribe/apache-activemq-5.15.8-bin/apache-activemq-5.15.8//bin/env'
INFO: Using java '/usr/bin/java'
INFO: Starting - inspect logfiles specified in logging.properties and log4j.properties to get details
INFO: pidfile created : '/home/ccoewlab1-pc84/Downloads/publishsubscribe/apache-activemq-5.15.8-bin/apache-activemq-5.15.8//data/activemq.pid' (pid '4871')

Subscriber Eclipse Output :

INFO | Successfully connected to tcp://localhost:61616

Publisher Eclipse Output :

INFO | Successfully connected to tcp://localhost:61616
Sent message 'This is a new message from publisher'
*/
