/**
 * 1991 트리 순회
 * 기본적인 이진트리 구현 +
 * 처음에 들어노는 root 노드를 저장 +
 * 이후 들어오는 노드들에 대해서는 탐색을 진행하여
 * (재귀함수로) 서브트리의 부모노드를 찾아줌 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static class Tree{
        Node root;
        public class Node{
            Object data;
            Node left;
            Node right;

            public Node(Object data) {
                this.data = data;
                left = null;
                right = null;
            }

        }

        public void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }

        public void add(String root, String left, String right) {
            if (this.root == null) {
                if (!root.equals(".")) {
                    this.root = new Node(root);
                }
                if (!left.equals(".")) {
                    this.root.left = new Node(left);
                }
                if (!right.equals(".")) {
                    this.root.right = new Node(right);
                }
            }else{ //루트가 null이 아니라면 탐색 진행
                searchAndAdd(this.root, root, left, right);
            }
        }

        private void searchAndAdd(Node node, String rootData, String leftData, String rightData) {
            if(node == null) {
                return;
            }
            else if (node.data.equals(rootData)) {
                if (!leftData.equals(".")) {
                    node.left = new Node(leftData);
                }
                if (!rightData.equals(".")) {
                    node.right = new Node(rightData);
                }
            }
            else{
                searchAndAdd(node.left, rootData, leftData, rightData);
                searchAndAdd(node.right, rootData, leftData, rightData);
            }

        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.add(root, left, right);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}