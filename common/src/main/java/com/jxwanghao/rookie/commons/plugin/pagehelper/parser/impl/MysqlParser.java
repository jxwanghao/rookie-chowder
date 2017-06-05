package com.jxwanghao.rookie.commons.plugin.pagehelper.parser.impl;

import com.yyfax.oss.common.plugin.pagehelper.Page;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;

import java.util.Map;

/**
 * MYSQL
 * 
 * @author administrator
 */
public class MysqlParser extends AbstractParser {
	@Override
	public String getPageSql(String sql) {
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 14);
		sqlBuilder.append(sql);
		sqlBuilder.append(" limit ?,?");
		return sqlBuilder.toString();
	}

	@Override
	public Map<String, Object> setPageParameter(MappedStatement ms, Object parameterObject, BoundSql boundSql, Page<?> page) {
		Map<String, Object> paramMap = super.setPageParameter(ms, parameterObject, boundSql, page);
		paramMap.put(PAGEPARAMETER_FIRST, page.getStartRow());
		paramMap.put(PAGEPARAMETER_SECOND, page.getPageSize());
		return paramMap;
	}
}