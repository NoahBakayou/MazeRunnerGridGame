public class LinkedList {
    Node headNode = null; //node type instance variable

    public void addHeadNode(int y, int x) {

        Node newNode = new Node();

        newNode.xPosition = x;
        newNode.yPosition = y;

        newNode.nextNode = this.headNode;

        this.headNode = newNode;

    }

    public Node removeHeadNode() {
        headNode = headNode.nextNode;
        return headNode;

    }
}
