
-- Query 1: Total number of comments authored by 'xymemez'
CREATE TABLE query1 AS 
SELECT COUNT(*) AS "count of comments" 
FROM comments 
WHERE author = 'xymemez';

-- Query 2: Total number of subreddits for each subreddit type
CREATE TABLE query2 AS
SELECT subreddit_type AS "subreddit type", COUNT(*) AS "subreddit count"
FROM subreddits
GROUP BY subreddit_type;

-- Query 3: Top 10 subreddits arranged by descendind order of number of comments
CREATE TABLE query3 AS
SELECT subreddit AS "name", COUNT(id) AS "comments count", ROUND(AVG(score), 2) AS "average score"
FROM comments
GROUP BY subreddit
ORDER BY COUNT(id) DESC
LIMIT 10;

-- Query 4: Users with >1,000,000 average karma
WITH karma AS (
    SELECT name, link_karma, comment_karma,
           (link_karma + comment_karma) AS total_karma
    FROM authors
)
SELECT name AS "name", link_karma AS "link karma", comment_karma AS "comment karma",
       CASE WHEN link_karma >= comment_karma THEN 1 ELSE 0 END AS "label"
INTO query4
FROM karma
WHERE total_karma / 2 > 1000000
ORDER BY total_karma / 2 DESC;

-- CREATE TABLE query4 AS
-- SELECT name AS "name", link_karma AS "link karma", comment_karma AS "comment karma",
--        CASE WHEN link_karma >= comment_karma THEN 1 ELSE 0 END AS "label"
-- FROM authors
-- WHERE (link_karma + comment_karma) / 2 > 1000000
-- ORDER BY (link_karma + comment_karma) / 2 DESC;

-- Query 5: Count of comments in subreddit types where '[deleted_user]' has commented
CREATE TABLE query5 AS
SELECT s.subreddit_type AS "sr type", COUNT(c.id) AS "comments num"
FROM comments c
JOIN subreddits s ON c.subreddit_id = s.name
WHERE c.author = '[deleted_user]'
GROUP BY s.subreddit_type;

