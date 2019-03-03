package sandbox;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class SerialisationDemo {


    public static void main(String[] args) throws IOException {
        Message message = new Message("hello");

        Person person = new Person("John", "Smith", 30 );
        Purchase laptop = new Purchase("laptop", 5234.99);
        person.addPurchase(laptop);
        person.addInteger(1);
        person.addInteger(2);
        person.addInteger(4);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String serialized = mapper.writeValueAsString(message);


        String personserialized = mapper.writeValueAsString(person);
       // System.out.println(personserialized);

        Message dersrialized = mapper.readValue(serialized, Message.class);

        System.out.println(dersrialized.getTimestamp());
        System.out.println(dersrialized.getContent());
    }
}
