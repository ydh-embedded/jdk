import re

# Read the input HTML file
with open('input.html', 'r') as f:
    html_content = f.read()

# Replace the specified pattern with a tab stop
modified_content = re.sub(r'>(<div', '>\t<div', html_content)

# Write the modified content to a new file
with open('output.html', 'w') as f:
    f.write(modified_content)