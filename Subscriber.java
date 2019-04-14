package publishersubscriber;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber 
{
	private static String url= ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main (String[] args) throws JMSException
	{
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
		Connection connect = connectionFactory.createConnection();
		connect.start();
		
		Session session= connect.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("Distributed Systems");
		MessageConsumer consumer=session.createConsumer(topic);
		MessageListener listen = new MessageListener()
		{

			@Override
			public void onMessage(Message message)
			{
				try{
					if(message instanceof TextMessage )
					{
						TextMessage msg= (TextMessage) message;
						System.out.println("REcieved message " + msg);
					}
					
				}
				catch(Exception e)
				{
					
					System.out.println("Exception "+ e);
				}
				// TODO Auto-generated method stub
				
			}
			
		};
		
		consumer.setMessageListener(listen);
	
		connect.close();
	}
}