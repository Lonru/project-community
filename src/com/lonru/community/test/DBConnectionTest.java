package com.lonru.community.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.lonru.community.config.DB;



public class DBConnectionTest {
	@Test
	public void test() {
		Connection conn = DB.getConnection();
		assertNotNull(conn);
	}
}
