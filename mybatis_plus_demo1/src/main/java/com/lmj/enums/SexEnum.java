package com.lmj.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 性别
 * @author lmj
 * @date 2020-10-23
 */
public enum SexEnum {
	MAN("1","男"),WOMAN("0","女");
	
	@EnumValue//标记数据库存的值是code
	private final String value;
	private String label;
	
	SexEnum(String value, String label){
		this.value = value;
		this.label = label;
	}
}
