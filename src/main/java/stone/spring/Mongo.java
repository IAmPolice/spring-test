package stone.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import stone.spring.db.mongo.MongoConfig;
import stone.spring.db.mongo.UserRepository;
import stone.spring.db.mongo.collection.User;

public class Mongo {
//	@Autowired
//	static
//	UserRepository mongoRep;

	public static void main(String[] args) {
    	//ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    	
    	MongoOperations mongoOps = (MongoOperations) ctx.getBean("mongoTemplate");
    	mongoOps.save(new User("stone1", "123456"));
//    	User u = mongoOps.findOne(new Query(Criteria.where("username").is("stone2")), User.class, "users");
    	
    	//UserRepository mongoRep = (UserRepository) ctx.getBean("userRepository");
		UserRepository mongoRep = ctx.getBean(UserRepository.class);
    	//User u = (User) mongoRep.findByUsername("stone2");
		//User u = mongoRep.findOne(new Query(Criteria.where("username").is("stone2")), User.class, "users");
		User u = mongoRep.findOne("stone2");

    	System.out.println(u);
    	// 結論
    	// MongoRepository與MongoTemplate 差異在下query的指令不一樣
    	// MongoRepository比較簡潔
    	
	}

}
