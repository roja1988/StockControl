package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Inout;

public interface InoutMapper {
	
	void insert(Inout inout) throws Exception;
	
	List<Inout> getInoutList(Integer itemId) throws Exception;
}
