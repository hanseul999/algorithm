/**
 * 이진트리 구현
 * 전위순회, 중위순회, 후위순회
 */
public class Main {

    public static class Tree{
        int count;

        public class Node{
            Object data;
            Node left;
            Node right;

            public Node(Object data) {
                this.data = data;
                left = null;
                right = null;
            }

            public void addLeft(Node node) {
                left = node;
                count++;
            }

            public void addRight(Node node) {
                right = node;
                count++;
            }

            public void deleteLeft() {
                left = null;
                count--;
            }

            public void deleteRight() {
                right = null;
                count--;
            }

        }

        public Node addNode(Object data) {
            return new Node(data);
        }

        public void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) {

        /*    트리 모양
         *        1
         *     2     3
         *   4  5   6  7
         */
        Tree tree = new Tree(); // 트리 생성

        // 노드 생성
        Tree.Node node1 = tree.addNode(1);
        Tree.Node node2 = tree.addNode(2);
        Tree.Node node3 = tree.addNode(3);
        Tree.Node node4 = tree.addNode(4);
        Tree.Node node5 = tree.addNode(5);
        Tree.Node node6 = tree.addNode(6);
        Tree.Node node7 = tree.addNode(7);

        //연결
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        //순회
        System.out.print("전위순회 : ");
        tree.preOrder(node1);

        System.out.print("중위순회 : ");
        tree.inOrder(node1);

        System.out.print("후위순회 : ");
        tree.postOrder(node1);

        System.out.println();


        /* 삭제
         * 삭제 후 트리 모양
         *       1
         *     2     
         *       5     
         */
        
        node2.deleteLeft();
        node1.deleteRight();

        //순회
        System.out.print("전위순회 : ");
        tree.preOrder(node1);

        System.out.print("중위순회 : ");
        tree.inOrder(node1);

        System.out.print("후위순회 : ");
        tree.postOrder(node1);
    }
}