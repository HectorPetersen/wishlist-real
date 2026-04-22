package org.example.wishlist.repository;

import org.example.wishlist.model.Wish;
import org.example.wishlist.model.Wishlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:h2init.sql", executionPhase = BEFORE_TEST_METHOD)
class WishlistRepositoryTest {

    @Autowired
   private WishlistRepository repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void saveWishlist() {
        Wish TestWish = new Wish();
        TestWish.setName("AirPods");
        TestWish.setLink("http://eksempellink.com/AirPods");
        TestWish.setPrice(1600);

        Wishlist wishlist = new Wishlist();
        wishlist.setName("TestListe");
        wishlist.setUserId(8);
        wishlist.setWishes(List.of(TestWish));

       Wishlist test = repo.saveWishlist(wishlist);
        assertThat(test).isNotNull();
        assertThat(test.getName()).isEqualTo("Testliste");
        assertThat(test.getUserId()).isEqualTo(8);

    }

    @Test
    void saveWish() {
    }

    @Test
    void deleteWishlist() {
    }

    @Test
    void findWishlist() {
    }

    @Test
    void login() {
    }

    @Test
    void registerUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void findUser() {
    }

    @Test
    void userExists() {
    }

    @Test
    void updateWishlist() {
    }

    @Test
    void updateWish() {
        Wish wish = new Wish();
        wish.setName("Original Name");
        wish.setLink("http://link.com");
        wish.setPrice(100.0);

        Wishlist wishlist = new Wishlist();
        wishlist.setName("Test Update Wishlist");
        wishlist.setUserId(1);
        wishlist.setWishes(List.of(wish));

        Wishlist savedWishlist = repo.saveWishlist(wishlist);
        Wish savedWish = savedWishlist.getWishes().get(0);

        savedWish.setName("Updated Name");
        repo.updateWish(savedWish);

        String sql = "SELECT name FROM wish WHERE id = ?";
        String updatedName = jdbcTemplate.queryForObject(sql, String.class, savedWish.getId());
        assertThat(updatedName).isEqualTo("Updated Name");
    }
}