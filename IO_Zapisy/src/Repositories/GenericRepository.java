package Repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import Entities.AbstractEntity;

public abstract class GenericRepository <EntityType extends AbstractEntity> {

	List<EntityType> list;
	private int indexCount;
	
	public GenericRepository() {
		this.indexCount = 1;
		this.list = new LinkedList<EntityType>();
	}
	
	public EntityType getById(int id) {
		Optional<EntityType> result = this.list.stream().filter(item -> item.id == id).findFirst();
		return result.isPresent() ? result.get() : null;
	}
	
	public List<EntityType> getAll() {
		return this.list ;
	}
	
	public EntityType create(EntityType entity) {
		if(entity.id == 0) entity.id = indexCount++;
		return list.add(entity) ? entity : null;
	}
	
	public EntityType update(EntityType entity) {
		this.list = this.list.stream().filter(item -> item.id != entity.id).toList();
		this.list.add(entity);
		return entity;
	}
	
	public boolean delete(EntityType entity) {
		this.list = this.list.stream().filter(item -> item.id != entity.id).toList();
		return true;
	}
}
