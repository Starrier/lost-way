package org.starrier.dreamwar.repository;


import org.starrier.dreamwar.model.entity.BookStore;
import org.starrier.dreamwar.model.entity.BookStoreWithBooks;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
