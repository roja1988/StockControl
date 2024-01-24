package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Area;

/**
 * エリアマスターマッパー
 * @author zd2O27
 *
 */
public interface AreaMapper {

	List<Area> selectAll() throws Exception;
}
