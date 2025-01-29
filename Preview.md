---
dg-home: true
dg-publish: false
---

# Markdown Theme Test Document

This document contains all standard Markdown elements for testing static site themes.

## Headings

# H1 Heading

## H2 Heading

### H3 Heading

#### H4 Heading

##### H5 Heading

###### H6 Heading

## Paragraphs

This is a standard paragraph. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.

This is another paragraph with some **bold text**, _italic text_, and _**bold italic text**_. You can also use **bold** and _italic_ with underscores.

## Line Breaks and Horizontal Rules

First line.  
Second line with two trailing spaces for line break.

---

Three dashes create a horizontal rule.

---

Three asterisks also work.

---

Three underscores too.

## Emphasis

_Italic text with asterisks_

_Italic text with underscores_

**Bold text with asterisks**

**Bold text with underscores**

_**Bold and italic**_

_**Bold and italic**_

~~Strikethrough text~~

## Lists

### Unordered Lists

- Item one
- Item two
- Item three
    - Nested item 3.1
    - Nested item 3.2
        - Deep nested item 3.2.1
- Item four

- Asterisks work too
- Another item
    - Nested with asterisk

- Plus signs also work
- Another item

### Ordered Lists

1. First item
2. Second item
3. Third item
    1. Nested item 3.1
    2. Nested item 3.2
        1. Deep nested item 3.2.1
4. Fourth item

### Mixed Lists

1. First ordered item
2. Second ordered item
    - Unordered sub-item
    - Another sub-item
        1. Ordered sub-sub-item
        2. Another one
3. Third ordered item

### Task Lists

- [x] Completed task
- [ ] Incomplete task
- [ ] Another incomplete task
    - [x] Nested completed task
    - [ ] Nested incomplete task

## Links

[Inline link](https://example.com)

[Inline link with title](https://example.com "Example Domain")

[Reference-style link](https://example.com "Reference Link Title")

Relative link to a file

[https://example.com](https://example.com) - Automatic link

## Images

![Alt text for image](https://via.placeholder.com/800x400 "Image Title")

![Reference-style image](https://via.placeholder.com/600x300 "Reference Image")

## Code

### Inline Code

Use `inline code` within a sentence. Here's a variable: `const x = 10;`

### Code Blocks

```
Plain code block without syntax highlighting
This is line two
This is line three
```

```javascript
// JavaScript code block
function greet(name) {
  console.log(`Hello, ${name}!`);
  return true;
}

const result = greet("World");
```

```python
# Python code block
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(10))
```

```html
<!-- HTML code block -->
<!DOCTYPE html>
<html>
<head>
  <title>Test Page</title>
</head>
<body>
  <h1>Hello World</h1>
</body>
</html>
```

```css
/* CSS code block */
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

#header {
  background-color: #333;
  color: white;
}
```

```bash
# Bash code block
#!/bin/bash
echo "Hello, World!"
for i in {1..5}; do
  echo "Number: $i"
done
```

```json
{
  "name": "test-package",
  "version": "1.0.0",
  "dependencies": {
    "express": "^4.18.0"
  }
}
```

## Blockquotes

> This is a blockquote. It can span multiple lines.

> Blockquotes can also be nested.
> 
> > This is a nested blockquote.
> > 
> > > And even deeper.

> **Blockquotes** can contain _other_ Markdown elements.
> 
> - Like lists
> - And other formatting
> 
> ```javascript
> // Even code blocks
> console.log("Inside a blockquote");
> ```

## Tables

|Header 1|Header 2|Header 3|
|---|---|---|
|Row 1 Col 1|Row 1 Col 2|Row 1 Col 3|
|Row 2 Col 1|Row 2 Col 2|Row 2 Col 3|
|Row 3 Col 1|Row 3 Col 2|Row 3 Col 3|

### Table with Alignment

|Left Aligned|Center Aligned|Right Aligned|
|:--|:-:|--:|
|Left|Center|Right|
|Text|Text|Text|
|More|More|More|

### Table with Formatting

|Feature|Supported|Notes|
|---|:-:|---|
|**Bold**|✓|Works in tables|
|_Italic_|✓|Also works|
|`Code`|✓|Inline code too|
|[Links](https://example.com)|✓|All formatting|

## HTML Elements

<div> <p>Raw HTML is often supported in Markdown.</p> <p>This is a <strong>paragraph</strong> with <em>HTML tags</em>.</p> </div> <details> <summary>Click to expand</summary>

This is hidden content inside a details element.

- It can contain Markdown
- Like lists
- And other elements

</details>

<kbd>Ctrl</kbd> + <kbd>C</kbd> - Keyboard shortcuts

<mark>Highlighted text</mark>

H<sub>2</sub>O - Subscript

X<sup>2</sup> - Superscript

## Special Characters and Escaping

Backslash escapes special characters:

*Not italic*

[Not a link]

`Not code`

Special characters: & < > " '

## Footnotes

Here's a sentence with a footnote.[^1]

This has another footnote.[^2]

[^1]: This is the first footnote. [^2]: This is the second footnote with more details.

## Definition Lists

Term 1 : Definition 1

Term 2 : Definition 2a : Definition 2b

## Abbreviations

The HTML specification is maintained by the W3C.

*[HTML]: Hyper Text Markup Language *[W3C]: World Wide Web Consortium

## Emoji (if supported)

:smile: :heart: :rocket: :+1:

## Math (if supported)

Inline math: $E = mc^2$

Block math:

$$ \int_{-\infty}^{\infty} e^{-x^2} dx = \sqrt{\pi} $$

## Mixed Content Example

### Article Section

This section demonstrates multiple elements together:

1. **Introduction**: This is a comprehensive test document
2. **Purpose**: To verify theme rendering
3. **Usage**: Load this in your static site generator

> **Note**: Make sure your theme handles all these elements properly.

Here's some `inline code` followed by a [link to documentation](https://example.com), and then an image:

![Sample image](https://via.placeholder.com/400x200)

The code for this feature:

```javascript
function testTheme() {
  return "All elements rendered";
}
```

---

## Conclusion

This document covers all standard Markdown elements. If your theme renders this correctly, it should handle most real-world content.