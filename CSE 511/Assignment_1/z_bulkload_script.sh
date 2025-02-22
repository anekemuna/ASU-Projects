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

# Paths
SQL_FILE="z_create_table.sql"
CONTROL_FILE="z_sample_csv.ctl"
DATA_FILE="z_data.csv"

# Step 1: Create the table
echo "Creating table..."
psql -U $DB_USER -d $DB_NAME -f $SQL_FILE

# Step 2: Run pg_bulkload
echo "Running pg_bulkload..."
#sudo -u postgres 
pg_bulkload -U $DB_USER -d $DB_NAME $CONTROL_FILE < $DATA_FILE

# Step 3: Verify data loaded into table
echo "Verifying data in test_data table..."
psql -U $DB_USER -d $DB_NAME -c "SELECT * FROM test_data;"

echo "Bulk load completed successfully!"

# Step 4: Drop Table {psql -U postgres -d postgres -c "DROP TABLE test_data;"}
