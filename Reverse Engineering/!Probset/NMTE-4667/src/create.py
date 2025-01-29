import re

for term in open('./formula.txt', 'r'):
    term = term.strip()
    
    # First, convert matrix notation (do this early before other processing)
    # a32 -> A[2][1] (note: converting to 0-indexed)
    def convert_matrix_ref(match):
        matrix = match.group(1).upper()
        row = int(match.group(2)) - 1
        col = int(match.group(3)) - 1
    
        # C matrix is transposed in the file format
        if matrix == 'C':
            return f"{matrix}[{col}][{row}]"
        else:
            return f"{matrix}[{row}][{col}]"

    term = re.sub(r'([abc])(\d)(\d)', convert_matrix_ref, term)
    
    # Split by the main multiplication operators (but not inside parentheses)
    # This is tricky - we need to find * that are between major groups
    parts = []
    depth = 0
    current = []
    for char in term:
        if char == '(':
            depth += 1
            current.append(char)
        elif char == ')':
            depth -= 1
            current.append(char)
        elif char == '*' and depth == 0:
            parts.append(''.join(current))
            current = []
        else:
            current.append(char)
    parts.append(''.join(current))
    
    if len(parts) != 3:
        print(f"// ERROR: Expected 3 parts, got {len(parts)}: {term}")
        continue
    
    factor_a = parts[0].strip()
    factor_b = parts[1].strip()
    factor_c = parts[2].strip()
    
    # Generate the lambda for factor A
    print(end=f"formula.push_back({{[](const Matrix& A) -> double {{ return {factor_a}; }},")
    
    # Generate the lambda for factor B
    print(end=f"[](const Matrix& B) -> double {{ return {factor_b}; }},")
    
    # Generate the distribution lambda for C
    print(end=f"[](Matrix& C, double P_k) {{")
    
    # Parse the C factor to extract individual terms
    # Remove outer parentheses
    factor_c = factor_c.strip('()')
    
    # Split by + or - while preserving the operator
    c_terms = re.split(r'(?=[+-])', factor_c)
    
    for c_term in c_terms:
        c_term = c_term.strip()
        if not c_term:
            continue
        
        # Parse term like "+C[2][3]" or "-2*C[4][3]"
        match = re.match(r'([+-]?)\s*(\d+)?\*?([A-Z]\[\d+\]\[\d+\])', c_term)
        if not match:
            print(f"    // ERROR: Could not parse C term: {c_term}")
            continue
        
        sign = match.group(1) if match.group(1) else '+'
        coeff = match.group(2) if match.group(2) else '1'
        matrix_ref = match.group(3)
        
        # Generate the update statement
        if coeff == '1':
            print(end=f" {matrix_ref} += {sign}P_k;")
        else:
            print(end=f" {matrix_ref} += {sign}{coeff}*P_k;")
    
    print(f"}}}});")
    # print()
# import re
# for term in open('./formula.txt', 'r'):
#     term = re.sub(r'(\(.*?a.*\))', r'formula.push_back({[](const Matrix& a) -> double { return \1', term)
#     term = re.sub(r'\*(\(.*?b.*\))', r'; }, [](const Matrix& b) -> double { return \1', term)
#     term = re.sub(r'\(c(\d\d)', r'(+c\1', term)
#     term = re.sub(r'\*\((.+?c)', r'; }, [](Matrix& c, double P_k) { \1', term)
#     term = re.sub(r'([+-])\s*(\d\+)?(c\d\d)', r'\3+=\1\2P_k;', term)
#     term = re.sub(r'\+\s*1\*', r'', term)
#     term = re.sub(r'([-+])\s*(\d+)\*', r'\1\2*', term)
#     term = re.sub(r'=[+-]\s*([\dP]+)', r'=\1', term)
#     term = re.sub(r'([abc])(\d)(\d)', r'\1[\2][\3]', term)
#     term = re.sub(r'\)$', r' }});', term)

#     print(end=term[:])
