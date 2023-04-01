package dev.demo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ContohConsumer {

   public static void main(String[] args) {
      Properties props = new Properties();
      props.setProperty("bootstrap.servers", "localhost:9092");
      props.setProperty("group.id", "test");
      props.setProperty("enable.auto.commit", "true");
      props.setProperty("auto.commit.intervalms", "1000");
      props.setProperty("key.deserializer", StringDeserializer.class.getName());
      props.setProperty("value.deserializer", StringDeserializer.class.getName());

      try (KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props)) {
         consumer.subscribe(Arrays.asList("hello"));

         while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
               System.out.println("Receive data : " + record.value());
            }
         }
      }
   }

}
