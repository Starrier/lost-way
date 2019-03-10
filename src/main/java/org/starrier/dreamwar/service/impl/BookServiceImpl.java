package org.starrier.dreamwar.service.impl;


import org.starrier.dreamwar.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrier.dreamwar.entity.Book;
import org.starrier.dreamwar.entity.BookWithBookStore;
import org.starrier.dreamwar.service.BookService;
import org.starrier.dreamwar.util.PageUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Starrier
 * @Time 2018/6/8
 */
@Service(value = "bookService")
public class
BookServiceImpl implements BookService {

    @Autowired
    private final BookDao bookRepository;

    @Autowired
    public BookServiceImpl(BookDao bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.selectBookById(id));
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.selectBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return bookRepository.selectBooksByPage(offset, perPage);
    }

    @Override
    public List<String> getAllBookNames() {
        return bookRepository
                .selectAllBooks()
                .stream()
                .map(Book::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookWithBookStore> getBookWithBookStoreById(Long id) {
        return Optional.ofNullable(bookRepository.selectBookWithBookStoreById(id));
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(bookRepository.selectCount(), perPage);
    }

    @Override
    @Transactional
    public boolean saveBook(Book book) {
        return bookRepository.insertBook(book) > 0;
    }

    @Override
    @Transactional
    public boolean modifyBookOnNameById(Book book) {
        return bookRepository.updateBookOnNameById(book) > 0;
    }

    @Override
    @Transactional
    public boolean deleteBookById(Long id) {
        return bookRepository.deleteBookById(id) > 0;
    }
}
