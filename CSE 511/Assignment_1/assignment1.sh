#!/bin/bash

# Function to cleanly exit the script
exit_script() {
  echo -e "\nScript has been interrupted. Exiting...\n"
  exit 1
}

# Trap SIGINT (Ctrl+C) to call exit_script function
trap exit_script SIGINT


# Database credentials
DB_NAME="postgres"
DB_USER="postgres"
DB_PASSWORD="postgres"


# SQL Files
CREATE_SQL_FILE="create_tables.sql"
RELATION_SQL_FILE="create_relations.sql"
QUERY_SQL_FILE="queries.sql"
DROP_SQL_FILE="drop_tables.sql"


# PG_BULKLOAD Control Files
AUTHOR_CONTROL_FILE="bulkload_authors.ctl"
COMMENT_CONTROL_FILE="bulkload_comments.ctl"
SUBMISSION_CONTROL_FILE="bulkload_submissions.ctl"
SUBREDDIT_CONTROL_FILE="bulkload_subreddits.ctl"

# CSV/Data Files
AUTHOR_DATA_FILE="authors.csv"
COMMENT_DATA_FILE="comments.csv"
SUBMISSION_DATA_FILE="submissions.csv"
SUBREDDIT_DATA_FILE="subreddits.csv"

echo -e "\n----- Assignment Script Start -------"

# Step 0: Delete tables
echo -e "\nStep 0: Delete table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -f $DROP_SQL_FILE
# Step 1: Create the table
echo -e "\nStep 1: Creating table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -f $CREATE_SQL_FILE

# Step 2: Add table relationships
echo -e "\nStep 2: Creating relationships..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -f $RELATION_SQL_FILE

# Step 3: Load data
#echo -e "\nStep 3: Running pg_bulkload...\n"
##sudo -u postgres 
#pg_bulkload -U $DB_USER -d $DB_NAME $AUTHOR_CONTROL_FILE < $AUTHOR_CONTROL_FILE
#pg_bulkload -U $DB_USER -d $DB_NAME $COMMENT_CONTROL_FILE < $COMMENT_DATA_FILE
#pg_bulkload -U $DB_USER -d $DB_NAME $SUBMISSION_CONTROL_FILE < $SUBMISSION_DATA_FILE
#pg_bulkload -U $DB_USER -d $DB_NAME $SUBREDDIT_CONTROL_FILE < $SUBREDDIT_DATA_FILE

# Step 3: Load data
echo -e "\nStep 3: Running copy..."
echo -e "\nLoading data from CSV files..."
echo "Authors CSV files..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "\COPY authors FROM 'authors.csv' DELIMITER ',' CSV HEADER;"
echo "Subreddits CSV files..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "\COPY subreddits FROM 'subreddits.csv' DELIMITER ',' CSV HEADER;"
echo "Comments CSV files..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "\COPY comments FROM 'comments.csv' DELIMITER ',' CSV HEADER;"
echo "Submissions CSV files ..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "\COPY submissions FROM 'submissions.csv' DELIMITER ',' CSV HEADER;"


# Step 4: Run queries
echo -e "\nStep 4: Run queries..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -f $QUERY_SQL_FILE

# Step 5: Verify data loaded into table
echo -e "\nVerifying data in query1 table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM query1;"
echo -e "\nVerifying data in query2 table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM query2;"
echo -e "\nVerifying data in query3 table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM query3;"
echo -e "\nVerifying data in query4 table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM query4;"
echo -e "\nVerifying data in query5 table..."
PGPASSWORD=$DB_PASSWORD time psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM query5;"

echo -e "\n----- Assignment Script End -------"

# Step 6: Drop Tables
# psql -U postgres -d postgres -f "drop_tables.sql"
# psql -U $DB_USER -d $DB_NAME -f "drop_tables.sql"

