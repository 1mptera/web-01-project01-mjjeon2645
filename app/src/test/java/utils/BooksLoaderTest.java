package utils;

import models.Book;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static models.Book.SCIENCE_IT;
import static org.junit.jupiter.api.Assertions.*;

class BooksLoaderTest {
  @Test
  void parseBook() {
    BooksLoader booksLoader = new BooksLoader();
    Book book = new Book("1", "1", "1", "1", "1", "과학/IT");

    assertEquals(book, booksLoader.parseBook("1///1///1///1///1///과학/IT"));
  }

  @Test
  void load() throws FileNotFoundException {
    BooksLoader booksLoader = new BooksLoader();
    Book book = new Book("1", "1", "1", "1", "1", "과학/IT");

    assertEquals(book, booksLoader.parseBook("1///1///1///1///1///과학/IT"));

    List<Book> books = booksLoader.load();

    Book book1 = books.get(0);
    Book book2 = books.get(1);

    assertEquals(book1, new Book("images/books/1.png", "객체지향의 사실과 오해", "조영호",
        "객체지향의 사실과 오해는 객체지향이란 무엇인가라는 원론적면서도 다소 위험한 질문에 답하기 위해 쓰여진 책이다. 안타깝게도 많은 사람들이 객체지향의 본질을 오해하고 있다. 가장 널리 퍼져있는 오해는 클래스가 객체지향 프로그래밍의 중심이라는 것이다. 객체지향으로 향하는 첫 걸음은 클래스가 아니라 객체를 바라보는 것에서부터 시작한다",
        "http://www.yes24.com/Product/Goods/18249021", "과학/IT"));

    assertEquals(book2, new Book("images/books/2.png", "토지 1", "박경리", "박경리는 『토지』의 작가로 불린다. 『토지』는 한국문학사의 기념비적인 작품이다. 『토지』는 1969년에서 1994년까지 26년 동안 집필되었으며, 그 크기만 해도 200자 원고지 4만여 장에 이르는 방대한 분량이다. 구한말에서 일제 강점기를 거쳐 해방에 이르기까지의 무수한 역사적 사건과 민중들의 삶이 고스란히 『토지』에 담겨 있다. 『토지』는 한마디로 “소설로 쓴 한국근대사”라 할 수 있다.",
        "http://www.yes24.com/Product/Goods/7412374", "소설"));
  }
}
