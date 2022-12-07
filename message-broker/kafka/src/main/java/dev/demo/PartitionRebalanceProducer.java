package dev.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class PartitionRebalanceProducer {

   public static void main(String[] args) {
      Properties props = new Properties();
      props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
      props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

      KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
      for (int i = 0; i < 10; i++) {
         ProducerRecord<String, String> records = new ProducerRecord<String, String>("topic-java", "topic-java " + i);
         producer.send(records);
      }

      producer.close();
   }

}
