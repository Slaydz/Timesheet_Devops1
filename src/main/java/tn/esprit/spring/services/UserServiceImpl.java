package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	

	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			
			L.info("In method retieveAllUsers :");
	
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				L.debug("connexion à la BD OK : ");
			} 
			L.info("Out of Method retrieveAllUSers with succes");
		}catch (Exception e) {
			L.error("Out of Methode retrieveAllUsers with errors : " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		L.info("In method addUser :");
		User u_saved = userRepository.save(u); 
		L.info("Out method addUser :");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		L.info("In method addUser :");
		User u_saved = userRepository.save(u); 
		L.info("Out method updateUser :");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		L.info("In method addUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		L.info("Out method deleteUser :");
	}

	@Override
	public User retrieveUser(String id) {
		L.info("In method addUser :");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out method retrieveUser :");
		return u; 
	}

}
