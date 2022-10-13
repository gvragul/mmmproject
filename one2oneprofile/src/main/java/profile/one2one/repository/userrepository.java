package profile.one2one.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import profile.one2one.model.User;
 
@Repository
public interface userrepository extends JpaRepository<User, Integer>{
 
}
// new-interface