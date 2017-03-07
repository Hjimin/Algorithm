/**
 * Created by Jimin on 2/26/17.
 */
public class CityTree {
    int[][] city_map;
    CityNode root;
    CityNode end;
    int count;

    public CityTree(int[][] city_map, int root, int end) {
        this.city_map = city_map;
        this.root = new CityNode(root, null);
        this.end = new CityNode(end, null);
        this.count = 1;
    }


    private CityNode addLeft(CityNode parent, int to){
        CityNode cityNode;
        if(root.getData() == parent.getData()) {
            cityNode = new CityNode(to, root);
            root.addLeftChild(cityNode);
        } else {
            cityNode = new CityNode(to, parent);
            parent.addLeftChild(cityNode);
        }
        return cityNode;
    }

    private CityNode addRight(CityNode parent, int to){
        CityNode cityNode;
        if(root.getData() == parent.getData()) {
            cityNode = new CityNode(to, root);
            root.addRightChild(cityNode);
        } else {
            cityNode = new CityNode(to, parent);
            parent.addRightChild(cityNode);
        }
        return cityNode;
    }

    private CityNode add(CityNode parent, int to) {
        CityNode cityNode;
        if(root.getData() == parent.getData()) {
            cityNode = new CityNode(to, root);
            if(!parent.isLeft()) {
                System.out.println("left " + parent.getData() + " " + cityNode.getData());
                parent.addLeftChild(cityNode);
            } else {
                System.out.println("right " + parent.getData() + " " + cityNode.getData());
                parent.addRightChild(cityNode);
            }
        } else {
            cityNode = new CityNode(to, parent);
            if(!parent.isLeft()) {
                System.out.println("left " + parent.getData() + " " + cityNode.getData());
                parent.addLeftChild(cityNode);
            } else {
                System.out.println("right " + parent.getData() + " " + cityNode.getData());
                parent.addRightChild(cityNode);
            }
        }
        return cityNode;
    }

//    private boolean isR(int j, CityNode parent) {
//
//
//    }

    private boolean isR(CityNode node, int j) {
        for(int i = 0 ; i<100 ; i++) {
            if (node.getData() != root.getData()) {
                if(node.getParent().getData() == j) {
                    return false;
                } else {
                    node = node.getParent();
                }
            }
        }

        return true;
    }

    public void makeTree(int from, int to) {
        CityNode parent = root;
        for(int j = 0; j<100; j++) {
            if(city_map[from][j] == 1 && j != from){
                System.out.println(from + " " + j);
                if(j != to){// && isR()) {
                    parent = add(parent, j);
                    if(isR(parent, j)) {
                        try {
                            makeTree(parent.getData(), to);
                        } catch (Exception e) {
                            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
                        }
                    }
                } else {
                    return;
                }
//                if(!check) {
//                    if(j != to) {
//                        parent = addLeft(parent, to);
//                        check = true;
//                        makeTree(j, to);
//                    } else {
//                        System.out.println("finished");
//                        //print out route
//                    }
//                } else {
//                    if(j != to) {
//                        parent = addRight(parent, to);
//                        makeTree(j, to);
//                    } else {
//                        System.out.println("finished");
//                    }
//                }
            }
        }
    }

    private void print() {
        System.out.println();
    }


}
