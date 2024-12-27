package finasit.dao.users;

import finasit.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

interface UsersRepository extends JpaRepository<Users,Integer> {

}
