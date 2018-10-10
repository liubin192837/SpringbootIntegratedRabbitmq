package com.mqSpring.mq;

import com.mqSpring.mq.send.Sender;
import com.mqSpring.mq.send.SenderFanout;
import com.mqSpring.mq.send.SenderTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

	@Autowired
	Sender sender;
	@Autowired
	SenderTopic senderTopic;
	@Autowired
	SenderFanout senderFanout;
	@Test
	public void contextLoads() {
		//hello
		sender.send();
		//topic
		senderTopic.sendOne();
		senderTopic.sendTwo();
		senderTopic.sendThree();
		//fanout
		senderFanout.sendFanout();
	}

}
