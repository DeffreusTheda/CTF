import re
import ast
import astor
from baby import *

# CONFIG
patterns = [
    r'(G0g0sQu1D_116510\(\d+, ?\d+\))',
    r'(g0GOsquiD\(\d+, ?\d+\))',
    r'(gOg0sQuId\(\d+, ?\d+\))',
    r'(G0G0SQU1D\(\d+, ?\d+\))',
]
lines = []

# Sentinel object to represent variables we cannot track (dynamic values)
UNKNOWN = object()

class Deobfuscator(ast.NodeVisitor):
    def __init__(self):
        self.scope = {}          # Tracks constant values {var_name: value}
        self.history = []        # Stores the cleaned linear code
        self.control_flow = None # Signals: 'break', 'continue', 'return'

    def simplify(self, source_code):
        tree = ast.parse(source_code)
        func_def = tree.body[0]
        
        self.scope = {}
        self.history = []
        
        # Walk the function body
        for node in func_def.body:
            self.visit(node)
            if self.control_flow == 'return':
                break

        func_def.body = self.history
        return astor.to_source(func_def)

    def _get_val(self, node):
        """Helper to evaluate AST nodes to constants or UNKNOWN."""
        if isinstance(node, ast.Constant):
            return node.value
        elif isinstance(node, ast.Name):
            return self.scope.get(node.id, UNKNOWN)
        # We could add support for basic math here (1+1), but strictly
        # keeping to literals is safer for unrolling prevention.
        return UNKNOWN

    def visit_Func(self, node):
        print(f'{node=}\n{dir(node)=}\n')

    def visit_Assign(self, node):
        target = node.targets[0]
        if not isinstance(target, ast.Name):
            self.history.append(node)
            return

        val = self._get_val(node.value)
        
        if val is not UNKNOWN:
            # It's a constant (State Variable), track it, don't emit code
            self.scope[target.id] = val
        else:
            # It's dynamic (e.g., list(range(...))), emit code
            # AND remove from scope just in case it was constant before
            if target.id in self.scope:
                del self.scope[target.id]
            self.history.append(node)

    def visit_If(self, node):
        # 1. Try to evaluate the condition
        # We assume structure: Name == Constant
        if (isinstance(node.test, ast.Compare) and 
            isinstance(node.test.left, ast.Name) and 
            isinstance(node.test.comparators[0], ast.Constant)):
            
            var_name = node.test.left.id
            check_val = node.test.comparators[0].value
            current_val = self.scope.get(var_name, UNKNOWN)

            if current_val is not UNKNOWN:
                # We know the state!
                if current_val == check_val:
                    # True branch: Enter and Execute
                    for child in node.body:
                        self.visit(child)
                        if self.control_flow:
                            return
                else:
                    # False branch: Dead code, ignore
                    pass
                return

        # 2. If condition is UNKNOWN or complex, preserve the IF node as is.
        # This handles real logic like 'if user_input == 5:'
        self.history.append(node)

    def visit_While(self, node):
        # Check if this is a "Dispatcher" (while True) or a "Logic Loop" (while data)
        condition = self._get_val(node.test)
        
        if condition is True: 
            # === DISPATCHER LOOP ===
            # Simulate execution inside
            max_iter = 5000 
            count = 0
            while count < max_iter:
                self.control_flow = None
                for child in node.body:
                    self.visit(child)
                    if self.control_flow:
                        break
                if self.control_flow == 'break':
                    self.control_flow = None
                    return
                elif self.control_flow == 'return':
                    return
                # 'continue' just lets the loop run again
                count += 1
        else:
            # === REAL LOGIC LOOP ===
            # The condition is UNKNOWN (e.g. 'while GOgO').
            # Do NOT simulate. Treat this loop as a single opaque statement.
            self.history.append(node)

    def visit_Break(self, node):
        self.control_flow = 'break'

    def visit_Continue(self, node):
        self.control_flow = 'continue'

    def visit_Return(self, node):
        self.history.append(node)
        self.control_flow = 'return'

    def visit_Expr(self, node):
        self.history.append(node)

    def visit_Pass(self, node):
        pass

def simplify_expressions():
    global lines
    for line in open('./baby.py.bak', 'r').readlines():
        for pat in patterns:
            matchs = re.findall(pat, line)
            for match in matchs:
                # print(match, '==>==', eval(match))
                line = re.sub(pat, str(eval(match)), line, count=1)
        print(line[:-1])
        lines.append(line)
# def 

def main():
    indent = len(re.search(r'^(\W+)', lines).group(0))
    obfuscated_code = ''.join([line[indent:] for line in lines])

    cleaner = Deobfuscator()
    result = cleaner.simplify(obfuscated_code)
    print(result)

if __name__ == '__main__':
    main()