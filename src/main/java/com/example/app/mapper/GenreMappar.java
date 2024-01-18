package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Genre;

/**
 * ジャンルマスターマッパー
 * @author zd2O27
 *
 */

public interface GenreMappar {

	List<Genre> selectAll() throws Exception;
}
