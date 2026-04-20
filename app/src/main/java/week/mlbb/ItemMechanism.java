package week.mlbb;

import java.util.ArrayList;
import java.util.List;

public class ItemMechanism {
static class ItemNode {
    String name;
    String note;
    List<ItemNode> children;

    ItemNode(String name, String note) {
        this.name = name;
        this.note = note;
        this.children = new ArrayList<>();
        }

        void addChild(ItemNode child) {
        children.add(child);
        }
    }
    
    static void printTree(ItemNode node, int level) {
        if (node == null) return;
        String indent = " ".repeat(level);
        System.out.println(indent + "- " + node.name + " -> " + node.note);
        for (ItemNode child : node.children) {
            printTree(child, level + 1);
            }
        }
    static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;
        path.add(node.name);
        if (node.children.isEmpty()) {
        System.out.println(String.join(" -> ", path));
        } else { for (ItemNode child : node.children) {
            printAllBuildPaths(child, path);
            }
        }
        path.remove(path.size() - 1);
    }
    static int countNodes(ItemNode node) {
        if (node == null) return 0;
        int total = 1;
        for (ItemNode child : node.children) {
        total += countNodes(child);
        }
        return total;
        }

        static int countLeaves(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int total = 0;
        for (ItemNode child : node.children) {
        total += countLeaves(child);
        }
        return total;
        }
        
        static int height(ItemNode node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;
        int maxChildHeight = 0;
            for (ItemNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
            }
        return 1 + maxChildHeight;
    }

    static boolean findPath(ItemNode node, String target, List<String> path) {
    if (node == null) return false;
    path.add(node.name);
    if (node.name.equalsIgnoreCase(target)) {
     return true;
    }
    for (ItemNode child : node.children) {
        if (findPath(child, target, path)) {
        return true;
        }
    }
    path.remove(path.size() - 1);
    return false;
    }
    static ItemNode findNode(ItemNode node, String target) {
        if (node == null) return null;
        if (node.name.equalsIgnoreCase(target)) {
            return node;
        }
        for (ItemNode x : node.children) {
            ItemNode found = findNode(x, target);
            if (found != null) return found;
        }
        return null;
    }

 public static int countItemOccurrences(ItemNode node, String target) {
    if (node == null) {
        return 0;
    }
    int count;
    if (node.name.equalsIgnoreCase(target)) {
        count = 1;
    } else {
        count = 0;
    }
    for (ItemNode child : node.children) {
        count = count + countItemOccurrences(child, target);
    }
    return count;
}


static void printPathsToEndItem(ItemNode node, String target, List<String> path) {
    if (node == null) return;
    path.add(node.name);
    if (node.children.isEmpty() && node.name.equalsIgnoreCase(target)) {
        System.out.println(String.join(" -> ", path));
    }

    for (ItemNode child : node.children) {
        printPathsToEndItem(child, target, path);
    }
    path.remove(path.size() - 1);
}


}