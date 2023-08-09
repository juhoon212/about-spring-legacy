package xyz.itwill.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill.controller.dto.Item;


@Repository
@Slf4j
public class ItemRepository {
	
	private Map<String, Item> store = new HashMap<>();
	
	public void save(Item item) {
		log.info("item save = {}" , item.getName());
		store.put(item.getName(), item);
	}
	
	
}
