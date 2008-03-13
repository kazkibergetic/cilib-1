/*
 * EntityCollection.java
 * 
 * Created on Aug 4, 2005
 *
 * Copyright (C) 2003, 2004, 2005 - CIRG@UP 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */
package net.sourceforge.cilib.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.sourceforge.cilib.util.Cloneable;

/**
 * This is a generalization for all algorithms that maintain a collection of
 * {@linkplain Entity} objects. Examples of this would include PSO, EC and ACO.
 * 
 * @author Gary Pampara
 * @author otter
 */
public abstract class EntityCollection<E extends Entity> 
	implements Iterable<E>, List<E>, Cloneable, Serializable {
	
	public abstract EntityCollection<E> getClone();
       
    /**
     * Adds an entity to the topology
     * @param The entity to be added
     */
    public abstract boolean add(E ent);
    
    
    /**
     * Removes an entity from the topology
     * @param The entity to be removed
     * @return boolean, true if remove operation was successful.
     */
    public abstract boolean remove(E indiv);
    
    
    /**
     * Returns an entity based on it's index number within the topology
     * @param The index
     * @return The Individual
     */
    public abstract E get(int index);
    
    
    /**
     * Update/replace a specific entity within the topology
     * @param The index within the topology structure
     * @param The replacement entity
     */
    public abstract E set(int index, E indiv);    
    
    /**
     * Returns true if there is no entities within the topology 
     * @return boolean 
     */
    public abstract boolean isEmpty();
    
    
    /**
     * Wipe all the entities within the topology
     */ 
    public abstract void clear();
    
    public abstract boolean contains(Object o);
    
    public abstract boolean containsAll(Collection<?> c);
    
    public abstract boolean equals(Object o);
    
    public abstract int hashCode();
    
    /**
     * Returns an <code>Iterator</code> over all the Entites within the topology.
     * @return <code>Iterator<Individual></code> - A Entity iterator.
     */
    public abstract Iterator<E> iterator();
    
    public abstract boolean remove(Object o);
    
    public abstract boolean removeAll(Collection<?> c);
    
    public abstract boolean retainAll(Collection<?> c);
    
    /**
     * Returns the size of the {@linkplain EntityCollection} 
     * @return The size of {@linkplain EntityCollection}
     */
    public abstract int size();
    
    public abstract Object [] toArray();
    
    public abstract <T> T[] toArray(T[] a);
    
    
    
    public abstract String getId();
    
    public abstract void setId(String id);
}
