package com.appleyk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.appleyk.entity.SumNumDto;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>单元测试</p>
 *
 * @Author Appleyk
 * @Blob https://blog.csdn.net/appleyk
 * @Date Created on 2018年11月10日 - 下午9:33:26
 * @Version V.1.0.1
 */
public class TestA {



	@PostMapping("/add")
	public Integer calNum(@RequestBody SumNumDto sumNumDto) {
		return sumNumDto.getNum1() + sumNumDto.getNum2();
	}
}
