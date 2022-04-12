package User.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import User.model.Users;

@Service
public interface UserService extends JpaRepository<Users, String>{

}
