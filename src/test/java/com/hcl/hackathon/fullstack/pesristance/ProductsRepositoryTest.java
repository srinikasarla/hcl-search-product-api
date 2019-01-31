package com.hcl.hackathon.fullstack.pesristance;

import com.google.common.collect.Lists;
import com.hcl.hackathon.fullstack.pesristance.entities.Category;
import com.hcl.hackathon.fullstack.pesristance.entities.Product;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductsRepositoryTest {

    @Autowired
    private ProductRepository subject;
    private Product product;

    @Before
    public void setUp() {
        subject.deleteAll();
        product = Product.builder()
            .name("name")
            .description("description")
            .averageRating(4.5)
            .totalRatings(12L)
            .imagePath("/imagePath")
            .categories(Lists.newArrayList(Category.builder()
                .name("tv")
                .build()))
            .build();
        subject.save(product);
    }

    @Test
    public void findByGivenSearch_includes_whenNameMatches() {
        List<Product> availableProducts = subject.findByGivenSearch("name");
        assertThat(availableProducts).hasSize(1);
    }

    @Test
    public void findByGivenSearch_includes_whenDescriptionMatches() {
        List<Product> availableProducts = subject.findByGivenSearch("description");
        assertThat(availableProducts).hasSize(1);
    }

    @Test
    public void findByGivenSearch_includes_whenCategoryMatches() {
        List<Product> availableProducts = subject.findByGivenSearch("tv");
        assertThat(availableProducts).hasSize(1);
    }

    @Test
    public void findByGivenSearch_returnsEmptyList_whenNoneMatches() {
        List<Product> availableProducts = subject.findByGivenSearch("non existing search text");
        assertThat(availableProducts).isEmpty();
    }

    @Test
    public void findByGivenSearch_returnsTwoProducts_whenNameMatches() {
        subject.save(Product.builder()
            .name("NAME2")
            .description("something else")
            .averageRating(3.0)
            .totalRatings(1L)
            .imagePath("/imagePathTest")
            .categories(Lists.newArrayList(Category.builder()
                .name("somethinglese")
                .build()))
            .build());
        List<Product> availableProducts = subject.findByGivenSearch("name");
        assertThat(availableProducts).hasSize(2);
    }

    @Test
    public void findByGivenSearch_returnsTwoProducts_whenDescMatches() {
        subject.save(Product.builder()
            .name("something else")
            .description("DESCRIPTION")
            .averageRating(3.0)
            .totalRatings(1L)
            .imagePath("/imagePathTest")
            .categories(Lists.newArrayList(Category.builder()
                .name("somethinglese")
                .build()))
            .build());
        List<Product> availableProducts = subject.findByGivenSearch("description");
        assertThat(availableProducts).hasSize(2);
    }

    @Test
    public void findByGivenSearch_returnsTwoProducts_whenCategoryMatches() {
        subject.save(Product.builder()
            .name("something else")
            .description("something else")
            .averageRating(3.0)
            .totalRatings(1L)
            .imagePath("/imagePathTest")
            .categories(Lists.newArrayList(Category.builder()
                .name("TV")
                .build()))
            .build());
        List<Product> availableProducts = subject.findByGivenSearch("tv");
        assertThat(availableProducts).hasSize(2);
    }
}
