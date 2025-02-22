#
# sample_csv.ctl -- Control file to load CSV input data
#
#    Copyright (c) 2007-2025, NIPPON TELEGRAPH AND TELEPHONE CORPORATION
#
OUTPUT = test_data                   # [<schema_name>.]table_name
TYPE = CSV                            # Input file type
INPUT = data2.csv
QUOTE = "\""                          # Quoting character
ESCAPE = \                            # Escape character for Quoting
DELIMITER = ","                       # Delimiter
