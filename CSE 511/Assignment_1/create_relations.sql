-- Alter authors 
ALTER TABLE authors
ADD PRIMARY KEY (id),
ADD UNIQUE (name);

-- Alter subreddits 
ALTER TABLE subreddits
ADD PRIMARY KEY (id),
ADD UNIQUE (name),
ADD UNIQUE (display_name);

-- Alter submissions 
ALTER TABLE submissions
ADD PRIMARY KEY (id),
ADD FOREIGN KEY (author) REFERENCES authors(name) ON DELETE SET NULL,
ADD FOREIGN KEY (subreddit_id) REFERENCES subreddits(name) ON DELETE CASCADE; 

-- Alter comments 
ALTER TABLE comments
ADD PRIMARY KEY (id),
ADD FOREIGN KEY (author) REFERENCES authors(name) ON DELETE SET NULL,
ADD FOREIGN KEY (subreddit) REFERENCES subreddits(display_name) ON DELETE CASCADE,
ADD FOREIGN KEY (subreddit_id) REFERENCES subreddits(name) ON DELETE CASCADE;

-- Verifying Constraints 
SELECT 
    tc.table_name,
    tc.constraint_name,
    tc.constraint_type,
    kcu.column_name
FROM 
    information_schema.table_constraints AS tc
JOIN 
    information_schema.key_column_usage AS kcu 
    ON tc.constraint_name = kcu.constraint_name
WHERE 
    tc.table_schema = 'public'  -- You can modify this if you are using a different schema
    AND tc.table_name IN ('authors', 'comments', 'submissions', 'subreddits')
ORDER BY 
    tc.table_name, tc.constraint_type;
