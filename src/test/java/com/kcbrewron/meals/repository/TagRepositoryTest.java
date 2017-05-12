package com.kcbrewron.meals.repository;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcbrewron.meals.domain.Tag;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TagRepositoryTest {

    @Autowired
    TagRepository repo;

    @Before
    public void setUp() {
        Tag tag1 = new Tag();
        tag1.setTagName("Mexican");
        tag1.setTagCnt(2);

        Tag tag2 = new Tag();
        tag2.setTagName("Kid Friendly");
        tag2.setTagCnt(30);

        Tag tag3 = new Tag();
        tag3.setTagName("CrockPot");
        tag3.setTagCnt(15);

        Set<Tag> myTags = new HashSet<Tag>();
        myTags.add(tag1);
        myTags.add(tag2);
        myTags.add(tag3);

        repo.save(myTags);

    }

    @Test
    public void testSaveS() {
        assertNotNull(repo);
        Tag tag1 = new Tag();
        tag1.setTagName("Mexican");
        tag1.setTagCnt(1L);
        Tag savedTag = repo.save(tag1);

        assertNotNull(savedTag);
        System.out.println(savedTag.toString());
    }

    @Test
    public void testFindOne() {
        assertNotNull(repo);
        Tag tag1 = new Tag();
        tag1.setTagName("Kid Friendly");
        tag1.setTagCnt(1L);
        Tag savedTag = repo.save(tag1);

        assertNotNull(savedTag);
        System.out.println(savedTag.toString());

        Tag foundTag = repo.findOne(savedTag.getId());
        assertNotNull(foundTag);
    }

    @Test
    public void testFindOneByNameBeginsWith() {
        assertNotNull(repo);
        Iterable<Tag> tags = repo.findManyByTagNameIsStartingWith("Kid");
        Iterator<Tag> iTags = tags.iterator();

        while (iTags.hasNext()) {
            iTags.next().toString();
        }
    }

}
