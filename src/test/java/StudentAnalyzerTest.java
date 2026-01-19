package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    /*
     * =================================
     * TEST countExcellentStudents()
     * =================================
     */

    /**
     * DT Rule: scores = null
     */
    @Test
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    /**
     * DT Rule: scores rỗng
     */
    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    /**
     * DT Rule: có điểm hợp lệ nhưng tất cả < 8.0
     */
    @Test
    public void testCountExcellentStudents_AllValidButNotExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(
                0,
                analyzer.countExcellentStudents(Arrays.asList(5.0, 7.9, 6.5))
        );
    }

    /**
     * DT Rule: có điểm hợp lệ >= 8.0
     * Kết hợp BVA + EP + robustness
     */
    @Test
    public void testCountExcellentStudents_BoundaryAndInvalidValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(
                2,
                analyzer.countExcellentStudents(
                        Arrays.asList(7.9, 8.0, 10.0, -0.1, 10.1)
                )
        );
    }

    /*
     * =================================
     * TEST calculateValidAverage()
     * =================================
     */

    /**
     * DT Rule: scores = null
     */
    @Test
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }

    /**
     * DT Rule: scores rỗng
     */
    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    /**
     * DT Rule: không có điểm hợp lệ
     */
    @Test
    public void testCalculateValidAverage_NoValidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Arrays.asList(-2.0, 11.0)),
                0.01
        );
    }

    /**
     * DT Rule: chỉ có 1 điểm hợp lệ
     */
    @Test
    public void testCalculateValidAverage_SingleValidScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(
                8.0,
                analyzer.calculateValidAverage(Arrays.asList(8.0)),
                0.01
        );
    }

    /**
     * DT Rule: nhiều điểm hợp lệ + không hợp lệ (BVA)
     */
    @Test
    public void testCalculateValidAverage_BoundaryAndInvalidValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(
                5.0,
                analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0, -0.1, 10.1)),
                0.01
        );
    }
}
