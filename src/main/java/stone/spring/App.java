package stone.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import stone.spring.db.mongo.MongoConfig;
import stone.spring.db.mongo.collection.User;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    	mongoOperation.save(new User("stone2", "123456"));
    	
    }
}
