/**
 * Created by Jimin on 2/26/17.
 */
public class CityNode {
    int data;
    CityNode left;
    CityNode right;
    CityNode parent;

    public CityNode(int data, CityNode parent){
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public void addRightChild(CityNode cityNode) {
        this.right = cityNode;
    }

    public void addLeftChild(CityNode cityNode) {
        this.left = cityNode;
    }

    public CityNode getLeftChild() {
        return left;
    }

    public CityNode getRightChild() {
        return right;
    }

    public boolean isLeaf(){
        if(left == null && right==null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeft () {
        if(left == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isRight() {
        if(right == null) {
            return false;
        } else {
            return true;
        }
    }

    public int getData () {
        return data;
    }
    public int getParentData() {
        return parent.getData();
    }

    public CityNode getParent() {
        return parent;
    }
}
