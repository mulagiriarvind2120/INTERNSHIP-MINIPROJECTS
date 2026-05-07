SELECT s.name AS student_name,
       c.club_name AS club_name
FROM Students s
INNER JOIN Student_Club sc
    ON s.student_id = sc.student_id
INNER JOIN Clubs c
    ON sc.club_id = c.club_id;

SELECT u.name AS user_name,
       s.plan AS subscription_plan
FROM Users u
LEFT JOIN Subscriptions s
    ON u.user_id = s.user_id;

SELECT b.title AS book_title,
       a.author_name AS author_name
FROM Authors a
RIGHT JOIN Books b
    ON a.author_id = b.author_id;
