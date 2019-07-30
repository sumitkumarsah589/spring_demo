package com.example.demo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {

	@Autowired
	DemoRepository repo;

	@RequestMapping("user")
	public List<User> getAllUser() {
		List<User> list = (List<User>) repo.findAll();
		/*
		 * List<User> list = new ArrayList<User>(); User user1 = new User();
		 * user1.setId(1); user1.setName("sam"); user1.setAge("25");
		 * user1.setGender("male"); list.add(user1); User user2 = new User();
		 * user2.setId(1); user2.setName("sam"); user2.setAge("25");
		 * user2.setGender("male"); list.add(user2);
		 */
		return list;
	}

	@RequestMapping(value = "add_user", method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		return repo.save(user).toString() != null ? "user added" : "unable to add user";
	}

	@RequestMapping(value = "del_user/{id}", method = RequestMethod.GET)
	private HashMap<String, String> deleteUser(@PathVariable int id) {
		
		Integer i = id;
		// ArrayList<String> al = new ArrayList<String>();
		
		//ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>(); 
		HashMap<String, String> map = new HashMap<String, String>();
		if (repo.existsById(i)) {
			repo.deleteById(i);
			map.put("isdeleted", String.valueOf(i) + " deleted successfully.");
			
			//al.add(i + " deleted successfully.");
			//list.add(map);
			return map;
		}
		 //al.add("id not found");
		map.put("isdeleted", " id not found.");
		//list.add(map);
		return map;
	}

	@RequestMapping("remove_all_user")
	private String deleteAllUser() {
		repo.deleteAll();
		return repo.findAll() != null ? "Deleted successfully" : "unable to delete";
	}
}
