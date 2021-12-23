import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class PathSetNode {
    private TreeMap<String, PathSetNode> children;
    private boolean isLast;

    public PathSetNode() {
        this.children = new TreeMap<String, PathSetNode>();
        this.isLast = false;
    }

    public boolean isEmpty() {
        return (!this.isLast && children.isEmpty());
    }

    public void add(List<String> path) {
        String s = path.get(0);
        if (children.containsKey(s)) {
            if (path.size() == 1) {
                isLast = true;
            } else {
                children.get(s).add(path.subList(1, path.size()));
            }
        } else {
            if (path.size() == 1) {
                children.put(s, new PathSetNode());
                isLast = true;
            } else {
                children.put(s, new PathSetNode());
                children.get(s).add(path.subList(1, path.size()));
            }
        }
    }

    public boolean contains(List<String> path) {
        boolean flag = true;
        String s = path.get(0);

        if (children.containsKey(s)) {
            if (path.size() == 1) {
                flag = isLast;
            } else {
                flag = flag && children.get(s).contains(path.subList(1, path.size()));
            }
        } else {
            flag = false;
        }
        
        return flag;
    }
  
    public List<List<String>> toListOfPaths() {

        List<List<String>> output = new LinkedList<List<String>>();
        
        for (Map.Entry<String, PathSetNode> entry : children.entrySet()) {
            if (entry.getValue().isEmpty()) {
                List<String> temp = new LinkedList<String>();
                temp.add(entry.getKey());
                output.add(temp);
            } else {
                List<List<String>> child = entry.getValue().toListOfPaths();
                for (List<String> l : child) {
                    l.add(0, entry.getKey());
                }
                if (isLast) {
                    List<String> temp = new LinkedList<String>();
                    child.add(0, temp);
                }
                output.addAll(child);
            }
        }
        
        return output;
    }
}
