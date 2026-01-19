package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    /*
     * ==============================
     * TEST countExcellentStudents()
     * ==============================
     */

    /**
     * BVA + EP:
     * - Biên nghiệp vụ: 8.0
     * - Biên trên: 10.0
     * - Ngoài biên: -0.1, 10.1
     */
    @Test
    public void testCountExcellentStudents_BoundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                2,
                analyzer.countExcellentStudents(
                        Arrays.asList(7.9, 8.0, 10.0, -0.1, 10.1)
                )
        );
    }

    /**
     * EP: Danh sách rỗng
     */
    @Test
    public void testCountExcellentStudents_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0,
                analyzer.countExcellentStudents(Collections.emptyList())
        );
    }

    /**
     * Robustness: danh sách null
     */
    @Test
    public void testCountExcellentStudents_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0,
                analyzer.countExcellentStudents(null)
        );
    }

    /**
     * BVA:
     * - Biên dưới: 0.0
     * - Biên trên: 10.0
     * - Ngoài biên: -0.1, 10.1
     */
    @Test
    public void testCalculateValidAverage_BoundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                5.0,
                analyzer.calculateValidAverage(
                        Arrays.asList(0.0, 10.0, -0.1, 10.1)
                ),
                0.01
        );
    }

    /**
     * EP: Không có điểm hợp lệ
     */
    @Test
    public void testCalculateValidAverage_NoValidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0.0,
                analyzer.calculateValidAverage(
                        Arrays.asList(-2.0, 11.0)
                ),
                0.01
        );
    }

    /**
     * EP: Danh sách rỗng
     */
    @Test
    public void testCalculateValidAverage_EmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0.0,
                analyzer.calculateValidAverage(Collections.emptyList()),
                0.01
        );
    }

    /**
     * Robustness: danh sách null
     */
    @Test
    public void testCalculateValidAverage_NullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0.0,
                analyzer.calculateValidAverage(null),
                0.01
        );
    }
}
