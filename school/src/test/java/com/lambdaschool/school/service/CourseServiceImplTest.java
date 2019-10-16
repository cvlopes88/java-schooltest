package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest {


    @Autowired
    private CourseService courseService;

    @Before
    public void AsetUp() throws Exception {
    }

    @After
    public void BtearDown() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void CfindAll() {
        assertEquals(6, courseService.findAll().size());
    }

    @Test
    public void DfindCourseById() {
     assertEquals("Mobile IOS",courseService.findCourseById(5).getCoursename());
    }

    @Test
    public void EgetCountStudentsInCourse() {
        assertEquals(5, courseService.getCountStudentsInCourse().size());

    }

    @Test
    public void FdeleteFOUND() {

        courseService.delete(5);
        assertEquals(5, courseService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void ZDeleteNotFound(){

        courseService.delete(10);
        assertEquals(3, courseService.findAll().size());

    }
}