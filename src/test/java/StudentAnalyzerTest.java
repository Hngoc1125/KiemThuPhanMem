package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAnalyzerTest {

    /**
     * EP1: Danh sách có điểm hợp lệ (xuất sắc + không xuất sắc)
     * EP2: Có điểm không hợp lệ (âm, >10)
     */
    @Test
    public void testCountExcellentStudents_MixedValidAndInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                2,
                analyzer.countExcellentStudents(
                        Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
                )
        );
    }

    /**
     * EP3: Danh sách rỗng
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
     * EP1 + EP2:
     * - Điểm hợp lệ được dùng tính trung bình
     * - Điểm không hợp lệ bị loại bỏ
     */
    @Test
    public void testCalculateValidAverage_MixedValidAndInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                8.17,
                analyzer.calculateValidAverage(
                        Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
                ),
                0.01
        );
    }

    /**
     * EP3: Không có điểm hợp lệ
     * Kỳ vọng: trả về 0.0
     */
    @Test
    public void testCalculateValidAverage_NoValidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();

        assertEquals(
                0.0,
                analyzer.calculateValidAverage(
                        Arrays.asList(-3.0, 12.0)
                ),
                0.01
        );
    }

    /**
     * EP4: Danh sách rỗng
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
}
