package com.innovatitive.dao;


import java.util.List;

import com.innovatitive.model.Innovativestudents;

public interface StudentDao {

	void save(Innovativestudents invStudent);

	void update(Innovativestudents invStudent);

	Innovativestudents findById(long invID);

	void delete(int invID);

	List<Innovativestudents> findAll();

}
