import fileinput

def replace_in_file(filename, search_str, replace_str):
    for line in fileinput.input(filename, inplace=True):
        line = line.replace(search_str, replace_str)
        print(line, end='')




replace_in_file('myfile.txt', '"><div', '"> TabStop<div')