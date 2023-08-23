package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService ser;
	
	@PostMapping("add")
	public StudentEntity add(@RequestBody StudentEntity st) {
		return ser.saveinfo(st);
	}
	
	@GetMapping("show")
	public List<StudentEntity> show(){
		return ser.showinfo();
	}
	
	@PutMapping("update")
	public StudentEntity modify(@RequestBody StudentEntity st) {
		return ser.changeinfo(st);
	}
	
	@DeleteMapping("delete")
	public String del(@RequestBody StudentEntity st) {
		ser.deleteinfo(st);
		return "Deleted successfully";
	}
	
	@DeleteMapping("delid/{id}")
	public void deletepid(@PathVariable int id) {
		ser.deletemyid(id);
	}
	
	@GetMapping("get/{id}")
	public Optional<StudentEntity> showid(@PathVariable int id)
	{
		return ser.getbyid(id);
	}
	
	@PutMapping("updateid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody StudentEntity st) {
		return ser.updateinfobyid(id, st);
	}
}
