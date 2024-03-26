# Parsen

Sure! Beautiful Soup is a Python library for parsing HTML and XML documents. It allows you to navigate, search, and modify the parse tree in a convenient way. Here's a simple example to get you started:

```py
from bs4 import BeautifulSoup

# Create a BeautifulSoup object from an HTML document
soup = BeautifulSoup("<html><body><div>Hello, world!</div></body></html>", 'html.parser')

# Access elements by tag name
print(soup.html)
print(soup.body)
print(soup.div)

# Access the text inside an element
print(soup.div.string)

# Find all elements with a specific tag name
for div in soup.find_all('div'):
    print(div)

# Search for elements with a specific attribute
for link in soup.find_all(href=True):
    print(link)

# Modify elements
soup.div.string = "Hi, there!"
soup.div['id'] = "hello-world"

# Save the modified HTML document to a file
with open('output.html', 'w') as f:
    f.write(str(soup))
```