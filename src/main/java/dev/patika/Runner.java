package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("librarymanagementsystem");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // Add publisher
        Publisher publisher1 = new Publisher();
        publisher1.setName("Bilgi Yayınevi");
        publisher1.setEstablishmentYear("1965");
        publisher1.setAddress("Gülbahar Mh Gülbağ Cd. B-Blok 33 A Mecidiyeköy");
        entityManager.persist(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("alBaraka Yayınları");
        publisher2.setEstablishmentYear("2018");
        publisher2.setAddress("Saray, Dr. Adnan Büyükdeniz Cd. No:6, 34768 Ümraniye/İstanbul");
        entityManager.persist(publisher2);

        Publisher publisher3 = new Publisher();
        publisher3.setName("Nesin Yayınevi");
        publisher3.setEstablishmentYear("2004");
        publisher3.setAddress("Eskişehir, No:, Şahin Sk. No:84/B D:C, 34375 Şişli/İstanbul");
        entityManager.persist(publisher3);

        Publisher publisher4 = new Publisher();
        publisher4.setName("Dokuz Yayınları");
        publisher4.setEstablishmentYear("2010");
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


        transaction.commit();
    }
}