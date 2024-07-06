package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("librarymanagementsystem");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // Add publisher
        Publisher publisher1 = new Publisher();
        publisher1.setName("Bilgi Yayınevi");
        publisher1.setEstablishmentYear(Year.of(1965));
        publisher1.setAddress("Gülbahar Mh Gülbağ Cd. B-Blok 33 A Mecidiyeköy");
        entityManager.persist(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("alBaraka Yayınları");
        publisher2.setEstablishmentYear(Year.of(2018));
        publisher2.setAddress("Saray, Dr. Adnan Büyükdeniz Cd. No:6, 34768 Ümraniye/İstanbul");
        entityManager.persist(publisher2);

        Publisher publisher3 = new Publisher();
        publisher3.setName("Nesin Yayınevi");
        publisher3.setEstablishmentYear(Year.of(2004));
        publisher3.setAddress("Eskişehir, No:, Şahin Sk. No:84/B D:C, 34375 Şişli/İstanbul");
        entityManager.persist(publisher3);

        Publisher publisher4 = new Publisher();
        publisher4.setName("Dokuz Yayınları");
        publisher4.setEstablishmentYear(Year.of(2010));
        publisher4.setAddress("MALTEPE MAHALLESİ, DAVUTPAŞA CADDESİ YILANLI AYAZMA YOLU, NO:8 ÖRME İŞ MERKEZİ KAT:2 DAİRE:1, 34010 Zeytinburnu/İstanbul");
        entityManager.persist(publisher4);

        // Add category
        Category category1 = new Category();
        category1.setName("Akademik");
        category1.setDescription("Akademik descrption");
        entityManager.persist(category1);

        Category category2 = new Category();
        category2.setName("Felsefe");
        category2.setDescription("Felsefe descrption");
        entityManager.persist(category2);

        Category category3 = new Category();
        category3.setName("Tarih");
        category3.setDescription("Tarih descrption");
        entityManager.persist(category3);

        Category category4 = new Category();
        category4.setName("Roman");
        category4.setDescription("Roman descrption");
        entityManager.persist(category4);

        Category category5 = new Category();
        category5.setName("Biyografi");
        category5.setDescription("Biyografi descrption");
        entityManager.persist(category5);

        // Add author
        Author author1 = new Author();
        author1.setName("Ann Druyan");
        author1.setBirthDate("1949");
        author1.setCountry("United States of America");
        entityManager.persist(author1);

        Author author2 = new Author();
        author2.setName("Thomas Junker");
        author2.setBirthDate("1957");
        author2.setCountry("Germany");
        entityManager.persist(author2);

        Author author3 = new Author();
        author3.setName("Jonathan Clements");
        author3.setBirthDate("1971");
        author3.setCountry("United Kingdom");
        entityManager.persist(author3);

        Author author4 = new Author();
        author4.setName("Seneca");
        author4.setBirthDate("MS 65");
        author4.setCountry("Italy");
        entityManager.persist(author4);

        Author author5 = new Author();
        author5.setName("Viktor Emil Frankl");
        author5.setBirthDate("1905");
        author5.setCountry("Austria");
        entityManager.persist(author5);

        Author author6 = new Author();
        author6.setName("David Sloan Wilson");
        author6.setBirthDate("1949");
        author6.setCountry("United States of America");
        entityManager.persist(author6);

        // Add book
        Book book1 = new Book();
        book1.setName("Mutlu Yaşam Üzerine - Yaşamın Kısalığı Üzerine");
        book1.setPublicationYear(Year.of(2019));
        book1.setStock(1500);
        book1.setAuthor(author4);
        List<Category> categoryList1 = new ArrayList<>();
        categoryList1.add(category1);
        categoryList1.add(category2);
        book1.setCategoryList(categoryList1);
        book1.setPublisher(publisher1);
        entityManager.persist(book1);

        Book book2 = new Book();
        book2.setName("İnsanın Anlam Arayışı");
        book2.setPublicationYear(Year.of(2019));
        book2.setStock(1100);
        book2.setAuthor(author5);
        List<Category> categoryList2 = new ArrayList<>();
        categoryList2.add(category1);
        categoryList2.add(category2);
        book2.setCategoryList(categoryList2);
        book2.setPublisher(publisher2);
        entityManager.persist(book2);

        Book book3 = new Book();
        book3.setName("National Geographic - Kozmos: Yeni Dünyalar");
        book3.setPublicationYear(Year.of(2023));
        book3.setStock(900);
        book3.setAuthor(author1);
        List<Category> categoryList3 = new ArrayList<>();
        categoryList3.add(category1);
        book3.setCategoryList(categoryList3);
        book3.setPublisher(publisher4);
        entityManager.persist(book3);

        //Add book borrowing
        BookBorrowing bookBorrowing1 = new BookBorrowing();
        bookBorrowing1.setBorrowerName("Yaşar Can");
        bookBorrowing1.setBorrowingDate(LocalDate.now());
        bookBorrowing1.setBook(book1);
        entityManager.persist(bookBorrowing1);

        BookBorrowing bookBorrowing2 = new BookBorrowing();
        bookBorrowing2.setBorrowerName("İlkin");
        bookBorrowing2.setBorrowingDate(LocalDate.parse("15/06/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        bookBorrowing2.setBook(book3);
        bookBorrowing2.setReturnDate(LocalDate.parse("03/07/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        entityManager.persist(bookBorrowing2);

        System.out.println(book1.toString());
        System.out.println(bookBorrowing2.toString());
        transaction.commit();
    }
}