/* IRepository.java
   Generic repository interface with abstraction
   Author: Paul Khumalo (230108547)
   Date: 13 March 2026
*/
package za.ac.cput.realestate.repository;

import java.util.List;

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    List<T> getAll();  // 20% of marks
}