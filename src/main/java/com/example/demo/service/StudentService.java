package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEntity;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo rr;
	public StudentEntity saveinfo(StudentEntity st) {
		return rr.save(st);
	}
	
	public  List<StudentEntity> showinfo(){
		return rr.findAll();
	}
	
	public StudentEntity changeinfo(StudentEntity st) {
		return rr.saveAndFlush(st);
	}
	
	public void deleteinfo(StudentEntity st) {
		rr.delete(st);
	}
	
	public void deletemyid(int id) {
		rr.deleteById(id);
	}
	public Optional<StudentEntity> getbyid(int id)
	{
		return rr.findById(id);
	}
	
	public String updateinfobyid(int id,StudentEntity st) {
		rr.saveAndFlush(st);
		if(rr.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid Id";
		}
	}
}
