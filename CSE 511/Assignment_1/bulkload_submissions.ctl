#
# sample_csv.ctl -- Control file to load CSV input data
#
#    Copyright (c) 2007-2025, NIPPON TELEGRAPH AND TELEPHONE CORPORATION
#
OUTPUT = submissions                   # [<schema_name>.]table_name
TYPE = CSV                            # Input file type
INPUT = stdin
QUOTE = "\""                          # Quoting character
ESCAPE = \                            # Escape character for Quoting
DELIMITER = ","                       # Delimiter
