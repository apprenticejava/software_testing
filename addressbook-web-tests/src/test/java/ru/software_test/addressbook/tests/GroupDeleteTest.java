package ru.software_test.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.software_test.addressbook.model.GroupData;
import ru.software_test.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void preconditionCheck(){
        app.goTo().groups();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("222").withHeader("hhh").withFooter("fff"));
        }

    }
    @Test
    public void testGroupDelete() throws Exception {

        Groups before = app.group().allset();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().allset();
        assertThat(after, equalTo(before.without(deletedGroup)));

    }



}
