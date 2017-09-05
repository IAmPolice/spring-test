package stone.spring.db.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import stone.spring.db.mongo.collection.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{username: ?0}")
	User findByUsername(String username);
//	@Query("{username: ?0}")
//	List<User> findByUsername(String username);
}
