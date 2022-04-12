package User.resource;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import User.model.Users;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ArrayList<Users> getUserInfo(){
		ArrayList<Users> userList = (ArrayList<Users>) userService.findAll();
		return userList;
	}
	
//	@PostMapping("/users/register")
//	public String registerUser(@RequestBody Users userObj) {
//		if(!userService.existsById(userObj.getUserEmail())) {
//			userService.save(userObj);
//			return "Registration Successfull";
//			//Reroute to login page
//			
//		}
//		else
//			return "Email aleady Exists";
//		///else print email already exists*/
//		
//	}
	
	@PostMapping("/users/register")
	public Users registerUser(@RequestBody Users userObj) throws Exception {
		if(!userService.existsById(userObj.getUserEmail())) {
			userService.save(userObj);
			return userObj;
			//Reroute to login page
		}
		else
			throw new Exception("user already exists");
		///else print email already exists*/
		
	}
	
	
	@PostMapping("/users/login")
	public Optional<Users> loginUser(@RequestBody Users userobj) throws Exception {
		String email=userobj.getUserEmail();
		String password=userobj.getUserPassword();
		Users uobj=new Users(); 
		if(userService.existsById(email)) {
			if(userService.findById(email).get().getUserPassword().equals(password)){
					return userService.findById(email);
			}
			else
			{
//				uobj.setUserEmail(email);
//				uobj.setUserPassword("incorrectpass");
//				return Optional.ofNullable(uobj);
				throw new Exception("incorrect pass");
			}
		}
		else

		{
//			uobj.setUserEmail("doesnotexist");
//			return Optional.ofNullable(uobj);
			throw new Exception("User does not exist");
		}
	}
	
	
	
//	@GetMapping("/users/login/{email}/{password}")
//	public String loginUser(@PathVariable("email") String email, @PathVariable("password") String password) {
//		if(userService.existsById(email)) {
//			if(userService.findById(email).get().getUserPassword().equals(password)){
//					return "Login Successfull";}
//			else
//				return "Incorrect Password";
//		}
//		else
//			return "Email does not exist!\n Please Register";
//			
//		
//}
	
	
	
	@PutMapping("/users/{email}")
	public void updateUserInfo(@RequestBody Users userObj, @PathVariable String email) {
		
		userService.deleteById(email);
		userService.save(userObj);
		
	}
	
	@GetMapping("/users/{email}")
	public Optional<Users> getUser(@PathVariable String email){
		return userService.findById(email);
	
	}
	
	@DeleteMapping("/users/{email}")
	public void deleteUser(@PathVariable String email) {
		userService.deleteById(email);
	}
	
}
