# Flyweight Pattern Example in Python
# Forest: shares TreeType (intrinsic) among many Tree instances (extrinsic position)

class TreeType:
    def __init__(self, name, color, texture):
        self.name = name
        self.color = color
        self.texture = texture
    
    def draw(self, x, y):
        return f"Draw {self.name} [{self.color},{self.texture}] at ({x},{y})"

class TreeFactory:
    _tree_types = {}
    
    @classmethod
    def get_tree_type(cls, name, color, texture):
        key = f"{name}-{color}-{texture}"
        if key not in cls._tree_types:
            cls._tree_types[key] = TreeType(name, color, texture)
        return cls._tree_types[key]

class Tree:
    def __init__(self, x, y, tree_type):
        self.x = x
        self.y = y
        self.tree_type = tree_type
    
    def draw(self):
        return self.tree_type.draw(self.x, self.y)

class Forest:
    def __init__(self):
        self.trees = []
    
    def plant_tree(self, x, y, name, color, texture):
        tree_type = TreeFactory.get_tree_type(name, color, texture)
        tree = Tree(x, y, tree_type)
        self.trees.append(tree)
    
    def draw(self):
        for tree in self.trees:
            print(tree.draw())

def main():
    forest = Forest()
    for i in range(5):
        forest.plant_tree(i, i*2, "Oak", "Green", "Rough")
    for i in range(3):
        forest.plant_tree(i+10, i*3, "Pine", "DarkGreen", "Smooth")
    forest.draw()

if __name__ == "__main__":
    main()
