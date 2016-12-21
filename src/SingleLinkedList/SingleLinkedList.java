package SingleLinkedList;

/**
 * Created by kiselev on 03.12.16.
 */
public class SingleLinkedList {
    public static void main (String[] args) {
        Node tailA = generateIter0(9);
        Node tailB = generateIter1(9);
        Node tail0 = generateRec0(9);
        Node tail1 = new Node(9, null); generateRec1(tail1);

        System.out.println(toStringIter(tailA));
        System.out.println(toStringIter(tailB));
        System.out.println(toStringRec(tail0));
        System.out.println(toStringRec(tail1));

        System.out.println("IterSize is: " + sizeIter(tailA));
        System.out.println("IterSum is: " + sumIter(tailA));
        System.out.println("IterMax is: " + maxIter(tailA));
        System.out.println("RecSize is: " + sizeRec(tailA, 0));
        System.out.println("RecSum is: " + sumRec(tailA, 0));
        System.out.println("RecMax is: " + maxRec(tailA, 0));
    }

    private static Node generateIter0(int max) {
        Node result = null;
        for (int k = 0; k <= max; k++) {
            result = new Node(k, result);
        }
        return result;
    }

    private static Node generateIter1(int max) {
        Node result = new Node(max, null);
        Node ref = result;
        for (int k = max; k > 0; k--) {
            ref.next = new Node(k - 1, null);
            ref = ref.next;
        }
        return result;
    }

    private static Node generateRec0(int value) {
        if (value >= 0) {
            return new Node(value, generateRec0(value - 1));
        } else {
            return null;
        }
    }

    private static void generateRec1(Node node) {
        if (node.value > 0) {
            node.next = new Node(node.value - 1, null);
            generateRec1(node.next);
        }
    }

    private static int sizeIter(Node ref) {
        int result = 0;
        while (ref != null) {
            ++result;
            ref = ref.next;
        }
        return result;
    }

    private static int sizeRec(Node ref, int result) {
        if (ref.next != null) {
            return sizeRec(ref.next, ++result);
        } else {
            return ++result;
        }
    }

    private static int sumRec(Node ref, int result) {
        if (ref.next != null) {
            return sumRec(ref.next, result += ref.value);
        } else {
            return result += ref.value;
        }
    }

    private static int maxRec(Node ref, int result) {
        if (ref.next != null) {
            if (ref.value > result) result = ref.value;
            return maxRec(ref.next, result);
        }
        else {
            return result;
        }
    }

    private static int sumIter(Node ref) {
        int result = 0;
        while (ref.next != null) {
            result += ref.value;
            ref = ref.next;
        }
        return result;
    }

    private static int maxIter(Node ref) {
        int result = 0;
        while (ref.next != null) {
            if (result < ref.value) result = ref.value;
            ref = ref.next;
        }
        return result;
    }

    private static String toStringIter(Node ref) {
        String result = "";
        while (ref != null) {
            result += "(" + ref.value + ")->";
            ref = ref.next;
        }
        result += "null";
        return result;
    }

    private static String toStringRec(Node ref){
        if (ref == null) {
            return "null";
        }
        else {
            return "(" + ref.value + ")->" + toStringRec(ref.next);
        }
    }
}

