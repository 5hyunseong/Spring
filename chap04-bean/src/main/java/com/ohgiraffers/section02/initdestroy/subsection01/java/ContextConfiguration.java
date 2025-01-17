package com.ohgiraffers.section02.initdestroy.subsection01.java;

import com.ohgiraffers.common.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

	/* Note. section01.scope.subsection02.prototype의 ContextConfiguration 내용을 그대로 복사. */
	@Bean
	public Product carpBread() {
		
		return new Bread("붕어빵", 1000, new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		
		return new Beverage("딸기우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		
		return new Beverage("지리산암반수", 3000, 500);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		
		return new ShoppingCart();
	}

	/* 설명. Bean의 생성/소멸 시점에 실행할 메소드 이름을 설정할 수 있다.(Singleton Scope)
	 *  init-method로 openShop 메소드를 설정하고 destory-method로 closeShope 메소드를 설정한다.
	 * */
	@Bean(initMethod = "openShop", destroyMethod="closeShop")
	public Owner owner() {

		return new Owner();
	}
	
}

