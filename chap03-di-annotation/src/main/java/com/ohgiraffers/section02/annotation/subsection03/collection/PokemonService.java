package com.ohgiraffers.section02.annotation.subsection03.collection;

import java.util.List;
import java.util.Map;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 설명. 같은 타입의 빈이 2개 이상일 경우, List 또는 Map과 같은 컬렉션 형태로 주입받을 수 있다. */

	/* 필기. List 타입으로 주입
	 *  같은 타입(Pokemon)의 빈들을 List 형태로 주입받을 수 있다.
	 * */
//	private List<Pokemon> pokemonList;
//
//	@Autowired
//	public PokemonService(List<Pokemon> pokemonList) {
//		this.pokemonList = pokemonList;
//	}
//
//	public void pokemonAttack() {
//		pokemonList.forEach(Pokemon::attack);
//	}


	/* 필기. Map 타입으로 주입
	 *  같은 타입(Pokemon)의 빈들을 Map 형태로 주입받을 수 있다.
	 * */
	private Map<String, Pokemon> pokemonMap;

	@Autowired
	public PokemonService(Map<String, Pokemon> pokemonMap) {
		this.pokemonMap = pokemonMap;
	}

    /* 설명. key 값은 bean 객체의 id가, value 값은 bean 객체의 주소값이 넘어온다. */
	public void pokemonAttack() {
		pokemonMap.forEach((k, v) -> {
			System.out.println("key : " + k);
			System.out.print("공격 : ");
			v.attack();
		});
	}

}





