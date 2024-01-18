package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Scale;

/**
 * スケールマスターマッパー
 * @author zd2O27
 *
 */

public interface ScaleMapper {

	List<Scale> selectAll() throws Exception;
}
