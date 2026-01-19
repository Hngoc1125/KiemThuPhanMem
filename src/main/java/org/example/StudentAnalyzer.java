package org.example;

import java.util.List;

public class StudentAnalyzer {

    /**
     * Đếm số sinh viên xuất sắc.
     * Sinh viên xuất sắc: điểm hợp lệ và >= 8.0
     * Điểm hợp lệ: 0 <= score <= 10
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Double score : scores) {
            if (isValidScore(score) && score >= 8.0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Tính điểm trung bình của các điểm hợp lệ.
     * Điểm hợp lệ: 0 <= score <= 10
     * Nếu không có điểm hợp lệ → trả về 0.0
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        int count = 0;

        for (Double score : scores) {
            if (isValidScore(score)) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return sum / count;
    }

    /**
     * Kiểm tra điểm hợp lệ
     */
    private boolean isValidScore(Double score) {
        return score != null && score >= 0.0 && score <= 10.0;
    }
}
