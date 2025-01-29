import ast
from pprint import pp
from baby import *
import code

# top level
constant_Call = ['G0g0sQu1D_116510', 'g0gosqu1D', 'g0GOsquiD', 'g0GOsquiD_37121', 'gOg0sQuId_362335', 'g0gosqu1D_663663', 'gOg0sQuId', 'G0G0SQU1D']
# in main
constant_Call = constant_Call # + ['g0G0']
todo_FunctionDef = constant_Call + ['G0goSQuId_531543', 'G0Gosqu1D_116510', 'goG0SQu1d']

class Evaluator(ast.NodeTransformer):
    def __init__(self):
        super().__init__()
        self.namespace = {}

    # get all functions (including nested) defined
    def visit_Module(self, node):
        pp(f'Visiting module {node}')
        code = compile(node, '<string>', 'exec')
        exec(code, self.namespace)
        return self.generic_visit(node)

    def visit_Call(self, node):
        self.generic_visit(node)
        try:
            if node.func.id in constant_Call:
                result = eval(compile(ast.Expression(body=node), '<string>', 'eval'), self.namespace)
                return ast.copy_location(ast.Constant(value=result), node)
        except AttributeError as e:
            # print(f'[!] {e} {node.__dict__}')
            pass
        return node

    def visit_FunctionDef(self, node):
        # exec(compile(ast.Module(node, type_ignores=[]), '<string>', 'exec'), self.namespace)
        exec(compile(ast.Module(body=[node], type_ignores=[]), '<string>', 'exec'), self.namespace)
        return self.generic_visit(node)

# Simplify while true statements
UNKNOWN = object() # for dynamic values
class Simplifier(ast.NodeTransformer):
    scope = {}
    is_simulate = None
    history = []

    def _get_val(self, node):
        if isinstance(node, ast.Constant):
            return node.value
        elif isinstance(node, ast.Name): # for `while GOgO`
            return self.scope.get(node.id, UNKNOWN)
        return UNKNOWN

    def visit_While(self, node):
        if self._get_val(node.test) is True:
            # SIMULATE
            self.is_simulate = True
            while True:
                self.control_flow = None
                for child in node.body:
                    # ALL IS ast.If
                    # pp(isinstance(node.body[0], ast.If))
                    # pp(node.body[0])
                    self.visit(child)
                    if self.control_flow:
                        break
                if self.control_flow == 'break':
                    self.control_flow = None
                    return node
                elif self.control_flow == 'return':
                    return node
                break # for test
            self.is_simulate = False
        return node

    def visit_If(self, node):
        if not self.is_simulate:
            return node
        if isinstance(node.test.comparators[0], ast.Constant):
            name = node.test.left.id
            check = node.test.comparators[0].value
            current = self.scope.get(name, UNKNOWN)

            pp(f'MAKING IF {name} {check} {current}')
            if current is not UNKNOWN:
                if current == check:
                    for child in node.body:
                        pp(f'ONG {node.body}')
                        self.visit(child)
                        if self.control_flow:
                            return node
                return node
        self.history.append(node) # preserve as is
        return node

    def visit_Assign(self, node):
        # if not self.is_simulate:
            # return node
        pp(node)
        return node

# Delete dead code
class Cleaner(ast.NodeTransformer):
    def visit_FunctionDef(self, node):
        if (node.name) == 'gog0sQu1D':
            code.interact(local=locals(), exitmsg="onward!")
        self.generic_visit(node)
        if node.name in todo_FunctionDef:
            return None
        return node

tree = ast.parse(open('./baby.py.bak').read())
tree = Evaluator().visit(tree)
tree = Simplifier().visit(tree)
tree = Cleaner().visit(tree)
ast.fix_missing_locations(tree)
open('solve.py', 'w').write(ast.unparse(tree))
# print(tree)
