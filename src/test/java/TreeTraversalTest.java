import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {
    TreeOneZero tree;
    @Before
    public void setup(){
        tree = new TreeOneZero(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
    }

    @Test
    public void traverseInOrderTest() {
        String expected = "3 4 5 6 7 8 9 ";
        String actual = tree.traverseInOrder(tree.root);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void traversePreOrderTest() {
        String expected = "6 4 3 5 8 7 9 ";
        String actual = tree.traversePreOrder(tree.root);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void traversePostOrderTest() {
        String expected = "3 5 4 7 9 8 6 ";
        String actual = tree.traversePostOrder(tree.root);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void traverseLevelOrderTest() {
        String expected = "6 4 8 3 5 7 9 ";
        String actual = tree.traverseLevelOrder();
        Assert.assertEquals(expected, actual);
    }
}
