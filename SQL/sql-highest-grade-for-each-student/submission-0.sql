-- for each studentId, find row w max score
-- output studentId, examId, score order by studentId asc


-- CTE + window func, score DESC, examId asc
-- filter and final sort

WITH ranked_exams AS (
    SELECT
        student_id, 
        exam_id,
        score,
        ROW_NUMBER() OVER (
            PARTITION BY student_id
            ORDER BY score DESC, exam_id ASC
        ) AS rn
    FROM exam_results
)

SELECT
    student_id,
    exam_id,
    score
FROM ranked_exams
WHERE rn = 1
ORDER BY student_id ASC;