#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Component
class FileSystemNode {
public:
    virtual void show(int indent = 0) = 0;
    virtual void add(FileSystemNode* node) {}
    virtual ~FileSystemNode() {}
};

// Leaf: File
class File : public FileSystemNode {
    string name;
public:
    File(string name) : name(name) {}

    void show(int indent = 0) override {
        cout << string(indent, ' ') << "- File: " << name << endl;
    }
};

// Composite: Folder
class Folder : public FileSystemNode {
    string name;
    vector<FileSystemNode*> children;
public:
    Folder(string name) : name(name) {}

    void add(FileSystemNode* node) override {
        children.push_back(node);
    }

    void show(int indent = 0) override {
        cout << string(indent, ' ') << "+ Folder: " << name << endl;
        for (auto child : children)
            child->show(indent + 2);
    }

    ~Folder() {
        for (auto child : children)
            delete child;
    }
};

int main() {
    Folder* root = new Folder("Root");
    root->add(new File("file1.txt"));
    root->add(new File("file2.txt"));

    Folder* subFolder = new Folder("SubFolder");
    subFolder->add(new File("subfile1.txt"));
    subFolder->add(new File("subfile2.txt"));

    root->add(subFolder);

    root->show();

    delete root;
    return 0;
}
